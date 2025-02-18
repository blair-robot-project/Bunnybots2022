package frc.team449.robot2022.drive

import edu.wpi.first.math.util.Units

object DriveConstants {

  /** Drive motor ports */
  const val DRIVE_MOTOR_FL = 1
  const val DRIVE_MOTOR_FR = 3
  const val DRIVE_MOTOR_BL = 5
  const val DRIVE_MOTOR_BR = 7
  const val TURN_MOTOR_FL = 2
  const val TURN_MOTOR_FR = 4
  const val TURN_MOTOR_BL = 6
  const val TURN_MOTOR_BR = 8

  /** Turning encoder channels */
  const val TURN_ENC_CHAN_FL = 1
  const val TURN_ENC_CHAN_FR = 0
  const val TURN_ENC_CHAN_BL = 3
  const val TURN_ENC_CHAN_BR = 2

  /** Offsets for the absolute encoders in rotations */
  const val TURN_ENC_OFFSET_FL = 0.035288
  const val TURN_ENC_OFFSET_FR = 0.112509
  const val TURN_ENC_OFFSET_BL = 0.870836 - 0.5
  const val TURN_ENC_OFFSET_BR = 0.963748 - 0.5

  /** PID gains for turning each module */
  const val TURN_KP = 0.75
  const val TURN_KI = 0.0
  const val TURN_KD = 0.0

  /** teddy is the best */

  /** Feed forward values for driving each module */
  const val DRIVE_KS = 0.14947
  const val DRIVE_KV = 2.6075
  const val DRIVE_KA = 0.20546

  /** PID gains for driving each module*/
  const val DRIVE_KP = 0.4
  const val DRIVE_KI = 0.0
  const val DRIVE_KD = 0.0

  /** Drive configuration */
  const val DRIVE_GEARING = 1 / 6.75
  const val DRIVE_UPR = 0.31818905832
  const val TURN_UPR = 2 * Math.PI
  const val MAX_LINEAR_SPEED = 2.25
  const val MAX_ROT_SPEED = 3.0
  const val MAX_ATTAINABLE_MK4I_SPEED = 4.267
  const val MAX_ACCEL = 4.5

  /** Controller Configurations */
  const val RATE_LIMIT = 10.5
  const val TRANSLATION_DEADBAND = .08
  const val ROTATION_DEADBAND = .07

  val WHEELBASE = Units.inchesToMeters(21.75)
  val TRACKWIDTH = Units.inchesToMeters(21.75)
}
