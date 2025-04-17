package LatihanLecture;

import java.util.Scanner;

public class Latihan4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[][] numberArray={	{15, 10, 1},
								{-10, 15, 2},
								{10, -10, 1},
								{15, -5, 3},
								{-5, 5, 2}
							};
		System.out.print("masukkan atribut pertama: ");
		float atribut1 = scanner.nextFloat();
		System.out.print("masukkan atrbut kedua: ");
		float atribut2 = scanner.nextFloat();
		
		int atribut1_barispertama = numberArray[0][0];
		int atribut2_barispertama = numberArray[0][1];
		
		float jarak_terpendek = (float)Math.pow((Math.pow((atribut1 - atribut1_barispertama), 2) + Math.pow(atribut2 - atribut2_barispertama, 2)), 0.5);
		int atribut_3_jarak_terpendek = numberArray[0][2];
		int baris = 1;
		
		for(int i = 1; i < 5; i++) {
			int numberArray_atribut1 = numberArray[i][0];
			int numberArray_atribut2 = numberArray[i][1];
			
			float jarak_terpendek_tes = (float)Math.pow((Math.pow((atribut1 - numberArray_atribut1), 2) + Math.pow(atribut2 - numberArray_atribut2, 2)), 0.5);
			if(jarak_terpendek > jarak_terpendek_tes) {
				jarak_terpendek = jarak_terpendek_tes;
				atribut_3_jarak_terpendek = numberArray[i][2];
				baris = i;
			}
			
			
		}
		System.out.println(String.format("nilai terdekat adalah %d dari baris %d kolum %d dengan jarak %f", atribut_3_jarak_terpendek, baris, 3, jarak_terpendek));
	}

}
