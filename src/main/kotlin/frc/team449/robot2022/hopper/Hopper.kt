package frc.team449.robot2022.hopper

import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj2.command.SubsystemBase

// Should this start by closing the gate?
class Hopper(
  private val gate: DoubleSolenoid
) : SubsystemBase() {

  // "Open" means that balls can be transferred into the hopper.
  private var hopperOpen = true

  fun toggleGate() {
    if (hopperOpen) {
      gate.set(DoubleSolenoid.Value.kForward)
      hopperOpen = false
    } else {
      gate.set(DoubleSolenoid.Value.kReverse)
      hopperOpen = true
    }
  }
}
