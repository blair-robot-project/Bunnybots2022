package frc.team449.robot2022.auto

import edu.wpi.first.wpilibj2.command.InstantCommand
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup
import frc.team449.control.auto.AutoRoutine
import frc.team449.control.auto.AutoUtils
import frc.team449.control.auto.HolonomicFollower
import frc.team449.robot2022.arm.Arm
import frc.team449.robot2022.hopper.Hopper
import frc.team449.robot2022.intake.Intake

class OneCrateRed(
  private val robot: frc.team449.robot2022.Robot,
  private val intake: Intake,
  private val arm: Arm,
  private val hopper: Hopper
) {
  fun routine(): AutoRoutine {
    val traj1 = Paths.RedCratept1
    val traj2 = Paths.RedCratept2
    val traj3 = Paths.RedCratept3
    val cmd = ParallelCommandGroup(
      HolonomicFollower(
        robot.drive,
        traj1,
        true,
        AutoConstants.MAX_ROTVEL,
        AutoConstants.MAX_ROTACC
      ),
      AutoUtils.autoSequence(
        listOf(
          0.75 to InstantCommand(intake::runIntake),
        )
      )
    )
    return AutoRoutine("One Crate Red", cmd)
  }
}
