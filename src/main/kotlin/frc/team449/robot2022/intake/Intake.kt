package frc.team449.robot2022.intake

import edu.wpi.first.wpilibj.DigitalInput
import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj2.command.SubsystemBase
import frc.team449.system.motor.WrappedMotor

class Intake(
  private val intakeMotor: WrappedMotor,
  private val intakeSensor: DigitalInput,
  private val intakePiston: DoubleSolenoid
) : SubsystemBase() {

  fun runIntake() {
    intakeMotor.setVoltage(IntakeConstants.INTAKE_VOLTAGE)
  }

  fun runIntakeReverse() {
    intakeMotor.setVoltage(-IntakeConstants.INTAKE_VOLTAGE)
  }

  fun stop() {
    intakeMotor.setVoltage(0.0)
  }

  override fun periodic() {
    // idk if this is correct..
    if (intakeSensor.get()) {
      intakePiston.set(DoubleSolenoid.Value.kReverse)
    } else {
      intakePiston.set(DoubleSolenoid.Value.kForward)
    }
  }
}
