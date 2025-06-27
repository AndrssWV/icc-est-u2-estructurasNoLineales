package materia.controllers;

import materia.models.Nodo;

public class AVLTree {
    private Nodo root;

    public AVLTree() {
        root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }
    
    public Nodo insertRec(Nodo node, int value) {
        if (node==null) {
            Nodo newn = new Nodo(value, node, node);
            System.out.println("Nodo insertado -> "+value+" con balance 0");
            newn.setHeight(1);
            return newn;
        }
        if (value<=node.getValor()) node.setLeft(insertRec(node.getLeft(), value));
        else if (value>node.getValor()) node.setRight(insertRec(node.getRight(), value));
        else return node;

        System.out.println("Nodo actual -> "+node.getValor());
        int altura = 1 + Math.max(height(node.getLeft()), height(node.getRight()));
        node.setHeight(altura);
        System.out.println("\tAltura -> "+altura);
        int balance = getBalance(node);
        System.out.println("\tBalance -> "+balance);



        return node;
     }

     private int height(Nodo node) {
        if (node == null) return 0;
        return node.getHeight();
     }

     private int getBalance(Nodo node) {
        if (node==null) return 0;
        return height(node.getLeft()) - height(node.getRight());
     }

     private Nodo leftRotation(Nodo x) {
        Nodo y = x.getRight();
        Nodo temp = y.getLeft();

        System.out.println("Rotacion IZQ con nodo " + x.getValor() + ", con balance " + getBalance(x));
        y.setLeft(x);
        x.setRight(temp);
        System.out.println("Nueva Raiz despues de la rotacion es "+y.getValor());
        return y;
     }

     private Nodo rightRotation(Nodo y) {
        Nodo x = y.getLeft();
        Nodo temp = x.getRight();

        System.out.println("Rotacion DER con nodo " + x.getValor() + ", con balance " + getBalance(x));
        x.setRight(y);
        y.setLeft(temp);
        System.out.println("Nueva Raiz despues de la rotacion es "+x.getValor());
        return x;
     }
    
}
