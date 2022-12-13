package frc.team449.robot2022.auto

import edu.wpi.first.wpilibj2.command.InstantCommand
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup
import frc.team449.control.auto.AutoRoutine
import frc.team449.control.auto.AutoUtils
import frc.team449.control.auto.HolonomicFollower
import frc.team449.robot2022.arm.Arm
import frc.team449.robot2022.hopper.Hopper
import frc.team449.robot2022.intake.Intake

class OneCrateRight(
  private val robot: frc.team449.robot2022.Robot,
  private val intake: Intake,
  private val arm: Arm,
  private val hopper: Hopper
) {
  fun routine(): AutoRoutine {
    val traj = Paths.OneCrateLeft
    val cmd = ParallelCommandGroup(
      HolonomicFollower(
        robot.drive,
        traj,
        true,
        AutoConstants.MAX_ROTVEL,
        AutoConstants.MAX_ROTACC
      ),
      AutoUtils.autoSequence(
        listOf(
          0.00 to InstantCommand(arm::groundPos),
          0.6 to InstantCommand(intake::runIntake),
          9.0 to InstantCommand(intake::runIntakeReverse)
        )
      )
    )
    return AutoRoutine("One Crate Right", cmd)
  }
}
