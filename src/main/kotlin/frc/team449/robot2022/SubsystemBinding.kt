package frc.team449.robot2022

import edu.wpi.first.wpilibj.DigitalInput
import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj.PneumaticsModuleType
import edu.wpi.first.wpilibj.XboxController
import frc.team449.system.encoder.NEOEncoder
import frc.team449.system.encoder.QuadEncoder
import frc.team449.system.motor.createSparkMax

class SubsystemBinding(private val mechanismsController: XboxController) {

  val intakeMotor = createSparkMax("Intake", 10, NEOEncoder.creator(1.0, 0.25), slaveSparks = mapOf(Pair(9, false)))
  val intakePneumatics = DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 4)
  val intakeSensor = DigitalInput(7)

  val armMotor = createSparkMax("Arm", 11, QuadEncoder.creator(), slaveSparks = mapOf(Pair(12, false)))

  fun bindButtons() {
//    JoystickButton(mechanismsController, XboxController.Button.kA.value).whenPressed(
//
//    )
  }
}
