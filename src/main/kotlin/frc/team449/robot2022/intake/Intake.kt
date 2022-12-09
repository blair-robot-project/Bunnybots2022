package frc.team449.robot2022.intake

import edu.wpi.first.wpilibj.DigitalInput
import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj2.command.CommandScheduler
import edu.wpi.first.wpilibj2.command.SubsystemBase
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
  private var sensorOutput = false

  private var overridden: () -> Boolean = { false }

  fun runIntake() {
    intakeMotor.setVoltage(IntakeConstants.INTAKE_VOLTAGE)
  }

  fun runIntakeReverse() {
    intakeMotor.setVoltage(-IntakeConstants.INTAKE_VOLTAGE)
  }

  fun stop() {
    intakeMotor.setVoltage(0.0)
  }

  fun overrideAutomatedSequence() {
    overridden = { true }
  }

  // TODO: Test automated arm pickup based on a crate being sensed
  override fun periodic() {
    sensorOutput = !intakeSensor.get()
    if (sensorOutput) {
      CommandScheduler.getInstance().schedule(AutomatedIntakeCommand(arm, hopper, this, overridden))
    } else {
      intakePiston.set(DoubleSolenoid.Value.kReverse)
      overridden = { false }
    }
  }
}
