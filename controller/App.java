package controller;

import javax.swing.JFrame;

import model.CoinDispenser;
import view.AppWindow;

public class App {
  public static final AppWindow win = new AppWindow();
  public static final CoinDispenser dispenser = new CoinDispenser(10, 12, 8);
  
  public static void main(String[] args) {
    win.init();
    win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    win.setLocation(300, 200);
    win.pack();
    win.setVisible(true);
  }
}
