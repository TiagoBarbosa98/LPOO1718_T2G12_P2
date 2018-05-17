package game.fighting.moves.collection;

import game.fighting.combatLogic.Types;
import game.fighting.moves.DamageMove;

public class BlazeKick extends DamageMove{
	
	public BlazeKick()
	{
		super("Blaze Kick", 70.0, 0.1, 1, Types.FIRE);
		msg1 = " elevates his fiery leg to strike his target's head!";
	}
	
}
