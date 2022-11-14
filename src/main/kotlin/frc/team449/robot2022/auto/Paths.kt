package frc.team449.robot2022.auto

import com.pathplanner.lib.PathPlanner

object Paths {

  val TEST =
    PathPlanner.loadPath(
      "Simple",
      AutoConstants.MAX_VEL,
      AutoConstants.MAX_ACC
    )
  val FIVE_BALL =
    PathPlanner.loadPath(
      "wishes",
      AutoConstants.MAX_VEL,
      AutoConstants.MAX_ACC
    )
  val EEEEE =
    PathPlanner.loadPath(
      "9",
      AutoConstants.MAX_VEL,
      AutoConstants.MAX_ACC
    )
  val EEEEEREAL =
    PathPlanner.loadPath(
      "eeeee",
      AutoConstants.MAX_VEL,
      AutoConstants.MAX_ACC
    )
  val WEAVE =
    PathPlanner.loadPath(
      "weave",
      AutoConstants.MAX_VEL,
      AutoConstants.MAX_ACC
    )
  val FOUR =
    PathPlanner.loadPath(
      "4",
      AutoConstants.MAX_VEL,
      AutoConstants.MAX_ACC
    )
}
