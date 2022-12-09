package frc.team449.robot2022.intake

object IntakeConstants {

  const val INTAKE_VOLTAGE = 4.0

  const val PNEUMATICS_FORWARD_CHANNEL = 2
  const val PNEUMATICS_REVERSE_CHANNEL = 3

  const val IR_SENSOR_CHANNEL = 7

  const val LEFT_CAN_ID = 10
  const val RIGHT_CAN_ID = 9

  const val INTAKE_UPR = 2 * Math.PI
  const val INTAKE_GEARING = 1.0 / 4.0

  // TODO: Find optimal wait time
  const val automatedWaitSeconds = 3.0
}
