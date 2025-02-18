
/**
 * Write a description of class Obtiaznost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obtiaznost {
    
    private String nazov;
    private int riadky;
    private int stlpce;
    private int nasobic;
    private int maxStrely;
    private int maxBomby;
    private int zivotyHraca;
    
    public Obtiaznost(String nazov, int riadky, int stlpce, int nasobic, int maxStrely, int maxBomby, int zivotyHraca) {
        this.nazov = nazov;
        this.riadky = riadky;
        this.stlpce = stlpce;
        this.nasobic = nasobic;
        this.maxStrely = maxStrely;
        this.maxBomby = maxBomby;
        this.zivotyHraca = zivotyHraca;
    }
    
    public String getNazov() {
        return this.nazov;
    }
    
    public int getRiadky() {
        return this.riadky;
    }
    
    public int getStlpce() {
        return this.stlpce;
    }    
    
    public int getNasobic() {
        return this.nasobic;
    }
 
    public int getMaxStrely() {
        return this.maxStrely;
    }
    
    public int getMaxBomby() {
        return this.maxBomby;
    }    
    
    public int getZivotyHraca() {
        return this.zivotyHraca;
    }    
}
