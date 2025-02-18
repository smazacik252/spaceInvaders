public class SSD {
    
    /*
    private Segment segmentA;
    private Segment segmentB;
    private Segment segmentC;
    private Segment segmentD;
    private Segment segmentE;
    private Segment segmentF;
    private Segment segmentG;
    */
    
    private Segment[] poleSegmentov;
    private static final int INDEX_A = 0;
    private static final int INDEX_B = 1;
    private static final int INDEX_C = 2;
    private static final int INDEX_D = 3;
    private static final int INDEX_E = 4;
    private static final int INDEX_F = 5;
    private static final int INDEX_G = 6;
    //                                       A     B     C     D     E     F      G
    public static final boolean[] MASKA_0 = {true, true, true, true, true, true, false};
    public static final boolean[] MASKA_1 = {false, true, true, false, false, false, false};
    public static final boolean[] MASKA_2 = {true, true, false, true, true, false, true};
    public static final boolean[] MASKA_3 = {true, true, true, true, false, false, true};
    public static final boolean[] MASKA_4 = {false, false, true, false, false, true, true};
    public static final boolean[] MASKA_5 = {true, false, true, true, false, true, true};
    public static final boolean[] MASKA_6 = {true, false, true, true, true, true, true};
    public static final boolean[] MASKA_7 = {true, true, true, false, false, false, false};
    public static final boolean[] MASKA_8 = {true, true, true, true, true, true, true};
    public static final boolean[] MASKA_9 = {true, true, true, true, false, true, true};
    
    public SSD(int dlzkaSegmentu, int hrubkaSegmentu, int poziciaDisplejaX, int poziciaDisplejaY) {
        this.poleSegmentov = new Segment[7];

        this.poleSegmentov[INDEX_A] = new Segment(dlzkaSegmentu, hrubkaSegmentu, poziciaDisplejaX + hrubkaSegmentu, poziciaDisplejaY);
        this.poleSegmentov[INDEX_B] = new Segment(hrubkaSegmentu, dlzkaSegmentu, poziciaDisplejaX + dlzkaSegmentu + hrubkaSegmentu, poziciaDisplejaY + hrubkaSegmentu);
        this.poleSegmentov[INDEX_C] = new Segment(hrubkaSegmentu, dlzkaSegmentu, poziciaDisplejaX + dlzkaSegmentu + hrubkaSegmentu, poziciaDisplejaY + dlzkaSegmentu + 2 * hrubkaSegmentu);
        this.poleSegmentov[INDEX_D] = new Segment(dlzkaSegmentu, hrubkaSegmentu, poziciaDisplejaX + hrubkaSegmentu, poziciaDisplejaY + 2 * dlzkaSegmentu + 2 * hrubkaSegmentu);
        this.poleSegmentov[INDEX_E] = new Segment(hrubkaSegmentu, dlzkaSegmentu, poziciaDisplejaX, poziciaDisplejaY + dlzkaSegmentu + 2 * hrubkaSegmentu);
        this.poleSegmentov[INDEX_F] = new Segment(hrubkaSegmentu, dlzkaSegmentu, poziciaDisplejaX, poziciaDisplejaY + hrubkaSegmentu);
        this.poleSegmentov[INDEX_G] = new Segment(dlzkaSegmentu, hrubkaSegmentu, poziciaDisplejaX + hrubkaSegmentu, poziciaDisplejaY + dlzkaSegmentu + hrubkaSegmentu);
    }
    
    public void zobraz0() {
        this.zhasni();
        this.zobrazMasku(MASKA_0);
        /*
        this.segmentA.rozsviet();
        this.segmentB.rozsviet();
        this.segmentC.rozsviet();
        this.segmentD.rozsviet();
        this.segmentE.rozsviet();
        this.segmentF.rozsviet();
        */
    }
    
    public void zobraz1() {
        this.zhasni();
        this.zobrazMasku(MASKA_1);
        // this.segmentB.rozsviet();
        // this.segmentC.rozsviet();
    }
    
    public void zobraz2() {
        this.zhasni();
        this.zobrazMasku(MASKA_2);
        // this.segmentA.rozsviet();
        // this.segmentB.rozsviet();
        // this.segmentG.rozsviet();
        // this.segmentE.rozsviet();
        // this.segmentD.rozsviet();
    }
    
    public void zobraz3() {
        this.zhasni();
        this.zobrazMasku(MASKA_3);
        // this.segmentA.rozsviet();
        // this.segmentB.rozsviet();
        // this.segmentG.rozsviet();
        // this.segmentC.rozsviet();
        // this.segmentD.rozsviet();
    }
    
    public void zobraz4() {
        this.zhasni();
        this.zobrazMasku(MASKA_4);
        // this.segmentB.rozsviet();
        // this.segmentC.rozsviet();
        // this.segmentF.rozsviet();
        // this.segmentG.rozsviet();        
    }
    
    public void zobraz5() {
        this.zhasni();
        this.zobrazMasku(MASKA_5);
        // this.segmentA.rozsviet();
        // this.segmentC.rozsviet();
        // this.segmentD.rozsviet();
        // this.segmentF.rozsviet();
        // this.segmentG.rozsviet();
    }
    
    public void zobraz6() {
        this.zhasni();
        this.zobrazMasku(MASKA_6);
        // this.segmentA.rozsviet();
        // this.segmentC.rozsviet();
        // this.segmentD.rozsviet();
        // this.segmentE.rozsviet();
        // this.segmentF.rozsviet();
        // this.segmentG.rozsviet();
    }
    
    public void zobraz7() {
        this.zhasni();
        this.zobrazMasku(MASKA_7);
        // this.segmentA.rozsviet();
        // this.segmentB.rozsviet();
        // this.segmentC.rozsviet();
    }
    
    public void zobraz8() {
        this.zhasni();
        this.rozsviet();
    }
    
    public void zobraz9() {
        this.zhasni();
        this.zobrazMasku(MASKA_9);
        // this.segmentA.rozsviet();
        // this.segmentB.rozsviet();
        // this.segmentC.rozsviet();
        // this.segmentD.rozsviet();
        // this.segmentF.rozsviet();
        // this.segmentG.rozsviet();        
    }
    
    public void zobrazCislo(int cifra) {
        switch (cifra) {
            case 0:
                this.zobraz0();
                break;
            case 1:
                this.zobraz1();
                break;
            case 2:
                this.zobraz2();
                break;
            case 3:
                this.zobraz3();
                break;
            case 4:
                this.zobraz4();
                break;
            case 5:
                this.zobraz5();
                break;
            case 6:
                this.zobraz6();
                break;
            case 7:
                this.zobraz7();
                break;
            case 8:
                this.zobraz8();
                break;  
            case 9:
                this.zobraz9();
                break; 
            default:
                System.out.println("Take cislo neviem");
        }
    }
    
    public void rozsviet() {
        for (Segment segment : this.poleSegmentov) {
            segment.rozsviet();
        }
        /*for(int i = 0; i < this.poleSegmentov.length; i++) {
            this.poleSegmentov[i].rozsviet();
        }
        this.segmentA.rozsviet();
        this.segmentB.rozsviet();
        this.segmentC.rozsviet();
        this.segmentD.rozsviet();
        this.segmentE.rozsviet();
        this.segmentF.rozsviet();
        this.segmentG.rozsviet();*/
    }
    
    public void zhasni() {
        for (Segment segment : this.poleSegmentov) {
            segment.zhasni();
        }
        /*
        for(int i = 0; i < this.poleSegmentov.length; i++) {
            this.poleSegmentov[i].zhasni();
        } 
        this.segmentA.zhasni();
        this.segmentB.zhasni();
        this.segmentC.zhasni();
        this.segmentD.zhasni();
        this.segmentE.zhasni();
        this.segmentF.zhasni();
        this.segmentG.zhasni();*/
    }
    
    public void zobrazMasku(boolean[] maska) {
        if (this.poleSegmentov.length == maska.length) {
            for (int i = 0; i < maska.length; i++) {
                if (maska[i]) {
                    this.poleSegmentov[i].rozsviet();
                } else {
                    this.poleSegmentov[i].zhasni();
                }
            }
        }
    }
}
