import java.util.ArrayList;
/**
 * Trieda vytvara strely ktore nasledne ine objekty strielaju.
 * 
 * @author Jan Vavrik 
 * 
 */
public class Strely {
    
    private static final int MAX_X = 500;
    
    private ArrayList<Charakter> strely;
    
    /**
     * Konstruktor vytvori prazdny ArrayList charakterov
     */
    public Strely() {
        this.strely = new ArrayList<>();
    }
    
    /**
     * Vytvory strelu pokial sa velkost ArrayListu nerovna maximalnej moznej hodnote zadanej parametrom
     * @param stredX - pozicia x na ktoru sa strela prida
     * @param stredY - pozicia y na ktoru sa strela prida
     * @param max - maximalna velkost ArrayListu;
     * @param cesta - cesta k suboru obrazku znazornujuci strelu
     */
    public void vystrel(int stredX, int stredY, int max, String cesta) {
        if (this.strely.size() != max) {
            this.strely.add(new Charakter(stredX, stredY, cesta));
        } 
    }
    
    /**
     * Vrati hodnotu streduX strely na danom indexi
     * @param index strely ktorej stredX ma vratit
     */
    public int getStredX(int index) {
        return this.strely.get(index).getStredX();
    }
    
    /**
     * Vrati hodnotu streduY strely na danom indexi
     * @param index strely ktorej stredY ma vratit
     */    
    public int getStredY(int index) {
        return this.strely.get(index).getStredY();
    }    
    
    /**
     * Zmeni polohu strely na danom indexe
     * @param stredX - pozicia x na ktoru ma strela zmenit polohu
     * @param stredY - pozicia y na ktoru ma strela zmenit polohu
     * @param index - index strely ktora ma zmenit polohu
     */
    public void zmenPolohu(int stredX, int stredY, int index) {
        this.strely.get(index).zmenPolohu(stredX, stredY);
    }
    
    /**
     * zobrazi strelu na danom indexe
     * @param index strely ktora sa ma zobrazit
     */
    public void zobraz(int index) {
        this.strely.get(index).zobraz();
    }
    /**
     * zobrazi strelu na danom indexe
     * @param index strely ktora sa ma skryt
     */    
    public void skry(int index) {
        this.strely.get(index).skry();
    }
    
    /**
     * Zisti ci je strela mimo platna
     * 
     */
    public boolean jeMimo() {
        boolean je = false;
        for (Charakter strela : this.strely) {
            if (strela.getStredY() <= 0 || strela.getStredY() >= MAX_X) {
                je = true;
            } 
        }
        return je;
    } 
    
    /**
     * Posunie vsetky strely o parameter
     * @pam vzdialenost o ktoru sa strely posunu
     */
    public void posun(int vzdialenost) {
        for (int i = 0; i < this.strely.size(); i++) {
            if (this.jeMimo()) {
                this.skry(i);
                this.strely.remove(i);
            }
        } 
        
        for (Charakter strela : this.strely) {
            strela.posunZvisle(vzdialenost);
        }
    }
    
    /**
     * Vrati velkost ArrayListu
     */
    public int getVelkostListu() {
        return this.strely.size();
    }
    
    /**
     * Vrati konkretnu strelu na danom parametre
     * @param index strely ktoru ma vratit
     */
    public Charakter getStrela(int index) {
        return this.strely.get(index);
    }
    
    /**
     * Vymaze strelu danu parametrom z ArrayListu a skryje ju
     * @param index na ktorom ju vymaze
     */
    public void vymazStrelu(int index) {
        this.strely.get(index).skry();
        this.strely.remove(index);
    }
    
    /**
     * Skryje vsetky strely
     */
    public void skryVsetkyStrely() {
        for(Charakter strela : this.strely) {
            strela.skry();
        }
    }
}
