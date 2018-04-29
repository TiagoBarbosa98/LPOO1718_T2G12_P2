package game.fighting.moves;

import game.fighting.DamageMove;

public class Uppercut extends DamageMove{
	public Uppercut()
	{
		super("Uppercut", 40.0, 0.2, 1.0);
		msg1 = "squats and then punches upwards hitting the target's chin!";
	}
}
