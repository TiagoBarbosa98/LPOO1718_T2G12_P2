package game.fighting;

//fighter moves that deal damage to the opponent (reduces their HP)
public class DamageMove {
	
	private String name;
	
	private Utility u;
	
	//the move's power
	private double power;
		
	//the move's chance to critically strike (will make the dmg output * 1.5) (in percentage)
	private int critChance;
	
	/*
	 * Get and Set methods
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPower() {
		return power;
	}

	public void setPower(double power) {
		this.power = power;
	}

	public int getCritChance() {
		return critChance;
	}

	public void setCritChance(int critChance) {
		this.critChance = critChance;
	}

	
	/*
	 * Constructor
	 */
	public DamageMove(double power, int critChance)
	{
		this.power = power;
		this.critChance = critChance;
	}
	
	
	//How much damage the move from Fighter f1 will do (after calculations) to Fighter f2
		public double dmgOutput(Fighter f1, Fighter f2)
		{		
			//modified crit chance to help with calcs
			double modCrit = critChance / 100.0;
			
			//random damage modifier
			double random = u.numberBetween(0.85, 1.0);
			
			double damageDone = power * f1.getAtk() / f2.getDef();
			
			//if crit chance is successful, damage done will be increased by 150%
			if(Math.random() <= modCrit)
				return (damageDone) * random * 1.5;
			else
				return (damageDone) * random;
					
		}
	
}
