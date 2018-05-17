package game.fighting.moves.collection;

import game.fighting.combatLogic.Types;
import game.fighting.moves.DamageMove;

public class Uppercut extends DamageMove{
	public Uppercut()
	{
		super("Uppercut", 40.0, 0.2, 1.0, Types.FIGHT);
		msg1 = " squats and then punches upwards hitting the target's chin!";
	}
}
