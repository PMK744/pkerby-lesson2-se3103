package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Coin;
import model.CoinDispenser;
import model.Dime;
import model.Nickel;
import model.Quarter;
import view.AppCanvas;

public class InsertListener implements ActionListener {
  
  @Override
  public void actionPerformed(ActionEvent e) {
    Coin newCoin = null;
    CoinDispenser dispenser = App.dispenser;
    int selectedSlotIndex = dispenser.selectedSlotIndex;

    int x = 0;
    int y = 0;

    if (selectedSlotIndex == CoinDispenser.SLOT_NICKELS) {
      assert dispenser.getNickelCount() < dispenser.maxNickels : "Nickel slot is full";

      newCoin = new Nickel();

      x = AppCanvas.X_SLOT + dispenser.getNickelCount() * (Nickel.SIZE + 10);
      y = AppCanvas.Y_NICKEL;
    } else if (selectedSlotIndex == CoinDispenser.SLOT_DIMES) {
      assert dispenser.getDimeCount() < dispenser.maxDimes : "Dime slot is full";

      newCoin = new Dime();

      x = AppCanvas.X_SLOT + dispenser.getDimeCount() * (Dime.SIZE + 10);
      y = AppCanvas.Y_DIME;
    } else if (selectedSlotIndex == CoinDispenser.SLOT_QUARTERS) {
      assert dispenser.getQuarterCount() < dispenser.maxQuarters : "Quarter slot is full";

      newCoin = new Quarter();

      x = AppCanvas.X_SLOT + dispenser.getQuarterCount() * (Quarter.SIZE + 10);
      y = AppCanvas.Y_QUARTER;
    }

    assert newCoin != null : "Unknown coin type";

    newCoin.setLocation(x, y);

    dispenser.getSlot(selectedSlotIndex).push(newCoin);

    App.win.updateWindow();
  }
}
