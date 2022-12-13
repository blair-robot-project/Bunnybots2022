package frc.team449.robot2022.auto

import com.pathplanner.lib.PathPlanner

object Paths {

  val TwoCrateRight =
    PathPlanner.loadPath(
      "Right Two Crate",
      AutoConstants.MAX_VEL,
      AutoConstants.MAX_ACC
    )

  val TwoCrateLeft =
    PathPlanner.loadPath(
      "Left Two Crate",
      AutoConstants.MAX_VEL,
      AutoConstants.MAX_ACC
    )

  val OneCrateRight =
    PathPlanner.loadPath(
      "Right",
      AutoConstants.MAX_VEL,
      AutoConstants.MAX_ACC
    )

  val OneCratept2 =
    PathPlanner.loadPath(
      "One Crate pt. 2",
      AutoConstants.MAX_VEL,
      AutoConstants.MAX_ACC
    )

  val OneCratept3 = PathPlanner.loadPath(
    "One Crate pt. 3",
    AutoConstants.MAX_VEL,
    AutoConstants.MAX_ACC
  )

  val OneCrateLeft =
    PathPlanner.loadPath(
      "Left",
      AutoConstants.MAX_VEL,
      AutoConstants.MAX_ACC
    )

  val RedCratept2 =
    PathPlanner.loadPath(
      "Red Crate pt. 2",
      AutoConstants.MAX_VEL,
      AutoConstants.MAX_ACC
    )

  val RedCratept3 =
    PathPlanner.loadPath(
      "Red Crate pt. 3",
      AutoConstants.MAX_VEL,
      AutoConstants.MAX_ACC
    )
}
