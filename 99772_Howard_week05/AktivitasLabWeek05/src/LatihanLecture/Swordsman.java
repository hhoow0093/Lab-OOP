package LatihanLecture;

public class Swordsman extends Character{
	public Swordsman(String name, float maxHp, float attack, float defense, int intelligence, int strength, int agility) {
		super(name, maxHp, attack, defense, intelligence, strength, agility);
	}
	
	public int takeDamage(int damage) {
		int X;
		X = damage - (int)(super.defense + super.strength * 0.5 + super.agility * 0.5);
		if(X < 0) {
			return X;
		}else {
			super.currentHP =  this.currentHP - X;
			return X;
		}
	}
	
	public int Hit() {
		int X;
		X = (int)(super.Attack + super.strength * 0.5 + super.intelligence * 0.5);
		return X;
	}
	

}
