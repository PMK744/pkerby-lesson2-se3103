package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.CoinDispenser;
import view.AppWindow;

public class CoinTypeListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		int slotIndex = -1;

    switch (e.getActionCommand()) {
      case AppWindow.radioButtonActionNickel: {
        slotIndex = CoinDispenser.SLOT_NICKELS;
        break;
      }

      case AppWindow.radioButtonActionDime: {
        slotIndex = CoinDispenser.SLOT_DIMES;
        break;
      }

      case AppWindow.radioButtonActionQuarter: {
        slotIndex = CoinDispenser.SLOT_QUARTERS;
        break;
      }
    }

    assert slotIndex >= 0 : "Unknown slot index for coin type";

    App.dispenser.selectedSlotIndex = slotIndex;
    App.win.updateWindow();
	}
}
