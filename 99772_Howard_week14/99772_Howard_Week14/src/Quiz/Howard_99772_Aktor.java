package Quiz;

class Howard_99772_Aktor extends Howard_99772_MediaPromosi {
    private int umur, tinggiBadan, beratBadan, fans;
    private String fanClub;

    public Howard_99772_Aktor(String nama, int umur, int tinggiBadan, int beratBadan, int fans, String fanClub) {
        super(nama, 0);
        this.umur = umur;
        this.tinggiBadan = tinggiBadan;
        this.beratBadan = beratBadan;
        this.fans = fans;
        this.fanClub = fanClub;
    }

    //ini fungsi mengitung harga berdasarkan fansnya gitu sih
    public int hitungHarga(String bidangOrder, int hari) {
        return fans * 2000 * hari;
    }

    //getter 
    public int getUmur() { 
    	return umur;
    }
    
    public int getTinggiBadan() { 
    	return tinggiBadan; 
    }
    
    public int getBeratBadan() { 
    	return beratBadan; 
    }
    
    public int getFans() { 
    	return fans; 
    }
    
    public String getFansClub() { 
    	return fanClub; 
    }
}