package LatihanLecture;

public class Magician extends Character{
	public Magician(String name, float maxHp, float attack, float defense, int intelligence, int strength, int agility) {
		super(name, maxHp, attack, defense, intelligence, strength, agility);
	}
	
	public int takeDamage(int damage) {
		int X;
		X = damage - (int)(0.8 * super.defense + super.intelligence * 0.53 + super.agility * 0.2);
		if(X < 0) {
			return X;
		}else {
			super.currentHP =  this.currentHP - X;
			return X;
		}
	}
	
	public int Hit() {
		int X;
		X = (int)(1.2 * super.Attack + super.intelligence * 0.7 + super.agility * 0.1 + super.strength * 0.1);
		return X;
	}
	
	public int Hit(String size) {
		double X;
		if(size == "small") {
			X = 0.75 % (1.2 * super.Attack + super.intelligence * 0.7 + super.agility * 0.1 + super.strength * 0.1);
			return (int)X;
			
		}else {
			X =  0.8 % (1.2 * super.Attack + super.intelligence * 0.7 + super.agility * 0.1 + super.strength * 0.1);
			return (int)X;
			
		}
	}

}
