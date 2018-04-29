package game.fighting.moves;

import game.fighting.StatsMove;

//0526.png sprite
public class BattleCry extends StatsMove{
	/*
	 * This move attempts to lower the target's defense by a third
	 * Only uses the reductionTo method
	 */
	public BattleCry()
	{
		super("Battle Cry", 0.66, "Defense", 0.9);
		msg1 = "unleashes a battle cry frightening the opponent!";
	}

}
