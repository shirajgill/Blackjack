package blackjack;

public enum Ranks {
	 ACE("A"),
   TWO("2"),
   THREE("3"),
   FOUR("4"),
   FIVE("5"),
   SIX("6"),
   SEVEN("7"),
   EIGHT("8"),
   NINE("9"),
   TEN("10"),
   JACK("J"),
   QUEEN("Q"),
   KING("K");
	
	//Hold the symbol that represents the rank 
	private String rankSymbol;
	
	private Ranks(String rankSymbol) { 
		this.rankSymbol = rankSymbol; 
	}
	
	public static Ranks getRankFromSymbol(String symbol) throws Exception {
		//Loop over all ranks and...
		for (Ranks rank : Ranks.values()) {
			//If the symbols match for this rank... 
			if (rank.getSymbol().equals(symbol)) { 
				//suit is the suit associated with the symbol
				return rank;
			}
		}
		throw new Exception("Incorrect Card Used");
	}
	
	public String getSymbol() {
		return this.rankSymbol;
	}
}
