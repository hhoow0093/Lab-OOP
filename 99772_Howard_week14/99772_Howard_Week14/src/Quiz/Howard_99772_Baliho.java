package Quiz;

class Howard_99772_Baliho extends Howard_99772_MediaPromosi {
    private int luas;
    private String letak;

    public Howard_99772_Baliho(String nama, int luas, String letak) {
        super(nama, 0);
        this.luas = luas;
        this.letak = letak;
    }

    public int hitungHarga(String bidangOrder, int hari) {
        return luas * 3_000_000 * hari;
    }

    public int getLuas() { 
    	return luas; 
    }
    
    public String getLetak() { 
    	return letak;
    }
}