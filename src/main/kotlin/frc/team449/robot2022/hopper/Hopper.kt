package frc.team449.robot2022.hopper

import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj2.command.SubsystemBase

// Should this start by closing the gate?
class Hopper(private val gate: DoubleSolenoid) : SubsystemBase() {
  var gateOpen = false
    private set

  fun openGate() {
    gate.set(DoubleSolenoid.Value.kReverse)
    gateOpen = true
  }

  fun closeGate() {
    gate.set(DoubleSolenoid.Value.kForward)
    gateOpen = false
  }

  fun toggleGate() {
    if (gateOpen) {
      closeGate()
    } else {
      openGate()
    }
  }
}
