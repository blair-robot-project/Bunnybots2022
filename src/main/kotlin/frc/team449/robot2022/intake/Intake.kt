package frc.team449.robot2022.intake

import edu.wpi.first.wpilibj.DigitalInput
import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj2.command.*
import frc.team449.robot2022.arm.Arm
import frc.team449.robot2022.hopper.Hopper
import frc.team449.system.motor.WrappedMotor
import io.github.oblarg.oblog.Loggable
import io.github.oblarg.oblog.annotations.Log

class Intake(
  private val intakeMotor: WrappedMotor,
  private val intakeSensor: DigitalInput,
  val intakePiston: DoubleSolenoid,
  private val arm: Arm,
  private val hopper: Hopper
) : SubsystemBase(), Loggable {

  @Log.ToString
  var sensorOutput = false

  var runCommand = true

  private var cmd = SequentialCommandGroup(
    InstantCommand(hopper::retractHopper),
    InstantCommand(this::pistonOn),
    WaitCommand(0.5),
    InstantCommand(arm::hopperPos),
    WaitCommand(1.5),
    InstantCommand(arm::groundPos)
  )

  init {
    cmd.addRequirements(arm, hopper, this)
    intakePiston.set(DoubleSolenoid.Value.kReverse)
  }

  private fun pistonOn() {
    intakePiston.set(DoubleSolenoid.Value.kForward)
  }

  fun runIntake() {
    intakeMotor.setVoltage(IntakeConstants.INTAKE_VOLTAGE)
  }

  fun runIntakeReverse() {
    intakeMotor.setVoltage(-IntakeConstants.INTAKE_VOLTAGE)
    intakePiston.set(DoubleSolenoid.Value.kReverse)
  }

  fun stop() {
    intakeMotor.setVoltage(0.0)
  }

  // TODO: Test automated arm pickup based on a crate being sensed
  override fun periodic() {
    sensorOutput = !intakeSensor.get()
    if (sensorOutput && runCommand) {
      CommandScheduler.getInstance().schedule(cmd)
      runCommand = false
    }
  }
}
