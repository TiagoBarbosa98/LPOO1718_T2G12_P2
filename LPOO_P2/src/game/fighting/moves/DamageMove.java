package game.fighting.moves;

import game.fighting.combatLogic.Types;

//fighter moves that deal damage to the opponent (reduces their HP)
public abstract class DamageMove extends PokeMove{
	
	/*
	 * Get's and Set's methods
	 */

	public double getCritChance() {
		return critChance;
	}

	public void setCritChance(int critChance) {
		this.critChance = critChance;
	}

	
	/*
	 * Constructor
	 */
	public DamageMove(String name, double power, double critChance, double accuracy, Types type)
	{
		super(type);
		this.name = name;
		this.power = power;
		this.critChance = critChance;
		this.accuracy = accuracy;
	}
	
	
}
