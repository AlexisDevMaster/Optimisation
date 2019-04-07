package utils;

import entite.Entite;
import java.util.ArrayList;

public class HeuristiqueCalculator {

    ArrayList<Entite> listEntite;
    int contrainte;
    float finalSolution;

    public HeuristiqueCalculator(int cont){
       contrainte = cont;
    }


    public ArrayList<Float> calculerHeuristique(){
        float limit=0;
        float temps=0;
        ArrayList<Float> takeOrNot = new ArrayList<>();
        for(int i = 0; i< listEntite.size();i++){
            if((limit +(float) listEntite.get(i).getCout())<=contrainte){
                limit += (float) listEntite.get(i).getCout();
                temps+=(float)listEntite.get(i).getTemps();
                takeOrNot.add(1f);
                listEntite.get(i).setRes(takeOrNot.get(i));
            }else {
                float tmpContrainte = (float)contrainte - limit;
                float coeff = (float)(tmpContrainte/ listEntite.get(i).getCout());
                takeOrNot.add((float)(coeff));
                temps+=(float)(listEntite.get(i).getTemps()*coeff);
                limit+= (float)(listEntite.get(i).getCout()*coeff);
                listEntite.get(i).setRes(takeOrNot.get(i));
            }
        }
       finalSolution = temps;
        return takeOrNot;
    }

    public float getFinalSolution(){
        return finalSolution;
    }

    public void setListEntite(ArrayList<Entite> listEntite) {
        this.listEntite = listEntite;
    }
}
