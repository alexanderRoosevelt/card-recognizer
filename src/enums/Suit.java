package enums;

public enum Suit {
  H("h"), D("d"), C("c"), S("s");

  private final String value;

  Suit(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}