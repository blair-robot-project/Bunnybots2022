package frc.team449.control.auto

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser
import frc.team449.robot2022.Robot
import frc.team449.robot2022.auto.OneCrateBlue
import frc.team449.robot2022.auto.OneCrateRed

class AutoChooser(
  robot: Robot
) : SendableChooser<AutoRoutine>() {
  init {
    // Add options here
    // this.setDefaultOption("CrossAutoLine", CrossAutoLine(robot = robot).routine())
    // this.setDefaultOption("OneCrate", OneCrate(robot = robot).routine())
    this.setDefaultOption(
      "Blue Crate Auto",
      OneCrateBlue(
        robot = robot,
        intake = robot.intake,
        arm = robot.arm,
        drive = robot.drive,
        hopper = robot.hopper
      ).routine()
    )
    this.addOption(
      "Red Crate Auto",
      OneCrateRed(
        robot = robot,
        intake = robot.intake,
        arm = robot.arm,
        hopper = robot.hopper
      ).routine()
    )
  }
}
