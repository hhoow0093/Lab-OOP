package Quiz;

class Howard_99772_Majalah extends Howard_99772_MediaPromosi {
    private int luas;
    private String letak, bidang;

    public Howard_99772_Majalah(String nama, int luas, String letak, String bidang) {
        super(nama, 0);
        this.luas = luas;
        this.letak = letak;
        this.bidang = bidang;
    }

    public int hitungHarga(String bidangOrder, int hari) {
        int harga = luas * 50000 * hari;
        if (bidang.equalsIgnoreCase(bidangOrder)) {
            harga += 200_000 * hari;
        }
        return harga;
    }
    
    //getternya
    public int getLuas() { 
    	return luas; 
    }
    
    public String getLetak() { 
    	return letak; 
    }
    
    public String getBidang() { 
    	return bidang; 
    }
}