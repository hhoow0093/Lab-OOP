package LatihanLecture;
import java.util.ArrayList;

public class Person {
	private String nama;
	private char jenisKelamin;
	private Person parent;
	private Person[] children;
	
	public Person(String nama, char jenisKelamin, Person parent, Person[] children) {
		this.nama = nama;
		this.jenisKelamin = jenisKelamin;
		this.parent = parent;
		this.children = children;
	}
	
	public String getNama() {
		return this.nama;
	}
	
	public char jenisKelamin() {
		return this.jenisKelamin;
	}
	
	public Person getParent() {
		return this.parent;
	}
	
	public Person[] getChild() {
		return this.children;
	}
	
	public void addChild(Person p) {
		Person[] newchildren = new Person[this.children.length + 1];
		System.arraycopy(this.children, 0, newchildren, 0, this.children.length);
		newchildren[this.children.length] = p;
		this.children = newchildren;
	}
	
	public ArrayList<String> getAllSuccesor(Person p) {
		ArrayList<String> NamaSuksesor = new ArrayList<>();
		getAllSuccesorHelper(p, NamaSuksesor);
		return NamaSuksesor;
	}
	
	public void getAllSuccesorHelper(Person p, ArrayList<String> NamaSuksesor) {
		for (Person child : p.getChild()) {
			NamaSuksesor.add(child.getNama());
			getAllSuccesorHelper(child, NamaSuksesor);
		}

	}

	public ArrayList<String> getAllAncestor(Person p) {
		ArrayList<String> NamaAncestor = new ArrayList<>();
		getAllAncestorHelper(p, NamaAncestor);
		return NamaAncestor;
	}

	public void getAllAncestorHelper(Person p, ArrayList<String> NamaAncestor) {
		if (p.getParent() != null) {
			NamaAncestor.add(p.getParent().getNama());
			getAllAncestorHelper(p.getParent(), NamaAncestor);
		}

	}
	
	

}