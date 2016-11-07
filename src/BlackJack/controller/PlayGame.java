package BlackJack.controller;

import BlackJack.view.IView;
import BlackJack.model.Game;

public class PlayGame implements BlackJack.model.BlackJackObserver{

	private BlackJack.view.IView m_view;
	private BlackJack.model.Game m_game;
	
	public PlayGame(Game a_game, IView a_view) {
		m_view = a_view;
		m_game = a_game;
	  
		//Add this as subscriber.
		m_game.addSubscriber(this);
	}
	
	//Changed to not have hidden dependencies.
  	public boolean Play() {
  		showInfoAndCards();

  		if (m_game.IsGameOver())
  			m_view.DisplayGameOver(m_game.IsDealerWinner());

  		//MAkes the view collect input
    	m_view.GetInput();
    
    	//Checks if the player wants to play, hit, stand or quit
    	if (m_view.Play())
    		m_game.NewGame();
    	else if (m_view.Hit())
    		m_game.Hit();
    	else if (m_view.Stand())
    		m_game.Stand();
    
    	return  !m_view.Quit();
  	}
  
  	public void cardDealt() {
  		try { 
  			//brief pause.
  			Thread.sleep(1500); 
  			//Show hand.
  			showInfoAndCards();
  		}
  		catch (InterruptedException e) { System.out.println("Something went wrong!"); }
  	}
  	
  	//Method for showing information and dealer/players hand so that it is easily called from cardDealt().
  	public void showInfoAndCards() {
  		m_view.DisplayWelcomeMessage();
  		m_view.DisplayDealerHand(m_game.GetDealerHand(), m_game.GetDealerScore());
  		m_view.DisplayPlayerHand(m_game.GetPlayerHand(), m_game.GetPlayerScore());
  	}
}