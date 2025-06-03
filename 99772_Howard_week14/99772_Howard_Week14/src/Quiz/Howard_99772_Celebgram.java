package Quiz;

class Howard_99772_Celebgram extends Howard_99772_MediaPromosi {
    private int umur, tinggiBadan, beratBadan, followers;
    private String akunMedia, bidang;

    public Howard_99772_Celebgram(String nama, int umur, int tinggiBadan, int beratBadan, int followers, String akunMedia, String bidang) {
        super(nama, 0);
        this.umur = umur;
        this.tinggiBadan = tinggiBadan;
        this.beratBadan = beratBadan;
        this.followers = followers;
        this.akunMedia = akunMedia;
        this.bidang = bidang;
    }

    //ini tuh untuk menghitung bayaranya berdasarkan followersnya gitu 
    public int hitungHarga(String bidangOrder, int hari) {
        int harga = followers * 1000 * hari;
        if (bidang.equalsIgnoreCase(bidangOrder)) {
            harga += 500_000 * hari;
        }
        return harga;
    }

    public int getUmur() { 
    	return umur; 
    }
    
    public int getTinggiBadan() { 
    	return tinggiBadan; 
    }
    
    public int getBeratBadan() {
    	return beratBadan; 
    }
    
    public int getFollowers() { 
    	return followers; 
    }
    
    public String getAkunMedia() {
    	return akunMedia;
    }
    
    public String getBidang() { 
    	return bidang; 
    }
}

