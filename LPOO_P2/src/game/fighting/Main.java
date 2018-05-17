package game.fighting;

import game.fighting.combatLogic.CombatLogic;
import game.fighting.pokemons.*;

public class Main {

	public static void main(String[] args) {
		CombatLogic cl = new CombatLogic();
		Blaziken b = new Blaziken();
		Gardevoir g = new Gardevoir();
		Blaziken b2 = new Blaziken();
		
		System.out.println(g.getHp());
		cl.damageOutput(b, b.getMoves().get(3), g);
		System.out.println(g.getHp());
		System.out.println(cl.getMsg());
		Trainer t = new Trainer("T");
		
		t.addPokemon(b);
		t.addPokemon(g);
		t.addPokemon(b2);
		
		System.out.println(t.getTeam());
		t.putInFront(2);
		System.out.println(t.getTeam());
	}
}
