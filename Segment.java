public class Segment {
    
    private Obdlznik segment;
    
    public Segment(int dlzkaSegmentu, int hrubkaSegmentu, int poziciaX, int poziciaY) {
        this.segment = new Obdlznik();
        this.segment.zmenStrany(dlzkaSegmentu, hrubkaSegmentu);
        this.segment.zmenPolohu(poziciaX, poziciaY);
    }
    
    public void rozsviet() {
        this.segment.zobraz();
    }
    
    public void zhasni() {
        this.segment.skry();
    }
}
