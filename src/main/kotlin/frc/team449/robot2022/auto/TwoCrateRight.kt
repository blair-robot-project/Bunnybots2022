package frc.team449.robot2022.auto

import edu.wpi.first.wpilibj2.command.InstantCommand
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup
import frc.team449.control.auto.AutoRoutine
import frc.team449.control.auto.AutoUtils
import frc.team449.control.auto.HolonomicFollower
import frc.team449.robot2022.arm.Arm
import frc.team449.robot2022.hopper.Hopper
import frc.team449.robot2022.intake.Intake

class TwoCrateRight(
  private val robot: frc.team449.robot2022.Robot,
  private val intake: Intake,
  private val arm: Arm,
  private val hopper: Hopper
) {
  fun routine(): AutoRoutine {
    val traj1 = Paths.OneCrateRight
    val traj2 = Paths.TwoCrateRight
    val cmd = ParallelCommandGroup(
      SequentialCommandGroup(
        HolonomicFollower(
          robot.drive,
          traj1,
          true,
          AutoConstants.MAX_ROTVEL,
          AutoConstants.MAX_ROTACC
        ),
        InstantCommand(intake::runIntakeReverse),
        HolonomicFollower(
          robot.drive,
          traj2,
          false,
          AutoConstants.MAX_ROTVEL,
          AutoConstants.MAX_ROTACC
        )
      ),
      AutoUtils.autoSequence(
        listOf(
          0.00 to InstantCommand(arm::groundPos),
          0.75 to InstantCommand(intake::runIntake),
          9.5 to InstantCommand(intake::runIntake)
        )
      )
    )
    return AutoRoutine("One Crate Left", cmd)
  }
}
