package frc.team449.robot2022

import edu.wpi.first.wpilibj.*
import edu.wpi.first.wpilibj.RobotBase.isReal
import frc.team449.RobotBase
import frc.team449.control.holonomic.OIHolonomic.Companion.createHolonomicOI
import frc.team449.control.holonomic.SwerveDrive
import frc.team449.control.holonomic.SwerveDrive.Companion.swerveDrive
import frc.team449.robot2022.arm.Arm
import frc.team449.robot2022.arm.ArmConstants
import frc.team449.robot2022.hopper.Hopper
import frc.team449.robot2022.hopper.HopperConstants
import frc.team449.robot2022.intake.Intake
import frc.team449.robot2022.intake.IntakeConstants
import frc.team449.system.AHRS
import frc.team449.system.encoder.NEOEncoder
import frc.team449.system.encoder.QuadEncoder
import frc.team449.system.motor.createSparkMax
import io.github.oblarg.oblog.annotations.Log

class Robot : RobotBase() {

  // Other CAN IDs
  private val PDP_CAN = 1
  private val PCM_MODULE = 0

  val driveController = XboxController(0)
  val mechanismsController = XboxController(1)

  private val ahrs = AHRS(SerialPort.Port.kMXP)

  // Instantiate/declare PDP and other stuff here

  override val powerDistribution: PowerDistribution = PowerDistribution(PDP_CAN, PowerDistribution.ModuleType.kCTRE)

  /**
   * Converts the drive to a SwerveSim if the robot is in simulation
   */
  @Log.Include
  override val drive = if (isReal()) swerveDrive(ahrs) else SwerveDrive.simOf(swerveDrive(ahrs))

  override val oi = createHolonomicOI(drive, driveController)

  private val armMotor = createSparkMax(
    "Arm",
    ArmConstants.MOTOR_CAN_ID,
    QuadEncoder.creator(
      ArmConstants.EXT_ENCODER,
      ArmConstants.EXTERNAL_ENC_CPR,
      ArmConstants.ARM_UPR,
      ArmConstants.ARM_GEARING,
      false
    ),
    slaveSparks = mapOf(Pair(ArmConstants.SLAVE_MOTOR_CAN_ID, false))
  )

  private val intakeMotor = createSparkMax(
    "Intake",
    IntakeConstants.LEFT_CAN_ID,
    NEOEncoder.creator(
      IntakeConstants.INTAKE_UPR,
      IntakeConstants.INTAKE_GEARING
    ),
    slaveSparks = mapOf(Pair(IntakeConstants.RIGHT_CAN_ID, true))
  )

  private val intakePneumatics = DoubleSolenoid(
    PCM_MODULE,
    PneumaticsModuleType.CTREPCM,
    IntakeConstants.PNEUMATICS_FORWARD_CHANNEL,
    IntakeConstants.PNEUMATICS_REVERSE_CHANNEL
  )

  private val intakeSensor = DigitalInput(IntakeConstants.IR_SENSOR_CHANNEL)

  private val hopperPneumatics = DoubleSolenoid(
    PCM_MODULE,
    PneumaticsModuleType.CTREPCM,
    HopperConstants.PNEUMATICS_FORWARD_CHANNEL,
    HopperConstants.PNEUMATICS_REVERSE_CHANNEL
  )

  val arm = Arm(armMotor)
  val hopper = Hopper(hopperPneumatics)
  val intake = Intake(intakeMotor, intakeSensor, intakePneumatics, arm, hopper)
}
