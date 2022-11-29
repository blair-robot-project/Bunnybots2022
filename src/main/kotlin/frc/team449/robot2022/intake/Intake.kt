package frc.team449.robot2022.intake

import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj2.command.SubsystemBase
import frc.team449.system.motor.WrappedMotor

class Intake(
  private val intakeMotor: WrappedMotor,
): SubsystemBase() {

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
    // TODO use infared sensor to detect crate; deploy pistons if detected
  }

}