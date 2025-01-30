package model;

public abstract class Coin {
  private int value;
  private int size;
  private int x;
  private int y;

  public Coin(int value, int size) {
    this.value = value;
    this.size = size;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public void setLocation(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}
