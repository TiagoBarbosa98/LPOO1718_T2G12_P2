package game.fighting;

//fighter move that affects the other fighter's stats (atk, def, speed...)
public abstract class StatsMove extends PokeMove{
		
	//name of the stat that will be affected
	private String stat;
	
	/*
	 * Constructor (make sure to construct with correct stat (either Attack, Defense or Speed)
	 */
	public StatsMove(double power, String stat)
	{
		this.power = power;
		this.stat = stat;
	}
	
	/*
	 * Move that attempts to lower the Fighter's f stats
	 * Returns true if it's successful or false if it isn't
	 */
	public boolean reductionTo(Fighter f)
	{
		if(f.isInvunerable())
			return false;
		else {
			if(stat.equals("Defense"))
				f.defReduction(power);
			else if(stat.equals("Attack"))
				f.atkReduction(power);
			else if(stat.equals("Speed"))
				f.speedReduction(power);
			
			return true;
		}
	}

}
