package frc.team449.robot2022.hopper

import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj2.command.SubsystemBase

// Should this start by closing the gate?
class Hopper(
  private val gate: DoubleSolenoid
) : SubsystemBase() {

  // "Retracted" means that the hopper is near the robot and not opened.
  private var hopperRetracted = true

  fun retractHopper() {
    gate.set(DoubleSolenoid.Value.kReverse)
    hopperRetracted = true
  }

  private fun dumpHopper() {
    gate.set(DoubleSolenoid.Value.kForward)
    hopperRetracted = false
  }

  fun toggleGate() {
    if (hopperRetracted) {
      dumpHopper()
    } else {
      retractHopper()
    }
  }
}
