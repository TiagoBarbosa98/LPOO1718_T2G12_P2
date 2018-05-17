package game.fighting.pokemons;

import java.util.ArrayList;
import game.fighting.combatLogic.*;
import game.fighting.moves.PokeMove;
import game.fighting.moves.collection.*;
import game.fighting.Pokemon;

public class Blaziken extends Pokemon{
	
	public Blaziken()
	{
		//	  hp   def  atk  speed
		super("Blaziken", 364, 262, 372, 284, Types.FIRE);
		moves.add(new BattleCry());
		moves.add(new BlazeKick());
		moves.add(new SwiftStrike());
		moves.add(new Uppercut());
	}	

}
