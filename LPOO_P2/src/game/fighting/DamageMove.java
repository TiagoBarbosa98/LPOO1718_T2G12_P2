package game.fighting;

//fighter moves that deal damage to the opponent (reduces their HP)
public abstract class DamageMove extends PokeMove{
	
		
	/*
	 * the move's chance to critically strike
	 * damage done will be increased by 150%
	 * should range from 0 to 1
	 */
	private double critChance;
	
	/*
	 * Get and Set methods
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
	public DamageMove(String name, double power, double critChance, double accuracy)
	{
		this.name = name;
		this.power = power;
		this.critChance = critChance;
		this.accuracy = accuracy;
	}
	
	
}
