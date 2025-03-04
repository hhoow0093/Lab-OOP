package LatihanLecture;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Person parent = new Person("Howard", 'M', null, new Person[0]);
		Person child1 = new Person("anak1", 'M', parent, new Person[0]);
		Person child2 = new Person("anak2", 'F', parent, new Person[0]);
		Person grandchild1 = new Person("cucu1", 'M', child1, new Person[0]);
		
		parent.addChild(child1);
		parent.addChild(child2);
		child1.addChild(grandchild1);
		
		//parent
		System.out.println("paling tua:");
		System.out.println(parent.getNama());
		System.out.println(parent.jenisKelamin());
		System.out.println(parent.getParent());
		System.out.println();
		
		// anaknya parent
		System.out.println("anak dari yang paling tua:");
		for (Person child : parent.getChild()) {
			System.out.println(child.getNama());
		}
		System.out.println();
		
		// successor dari parent
		System.out.println("successor dari yang paling tua:");
		ArrayList<String> suksesor = parent.getAllSuccesor(parent);
		for (int i = 0; i < suksesor.size(); i++) {
			System.out.println(suksesor.get(i));
		}
		System.out.println();

		//ancestor dari granchild 1
		System.out.println("ancestor granchild1:");
		ArrayList<String> ancestor = grandchild1.getAllAncestor(grandchild1);
		for (int i = 0; i < ancestor.size(); i++) {
			System.out.println(suksesor.get(i));
		}

	
	}
	
	

}
