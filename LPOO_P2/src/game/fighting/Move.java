package game.fighting;
public class Move {
	//the move's power
	protected double power;
	//the move's chance to critically strike (will make the dmg output * 1.5) (in percentage)
	protected int critChance;
	
	public Move(double power, int critChance)
	{
		this.power = power;
		this.critChance = critChance;
	}
	
	//how much damage the move from Fighter f1 will do (after calculations) to Fighter f2
	public double dmgOutput(Fighter f1, Fighter f2)
	{		
		//modified crit chance to help with calcs
		double modCrit = critChance / 100.0;
		
		//random damage modifier
		double random = Math.random() * 0.15 + 0.85;
		
		double damageDone = power * f1.getAtk() / f2.getDef();
		
		//if crit chance is successful, damage done will be increased by 150%
		if(Math.random() <= modCrit)
			return (damageDone) * random * 1.5;
		else
			return (damageDone) * random;
				
	}
	
}
