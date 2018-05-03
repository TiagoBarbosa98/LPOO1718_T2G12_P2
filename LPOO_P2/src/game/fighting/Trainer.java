package game.fighting;

import java.util.ArrayList;

//each trainer will have 3 pokemon per team
public class Trainer {
	
	private String name;
	/*
	 * The 3 pokemons the trainer chose to fight
	 */
	private ArrayList<Pokemon> team;
	/*
	 * each trainer starts with 3 potions that regenerate 80 hp
	 */
	private int potions;
	
	public Trainer(String name)
	{
		this.name = name;
		team = new ArrayList<Pokemon>(3);
		potions = 3;
	}
	
	
	/*
	 * Get's and Set's methods
	 */
	int getTeamSize()
	{
		return team.size();
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	/*
	 * after a battle ends, the trainer's go back to 3
	 */
	public void setPotion()
	{
		potions = 3;
	}
	
	/*
	 * Every time a trainer uses a potion the number of potions
	 * decrements by 1
	 */
	public void decreasePotions()
	{
		potions--;
	}
	
	/*
	 * The potion will restore 80 hp on Pokemon p
	 */
	public void usePotion(Pokemon p)
	{
		if(potions > 0)
		{
			p.setHp(p.getHp() + 80);
		}
	}
	
	/*
	 * Adds Pokemon p to current team
	 */
	boolean addPokemon(Pokemon p)
	{
		if(team.size() < 3)
		{
			team.add(p);
			return true;
		}
		else
			return false;
	}
	
	
	public Pokemon getPokemon(int index)
	{
		return team.get(index);
	}

}
