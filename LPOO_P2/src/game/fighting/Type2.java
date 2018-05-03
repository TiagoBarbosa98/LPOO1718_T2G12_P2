package game.fighting;

public interface Type2 {
	/*
	 * checks whether the current Type is effective vs Type t
	 * will do 2x the damage if it is super effective and 0.5x if its not effective
	 * @return 1 if it's 1x, 2 if it's 2x, and 0.5 if its 0.5x
	 */
	public double isEffective(Type2 t);
	
	/*
	 * Water 2x Fire
	 * Fire 2x Grass
	 * Grass 2x Water
	 * Fight 2x Normal
	 * Normal 2x Psychic
	 * Psychic 2x Fight
	 * Fairy 1x all
	 */
}
