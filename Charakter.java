
/**
 * Trieda vytvori obrazok na zadanych poziciach x a y.
 * 
 * @author Jan Vavrik 
 * 
 */
public class Charakter {
      
    private Obrazok charakter;
    
    private int stredX;
    private int stredY;
    private boolean jeZobrazeny;
    
    /**
     * Konstuktor vytvori charakter s danymi parametrami
     * Pozor! Konstruktor nekontroluje zadane parametre
     * @param stredX - pozicia X kde sa obrazok zobrazi
     * @param stredY - pozicia Y kde sa obrazok zobrazi
     * @param cesta - cesta k suboru,obrazok musi byt ulozeny v priecinku pics
     */
    
    public Charakter(int stredX, int stredY, String cesta) {  
        this.stredX = stredX;
        this.stredY = stredY;
        this.jeZobrazeny = false;
        this.charakter = new Obrazok(cesta);
        this.charakter.zmenPolohu(stredX, stredY);
        this.charakter.zobraz();
    }
    
    /**
     * Zmeni polohu charakteru;
     */
    public void zmenPolohu(int stredX, int stredY) {
        this.charakter.zmenPolohu(stredX, stredY);
        this.stredX = stredX;
        this.stredY = stredY;
    }

    /**
     * Vrati hodnotu lavehoHornehoX
     */
    public int getLavyHornyX() {
        return this.charakter.getX();
    }
    
    /**
     * Vrati hodnotu lavehoHornehoY
     */
    public int getLavyHornyY() {
        return this.charakter.getY();
    }
    
    /**
     * Vrati hodnotu streduX;
     */
    public int getStredX() {
        return this.stredX;
    }
    
    /**
     * Vrati hodnotu streduY
     */
    public int getStredY() {
        return this.stredY;
    }    
    
    /**
     * Vrati vysku obrazku;
     */
    public int getVyska() {
        return this.charakter.vyska();
    }
    
    /**
     * Vrati sirku obrazku;
     */    
    public int getSirka() {
        return this.charakter.sirka();
    }
    
    /**
     * Skryje charakter;
     */
    public void skry() {
        this.charakter.skry();
        this.jeZobrazeny = false;
    }
    
    /**
     * Posunie charakter vodorovne o dany parameter
     * @param kladny posunie do prava, zaporny dolava;
     */
    public void posunVodorovne(int vzdialenost) {
        this.charakter.posunVodorovne(vzdialenost);
        this.stredX += vzdialenost;
    }
    
    /**
     * Posunie charakter zvisle o dany parameter
     * @param kladny posunie do prava, zaporny dolava;
     */    
    public void posunZvisle(int vzdialenost) {
        this.charakter.posunZvisle(vzdialenost);
        this.stredY += vzdialenost;
    }
    
    /**
     * zobrazi charakter
     */
    public void zobraz() {
        this.charakter.zobraz();
        this.jeZobrazeny = true;
    }
    
}
