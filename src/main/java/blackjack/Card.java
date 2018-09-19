package blackjack;

public class Card {
	//Holds the value of the card 
	private int value;
	//Holds the suit of the card
	private Suits suit;
	//Holds the rank of the card
	private Ranks rank;
	
	//Constructor with Suit and Rank
	public Card(Suits suit, Ranks rank) {
		this.suit = suit;
		this.rank = rank;
		this.value = this.getValueBasedOnCard(rank);
	}
	
	//Constructor with the symbols 
	public Card(String suitSymbol, String rankSymbol) {
		//Get the rank and suit associated with the symbols and call the constructor 
		this(Suits.getSuitFromSymbol(suitSymbol), Ranks.getRankFromSymbol(rankSymbol));
	}
	
	private int getValueBasedOnCard(Ranks rank) {
		//Based on the rank, compute the value
		switch (rank) {
     	case ACE:
         return 1;
             
     	case TWO:
        return 2;
     	
     	case THREE:
        return 3;
        
     	case FOUR:
        return 4;
        
     	case FIVE:
        return 5;
     	
     	case SIX:
        return 6;
        
     	case SEVEN:
        return 7;
        
     	case EIGHT:
        return 8;
        
     	case NINE:
        return 9;
     	
     	case TEN:
        return 10;
      
     	case JACK:
        return 10;
      
      case QUEEN:
        return 10;
        
      case KING:
        return 10;
      
      default:
      	throw new IllegalArgumentException("Unrecoganized card rank");
		}
	}
	
	 
   public boolean rankEquals(Card card) { 
	   //Return true if the rank match
	   return this.rank == card.rank;
   } 
   
   public boolean equals(Card card) { 
  	 //This functions returns true if both suit and rank match 
	   //Return true if the rank and suit match
	   return this.rank == card.rank && this.suit == card.suit;
   } 

	
	public int getValue() {
		return value;
	}
	

	public void setValue(int value) {
		this.value = value;
	}

	public Suits getSuit() {
		return suit;
	}

	public void setSuit(Suits suit) {
		this.suit = suit;
	}

	public Ranks getRank() {
		return rank;
	}

	public void setRank(Ranks rank) {
		this.rank = rank;
	}
	
	public String toString() { 
    return this.suit.getSymbol() + this.rank.getSymbol();
} 
}