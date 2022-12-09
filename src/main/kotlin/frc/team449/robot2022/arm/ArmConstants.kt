package frc.team449.robot2022.arm

import edu.wpi.first.wpilibj.Encoder

object ArmConstants {

  // PID controller values.
  const val kP = 1.0
  const val kI = 0.0
  const val kD = 0.0

  // Maximum velocity and acceleration.
  const val maxVel = 1.0
  const val maxAccel = 1.0

  // Feed forward values.
  const val kV = 0.10764
  const val kS = 0.5727
  const val kA = 0.10546
  const val kG = -0.40959

  const val hopperDesiredAngle = 0.0
  const val groundAngle = Math.PI / 2

  val EXT_ENCODER = Encoder(8, 9)
  const val EXTERNAL_ENC_CPR = 256
  const val ARM_UPR = 2 * Math.PI
  const val ARM_GEARING = 1 / 3.5

  const val MOTOR_CAN_ID = 11
  const val SLAVE_MOTOR_CAN_ID = 12
}
