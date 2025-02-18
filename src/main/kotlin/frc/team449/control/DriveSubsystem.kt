package frc.team449.control

import edu.wpi.first.math.geometry.Pose2d
import edu.wpi.first.math.geometry.Rotation2d
import edu.wpi.first.math.kinematics.ChassisSpeeds
import edu.wpi.first.wpilibj2.command.Subsystem
import io.github.oblarg.oblog.Loggable

/** A drivetrain that uses closed-loop velocity control. */
interface DriveSubsystem : Subsystem, Loggable {
  val heading: Rotation2d
    get() = this.pose.rotation

  var pose: Pose2d

  /** Set the desired speeds to go at. */
  fun set(desiredSpeeds: ChassisSpeeds)

  /** Set both motors' voltage to 0. */
  fun stop()

  /**
   * Used to simulate a drivetrain. Only one instance of this class should be made per drivetrain.
   */
  interface SimController {
    fun update()

    /**
     * Simulate the current drawn by the drivetrain
     */
    fun getCurrentDraw(): Double
  }
}
