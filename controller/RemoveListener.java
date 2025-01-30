package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.CoinDispenser;

public class RemoveListener implements ActionListener {

  @Override
  public void actionPerformed(ActionEvent e) {
    CoinDispenser dispenser = App.dispenser;
    int selectedSlotIndex = dispenser.selectedSlotIndex;

    assert 0 <= selectedSlotIndex && selectedSlotIndex <= 2 : "Invalid slot index for remove";
    assert dispenser.getSlot(selectedSlotIndex).size() > 0 : "Empty coin slot";
    
    dispenser.getSlot(selectedSlotIndex).pop();

    App.win.updateWindow();
  }
}
