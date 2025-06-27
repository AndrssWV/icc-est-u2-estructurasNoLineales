import materia.controllers.AVLTree;
import materia.controllers.BinaryTree;

public class App {
    public static void main(String[] args) throws Exception {
        
        AVLTree at = new AVLTree();
        at.insert(50);
        at.insert(17);
        at.insert(76);
        at.insert(9);
        at.insert(23);
        at.insert(54);
        at.insert(14);
        at.insert(19);
    

        //System.err.println("La altura es " + bt.getHeightTree());
        //System.err.println("El factor es " + bt.getFactor());
    }
}
