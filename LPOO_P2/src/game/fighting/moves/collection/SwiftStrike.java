package game.fighting.moves.collection;

import game.fighting.combatLogic.Types;
import game.fighting.moves.DamageMove;

public class SwiftStrike extends DamageMove{
	public SwiftStrike()
	{
		super("SwiftStrike", 70.0, 0.1, 0.8, Types.NORMAL);
		msg1 = " quickly strikes the target with it's claws!";
	}

}
