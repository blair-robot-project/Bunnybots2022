package frc.team449

import edu.wpi.first.wpilibj.DriverStation
import edu.wpi.first.wpilibj.RobotBase
import edu.wpi.first.wpilibj.TimedRobot
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.wpilibj2.command.CommandScheduler
import frc.team449.control.DriveCommand
import frc.team449.control.auto.AutoChooser
import frc.team449.robot2022.ControllerBinder
import frc.team449.robot2022.Robot
import io.github.oblarg.oblog.Logger

/** The main class of the robot, constructs all the subsystems and initializes default commands. */
class RobotLoop : TimedRobot() {

  private val robot = Robot()
  private var autoChooser: AutoChooser = AutoChooser(robot)
  private var autoCommand: Command? = null

  override fun robotInit() {
    // Yes this should be a print statement, it's useful to know that robotInit started.
    println("Started robotInit.")

    if (RobotBase.isSimulation()) {
      // Don't complain about joysticks if there aren't going to be any
      DriverStation.silenceJoystickConnectionWarning(true)
    }

    Logger.configureLoggingAndConfig(robot, false)
    Shuffleboard.setRecordingFileNameFormat("log-\${time}")
    Shuffleboard.startRecording()

    SmartDashboard.putData(robot.field)

    SmartDashboard.putData(autoChooser)
  }

  override fun robotPeriodic() {
    CommandScheduler.getInstance().run()

    Logger.updateEntries()

    robot.field.robotPose = robot.drive.pose
  }

  override fun autonomousInit() {
    robot.drive.defaultCommand = DriveCommand(robot.drive, robot.oi, false)
    val routine = autoChooser.selected
    if (routine != null) {
      this.autoCommand = routine.cmd
      CommandScheduler.getInstance().schedule(this.autoCommand)
    }
  }

  override fun autonomousPeriodic() {}

  override fun teleopInit() {
    if (autoCommand != null) {
      CommandScheduler.getInstance().cancel(autoCommand)
    }
    robot.drive.stop()
    ControllerBinder(robot.mechanismsController, robot.arm, robot.intake, robot.hopper).bindButtons()
    robot.drive.defaultCommand = DriveCommand(robot.drive, robot.oi, true)
  }

  override fun teleopPeriodic() {
  }

  override fun disabledInit() {
    robot.drive.defaultCommand = DriveCommand(robot.drive, robot.oi, false)
  }

  override fun disabledPeriodic() {}

  override fun testInit() {
    if (autoCommand != null) {
      CommandScheduler.getInstance().cancel(autoCommand)
    }
  }

  override fun testPeriodic() {}

  override fun simulationInit() {}

  override fun simulationPeriodic() {}
}
