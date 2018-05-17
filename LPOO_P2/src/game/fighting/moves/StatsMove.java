package game.fighting.moves;

import game.fighting.combatLogic.Types;

//fighter move that affects the other fighter's stats (atk, def, speed...)
public abstract class StatsMove extends PokeMove{
		
	//name of the stat that will be affected
	private String stat;
	
	/*
	 * Constructor (make sure to construct with correct stat (either Attack, Defense or Speed)
	 */
	public StatsMove(String name, String stat,  double power,  double accuracy, Types type)
	{
		/*
		 * in this case, power shall have values between 0 and 2
		 * because it'll work as a percentage (0 - 200%)
		 */
		super(type);
		this.name = name;
		this.power = power;
		this.stat = stat;
		this.accuracy = accuracy;
	}
	
	public String getStat()
	{
		return stat;
	}
	

}

