package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import controller.App;
import controller.CoinTypeListener;
import controller.InsertListener;
import controller.RemoveListener;
import model.CoinDispenser;

public class AppWindow extends JFrame {
  private AppCanvas canvas = new AppCanvas();

  public static final String radioButtonActionNickel = "Nickel";
  public static final String radioButtonActionDime = "Dime";
  public static final String radioButtonActionQuarter = "Quarter";

  public static final String buttionActionInsert = "Insert";
  public static final String buttionActionRemove = "Remove";

  private JButton insertButton = new JButton(buttionActionInsert);
  private JButton removeButton = new JButton(buttionActionRemove);

  public void init() {
    var cp = this.getContentPane();

    int selectedSlotIndex = App.dispenser.selectedSlotIndex;

    JPanel southPanel = new JPanel();
    southPanel.setLayout(new GridLayout(2, 1));
    
    // Radio buttons for coin type
    JPanel coinTypePanel = new JPanel();
    coinTypePanel.setBorder(new TitledBorder("Coin type"));
    JRadioButton nickelButton = new JRadioButton(radioButtonActionNickel, selectedSlotIndex == CoinDispenser.SLOT_NICKELS);
    JRadioButton dimeButton = new JRadioButton(radioButtonActionDime, selectedSlotIndex == CoinDispenser.SLOT_DIMES);
    JRadioButton quarterButton = new JRadioButton(radioButtonActionQuarter, selectedSlotIndex == CoinDispenser.SLOT_QUARTERS);
    ButtonGroup coinGroup = new ButtonGroup();
    coinGroup.add(nickelButton);
    coinGroup.add(dimeButton);
    coinGroup.add(quarterButton);
    coinTypePanel.add(nickelButton);
    coinTypePanel.add(dimeButton);
    coinTypePanel.add(quarterButton);
    southPanel.add(coinTypePanel);

    CoinTypeListener coinTypeListener = new CoinTypeListener();
    nickelButton.addActionListener(coinTypeListener);
    dimeButton.addActionListener(coinTypeListener);
    quarterButton.addActionListener(coinTypeListener);

    // 2 buttons for insert and remove
    JPanel actionPanel = new JPanel();
    actionPanel.setBorder(new TitledBorder("Action"));
    actionPanel.add(this.insertButton);
    actionPanel.add(this.removeButton);
    southPanel.add(actionPanel);

    InsertListener insertListener = new InsertListener();
    this.insertButton.addActionListener(insertListener);

    RemoveListener removeListener = new RemoveListener();
    this.removeButton.addActionListener(removeListener);

    // Add the panels to the content pane
    cp.add(this.canvas, BorderLayout.CENTER);
    cp.add(southPanel, BorderLayout.SOUTH);

    this.updateWindow();
  }

  public void updateWindow() {
    // update components on the window
    int selectedSlotIndex = App.dispenser.selectedSlotIndex;
    int coinCount = 0;
    int maxAllowed = 0;

    switch (selectedSlotIndex) {
      case CoinDispenser.SLOT_NICKELS: {
        coinCount = App.dispenser.getNickelCount();
        maxAllowed = App.dispenser.maxNickels;
        break;
      }

      case CoinDispenser.SLOT_DIMES: {
        coinCount = App.dispenser.getDimeCount();
        maxAllowed = App.dispenser.maxDimes;
        break;
      }

      case CoinDispenser.SLOT_QUARTERS: {
        coinCount = App.dispenser.getQuarterCount();
        maxAllowed = App.dispenser.maxQuarters;
        break;
      }
    }

    this.insertButton.setEnabled(coinCount < maxAllowed);
    this.removeButton.setEnabled(coinCount > 0);

    this.canvas.repaint();
  }
}
