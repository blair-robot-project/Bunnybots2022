package frc.team449.robot2022.hopper

import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj2.command.SubsystemBase

// Should this start by closing the gate?
class Hopper(
  private val gate: DoubleSolenoid
) : SubsystemBase() {

  // "Open" means that balls can be transferred into the hopper.
  private var hopperRetracted = true

  fun closeGate() {
    gate.set(DoubleSolenoid.Value.kReverse)
    hopperRetracted = true
  }

  private fun openGate() {
    gate.set(DoubleSolenoid.Value.kForward)
    hopperRetracted = false
  }

  fun toggleGate() {
    if (hopperRetracted) {
      openGate()
    } else {
      closeGate()
    }
  }
}
