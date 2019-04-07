package branchandbound;

import entite.Entite;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BinaryTree {

    Node root;
    ArrayList<Entite> entites;
    ArrayList<Node> lastNodes;
    int compteur;

    public BinaryTree(float borneSup, float cout, ArrayList<Entite> listes){
        lastNodes = new ArrayList<>();
        entites = listes;
        root = new Node(borneSup, cout);
       compteur = 0;
        genererBranchAndBound(0,listes.get(0),  root);

    }

    public Node getBinaryTree(){
        return root;
    }

    public void addNodeLeft(Node newNode, Node root){
            if(root.getLeft()!=null)
                addNodeLeft(newNode, root.getLeft());
            else
                root.setLeft(newNode);
    }

    public void addNodeRight(Node newNode, Node root){
            if(root.getRight() != null)
                addNodeRight(newNode, root.getRight());
            else
                root.setRight(newNode);

    }

    public void genererBranchAndBound(int i, Entite e, Node root){
        //Verification sion ne depasse pas la liste des entites
        if(i < entites.size()) {
            System.out.println();
            //Creation node de gauche
            Node newNodLeft = new Node(root.getBorneSup() - e.getTemps(), root.getCout());
            //Creation node de droite
            Node newNodeRight = new Node(root.getBorneSup(), root.getCout() - e.getCout());
            //Verification si node de gauche nécéssaire
            if (newNodLeft.getBorneSup() == root.getBorneSup()) {
                //Ajout node de gauche
                System.out.println("----");
                System.out.println("Node Gauche existe! :");
                System.out.println("Indice de l'entité : " +i+ " \n nom : "+ entites.get(i).getNom() + " \n ratio : "+ entites.get(i).getRatio());
                this.addNodeLeft(newNodLeft, root);
                System.out.println("Valeur dans le noeud gauche : \n BorneSup : "+ newNodLeft.getBorneSup() + " \n Cout restant : "+newNodLeft.getCout());
                System.out.println("----");
                //Appel recursif pour generer les nodes gauches droite du noeud
                genererBranchAndBound(i+1, entites.get(i+1), newNodLeft);
            }else{
                System.out.println("----");
                System.out.println("Node Gauche n'existe pas");
                System.out.println("----");
            }
            System.out.println();
            //Verification node de droite necessaire
            if (root.getCout() - e.getCout() >= 0) {
                //Ajout node de droite
                System.out.println("----");
                System.out.println("Node Droite existe! :");
                System.out.println("Indice de l'entité : " +i+ " \n nom : "+ entites.get(i).getNom() + " \n ratio : "+ entites.get(i).getRatio());
                this.addNodeRight(newNodeRight, root);
                System.out.println("Valeur dans le noeud droit : \n BorneSup : "+ newNodeRight.getBorneSup() + " \n Cout restant : "+newNodeRight.getCout());
                System.out.println("----");
                //Appel recursif pour generer les nodes gauches droite du noeud
                genererBranchAndBound(i+1, entites.get(i+1), newNodeRight);
            }else{
                System.out.println("Node Droite n'existe pas");
            }

            if(root.getLeft()== null && root.getRight()==null){
                System.out.println("------------");
                System.out.println("VALEUR OPTIMAL : ");
                System.out.println("Borne Superieur : "+root.getBorneSup());
                System.out.println("Cout total : "+root.getCout());
            }

        }
    }

}
