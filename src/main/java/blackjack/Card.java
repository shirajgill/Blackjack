package blackjack;

public class Card {
	//Holds the value of the card 
	private int value;
	//Holds the suit of the card
	private Suits suit;
	//Holds the rank of the card
	private Ranks rank;
	
	//Constructor 
	public Card(Suits suit, Ranks rank) {
		this.value = this.getValueBasedOnCard(rank);
		this.suit = suit;
		this.rank = rank;
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
	
	 
   public boolean equals(Card card) { 
 
	   //The easy case is that if the   
	   if (card == this) { 
	  	 return true; 
	   } 
	 
	   //If the object is not instance of the card object return false
	   if (!(card instanceof Card)) {
	  	 return false;
	   }
	   
	   //Return true if the rank and suit match
	   return this.suit == card.suit && this.rank == card.rank;
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
}