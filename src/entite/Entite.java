package entite;

import java.util.Comparator;

public class Entite /*implements Comparable<Entite> */{
    private String  nom;
    private int temps;
    private int cout;
    private float ratio;
    private float res = 0;

    public Entite(int t, int c, int select, String n){
        temps = t;
        cout = c;
        ratio = calculRatio(select, t,c);
        nom = n;
    }

    private float calculRatio(int selecteur, int t, int c){
        float returnValue = 0;
        switch(selecteur){
            case 0 :
                returnValue = (float) c/t;
                break;
            case 1:
                returnValue = (float) t/c;
                break;
        }
        return returnValue;
    }

    public int getTemps() {
        return temps;
    }

    public int getCout() {
        return cout;
    }

    public String getNom(){return nom;}

    public float getRatio() {
        return ratio;
    }

    public float getRes() {
        return res;
    }

    public void setRes(float res) {
        this.res = res;
    }

    public static Comparator<Entite> EntiteCoutComparatorAsc = new Comparator<Entite>() {

        public int compare(Entite entite1, Entite entite2) {

            String cout1 = ""+entite1.getCout();
            String cout2 = ""+entite2.getCout();
            //ascending order
            return cout1.compareTo(cout2);
            //descending order
            //return fruitName2.compareTo(fruitName1);
        }
    };
    public static Comparator<Entite> EntiteHeureComparatorDesc = new Comparator<Entite>() {

        public int compare(Entite entite1, Entite entite2) {

            float temps1 = entite1.getTemps();
            float temps2 = entite2.getTemps();
            //ascending order
            //return cout1.compareTo(cout2);
            //descending order
            if (temps1 > temps2) return -1;
            if (temps1 < temps2) return 1;
            return 0;
        }
    };
    public static Comparator<Entite> EntiteRatioComparatorDesc = new Comparator<Entite>() {

        public int compare(Entite entite1, Entite entite2) {

            float ratio1 =  entite1.getRatio();
            float ratio2 = entite2.getRatio();
            //ascending order
            //return cout1.compareTo(cout2);
            //descending order
            if (ratio1 < ratio2) return -1;
            if (ratio1 > ratio2) return 1;
            return 0;
        }
    };
    public static Comparator<Entite> EntiteNomComparatorDesc = new Comparator<Entite>() {

        public int compare(Entite entite1, Entite entite2) {

            String nom1 =  entite1.getNom();
            String nom2 = entite2.getNom();
            //ascending order
            return nom1.compareTo(nom2);
            //descending order
        }
    };
}

