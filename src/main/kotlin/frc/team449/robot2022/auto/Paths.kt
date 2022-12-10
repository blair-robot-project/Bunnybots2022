package frc.team449.robot2022.auto

import com.pathplanner.lib.PathPlanner

object Paths {

  val OneCrate =
    PathPlanner.loadPath(
      "One Crate",
      AutoConstants.MAX_VEL,
      AutoConstants.MAX_ACC
    )

  val CrossAutoLine =
    PathPlanner.loadPath(
      "crossAutoLine",
      AutoConstants.MAX_VEL,
      AutoConstants.MAX_ACC
    )

  val OneCratept1 =
    PathPlanner.loadPath(
      "One Crate pt. 1",
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

  val RedCratept1 =
    PathPlanner.loadPath(
      "Red Crate pt. 1",
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
