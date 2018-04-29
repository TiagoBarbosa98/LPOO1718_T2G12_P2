package game.fighting.combatLogic;

/*
 * In this package we will be creating a state machine for 1v1 pokemon combat
 */
import game.fighting.PokeMove;

public interface CombatState {
	void player1Chooses(PokeMove moveChosen);
	//animation for after the player1 chooses the move he wants to use
	void player1Attacks();
	
	void player2Chooses(PokeMove moveChosen);
	void player2Attacks();
	
	void playerDies();
	
	enum States{
		PLAYER1CHOOSING,
		PLAYER2CHOOSING,
		PLAYER1ATTACKING,
		PLAYER2ATTACKING,	
		PLAYERDIED;
	}

}
