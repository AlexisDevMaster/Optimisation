package utils;

import entite.*;

import java.util.ArrayList;

public class ObjectifCalulator {
    /***
     * Attribut qui permet d'enregistrer les valeurs des entités étuidiées (ex: Temps, Cout, Ratio)
     */
    private ArrayList<Float> coeffObjectif;

    private Athletisme athletisme;
    private Basket basket;
    private Cyclisme cyclisme;
    private Football football;
    private Judo judo;
    private Natation natation;
    /***
     * Attribut qui permet de déterminé si c'est Min ou Max recherché
     */
    private int maxOrMin;

    /***
     *
     * @param selecteur permet de selectionner l'attribut à étudier
     * @param maxOrMin
     * @param a
     * @param b
     * @param c
     * @param f
     * @param j
     * @param n
     */
    public ObjectifCalulator(int selecteur, int maxOrMin, Athletisme a, Basket b, Cyclisme c, Football f, Judo j, Natation n){
        coeffObjectif = new ArrayList<>();
        athletisme = a;
        basket = b;
        cyclisme =c;
        football = f;
        judo = j;
        natation = n;
        switch (selecteur){
            case 0:
                coeffObjectif.add(((float) a.getTemps()));
                coeffObjectif.add(((float) b.getTemps()));
                coeffObjectif.add(((float) c.getTemps()));
                coeffObjectif.add(((float) f.getTemps()));
                coeffObjectif.add(((float) j.getTemps()));
                coeffObjectif.add(((float) n.getTemps()));
                break;
            case 1:
                coeffObjectif.add(((float) a.getCout()));
                coeffObjectif.add(((float) b.getCout()));
                coeffObjectif.add(((float) c.getCout()));
                coeffObjectif.add(((float) f.getCout()));
                coeffObjectif.add(((float) j.getCout()));
                coeffObjectif.add(((float) n.getCout()));
                break;
            case 2:
                coeffObjectif.add((a.getRatio()));
                coeffObjectif.add((b.getRatio()));
                coeffObjectif.add((c.getRatio()));
                coeffObjectif.add((f.getRatio()));
                coeffObjectif.add((j.getRatio()));
                coeffObjectif.add((n.getRatio()));
                break;
        }
        this.maxOrMin = maxOrMin;
        genererFonctionObjectif();
    }

    /***
     * Fonction à appeller pour afficher la fonction objectif
     * @return fonction objectif au format String
     */
    public String genererFonctionObjectif() {
        String mOrm;
        if(maxOrMin ==0){
            mOrm = "Min";
        }else{
            mOrm = "Max";
        }
        return  mOrm + "("+coeffObjectif.get(0)+" * x0 + "+coeffObjectif.get(1)+" * x1 + "+coeffObjectif.get(2)+"* x2 + "+coeffObjectif.get(3)+" * x3 + "+coeffObjectif.get(4)+" * x4 + "+
                coeffObjectif.get(5)+" * x5"+")"+ "     [où x0, x1, x2, x3, x4, x5 = 0 ou 1]";
    }



    public int getMaxOrMin() {
        return maxOrMin;
    }


    public ArrayList<Float> getCoeffObjectif() {
        return coeffObjectif;
    }

}
