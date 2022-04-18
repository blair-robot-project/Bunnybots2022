package frc.team449.abstractions;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.Subsystem;

/** A drivetrain that uses closed-loop velocity control. */
public interface DriveSubsystem extends Subsystem {
  /** Set the desired speeds to go at. */
  void set(ChassisSpeeds desiredSpeeds);

  // todo make AHRS class
  // AHRS getAHRS();

  /** Reset the drivetrain's pose. Should really only be done at the start of auto. */
  Pose2d setPose(Pose2d pose);

  Pose2d getPose();

  /** Set both motors' voltage to 0. */
  void stop();
}
