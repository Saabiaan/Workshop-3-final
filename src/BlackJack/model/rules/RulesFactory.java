package BlackJack.model.rules;

public class RulesFactory {

  public IHitStrategy GetHitRule() { return new Soft17(); }

  public INewGameStrategy GetNewGameRule() { return new AmericanNewGameStrategy(); }
  
  public IWinner GetWinnerRule() { return new IsPlayerWinner(); }
}