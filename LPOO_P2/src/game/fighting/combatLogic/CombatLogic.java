package game.fighting.combatLogic;

import game.fighting.Pokemon;
import game.fighting.Utility;
import game.fighting.moves.DamageMove;
import game.fighting.moves.PokeMove;
import game.fighting.moves.StatsMove;

public class CombatLogic {
	
	private Utility u = new Utility();
	
	private String msg;
	
	public String getMsg()
	{
		return msg;
	}
	
	/*
	 * Determines if the move m is effective or not vs Pokemon p
	 * 1 if normal effectiveness, 2 for super effective, 0.5 for not effective
	 * these numbers will be multiplied to the damage output
	 * (if move is a damage move)
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
		
		String seffective = " It's super effective! ";
		String neffective = " It's not very effective... ";
		
		switch(moveType)
		{
			case WATER:
				if(pokeType == FIRE)
				{
					msg = msg + seffective;
					return 2;
				}
				else if(pokeType == GRASS | pokeType == WATER)
				{
					msg = msg + neffective;
					return 0.5;
				}
				else 
					return 1;
			case FIRE:
				if(pokeType == GRASS | pokeType == FIRE)
				{
					msg = msg + seffective;
					return 2;
				}
				else if(pokeType == FIRE| pokeType == WATER)
				{
					msg = msg + neffective;
					return 0.5;
				}
				else 
					return 1;
			case GRASS:
				if(pokeType == WATER)
				{
					msg = msg + seffective;
					return 2;
				}
				else if(pokeType == GRASS | pokeType == FIRE)
				{
					msg = msg + neffective;
					return 0.5;
				}
				else
					return 1;
			case NORMAL:
				if(pokeType == PSYCHIC)
				{
					msg = msg + seffective;
					return 2;
				}
				else if(pokeType == NORMAL | pokeType == FIGHT)
				{
					msg = msg + neffective;
					return 0.5;
				}
				else
					return 1;
			case FIGHT:
				if(pokeType == NORMAL)
				{
					msg = msg + seffective;
					return 2;
				}
				else if(pokeType == FIGHT | pokeType == PSYCHIC)
				{
					msg = msg + neffective;
					return 0.5;
				}
				else 
					return 1;
			case PSYCHIC:
				if(pokeType == FIGHT)
				{
					msg = msg + seffective;
					return 2;
				}
				else if(pokeType == PSYCHIC | pokeType == NORMAL)
				{
					msg = msg + neffective;
					return 0.5;
				}
				else
					return 1;
			case STEEL:
				if(pokeType == POISON)
				{
					msg = msg + seffective;
					return 2;
				}
				else if(pokeType == STEEL | pokeType == FAIRY)
				{
					msg = msg + neffective;
					return 0.5;
				}
				else
					return 1;
			case FAIRY:
				if(pokeType == STEEL)
				{
					msg = msg + seffective;
					return 2;
				}
				else if(pokeType == FAIRY | pokeType == POISON)
				{
					msg = msg + neffective;
					return 0.5;
				}
				else
					return 1;
					
				default:
					return 1;
		}
	}
		
	
	/*
	 * Determines if the move will hit or not based on accuracy
	 */
	public boolean succesfulAtk(PokeMove move)
	{
		double random = Math.random();
		
		if(random > move.getAccuracy())
			return false;
		else
			return true;
	}
	
	
	/*
	 * Pokemon f1 move that attempts to lower the Pokemon's f stats
	 */
	public void reductionTo(Pokemon f1, Pokemon f, StatsMove move)
	{
		//the message to be displayed starts with the intro message of the move
		this.msg = f1.getName() + move.getMsg1();
		
		String pokemonName = f.getName();
		
		String lowered = "has been lowered!";
		
		if(move.succesfulAtk())
		{
			if(f.isInvunerable())
			{
				msg = msg + " " + pokemonName + "'s stats cannot be lowered!";
				move.setMsg2(pokemonName + "'s stats cannot be lowered!");
			}
			else {
				if(move.getStat().equals("Defense"))
				{
					msg = msg + " " + pokemonName + "'s defense" + lowered;
					f.defAlter(move.getPower());
				}
				else if(move.getStat().equals("Attack"))
				{
					msg = msg + " " + pokemonName + "'s attack" + lowered;
					f.atkAlter(move.getPower());
				}
				else if(move.getStat().equals("Speed"))
				{
					msg = msg + " " + pokemonName + "'s speed" + lowered;
					f.speedAlter(move.getPower());
				}

			}
		}
		else
			msg = msg + "The move missed!";

	}
	
	
	/*
	 * Move that attempts to increase a stat 
	 */
	public void increaseTo(Pokemon f, StatsMove move)
	{
		//the message to be displayed starts with the intro message of the move
		this.msg = f.getName() + move.getMsg1();
		
		String pokemonName = f.getName();
		String increase = "has been increased!";
		
		if(move.succesfulAtk())
		{
			if(move.getStat().equals("Defense"))
			{
				msg = msg + " " + pokemonName + "'s defense" + increase;
				f.defAlter(move.getPower());
			}
			else if(move.getStat().equals("Attack"))
			{
				msg = msg + " " + pokemonName + "'s attack" + increase;
				f.atkAlter(move.getPower());
			}
			else if(move.getStat().equals("Speed"))
			{
				msg = msg + " " + pokemonName + "'s speed" + increase;
				f.speedAlter(move.getPower());
			}

		}
		else
			move.setMsg2("The move missed!");
	}
	
	
	/*
	 * How much damage the move from Fighter f1 will do (after calculations) to Fighter f2
	 */
	public void damageOutput(Pokemon f1, PokeMove move, Pokemon f2)
	{	
		//the message to be displayed starts with the intro message of the move
		this.msg = f1.getName() + move.getMsg1();
		
		if(move.succesfulAtk())
		{
			double modCrit = move.getCritChance();
			
			//determining if move is effective or not
			double effectiveness = isEffective(move, f2);

			//random damage modifier
			double random = u.numberBetween(0.85, 1.0);

			//calculations for the base damage a move will do to pokemon f2
			double damageDone = move.getPower() * f1.getAtk() / f2.getDef();
	
			//if crit chance is successful, damage done will be increased by 170%
			if(Math.random() <= modCrit)
			{
				msg = msg + "The move critically struck!";
				damageDone = damageDone * random * 1.7 * effectiveness;
				f2.hpReduction(damageDone);
			}
			else
				{
					damageDone = damageDone * random  *  effectiveness;
					f2.hpReduction(damageDone);
				}
		}
		else
			msg = msg + "The move missed.";
			
	}

}
