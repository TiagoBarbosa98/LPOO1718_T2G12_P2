package game.fighting;

public class Combat {
	
	private Utility u;
	/*
	 * Message that will be displayed if move misses or fails
	 */
	private String msg2 = "";
	
	
	//How much damage the move from Fighter f1 will do (after calculations) to Fighter f2
	public void damageOutput(Pokemon f1, DamageMove move, Pokemon f2)
	{		
		//modified crit chance to help with calcs
		double modCrit = move.getCritChance();

		//random damage modifier
		double random = u.numberBetween(0.85, 1.0);

		double damageDone = move.getPower() * f1.getAtk() / f2.getDef();

		if(move.succesfulAtk())
		{//if crit chance is successful, damage done will be increased by 150%
			if(Math.random() <= modCrit)
			{
				msg2 = "The move critically struck!";
				f2.hpReduction((damageDone) * random * 1.5);
			}
			else
				f2.hpReduction((damageDone) * random);
		}
		else
			msg2 = "The move missed!";
			
	}
	
	public String getMsg()
	{
		return msg2;
	}
	
	
	public boolean succesfulAtk(PokeMove move)
	{
		double random = Math.random();
		
		if(random > move.getAccuracy())
			return false;
		else
			return true;
	}
	
	/*
	 * Move that attempts to lower the Fighter's f stats
	 * Returns true if it's successful or false if it isn't
	 */
	public boolean reductionTo(Pokemon f, StatsMove move)
	{
		String pokemonName = f.getName();
		
		if(move.succesfulAtk())
		{
			if(f.isInvunerable())
			{
				msg2 = pokemonName + "'s stats cannot be lowered!";
				return false;
			}
			else {
				if(move.getStat().equals("Defense"))
				{
					msg2 = pokemonName + "'s defense has been lowered!";
					f.defAlter(move.getPower());
				}
				else if(move.getStat().equals("Attack"))
				{
					msg2 = pokemonName + "'s attack has been lowered!";
					f.atkAlter(move.getPower());
				}
				else if(move.getStat().equals("Speed"))
				{
					msg2 = pokemonName + "'s speed has been lowered!";
					f.speedAlter(move.getPower());
				}

				return true;
			}
		}
		else
		{
			msg2 = "The move missed!";
			return false;
		}
	}
	
	/*
	 * Move that attempts to increase a stat 
	 */
	public void increaseTo(Pokemon f, StatsMove move)
	{
		String pokemonName = f.getName();
		if(move.succesfulAtk())
		{
			if(move.getStat().equals("Defense"))
			{
				msg2 = pokemonName + "'s defense has been increased!";
				f.defAlter(move.getPower());
			}
			else if(move.getStat().equals("Attack"))
			{
				msg2 = pokemonName + "'s attack has been increased!";
				f.atkAlter(move.getPower());
			}
			else if(move.getStat().equals("Speed"))
			{
				msg2 = pokemonName + "'s speed has been increased!";
				f.speedAlter(move.getPower());
			}

		}
		else
			msg2 = "The move missed!";
	}

}
