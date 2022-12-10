package frc.team449.control.auto

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser
import frc.team449.robot2022.Robot
import frc.team449.robot2022.arm.Arm
import frc.team449.robot2022.auto.CrossAutoLine
import frc.team449.robot2022.auto.OneCrate
import frc.team449.robot2022.auto.OneCratept1
import frc.team449.robot2022.auto.RedCratept1
import frc.team449.robot2022.hopper.Hopper
import frc.team449.robot2022.intake.Intake

class AutoChooser(
  robot: Robot,
  intake: Intake,
  arm: Arm,
  hopper: Hopper) : SendableChooser<AutoRoutine>() {
  init {
    // Add options here
    this.setDefaultOption("CrossAutoLine", CrossAutoLine(robot = robot).routine())
    this.addOption("OneCrate", OneCrate(robot = robot).routine())
    this.addOption("Blue Crate Auto", OneCratept1(robot = robot, intake = intake, arm = arm, hopper = hopper).routine())
    this.addOption("Red Crate Auto", RedCratept1(robot = robot, intake = intake, arm = arm, hopper = hopper).routine())
  }
}
