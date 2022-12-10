package frc.team449.robot2022.intake

import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj.Timer
import edu.wpi.first.wpilibj2.command.CommandBase
import edu.wpi.first.wpilibj2.command.WaitCommand
import edu.wpi.first.wpilibj2.command.WaitUntilCommand
import frc.team449.robot2022.arm.Arm
import frc.team449.robot2022.hopper.Hopper

class AutomatedIntakeCommand(
  private val arm: Arm,
  private val hopper: Hopper,
  private val intake: Intake
) : CommandBase() {

  private val timer = Timer()

  init {
    addRequirements(arm, hopper, intake)
  }

  override fun initialize() {
    timer.start()
    hopper.retractHopper()
    intake.intakePiston.set(DoubleSolenoid.Value.kForward)
    WaitCommand(10.0)
    intake.stop()
    arm.hopperPos()
    WaitUntilCommand(arm.controller::atGoal)
    arm.groundPos()
  }

  override fun execute() {
  }

  override fun isFinished(): Boolean {
    return timer.equals(IntakeConstants.automatedWaitSeconds) && arm.controller.atGoal()
  }

  override fun end(interrupted: Boolean) {
    // TODO: What drivers want to happen in case they override the automation
    intake.stop()
    intake.intakePiston.set(DoubleSolenoid.Value.kReverse)
    arm.groundPos()
  }
}
