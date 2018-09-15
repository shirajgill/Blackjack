package blackjack;

public enum Suits {
	SPADES("S"),
	CLUBS("C"),
	HEARTS("H"),
	DIAMONDS("D");
	
	//Hold the symbol that represents the suit 
	private String suitSymbol;
	
	private Suits(String suitSymbol) { 
		this.suitSymbol = suitSymbol; 
	}
	
	public static Suits getSuitFromSymbol(String symbol) {
		//Loop over all suits and...
		for (Suits suit : Suits.values()) {
			//If the symbols match for this suit... 
			if (suit.getSymbol().equals(symbol)) {
				//suit is the suit associated with the symbol
				return suit;
			}
		}
		//Return null if no suit with the symbol
		return null;
	}
	
	public String getSymbol() {
		return this.suitSymbol;
	}
	
}
