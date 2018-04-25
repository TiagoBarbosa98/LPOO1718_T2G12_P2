package game.fighting;

public class Utility {
	public Utility()
	{
	}
	
	public double numberBetween(double a, double b)
	{
		return Math.random() * (b - a) + a;
	}
	
	public int numberBetween(int a, int b)
	{
		return (int) Math.random() * (b - a) + a;
	}
}
