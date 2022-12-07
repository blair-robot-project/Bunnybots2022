package frc.team449.robot2022

import edu.wpi.first.wpilibj.*
import edu.wpi.first.wpilibj2.command.button.JoystickButton
import frc.team449.robot2022.arm.Arm
import frc.team449.robot2022.arm.ArmConstants
import frc.team449.robot2022.hopper.Hopper
import frc.team449.robot2022.hopper.HopperConstants
import frc.team449.robot2022.intake.Intake
import frc.team449.robot2022.intake.IntakeConstants
import frc.team449.system.encoder.NEOEncoder
import frc.team449.system.encoder.QuadEncoder
import frc.team449.system.motor.createSparkMax

class ControllerBinder(private val mechanismsController: XboxController) {

  private val PCM_MODULE = 0

  private val armMotor = createSparkMax(
    "Arm",
    ArmConstants.MOTOR_CAN_ID,
    QuadEncoder.creator(
      ArmConstants.EXT_ENCODER,
      ArmConstants.EXTERNAL_ENC_CPR,
      ArmConstants.ARM_UPR,
      ArmConstants.ARM_GEARING,
      inverted = false
    ),
    slaveSparks = mapOf(Pair(ArmConstants.SLAVE_MOTOR_CAN_ID, false))
  )

  private val intakeMotor = createSparkMax(
    "Intake",
    IntakeConstants.LEFT_CAN_ID,
    NEOEncoder.creator(1.0, 0.25),
    slaveSparks = mapOf(Pair(IntakeConstants.RIGHT_CAN_ID, false))
  )

  private val intakePneumatics = DoubleSolenoid(
    PCM_MODULE,
    PneumaticsModuleType.CTREPCM,
    IntakeConstants.PNEUMATICS_FORWARD_CHANNEL,
    IntakeConstants.PNEUMATICS_REVERSE_CHANNEL
  )

  private val intakeSensor = DigitalInput(IntakeConstants.IR_SENSOR_CHANNEL)

  private val hopperPneumatics = DoubleSolenoid(
    PCM_MODULE,
    PneumaticsModuleType.CTREPCM,
    HopperConstants.PNEUMATICS_FORWARD_CHANNEL,
    HopperConstants.PNEUMATICS_REVERSE_CHANNEL
  )

  private val arm = Arm(armMotor)
  private val intake = Intake(intakeMotor, intakeSensor, intakePneumatics)
  private val hopper = Hopper(hopperPneumatics)

  fun bindButtons() {
    JoystickButton(mechanismsController, XboxController.Button.kA.value).whenPressed(
      arm::groundPos
    )

    JoystickButton(mechanismsController, XboxController.Button.kY.value).whenPressed(
      arm::hopperPos
    )

    JoystickButton(mechanismsController, XboxController.Button.kRightBumper.value).whenPressed(
      intake::runIntake
    ).whenReleased(
      intake::stop
    )

    JoystickButton(mechanismsController, XboxController.Button.kLeftBumper.value).whenPressed(
      intake::runIntakeReverse
    ).whenReleased(
      intake::stop
    )

    JoystickButton(mechanismsController, XboxController.Button.kX.value).whenPressed(
      hopper::toggleGate
    )
  }
}
