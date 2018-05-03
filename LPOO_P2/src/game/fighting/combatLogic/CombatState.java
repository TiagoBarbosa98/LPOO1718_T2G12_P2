package game.fighting.combatLogic;

public class CombatState {
	
	CombatState currentState;
	State state;
	
	public CombatState()
	{
		state = State.MENU;
	}
	
	void setState(CombatState newState)
	{
		currentState = newState;
	}
	
	enum State{
		MENU,			//The player can choose between the 3 options above
		CHOOSING_MOVE, 	//The player is choosing a move for the pokemon to use
		SWITCHING_POKE, //The player is switching his current pokemon with another one
		USE_POTION,		//The player is using a potion on a pokemon 
		COMBAT_END;
	}
}
