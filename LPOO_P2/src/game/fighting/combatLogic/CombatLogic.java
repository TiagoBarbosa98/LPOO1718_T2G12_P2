package game.fighting.combatLogic;

import game.fighting.Pokemon;
import game.fighting.Utility;
import game.fighting.moves.DamageMove;
import game.fighting.moves.PokeMove;
import game.fighting.moves.StatsMove;

public class CombatLogic {
	
	private Utility u;
	/*
	 * Message that will be displayed if move misses or fails
	 */
	private String msg2 = "";
	
	/*
	 * Determines if the move m is effective or not vs Pokemon p
	 * 1 if normal effectiveness, 2 for super effective, 0.5 for not effective
	 */
	public double isEffective(PokeMove m, Pokemon p)
	{
		Types moveType = m.getType();
		Types pokeType = p.getType();
		Types FIRE = Types.FIRE;
		Types WATER = Types.WATER;
		Types GRASS = Types.GRASS;
		Types PSYCHIC = Types.PSYCHIC;
		Types POISON = Types.POISON;
		Types FIGHT = Types.FIGHT;
		Types FAIRY = Types.FAIRY;
		Types NORMAL = Types.NORMAL;
		Types STEEL = Types.STEEL;
		
		switch(moveType)
		{
			case WATER:
				if(pokeType == FIRE)
				{
					msg2 = "It's super effective! ";
					return 2;
				}
				else if(pokeType == GRASS | pokeType == WATER)
				{
					msg2 = "It's not very effective... ";
					return 0.5;
				}
				else 
					return 1;
			case FIRE:
				if(pokeType == GRASS | pokeType == FIRE)
				{
					msg2 = "It's super effective! ";
					return 2;
				}
				else if(pokeType == FIRE| pokeType == WATER)
				{
					msg2 = "It's not very effective... ";
					return 0.5;
				}
				else 
					return 1;
			case GRASS:
				if(pokeType == WATER)
				{
					msg2 = "It's super effective! ";
					return 2;
				}
				else if(pokeType == GRASS | pokeType == FIRE)
				{
					msg2 = "It's not very effective... ";
					return 0.5;
				}
				else
					return 1;
			case NORMAL:
				if(pokeType == PSYCHIC)
				{
					msg2 = "It's super effective! ";
					return 2;
				}
				else if(pokeType == NORMAL | pokeType == FIGHT)
				{
					msg2 = "It's not very effective... ";
					return 0.5;
				}
				else
					return 1;
			case FIGHT:
				if(pokeType == NORMAL)
				{
					msg2 = "It's super effective! ";
					return 2;
				}
				else if(pokeType == FIGHT | pokeType == PSYCHIC)
				{
					msg2 = "It's not very effective... ";
					return 0.5;
				}
				else 
					return 1;
			case PSYCHIC:
				if(pokeType == FIGHT)
				{
					msg2 = "It's super effective! ";
					return 2;
				}
				else if(pokeType == PSYCHIC | pokeType == NORMAL)
				{
					msg2 = "It's not very effective... ";
					return 0.5;
				}
				else
					return 1;
			case STEEL:
				if(pokeType == FAIRY)
				{
					msg2 = "It's super effective! ";
					return 2;
				}
				else if(pokeType == STEEL | pokeType == FIGHT)
				{
					msg2 = "It's not very effective... ";
					return 0.5;
				}
				else
					return 1;
				
				default:
					return 1;
		}
	}
	//How much damage the move from Fighter f1 will do (after calculations) to Fighter f2
	public void damageOutput(Pokemon f1, DamageMove move, Pokemon f2)
	{		
		//modified crit chance to help with calcs
		double modCrit = move.getCritChance();
		
		double effectiveness = isEffective(move, f2);

		//random damage modifier
		double random = u.numberBetween(0.85, 1.0);

		//calculations for the base damage a move will do to pokemon f2
		double damageDone = move.getPower() * f1.getAtk() / f2.getDef();
		
		double totalDmg = damageDone;

		if(move.succesfulAtk())
		{//if crit chance is successful, damage done will be increased by 150%
			if(Math.random() <= modCrit)
			{
				msg2 = msg2 + " The move critically struck!";
				damageDone = damageDone * random * 1.5 * effectiveness;
			}
			else
			{
				damageDone = damageDone * random  *  effectiveness;
				msg2 = msg2 + " The move hit for normal damage." ;
			}
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
