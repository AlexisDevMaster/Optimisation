import branchandbound.BinaryTree;
import entite.*;
import utils.ContraintesCalculator;
import utils.HeuristiqueCalculator;
import utils.ObjectifCalulator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Principale {

    public static void main(String[] args){

        System.out.println("---------------Bienvenue sur le programme d'Optimisation---------------\n\n");
//        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
//        String temp="";
//        int cout= 0;
//
//        System.out.println("Commen");
//        String userName = scanner.nextLine();  // Read user input
//        System.out.println("Username is: " + userName);  // Output user input
        Athletisme athletisme = new Athletisme(9,450,0);
        Basket basket = new Basket(2,700,0);
        Cyclisme cyclisme = new Cyclisme(3,350,0);
        Football football = new Football(13,500,0);
        Judo judo = new Judo(6,450,0);
        Natation natation = new Natation(5,100,0);

        System.out.println("Le programme s'éxécute par défault avec les valeurs de l'énoncé\n");
        System.out.println("Récapitualtif: \n");
        System.out.println("Athlétisme : \n"+"       Temps : "+athletisme.getTemps()+ "h\n"+"       Coût : "+athletisme.getCout());
        System.out.println("Basket : \n"+"       Temps : "+basket.getTemps()+ "h\n"+"       Coût : "+basket.getCout());
        System.out.println("Cyclisme : \n"+"       Temps : "+cyclisme.getTemps()+ "h\n"+"       Coût : "+cyclisme.getCout());
        System.out.println("Football : \n"+"       Temps : "+football.getTemps()+ "h\n"+"       Coût : "+football.getCout());
        System.out.println("Judo : \n"+"       Temps : "+judo.getTemps()+ "h\n"+"       Coût : "+judo.getCout());
        System.out.println("Natation : \n"+"       Temps : "+natation.getTemps()+ "h\n"+"       Coût : "+natation.getCout());

        // (selecteur de la variable, min ou max, entité1, entité2, ....)
        // sélecteur de la variable 0 = temps, 1 = cout, 2 = ratio
        ObjectifCalulator objectifCalulator = new ObjectifCalulator(0, 1, athletisme, basket, cyclisme, football, judo, natation);
        System.out.println("La fonction Objectif est égale à : "+objectifCalulator.genererFonctionObjectif());

        // (selecteur de la variable, inferieur ou supérieur, valeur de la contrainte, entité1, entité2, ....)
        // sélecteur de la variable 0 = temps, 1 = cout, 2 = ratio
        // inf = 0, sup = 1
        ContraintesCalculator contrainteCalulator = new ContraintesCalculator(1, 0, 1000, athletisme, basket, cyclisme, football, judo, natation);
        System.out.println("Il n'y a qu'une seule contrainte : "+ contrainteCalulator.genererContrainte());

        System.out.println("\n");
        System.out.println("----Calcul des Heuristiques----\n");
        HeuristiqueCalculator heuristiqueCalculator = new HeuristiqueCalculator(contrainteCalulator.getContrainte());
        System.out.println("Heuristique 1 : Ordre croissant des prix des packs");
        ArrayList<Entite> entitePrixPack = new ArrayList<>();
        entitePrixPack.add(athletisme);
        entitePrixPack.add(basket);
        entitePrixPack.add(cyclisme);
        entitePrixPack.add(football);
        entitePrixPack.add(judo);
        entitePrixPack.add(natation);
        entitePrixPack.sort(Entite.EntiteCoutComparatorAsc);
        System.out.println("La liste des entitées triées par l'heuristique 1 : ");
        for (Entite i:entitePrixPack) {
            System.out.print(i.getNom()+ ": "+i.getCout()+  "      ");
        }
        System.out.println("\n");
         heuristiqueCalculator.setListEntite(entitePrixPack);
        ArrayList<Float> heuristique = heuristiqueCalculator.calculerHeuristique();
        System.out.println("La liste des entitées prisent par l'heuristique 1 : ");
        System.out.println("    Liste brut :");
        System.out.print("        ");
        for (int i = 0; i < heuristique.size(); i++) {
            System.out.print(""+heuristique.get(i));
            if(i < heuristique.size()-1){
                System.out.print(", ");
            }else{
                System.out.println("");
            }
        }
        System.out.println("Temps total : "+ heuristiqueCalculator.getFinalSolution());


        System.out.println("\n");

        System.out.println("Heuristique 2 : Ordre décroissant des heures des packs");
        ArrayList<Entite> entiteTempsPack = new ArrayList<>();
        entiteTempsPack.add(athletisme);
        entiteTempsPack.add(basket);
        entiteTempsPack.add(cyclisme);
        entiteTempsPack.add(football);
        entiteTempsPack.add(judo);
        entiteTempsPack.add(natation);
        entiteTempsPack.sort(Entite.EntiteHeureComparatorDesc);
        System.out.println("La liste des entitées triées par l'heuristique 2 : ");
        for (Entite i:entiteTempsPack) {
            System.out.print(i.getNom()+ ": "+i.getTemps()+ "      ");
        }
        System.out.println("\n");
        heuristiqueCalculator.setListEntite(entiteTempsPack);
        heuristique = heuristiqueCalculator.calculerHeuristique();
        System.out.println("La liste des entitées prisent par l'heuristique 2 : ");
        System.out.println("    Liste brut :");
        System.out.print("        ");
        for (int i = 0; i < heuristique.size(); i++) {
            System.out.print(""+heuristique.get(i));
            if(i < heuristique.size()-1){
                System.out.print(", ");
            }else{
                System.out.println("");
            }
        }
        System.out.println("Temps total : "+ heuristiqueCalculator.getFinalSolution());

        System.out.println("\n");

        System.out.println("Heuristique 3 : Ordre croissant des ratios temps/cout des packs");
        ArrayList<Entite> entiteRatioPack = new ArrayList<>();
        entiteRatioPack.add(athletisme);
        entiteRatioPack.add(basket);
        entiteRatioPack.add(cyclisme);
        entiteRatioPack.add(football);
        entiteRatioPack.add(judo);
        entiteRatioPack.add(natation);
        entiteRatioPack.sort(Entite.EntiteRatioComparatorDesc);
        System.out.println("La liste des entitées triées par l'heuristique 3 : ");
        for (Entite i:entiteRatioPack) {
            System.out.print(i.getNom()+ ": "+i.getRatio()+ "      ");
        }
        System.out.println("\n");
        heuristiqueCalculator.setListEntite(entiteRatioPack);
        heuristique = heuristiqueCalculator.calculerHeuristique();
        System.out.println("La liste des entitées prisent par l'heuristique 3 : ");
        System.out.println("    Liste brut :");
        System.out.print("        ");
        for (int i = 0; i < heuristique.size(); i++) {
            System.out.print(""+heuristique.get(i));
            if(i < heuristique.size()-1){
                System.out.print(", ");
            }else{
                System.out.println("");
            }
        }
        System.out.println("Temps total : "+ heuristiqueCalculator.getFinalSolution());

        System.out.print("Solution intitale : ");
        for (int i = 0; i < heuristique.size(); i++) {
            System.out.print(""+heuristique.get(i));
            if(i < heuristique.size()-1){
                System.out.print(", ");
            }
        }
        System.out.print("   z = "+heuristiqueCalculator.getFinalSolution());
        System.out.println();
        System.out.print("Solution Actuelle : ");
        for (int i = 0; i < heuristique.size(); i++) {
            System.out.print(""+heuristique.get(i));
            if(i < heuristique.size()-1){
                System.out.print(", ");
            }
        }
        System.out.print("   z = "+heuristiqueCalculator.getFinalSolution());
        System.out.println();
        System.out.println("Borne supérieur : relaxe réelle");

        System.out.println("----Construction du Branch&Bounds----");

        BinaryTree bt = new BinaryTree(26,1000, entiteRatioPack);
        System.out.println("Execution passée");

    }


}
