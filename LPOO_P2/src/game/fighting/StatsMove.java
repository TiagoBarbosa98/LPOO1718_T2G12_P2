package game.fighting;

//fighter move that affects the other fighter's stats (atk, def, speed...)
public class StatsMove {
	
	//percentage of the stat that will remain after changes (from 0 to 1)
	private double percentage;
	
	//name of the stat that will be affected
	private String stat;
	
	
	/*
	 * Constructor (make sure to construct with correct stat (either Attack, Defense or Speed)
	 */
	public StatsMove(double percentage, String stat)
	{
		this.percentage = percentage;
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
				f.defReduction(percentage);
			else if(stat.equals("Attack"))
				f.atkReduction(percentage);
			else if(stat.equals("Speed"))
				f.speedReduction(percentage);
			
			return true;
		}
	}

}
