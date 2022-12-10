package frc.team449.robot2022.auto

import edu.wpi.first.wpilibj2.command.InstantCommand
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup
import frc.team449.control.auto.AutoRoutine
import frc.team449.control.auto.AutoUtils
import frc.team449.control.auto.HolonomicFollower
import frc.team449.robot2022.arm.Arm
import frc.team449.robot2022.hopper.Hopper
import frc.team449.robot2022.intake.Intake

class OneCratept1(
  private val robot: frc.team449.robot2022.Robot,
  private val intake: Intake,
  private val arm: Arm,
  private val hopper: Hopper) {
  fun routine(): AutoRoutine {
    val traj1 = Paths.OneCratept1
    val traj2 = Paths.OneCratept2
    val traj3 = Paths.OneCratept3
    val cmd = ParallelCommandGroup(
      HolonomicFollower(
        robot.drive,
        traj1,
        true,
        AutoConstants.MAX_ROTVEL,
        AutoConstants.MAX_ROTACC
      ).andThen(
        HolonomicFollower(
          robot.drive,
          traj2,
          false,
          AutoConstants.MAX_ROTVEL,
          AutoConstants.MAX_ROTACC
        ).andThen(
          HolonomicFollower(
            robot.drive,
            traj3,
            false,
            AutoConstants.MAX_ROTVEL,
            AutoConstants.MAX_ROTACC
          )
        )
      ),
      AutoUtils.autoSequence(
        listOf(
          1.0 to InstantCommand(intake::runIntake),
          2.09 to InstantCommand(intake::stop),
          2.59 to InstantCommand(arm::hopperPos),
          4.34 to InstantCommand(arm::groundPos),
          4.84 to InstantCommand(intake::runIntakeReverse),
          5.59 to InstantCommand (intake::runIntake),
          6.77 to InstantCommand(intake::stop),
          7.27 to InstantCommand(arm::hopperPos),
          8.12 to InstantCommand(hopper::toggleGate)
        )
      )
    )
    return AutoRoutine("One Crate pt. 1", cmd)
  }
}