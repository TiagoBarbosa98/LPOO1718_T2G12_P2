package game.fighting.moves.collection;

import game.fighting.combatLogic.Types;
import game.fighting.moves.StatsMove;

//0526.png sprite
public class BattleCry extends StatsMove{
	/*
	 * This move attempts to lower the target's defense by a third
	 * Only uses the reductionTo method
	 */
	public BattleCry()
	{
		super("Battle Cry", "Defense", 0.66,  0.9, Types.FIGHT);
		msg1 = " unleashes a battle cry frightening the opponent!";
	}

}
