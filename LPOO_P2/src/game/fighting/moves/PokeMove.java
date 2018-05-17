package game.fighting.moves;

import game.fighting.Utility;
import game.fighting.combatLogic.Types;
import game.fighting.combatLogic.Types;

public abstract class PokeMove {
	
	protected Utility u;
	protected String name;
	protected double power;
	protected Types type;
	
	/*
	 * the move's chance to critically strike
	 * damage done will be increased by 150%
	 * should range from 0 to 1
	 */
	protected double critChance;

	/*
	 * msg1 will contain the output that should be displayed on the screen
	 * when the move is used msg1 is always displayed
	 */
	protected String msg1;
	
	/*
	 * msg2 will contain the output that should be displayed on the screen
	 * if the move is super effective or not very effective
	 */
	protected String msg2;
	/*
	 * accuracy (double between 0 and 1) to determine how often 
	 * the attack will be successful
	 */
	protected double accuracy;
	
	/*
	 * Constructor
	 */
	public PokeMove(Types type)
	{
		this.type = type;
	}
	
	
	/*
	 * Get's And Set's Methods
	 */
	public Types getType() {
		return type;
	}
	public void setType(Types type) {
		this.type = type;
	}
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
	public String getMsg1() {
		return msg1;
	}
	public void setMsg1(String msg1) {
		this.msg1 = msg1;
	}
	public double getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(double accuracy) {
		this.accuracy = accuracy;
	}
	public String getMsg2()
	{
		return msg2;
	}
	public void setMsg2(String msg2)
	{
		this.msg2 = msg2;
	}
	public double getCritChance() {
		return critChance;
	}
	
	
	public boolean succesfulAtk()
	{
		double random = Math.random();
		
		if(random > accuracy)
			return false;
		else
			return true;
	}
}
