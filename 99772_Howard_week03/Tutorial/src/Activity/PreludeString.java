package Activity;

public class PreludeString {
	public static void main(String[] args) {
		String pbo1 = "Pemograman Berorientasi Objek";
		String pbo2 = new String("Pemrograman Berorientasi Objek");
		
		// method dalam string
		System.out.print(String.format("panjang pbo1: %d", pbo1.length()));
		System.out.println();
		
		System.out.print(String.format("pbo1 start dari index ke 12 berada pada %s", pbo1.charAt(12)));
		System.out.println();
		
		System.out.print(String.format("substring pbo1 pada index ke 24 berada pada %s", pbo1.substring(24)));
		System.out.println();
		
		System.out.print(String.format("substring pbo1 pada index ke 12 sampai 24 adalah %s", pbo1.substring(11, 24)));
		System.out.println();
		
		String kode = "IF 402 - ";
		String out = kode.concat(pbo1);
		System.out.println(out);
		
	}

}
