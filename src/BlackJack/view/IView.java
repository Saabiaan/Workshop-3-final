package BlackJack.view;

	public interface IView {
		//Methods for checking what action the player wants.
		boolean Play();
		boolean Stand();
		boolean Hit();
		boolean Quit();
		
		void DisplayWelcomeMessage();
		void GetInput(); //Changed to void instead of int.
		void DisplayCard(BlackJack.model.Card a_card);
		void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);
		void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);
		void DisplayGameOver(boolean a_dealerIsWinner);
	}