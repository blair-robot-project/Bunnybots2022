package frc.team449.robot2022.arm

import edu.wpi.first.math.controller.ArmFeedforward
import edu.wpi.first.math.controller.ProfiledPIDController
import edu.wpi.first.math.trajectory.TrapezoidProfile
import edu.wpi.first.wpilibj.Timer
import edu.wpi.first.wpilibj2.command.SubsystemBase
import frc.team449.system.motor.WrappedMotor
import io.github.oblarg.oblog.Loggable
import io.github.oblarg.oblog.annotations.Log

class Arm(
  private val armMotor: WrappedMotor
) : SubsystemBase(), Loggable {

  private var lastSpeed: Double = 0.0
  private var lastTime: Double = Timer.getFPGATimestamp()

  var controller: ProfiledPIDController = ProfiledPIDController(
    ArmConstants.kP,
    ArmConstants.kI,
    ArmConstants.kD,
    TrapezoidProfile.Constraints(ArmConstants.maxVel, ArmConstants.maxAccel)
  )

  private var feedForward: ArmFeedforward = ArmFeedforward(ArmConstants.kS, ArmConstants.kG, ArmConstants.kV, ArmConstants.kA)

  @Log.ToString
  private var goal: Double = controller.goal.position

  init {
    armMotor.encoder.resetPosition(0.0)
    controller.setTolerance(Math.PI / 30)
  }

  fun hopperPos() {
    val goalState: TrapezoidProfile.State = TrapezoidProfile.State(ArmConstants.hopperDesiredAngle, 0.0)
    controller.goal = goalState
  }

  fun groundPos() {
    val goalState: TrapezoidProfile.State = TrapezoidProfile.State(ArmConstants.groundAngle, 0.0)
    controller.goal = goalState
  }

  override fun periodic() {
    goal = controller.goal.position
    val feedForwardAccel: Double = (controller.setpoint.velocity - lastSpeed) / (Timer.getFPGATimestamp() - lastTime)
    armMotor.setVoltage(
      controller.calculate(armMotor.encoder.position) + feedForward.calculate(controller.setpoint.position, controller.setpoint.velocity, feedForwardAccel)
    )
    lastSpeed = controller.setpoint.velocity
    lastTime = Timer.getFPGATimestamp()
  }
}
