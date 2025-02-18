import java.util.Scanner;
import java.io.FileNotFoundException;
/**
 * Trieda vytvara instanciu hry,vypisuje menu na terminal,kontroluje kolizie objektov.
 * 
 * @author Jan Vavrik
 * 
 */
public class Hra {
        
    private static Hra instancia = null;
                                                         //Nazov,riadky,stlpce,nasobic,maxStrely,maxBomby,zivotyHraca
    private static final Obtiaznost LAHKA = new Obtiaznost("Lahka", 3, 5, 1, 3, 3, 3);
    private static final Obtiaznost STREDNA = new Obtiaznost("Stredna", 4, 5, 2, 2, 4, 2);
    private static final Obtiaznost TAZKA = new Obtiaznost("Tazka", 5, 5, 3, 1, 5, 1);  
    private static final int TABULA_X = 10;
    private static final int TABULA_Y = 10;
    private static final int TABULA_POCET_DISPLEJOV = 3;
    private static final int PRIDAJ_BODY = 10;
    private static final int VELKOST_BOMB_POLKA = 15;
    private static final int VELKOST_STREL_POLKA = 15;
    
    private Votrelci votrelci;
    private Manazer manazer;
    private Hrac hrac;
    private Tabula tabula;
    private Scanner terminal;
    private int nasobic;
    private String nazov;
    
    /**
     *Spusti hru 
     */
    public static void main(String[] args) throws FileNotFoundException {
        spusti();
    }
    
    private Hra() {
    }
    
    private Hra(String nazov, int riadky, int stlpce, int nasobic, int maxStrely, int maxBomby, int zivotyHraca) {
        this.nazov = nazov;
        this.hrac = new Hrac(zivotyHraca, maxStrely);
        this.votrelci = new Votrelci(riadky, stlpce, maxBomby);
        this.manazer = new Manazer();
        this.tabula = new Tabula(TABULA_X, TABULA_Y, TABULA_POCET_DISPLEJOV);
        this.nasobic = nasobic;
    }
    
    private void inicializujTerminal() {
        this.terminal = new Scanner(System.in);
    }
    
    /**
     * Vrati instanciu triedy,singleton
     */
    public static Hra getInstancia() {
        if (Hra.instancia == null) {
            Hra.instancia = new Hra();
        }
        return Hra.instancia;
    }
    
    
    private static void spusti() throws FileNotFoundException {
        Hra.getInstancia().zobrazHlavneMenu();
    }
    
    private void zobrazHlavneMenu() throws FileNotFoundException {
        this.inicializujTerminal();
        String volba;
        do {
            System.out.println("\fHlavne menu\n[H].Hraj\n[T].Tabulka\n[K].Koniec");
            volba = this.terminal.nextLine();
            switch (volba) {
                case "H":
                    this.zobrazMenuObtiaznost();
                    break;
                case "K":
                    break;
                default:
                    this.upozorniNaNespravnuVolbu();
            }                
        } while (!volba.equals("K"));
    }
    
    
    private void zobrazMenuObtiaznost() {
        String volba;
        do {
            System.out.println("\fVyber obtiaznosti\n[L].Lahka\n[S].Stredna\n[T].Tazka\n[B].Spat)");
            volba = this.terminal.nextLine();
            switch (volba) {
                case "L":
                    Hra.instancia = new Hra(LAHKA.getNazov(), LAHKA.getRiadky(), LAHKA.getStlpce(), LAHKA.getNasobic(), 
                    LAHKA.getMaxStrely(), LAHKA.getMaxBomby(), LAHKA.getZivotyHraca());
                    Hra.instancia.start();
                    break;
                case "S":
                    Hra.instancia = new Hra(STREDNA.getNazov(), STREDNA.getRiadky(), STREDNA.getStlpce(), STREDNA.getNasobic(),
                    STREDNA.getMaxStrely(), STREDNA.getMaxBomby(), STREDNA.getZivotyHraca());
                    Hra.instancia.start();
                    break;
                case "T":
                    Hra.instancia = new Hra(TAZKA.getNazov(), TAZKA.getRiadky(), TAZKA.getStlpce(), TAZKA.getNasobic(),
                    TAZKA.getMaxStrely(), TAZKA.getMaxBomby(), TAZKA.getZivotyHraca()); 
                    Hra.instancia.start();
                    break;
                case "B":
                    break;
                default:
                    this.upozorniNaNespravnuVolbu();
            }            
        } while (!volba.equals("B"));
    }    
    
    private void upozorniNaNespravnuVolbu() {
        System.out.println("Nespravna volba");
        this.pockajNaEnter();      
    }

    private void pockajNaEnter() {
        System.out.println("Stlacte enter pre pokracovanie");
        this.terminal.nextLine();
    }    
    
    /**
     * Inicializuje potrebne veci a odstartuje hru
     */
    private void start() {
        this.tabula.rozsviet();
        this.tabula.zobrazCislo(0);
        this.votrelci.zobrazVotrelcov();
        this.manazer.spravujObjekt(this.hrac);
        this.manazer.spravujObjekt(this.votrelci);
        this.manazer.spravujObjekt(this);
        
    }
     
    private void kolizia() {
        for (int i = 0; i < this.votrelci.getVelkostListu(); i++) {
            for (int j = 0; j < this.hrac.getVelkostStriel(); j++) {
                if (this.votrelci.jeVRozsahu(this.hrac.getStredXStrely(j), this.hrac.getStredYStrely(j) - VELKOST_STREL_POLKA, i)) {
                    this.votrelci.vymazVotrelca(i);
                    this.hrac.vymazStrelu(j);
                    this.hrac.pridajSkore(PRIDAJ_BODY * nasobic);
                    this.tabula.zobrazCislo(this.hrac.getSkore());
                }
            }
        }
     
        for (int i = 0; i < this.votrelci.getVelkostBomb(); i++) {
            if (this.hrac.jeVRozsahu(this.votrelci.getStredXBomby(i), this.votrelci.getStredYBomby(i) + VELKOST_BOMB_POLKA, i)) {
                this.hrac.odstranZivot();
                this.votrelci.vymazBombu(i);
            }
        }        
    }
    
    private boolean koniec() {
        return this.hrac.getZivoty() == 0 || this.votrelci.getVelkostListu() == 0 || this.votrelci.suNaKonci();
    }
    
    
    /**
     * Metoda pre manazera,kazdy tik kontroluje ci doslo ku kolizii alebo ku koncu hry,ak doslo ku koncu hry tak prestane spravovat objekty a skryje ich
     */
    public void tik() {
        this.kolizia();
        if (this.koniec()) {
            this.manazer.prestanSpravovatObjekt(this.votrelci);
            this.manazer.prestanSpravovatObjekt(this.hrac);
            this.manazer.prestanSpravovatObjekt(this);
            this.votrelci.skryVotrelcov();
            this.votrelci.skryBomby();
            this.hrac.skry();
            this.hrac.skryStrely();
        }
    }
}
