package LatihanLecture;

public class Character {
	protected String name;
	protected float currentHP;
	protected float maxHP;
	protected float Attack;
	protected float defense;
	protected int intelligence;
	protected int strength;
	protected int agility;
	
	public Character(String name, float maxHp, float attack, float defense, int intelligence, int strength, int agility ) {
		this.name = name;
		this.maxHP = maxHp;
		this.currentHP = maxHp;
		this.Attack = attack;
		this.defense = defense;
		this.intelligence = intelligence;
		this.strength = strength;
		this.agility = agility;
	}
	
	public int takeDamage(int damage) {
		int X;
		X = damage - (int)this.defense;
		if(X < 0) {
			return X;
		}else {
			this.currentHP = this.currentHP - X;
			return X;
		}
	}
	
	public int Hit(){
		return (int)this.Attack;
	}
	
	public float getHP() {
		return this.currentHP;
	}
	
	public String name() {
		return this.name;
	}
	
	
	

}
