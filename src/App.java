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
        
        System.out.println();

        if (bt.findValue(23)) System.out.println("Encontrado el valor 23");
        else System.out.println("No encontro no una chimba");
        if (bt.findValue(77)) System.out.println("Encontrado el valor 77");
        else System.out.println("No encontro una chimba");
    }
}
