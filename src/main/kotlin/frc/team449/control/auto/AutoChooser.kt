package frc.team449.control.auto

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser
import frc.team449.robot2022.Robot
import frc.team449.robot2022.auto.CrossAutoLine
import frc.team449.robot2022.auto.OneCrate

class AutoChooser(robot: Robot) : SendableChooser<AutoRoutine>() {
  init {
    // Add options here
    this.setDefaultOption("CrossAutoLine", CrossAutoLine(robot = robot).routine())
    this.addOption("OneCrate", OneCrate(robot = robot).routine())
  }
}
