package game.fighting;

public class Fighter {
	
	protected String name;
	
	//description of the move's purpose
	protected String description;
	
	//total health points of the fighter
	protected int totalHp;
	
	//current health points of the fighter
	protected int hp;
	
	//defensive stats
	protected int def;
	
	//offensive stats
	protected int atk;
	
	//speed stats (who moves first in a battle)
	protected int speed;
	
	//shield amount (shield is gained with certain moves, but it is not recoverable, unlike health which can be recovered with certain moves)
	protected int shield;
	
	//some moves make the fighter invunerable to stat reduction
	protected boolean invunerable;


	public Fighter(int hp, int def, int atk, int speed)
	{
		this.hp = hp;
		this.totalHp = hp;
		this.def = def;
		this.atk = atk;
		this.speed = speed;
		this.shield = 0; //always starts at 0
		this.invunerable = false;
		this.description = "";
	}


	/*
	 * Gets and sets methods
	 */
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
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

	public int getShield() {
		return shield;
	}

	public void setShield(int shield) {
		this.shield = shield;
	}
	
	public double getTotalhp() {
		return totalHp;
	}

	public void setTotalhp(int totalhp) {
		this.totalHp = totalhp;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public boolean isInvunerable() {
		return invunerable;
	}


	public void setInvunerable(boolean invunerable) {
		this.invunerable = invunerable;
	}
	
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	
	/*
	 * Stats Reductions
	 */
	//returns the current health percentage of the fighter
	public int healthPercentage()
	{
		double d = (double) hp;

		double quotient = d * 1.0 / totalHp;

		return (int) Math.floor(quotient * 100);
	}
	
	//subtracts the hp and/or shield from the Fighter f after taking some damage
	public void hpReduction(double damage)
	{	
		int dmg = (int) Math.floor(damage);
		
		if(dmg > shield)
			hp = (hp - (dmg - shield));
		else
			shield = (shield - dmg);
	}
	
	//reduces the attack value from the fighter
	public void atkReduction(double percentage)
	{
		atk = (int) Math.floor(atk * percentage);
	}
	
	//reduces the defense value from the fighter
	public void defReduction(double percentage)
	{
		def = (int) Math.floor(def * percentage);
	}
	
	//reduces the speed value from the fighter
	public void speedReduction(double percentage)
	{
		speed = (int) Math.floor(speed * percentage);
	}
	
	

}
