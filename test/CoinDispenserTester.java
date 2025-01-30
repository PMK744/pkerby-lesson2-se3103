package test;

import model.CoinDispenser;
import model.Dime;
import model.Nickel;
import model.Quarter;

public class CoinDispenserTester {
  public static void main(String[] args) {
    CoinDispenser dispenser = new CoinDispenser(5, 6, 4);

    dispenser.insert(new Dime());
    dispenser.insert(new Dime());
    dispenser.insert(new Dime());
    dispenser.insert(new Quarter());
    dispenser.insert(new Quarter());
    dispenser.insert(new Nickel());

    assert dispenser.getDimeCount() == 3 : "Dime count is incorrect";
    assert dispenser.getQuarterCount() == 2 : "Quarter count is incorrect";
    assert dispenser.getNickelCount() == 1 : "Nickel count is incorrect";

    dispenser.removeByCoinValue(10);
  }
}
