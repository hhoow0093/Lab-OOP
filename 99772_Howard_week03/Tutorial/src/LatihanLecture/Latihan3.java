package LatihanLecture;
import java.util.Scanner;
public class Latihan3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[][] numberArray={	{15, 10, 1},
								{-10, 15, 2},
								{10, -10, 1},
								{15, -5, 3},
								{-5, 5, 2}
							};
		
		System.out.println("isi dalam array adalah:");
		for(int i =0; i < 5; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(String.format("%d ", numberArray[i][j]));
			}
			System.out.println();
		}
		
	}

}
