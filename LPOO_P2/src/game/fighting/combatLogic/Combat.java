package game.fighting.combatLogic;

public class Combat {
	CombatState player1Choosing;
	CombatState player1Attacking;
	CombatState player2Choosing;
	CombatState player2Attacking;
	CombatState playerDied;
	
	CombatState currentState;
	
	public Combat()
	{
		
	}
	
	void setState(CombatState newState)
	{
		currentState = newState;
	}
	
	enum States{
		CHOOSING_MOVE, 	//The player is choosing a move for the pokemon to use
		SWITCHING_POKE, //The player is switching his current pokemon with another one
		USE_POTION,		//The player is using a potion on a pokemon 
		COMBAT_END;
	}
}
