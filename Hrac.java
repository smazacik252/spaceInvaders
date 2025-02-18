import java.util.ArrayList;
/**
 * Trieda vytvara hraca ktory sa vie pohybovat a striela strely.
 * 
 * @author Jan Vavrik 
 * 
 */
public class Hrac {
    
    private static final int DLZKA_POSUNU = 15;
    private static final int POZICIA_HRACA_X = 250;
    private static final int POZICIA_HRACA_Y = 470;
    private static final String CESTA_K_SUBORU = "pics/lod.png";
    private static final int POZICIA_ZIVOT_X = 470;
    private static final int POZICIA_ZIVOT_Y = 30;
    private static final int MAX_X = 500;
    
    private Charakter hrac;
    private Strely strely;
    private int zivoty;
    private ArrayList<Obrazok> obrZivoty;
    private int skore;
    private int maxStrely;
    private Manazer manazer;
    
    /**
     * Konstruktor vytvori hraca na predom urcenom mieste s dopredu urcenym obrazkom
     * @param zivoty - pocet zivotov hraca,pozor musia byt kladne,nie je kontrolovane
     * @param maxStrely - pocet striel ktore hrac moze naraz vystrelit,pozor musia byt kladne,nie je kontrolovane
     */

    public Hrac(int zivoty, int maxStrely) {
        this.strely = new Strely();
        this.zivoty = zivoty;
        this.maxStrely = maxStrely;
        this.hrac = new Charakter(POZICIA_HRACA_X, POZICIA_HRACA_Y, CESTA_K_SUBORU);
        this.hrac.zobraz();
        this.manazer = new Manazer();
        this.skore = 0;
        this.obrZivoty = new ArrayList<>();
        for (int i = 0; i < this.zivoty; i++) {
            this.obrZivoty.add(new Obrazok("pics/lod.png"));
            this.obrZivoty.get(i).zmenPolohu(POZICIA_ZIVOT_X - i * this.obrZivoty.get(i).sirka(), POZICIA_ZIVOT_Y);
            this.obrZivoty.get(i).zobraz();
        }
    }
    
    /**
     * Vystreli strelu
     */
    public void vystrel() {
        this.strely.vystrel(this.hrac.getStredX(), this.hrac.getStredY() - 25, 3, "pics/strela.png");
    }
    
    /**
     * Reaguje na spravu od manazera,posunie strely zvisle o -15
     */
    public void tik() {     
        this.strely.posun(-DLZKA_POSUNU);
    }
    
    /**
     * posunie hraca vlavo
     */
    public void posunVlavo() {
        if (this.hrac.getStredX() - 30 > 0) {
            this.hrac.posunVodorovne(-DLZKA_POSUNU);
        }
    }
    
    /**
     * posunie hraca vpravo
     */
    public void posunVpravo() {
        if (this.hrac.getStredX() + 30 < MAX_X) {
            this.hrac.posunVodorovne(DLZKA_POSUNU);
        }
    } 
    
    /**
     * vymaze strelu danu parametrom
     * @param index na ktorom strelu vymaze
     */
    public void vymazStrelu(int index) {
        this.strely.vymazStrelu(index);
    }
    
    /**
     * Vrati velkost ArrayListu striel
     */
    public int getVelkostStriel() {
        return this.strely.getVelkostListu();
    }
    
    /**
     * Vrati stredX strely urcenej parametrom
     * @param index ktorej strely ma vratit stredX
     */
    public int getStredXStrely(int index) {
        return this.strely.getStredX(index);
    }
    
    /**
     * Vrati stredY strely urcenej parametrom
     * @param index ktorej strely ma vratit stredY
     */    
    public int getStredYStrely(int index) {
        return this.strely.getStredY(index);
    }
    
    private boolean vRozsahu(int hodnota, int min, int max) {
        return max >= hodnota && hodnota >= min;
    }    
    
    /**
     * Zisti ci su su suradnice dane parametrom v rozsahu
     * @param x suradnica x 
     * @param y suradnica y
     */
    public boolean jeVRozsahu(int x, int y, int index) {
        int lavyHornyX = this.hrac.getLavyHornyX();
        int lavyHornyY = this.hrac.getLavyHornyY();
        return this.vRozsahu(x, lavyHornyX, lavyHornyX + 50) && this.vRozsahu(y, lavyHornyY, lavyHornyY + 20);
    }  
    
    /**
     * Skryje hraca
     */
    public void skry() {
        this.hrac.skry();
    }
    
    /**
     * Odstrani hracovy jeden zivot
     */
    public void odstranZivot() {
        this.zivoty--;
        this.obrZivoty.get(0).skry();
        this.obrZivoty.remove(0);
    }
    
    /**
     * Vrati pocet hracovych zivotov
     */
    public int getZivoty() {
        return this.zivoty;
    }
    
    /**
     * Prida hracovy skore dane parametrom
     * @param cislo skore ktore sa ma pridat
     */
    public void pridajSkore(int cislo) {
        this.skore += cislo;
    }
    
    /**
     * Skryje vsetky strely
     */
    public void skryStrely() {
        this.strely.skryVsetkyStrely();
    }
    
    /**
     * vrati hracove skore
     */
    public int getSkore() {
        return this.skore;
    }
}
