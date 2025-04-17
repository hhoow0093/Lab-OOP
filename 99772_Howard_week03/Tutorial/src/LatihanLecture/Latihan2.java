package LatihanLecture;

public class Latihan2 {
	public static void main(String[] args) {
		float [] tinggi_badan_array = new float[10];
		for(int i = 0; i < tinggi_badan_array.length; i++) {
			tinggi_badan_array[i] = 145 + (float)(Math.random() * 35);
			
		}
		System.out.println("Isi array tinggi badan: ");
		for(float tinggibadan: tinggi_badan_array) {
			System.out.println(tinggibadan);
		}
		float pembilang_rata_rata = 0;
		int penyebut_rata_rata = tinggi_badan_array.length;
		
		for(float tinggibadan: tinggi_badan_array) {
			pembilang_rata_rata += tinggibadan;
		}
		
		float rata_rata = (float)(pembilang_rata_rata/penyebut_rata_rata);
		
		float pembilang_std_dev = 0;
		for(float tinggibadan: tinggi_badan_array) {
			pembilang_std_dev += Math.pow(tinggibadan - rata_rata, 2);
		}
		float std_dev = (float)(pembilang_std_dev / penyebut_rata_rata);
		
		System.out.println(String.format("nilai rata rata adalah %f", rata_rata));
		System.out.println(String.format("nilai standar deviasi adalah %f", std_dev));
		
		
		
		
	}

}
