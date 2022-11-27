package frc.team449.robot2022.arm

import edu.wpi.first.math.controller.ProfiledPIDController
import edu.wpi.first.math.controller.SimpleMotorFeedforward
import edu.wpi.first.math.trajectory.TrapezoidProfile
import edu.wpi.first.wpilibj.Timer
import edu.wpi.first.wpilibj2.command.SubsystemBase
import frc.team449.system.motor.WrappedMotor

class Arm(
  private val armMotor: WrappedMotor
) : SubsystemBase() {

  var lastSpeed: Double = 0.0
  var lastTime: Double = Timer.getFPGATimestamp()

  var controller: ProfiledPIDController = ProfiledPIDController(
    ArmConstants.kP,
    ArmConstants.kI,
    ArmConstants.kD,
    TrapezoidProfile.Constraints(ArmConstants.maxVel, ArmConstants.maxAccel)
  )

  var feedForward: SimpleMotorFeedforward = SimpleMotorFeedforward(ArmConstants.kS, ArmConstants.kV, ArmConstants.kA)

  fun goToPos(desiredPos: Double) {
    var goalState: TrapezoidProfile.State = TrapezoidProfile.State(desiredPos, 0.0)
    controller.goal = goalState
  }

  fun hopperPos() {
    var goalState: TrapezoidProfile.State = TrapezoidProfile.State(ArmConstants.hopperDesiredAngle, 0.0)
    controller.goal = goalState
  }

  fun groundPos() {
    var goalState: TrapezoidProfile.State = TrapezoidProfile.State(ArmConstants.groundAngle, 0.0)
    controller.goal = goalState
  }

  override fun periodic() {
    var accel: Double = (controller.setpoint.velocity - lastSpeed) / (Timer.getFPGATimestamp() - lastTime)
    armMotor.setVoltage(
      controller.calculate(armMotor.encoder.position) + feedForward.calculate(controller.setpoint.velocity, accel)
    )
    lastSpeed = controller.setpoint.velocity
    lastTime = Timer.getFPGATimestamp()
  }
}
