package game.fighting.combatLogic;

import game.fighting.Trainer;

public class Battle {
	
	private Trainer t1, t2;
	private CombatLogic logic;
	
	public Battle(Trainer t1, Trainer t2)
	{
		this.t1 = t1;
		this.t2 = t2;
		logic = new CombatLogic();
		
	}
	
	public void setCombatLogic()
	{
		logic = new CombatLogic();
	}
	
	public void playTurn()
	{
		
	}
}
