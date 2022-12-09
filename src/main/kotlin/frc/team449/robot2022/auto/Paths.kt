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
}
