package frc.team449.robot2022.intake

import edu.wpi.first.wpilibj.DigitalInput
import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj2.command.SubsystemBase
import frc.team449.system.motor.WrappedMotor
import io.github.oblarg.oblog.Loggable
import io.github.oblarg.oblog.annotations.Log

class Intake(
  private val intakeMotor: WrappedMotor,
  private val intakeSensor: DigitalInput,
  private val intakePiston: DoubleSolenoid,
//  private val arm: Arm
) : SubsystemBase(), Loggable {

  @Log.ToString
  private var sensorOutput = false

  fun runIntake() {
    intakeMotor.setVoltage(IntakeConstants.INTAKE_VOLTAGE)
  }

  fun runIntakeReverse() {
    intakeMotor.setVoltage(-IntakeConstants.INTAKE_VOLTAGE)
  }

  fun stop() {
    intakeMotor.setVoltage(0.0)
  }

  // TODO: Test automated arm pickup based on a crate being sensed
  override fun periodic() {
    sensorOutput = intakeSensor.get()
//    if (sensorOutput) {
//      intakePiston.set(DoubleSolenoid.Value.kForward)
//      arm.hopperPos()
//      this.stop()
//    } else {
    intakePiston.set(DoubleSolenoid.Value.kOff)
//      arm.groundPos()
//    }
  }
}
