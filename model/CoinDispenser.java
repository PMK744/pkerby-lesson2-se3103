package model;

import java.util.ArrayList;
import java.util.Stack;

public class CoinDispenser {
  public static final int SLOT_NICKELS = 0;
  public static final int SLOT_DIMES = 1;
  public static final int SLOT_QUARTERS = 2;

  private final ArrayList<Stack<Coin>> slots = new ArrayList<>();

  public final int maxNickels;
  public final int maxDimes;
  public final int maxQuarters;

  public int selectedSlotIndex = 1;

  public CoinDispenser(int maxNickels, int maxDimes, int maxQuarters) {
    this.maxNickels = maxNickels;
    this.maxDimes = maxDimes;
    this.maxQuarters = maxQuarters;

    slots.add(SLOT_NICKELS, new Stack<Coin>());
    slots.add(SLOT_DIMES, new Stack<Coin>());
    slots.add(SLOT_QUARTERS, new Stack<Coin>()); 
  }

  public void insert(Coin coin) {
    int slotIndex = -1;

    if (coin instanceof Nickel) {
      assert this.getNickelCount() < maxNickels : "Nickel slot is full";
      slotIndex = SLOT_NICKELS;
    } else if (coin instanceof Dime) {
      assert this.getDimeCount() < maxDimes : "Dime slot is full";
      slotIndex = SLOT_DIMES;
    } else if (coin instanceof Quarter) {
      assert this.getQuarterCount() < maxQuarters : "Quarter slot is full";
      slotIndex = SLOT_QUARTERS;
    }

    slots.get(slotIndex).push(coin);
  }

  public void removeByCoinValue(int value) {
    int slotIndex = -1;

    switch (value) {
      case Nickel.VALUE: {
        assert this.getNickelCount() > 0 : "Nickel slot is empty";
        slotIndex = SLOT_NICKELS;
        break;
      }

      case Dime.VALUE: {
        assert this.getDimeCount() > 0 : "Dime slot is empty";
        slotIndex = SLOT_DIMES;
        break;
      }

      case Quarter.VALUE: {
        assert this.getQuarterCount() > 0 : "Quarter slot is empty";
        slotIndex = SLOT_QUARTERS;
        break;
      }
    }

    assert slotIndex >= 0 : "Unknown coin value to remove";

    slots.get(slotIndex).pop();
  }

  public Stack<Coin> getSlot(int index) {
    return slots.get(index);
  }

  public int getNickelCount() {
    return slots.get(SLOT_NICKELS).size();
  }

  public int getDimeCount() {
    return slots.get(SLOT_DIMES).size();
  }

  public int getQuarterCount() {
    return slots.get(SLOT_QUARTERS).size();
  }

  public int getBalance() {
    int balance =
      getNickelCount() * Nickel.VALUE +
      getDimeCount() * Dime.VALUE +
      getQuarterCount() * Quarter.VALUE;
    
    return balance;
  }
}
