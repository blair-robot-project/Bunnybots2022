package frc.team449.control

import edu.wpi.first.wpilibj2.command.CommandBase

/**
 * Generic driving command that applies the OI output to the Drive
*/
class DriveCommand(
  private val drive: DriveSubsystem,
  private val oi: OI,
  private val run: Boolean
) : CommandBase() {

  init {
    addRequirements(drive)
  }

  override fun execute() {
    if (run) {
      drive.set(oi.get())
    } else {
      drive.stop()
    }
  }
}
