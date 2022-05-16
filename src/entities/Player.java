package entities;

public class Player {

	private String name;
	private int points;
	
	public Player(String name, int points) {
	this.name = name;
	this.points = 0;

	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public void setPoints(int p) {
		points = p;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void addPoints() {
		points++;
	}


	@Override
	public String toString() {
		return "Player [Name: " + name + ", Points: " + points + "]";
	}
}
