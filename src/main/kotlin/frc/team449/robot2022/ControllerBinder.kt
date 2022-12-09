package frc.team449.robot2022

import edu.wpi.first.wpilibj.XboxController
import edu.wpi.first.wpilibj2.command.button.JoystickButton
import frc.team449.robot2022.arm.Arm
import frc.team449.robot2022.hopper.Hopper
import frc.team449.robot2022.intake.Intake

class ControllerBinder(
  private val mechanismsController: XboxController,
  private val arm: Arm,
  private val intake: Intake,
  private val hopper: Hopper
) {

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

    JoystickButton(mechanismsController, XboxController.Button.kB.value).whenPressed(
      intake::overrideAutomatedSequence
    )

    JoystickButton(mechanismsController, XboxController.Button.kX.value).whenPressed(
      hopper::toggleGate
    )
  }
}
