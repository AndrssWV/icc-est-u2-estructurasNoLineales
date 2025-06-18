import materia.controllers.BinaryTree;

public class App {
    public static void main(String[] args) throws Exception {
        
        BinaryTree bt = new BinaryTree();
        bt.insert(50);
        bt.insert(17);
        bt.insert(76);
        bt.insert(9);
        bt.insert(23);
        bt.insert(54);
        bt.insert(14);
        bt.insert(19);

        bt.printTree();
    }
}
