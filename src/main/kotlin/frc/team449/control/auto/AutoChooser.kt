package frc.team449.control.auto

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser
import frc.team449.robot2022.Robot
import frc.team449.robot2022.auto.OneCrateLeft
import frc.team449.robot2022.auto.OneCrateRight

class AutoChooser(
  robot: Robot
) : SendableChooser<AutoRoutine>() {
  init {
    // Add options here
    // this.setDefaultOption("CrossAutoLine", CrossAutoLine(robot = robot).routine())
    // this.setDefaultOption("OneCrate", OneCrate(robot = robot).routine())
    this.addOption(
      "One Crate Right",
      OneCrateRight(
        robot = robot,
        intake = robot.intake,
        arm = robot.arm,
        hopper = robot.hopper
      ).routine()
    )
    this.setDefaultOption(
      "One Crate Left",
      OneCrateLeft(
        robot = robot,
        intake = robot.intake,
        arm = robot.arm,
        hopper = robot.hopper
      ).routine()
    )
  }
}
