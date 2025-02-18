import java.util.ArrayList;
import java.util.Random;
/**
 * Trieda vytvara ArrayList votrelcov,vie s nimi hybat a strielat.
 * 
 * @author Jan Vavrik
 * 
 */
public class Votrelci {
    
    private static final int VZDIALENOST = 15;
    private static final String CESTA_K_SUBORU = "pics/invader.png";
    private static final int I_POZ_X = 40;
    private static final int I_POZ_Y = 80;
    private static final int POSUN_X = 60;
    private static final int POSUN_Y = 40;
    private static final int MAX_X = 500;
    
    private ArrayList<Charakter> votrelci;
    private Strely bomby; 
    private int riadky;
    private int stlpce;
    private int maxBomby;
    private int vzdialenost;
    private Random generator;
    
    
    /**
     * Konstuktor vytvori instanciu s riadkami,stlpcami a maxBombami urcenych parametrami
     * @param riadk pocet riadkov ufonov
     * @param stlpce pocet stlpcov ufonov
     * @param maxBomby pocet maximalnych bomb ktore mozu ufoni naraz vystrelit
     */
    public Votrelci(int riadky, int stlpce, int maxBomby) {
        this.riadky = riadky;
        this.stlpce = stlpce;
        this.maxBomby = maxBomby;
        this.vzdialenost = VZDIALENOST;
        this.votrelci = new ArrayList<>();
        this.bomby = new Strely();
        this.generator = new Random();
        for (int i = 0; i < this.stlpce; i++) {
            for (int j = 0; j < this.riadky; j++) {       
                this.votrelci.add(new Charakter(I_POZ_X + POSUN_X * i, I_POZ_Y + POSUN_Y * j, CESTA_K_SUBORU));
            }
        }
    }
    
    
    private int vyberNahodnehoVotrelca() {
        return this.generator.nextInt(this.votrelci.size());
    }
    
    private boolean vystreli() {
        return this.generator.nextBoolean();
    }
    
    private void vystrel() {
        int votrelec = this.vyberNahodnehoVotrelca();
        this.bomby.vystrel(this.votrelci.get(votrelec).getStredX(), this.votrelci.get(votrelec).getStredY(), this.maxBomby, "pics/bomba.png");        
    }
    
    
    /**
     * Zobrazi vsetkych votrelcov
     */
    public void zobrazVotrelcov() {
        for (Charakter votrelec : this.votrelci) {
            votrelec.zobraz();
        }
    }
    
    /**
     * Skryje vsetkych votrelcov
     */
    public void skryVotrelcov() {
        for (Charakter votrelec : this.votrelci) {
            votrelec.skry();
        }
    }    
    
    /**
     * Posunie so vsetkymi votrelcami 
     */
    public void posun() {
        for (Charakter votrelec : this.votrelci) {
            if (votrelec.getStredX() + 30 >= MAX_X) {
                this.vzdialenost = -VZDIALENOST;
                for (Charakter votreleC : this.votrelci) {
                    votreleC.posunZvisle(VZDIALENOST);
                }
                break;
            } else if (votrelec.getStredX() - 30 <= 0) {
                this.vzdialenost = VZDIALENOST;
                for (Charakter votreleC : this.votrelci) {
                    votreleC.posunZvisle(VZDIALENOST);
                }
                break;
            } 
        }
        
        for (Charakter votrelec : this.votrelci) {
            votrelec.posunVodorovne(this.vzdialenost);
        }
    }  
    
    /**
     * Vrati ci su votrelci na konci resp pri lodi hraca
     */
    public boolean suNaKonci() {
        boolean su = false;
        for (Charakter votrelec : this.votrelci) {
            if (votrelec.getStredY() >= 450) {
                su = true;
            } 
        }
        return su;
    }
    
    /**
     * Metoda pre manazera,kazdy tik sa rozhodne ci vystreli bombu a posunie vsetky uz vystrelene bomby
     */
    public void tik() {
        if (this.vystreli()) {
            this.vystrel();
        }
        this.bomby.posun(VZDIALENOST);
        this.posun();
    }
    
    /**
     * Vymaze a skryje votrelca na indexe
     * @param index ktoreho votrelca vymaze
     */
    public void vymazVotrelca(int index) {
        this.votrelci.get(index).skry();
        this.votrelci.remove(index);
    }
    
    /**
     * Vrati velkost ArrayListu votrelcov
     */
    public int getVelkostListu() {
        return this.votrelci.size();
    }
    
    /**
     * Vrati stredX votrelca na indexe
     * @param index votrelca ktoreho stredX vrati
     */
    public int getStredXVotrelca(int index) {
        return this.votrelci.get(index).getStredX();
    }
    
    /**
     * Vrati stredY votrelca na indexe
     * @param index votrelca ktoreho stredY vrati
     */    
    public int getStredYVotrelca(int index) {
        return this.votrelci.get(index).getStredY();
    }    

    private boolean vRozsahu(int hodnota, int min, int max) {
        return max >= hodnota && hodnota >= min;
    }    
    
    /**
     * Vrati ci su suradnice v rozsahu votrelca alebo nie
     */
    public boolean jeVRozsahu(int x, int y, int index) {
        int lavyHornyX = this.votrelci.get(index).getLavyHornyX();
        int lavyHornyY = this.votrelci.get(index).getLavyHornyY();
        return this.vRozsahu(x, lavyHornyX, lavyHornyX + 40) && this.vRozsahu(y, lavyHornyY, lavyHornyY + 30);
    }
    
    /**
     * Vrati velkost ArrayListu bomby
     */
    public int getVelkostBomb() {
        return this.bomby.getVelkostListu();
    }
    
    /**
     * Vymaze bombu na danom indexe
     * @param index bomba ktoru vymaze
     */
    public void vymazBombu(int index) {
        this.bomby.vymazStrelu(index);
    }
    
    /**
     * Vrati stredX bomby na danom indexe
     * @param index bomby ktorej stredX vrati
     */
    public int getStredXBomby(int index) {
        return this.bomby.getStredX(index);
    }
    
    /**
     * Vrati stredY bomby na danom indexe
     * @param index bomby ktorej stredY vrati
     */    
    public int getStredYBomby(int index) {
        return this.bomby.getStredY(index);
    }  
    
    /**
     * skryje vsetky bomby
     */
    public void skryBomby() {
        this.bomby.skryVsetkyStrely();
    }
}
