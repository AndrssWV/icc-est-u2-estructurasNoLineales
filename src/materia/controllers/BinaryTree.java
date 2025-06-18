package materia.controllers;

import materia.models.Nodo;

public class BinaryTree {
    private Nodo root;
    
    public BinaryTree() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Nodo insertRec(Nodo padre, int value) {
        if (padre == null) return new Nodo(value, padre, padre);

        if (value < padre.getValor()) padre.setLeft(insertRec(padre.getLeft(), value));
        else padre.setRight(insertRec(padre.getRight(), value));

        return padre;
    }

    public void printTree() {
        preOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        inOrder(root);
        
    }

    private void preOrder(Nodo node) {
        if (node != null) {
            System.out.print(node.getValor() + " ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    
    }

    private void postOrder(Nodo node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(node.getValor() + " ");      
        }
    
    }

    private void inOrder(Nodo node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.print(node.getValor() + " ");
            inOrder(node.getRight());
        }
    
    }
}
