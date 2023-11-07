package enums;

public enum Deck {
  TWO("2"),
  THREE("3"),
  FOUR("4"),
  FIVE("5"),
  SIX("6"),
  SEVEN("7"),
  EIGHT("8"),
  NINE("9"),
  TEN("10"),
  VALET("J"),
  LADY("Q"),
  KING("K"),
  ACE("A");

  private final String value;

  Deck(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}