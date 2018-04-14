package game.fighting;

public class Fighter {
	//total health points of the fighter
	protected double totalhp;
	
	//current health points of the fighter
	protected double hp;
	
	//defensive stats
	protected int def;
	
	//offensive stats
	protected int atk;
	
	//speed stats (who moves first in a battle)
	protected int speed;
	
	//shield amount (shield is gained with certain moves, but it is not recoverable, unlike health which can be recovered with certain moves)
	protected double shield;
	
	
	public Fighter(double hp, int def, int atk, int speed)
	{
		this.hp = hp;
		this.def = def;
		this.atk = atk;
		this.speed = speed;
		this.shield = 0; //always starts at 0
	}

	
	/*
	 * Gets and sets methods
	 */
	public double getHp() {
		return hp;
	}

	public void setHp(double hp) {
		this.hp = hp;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public double getShield() {
		return shield;
	}

	public void setShield(double shield) {
		this.shield = shield;
	}
	
	public double getTotalhp() {
		return totalhp;
	}

	public void setTotalhp(double totalhp) {
		this.totalhp = totalhp;
	}
	
	
	//subtracts the hp or shield from the Fighter f 
	public void hpReduction(Fighter f, double dmg)
	{			
		if(dmg > shield)
			f.setHp(f.getHp() - (dmg - shield));
		else
			f.setShield(shield - dmg);
	}

}
