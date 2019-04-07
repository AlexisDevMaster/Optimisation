package utils;

import entite.*;

import java.util.ArrayList;

public class ContraintesCalculator {

    private ArrayList<Float> coeffContrainte;
    private int selecteur;
    private int contrainte;
    private int inferieurOuSuperieur;
    private Athletisme athletisme;
    private Basket basket;
    private Cyclisme cyclisme;
    private Football football;
    private Judo judo;
    private Natation natation;

    public ContraintesCalculator(int select, int infOrSup, int cont, Athletisme a, Basket b, Cyclisme c, Football f, Judo j, Natation n){
        coeffContrainte = new ArrayList<>();
        inferieurOuSuperieur=infOrSup;
        selecteur = select;
        contrainte = cont;
        athletisme = a;
        basket = b;
        cyclisme = c;
        football = f;
        judo = j;
        natation = n;
        switch (selecteur){
            case 0:
                coeffContrainte.add(((float) a.getTemps()));
                coeffContrainte.add(((float) b.getTemps()));
                coeffContrainte.add(((float) c.getTemps()));
                coeffContrainte.add(((float) f.getTemps()));
                coeffContrainte.add(((float) j.getTemps()));
                coeffContrainte.add(((float) n.getTemps()));
                break;
            case 1:
                coeffContrainte.add(((float) a.getCout()));
                coeffContrainte.add(((float) b.getCout()));
                coeffContrainte.add(((float) c.getCout()));
                coeffContrainte.add(((float) f.getCout()));
                coeffContrainte.add(((float) j.getCout()));
                coeffContrainte.add(((float) n.getCout()));
                break;
            case 2:
                coeffContrainte.add((a.getRatio()));
                coeffContrainte.add((b.getRatio()));
                coeffContrainte.add((c.getRatio()));
                coeffContrainte.add((f.getRatio()));
                coeffContrainte.add((j.getRatio()));
                coeffContrainte.add((n.getRatio()));
                break;
        }
    }


    public String genererContrainte() {
        String res;
        if(inferieurOuSuperieur ==0){
            res = "<=";
        }else{
            res = ">=";
        }
        return   coeffContrainte.get(0)+" * x0 + "+coeffContrainte.get(1)+" * x1 + "+coeffContrainte.get(2)+"* x2 + "+coeffContrainte.get(3)+" * x3 + "+coeffContrainte.get(4)+" * x4 + "+
                coeffContrainte.get(5)+" * x5 "+ res + " "+ contrainte +"     [où x0, x1, x2, x3, x4, x5 = 0 ou 1]";
    }

    public int getContrainte() {
        return contrainte;
    }

}
