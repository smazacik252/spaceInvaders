public class Tabula {
    
    private SSD[] poleSSD;
    private static final int DLZKA_SEGMENTU = 10;
    private static final int HRUBKA_SEGMENTU = 2;
    private static final int POZICIA_X = 200;
    private static final int POZICIA_Y = 10;
    private static final int POSUN = DLZKA_SEGMENTU + HRUBKA_SEGMENTU * 2 + 10;
    
    public Tabula(int x, int y, int pocetDisplejov) {
        this.poleSSD = new SSD[pocetDisplejov];
        for (int i = 0; i < this.poleSSD.length; i++) {
            this.poleSSD[i] = new SSD(DLZKA_SEGMENTU, HRUBKA_SEGMENTU, x + POSUN * i , y);
        }
    }
    
    public void rozsviet() {
        for (SSD ssd : this.poleSSD) {
            ssd.rozsviet();
        }
    }
    
    public void zhasni() {
        for (SSD ssd : this.poleSSD) {
            ssd.zhasni();
        }        
    }
    
    public void zobrazCislo(int cislo) {
        int indexAktualnehoDispleja = this.poleSSD.length - 1;
        do {
            int cifra = cislo % 10;
            cislo /= 10;
            
            this.poleSSD[indexAktualnehoDispleja].zobrazCislo(cifra);
            indexAktualnehoDispleja--;
        } while (cislo != 0 && indexAktualnehoDispleja >= 0);
        
        for ( ; indexAktualnehoDispleja >= 0; indexAktualnehoDispleja--) {
            this.poleSSD[indexAktualnehoDispleja].zhasni();
        }
    }
}
