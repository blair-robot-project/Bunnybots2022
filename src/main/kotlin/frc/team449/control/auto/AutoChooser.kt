package frc.team449.control.auto

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser
import frc.team449.robot2022.Robot
import frc.team449.robot2022.auto.CrossLine
import frc.team449.robot2022.auto.Eeeee
import frc.team449.robot2022.auto.Example
import frc.team449.robot2022.auto.Weave

class AutoChooser(robot: Robot) : SendableChooser<AutoRoutine>() {
  init {
    // Add options here
    this.setDefaultOption("example", Example(robot = robot).routine())
    this.addOption("5 e's", Eeeee(robot = robot).routine())
    this.addOption("weavebot", Weave(robot = robot).routine())
    this.addOption("CrossLine", CrossLine(robot = robot).routine())
  }
}
