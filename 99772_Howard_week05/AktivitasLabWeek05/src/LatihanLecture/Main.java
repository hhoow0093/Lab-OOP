package LatihanLecture;

public class Main {
	public static void main(String[] args) {
		Character character1 = new Character("Howard", 100, 15, 5, 10, 10, 10);
		character1.takeDamage(10);
		System.out.println(String.format("sisa HP %s adalah %.0f", character1.name(), character1.getHP()));
		System.out.println(String.format("%s memiliki attack sebesar %d", character1.name(),character1.Hit()));
		
		Swordsman character2 = new Swordsman("chihaya", 100, 15, 5, 10, 10, 10);
		character2.takeDamage(10);
		System.out.println(String.format("sisa HP %s adalah %.0f", character2.name(), character2.getHP()));
		System.out.println(String.format("%s memiliki attack sebesar %d", character2.name(),character2.Hit()));
		
		Magician character3 = new Magician("pekora", 100, 15, 5, 10, 10, 10);
		System.out.println(String.format("sisa HP %s adalah %.0f", character3.name(), character3.getHP()));
		System.out.println(String.format("%s memiliki attack sebesar %d", character3.name(),character3.Hit()));
		System.out.println(String.format("%s memiliki attack sebesar %d", character3.name(),character3.Hit("big")));
	}

}
