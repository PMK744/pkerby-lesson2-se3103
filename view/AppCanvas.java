package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

import controller.App;
import model.Coin;
import model.CoinDispenser;

public class AppCanvas extends JPanel {
  public static final int WIDTH = 700;
  public static final int HEIGHT = 300;

  public static final int X_SLOT = 90;
  public static final int Y_TITLE = 50;
  public static final int Y_NICKEL = 100;
  public static final int Y_DIME = 170;
  public static final int Y_QUARTER = 240;

  final Font titleFont = new Font("Courier New", Font.BOLD, 30);
  final Font coinTypeFont = new Font("Courier New", Font.ITALIC, 14);

  final Color nickleColor = Color.RED;
  final Color dimeColor = Color.BLUE;
  final Color quarterColor = Color.GREEN;

  public AppCanvas() {
    super();

    this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
  }

  @Override
  public void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);
    this.drawTextStrings((Graphics2D) graphics);
    this.drawCoinSlots((Graphics2D) graphics);
  }

  private void drawTextStrings(Graphics2D graphics) {
    // Get the coin dispenser instance from the App class
    CoinDispenser dispenser = App.dispenser;

    graphics.setFont(titleFont);
    graphics.drawString(
      String.format("Coin Dispenser (balance = %dc)", dispenser.getBalance()),
      X_SLOT, Y_TITLE
    );

    graphics.setFont(coinTypeFont);
    graphics.drawString(
      String.format(
        "Nickels (%d of %d)",
        dispenser.getNickelCount(),
        dispenser.maxNickels
      ),
      X_SLOT, Y_NICKEL
    );

    graphics.setFont(coinTypeFont);
    graphics.drawString(
      String.format(
        "Dimes (%d of %d)",
        dispenser.getDimeCount(),
        dispenser.maxDimes
      ),
      X_SLOT, Y_DIME
    );

    graphics.setFont(coinTypeFont);
    graphics.drawString(
      String.format(
        "Quarters (%d of %d)",
        dispenser.getQuarterCount(),
        dispenser.maxQuarters
      ),
      X_SLOT, Y_QUARTER
    );
  }

  private void drawCoin(Graphics2D graphics, Coin coin) {
    var e = new Ellipse2D.Float(coin.getX(), coin.getY(), coin.getSize(), coin.getSize());

    graphics.fill(e);
  }

  private void drawCoinSlots(Graphics2D graphics) {
    graphics.setColor(nickleColor);
    for (var x: App.dispenser.getSlot(CoinDispenser.SLOT_NICKELS)) {
      this.drawCoin(graphics, x);
    }

    graphics.setColor(dimeColor);
    for (var x: App.dispenser.getSlot(CoinDispenser.SLOT_DIMES)) {
      this.drawCoin(graphics, x);
    }

    graphics.setColor(quarterColor);
    for (var x: App.dispenser.getSlot(CoinDispenser.SLOT_QUARTERS)) {
      this.drawCoin(graphics, x);
    }
  }
}
