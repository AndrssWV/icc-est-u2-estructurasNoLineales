package materia.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import materia.models.Nodo;

public class BinaryTree {
    private Nodo root;
    private int weight;
    private Map<Integer,Integer> unbalanced;
    
    public BinaryTree() {
        this.root = null;
        this.weight = 0;
        unbalanced = new HashMap<>();
    }

    public void insert(int value) {
        root = insertRec(root, value);
        weight++;
    }

    private Nodo insertRec(Nodo padre, int value) {
        if (padre == null) return new Nodo(value, padre, padre);
        if (value < padre.getValor()) padre.setLeft(insertRec(padre.getLeft(), value));
        else padre.setRight(insertRec(padre.getRight(), value));
        return padre;
    }

    public boolean findValue(int n) {
        return findValueRec(root, n);
    }

    public boolean findValueRec(Nodo node, int n) {
        if (node != null) {
            if (node.getValor() == n) return true;
            if (node.getValor() < n) return findValueRec(node.getRight(), n);
            return findValueRec(node.getLeft(), n);
        }
        return false;
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
            System.out.print(node.getValor() + ", ");
            inOrder(node.getRight());
        }
    
    }

    private void inOrderHeight(Nodo node) {
        if (node != null) {
            inOrderHeight(node.getLeft());
            System.out.print(node.getValor() + "(" + getHeightTreeRec(node) + "), ");
            inOrderHeight(node.getRight());
        }
    
    }

    private void inOrderFactor(Nodo node) {
        if (node != null) {
            inOrderFactor(node.getLeft());
            System.out.print(node.getValor() + "(bf=" + getFactorRec(node) + "), ");
            if (getFactorRec(node) > 1 || getFactorRec(node) < -1) unbalanced.put(node.getValor(), getFactorRec(node));
            inOrderFactor(node.getRight());
        }
    
    }

    public int getHeightTree() {
        return getHeightTreeRec(root);
    }

    public int getHeightTreeRec(Nodo node) {
        if (node == null) return 0;
        int l = getHeightTreeRec(node.getLeft());
        int r = getHeightTreeRec(node.getRight());
        return l > r ? l+1 : r+1;
    }

    public int getFactor() {
        return getFactorRec(root);
    }

    public int getFactorRec(Nodo node) {
        if (node == null) return 0;
        return getHeightTreeRec(node.getLeft()) - getHeightTreeRec(node.getRight());
    }

    public void print() {
        System.out.println("Nombre: Andres Villalta");
        System.out.println();

        System.err.println("Peso del arbol = " + weight);
        System.err.println("Altura es = " + getHeightTree());
        System.out.println();
        
        System.out.println("Arbol InOrder");
        inOrder(root);
        System.out.println();
        System.out.println();

        System.out.println("Arbol InOrder con alturas");
        inOrderHeight(root);
        System.out.println();
        System.out.println();

        System.out.println("Arbol InOrder con factor equilibrio");
        inOrderFactor(root);
        System.out.println();
        System.out.println();

        System.out.println("Arbol esta equilibrado = " + ((getFactor()>1 || getFactor()<-1)? "FALSE" : "TRUE"));
        System.out.println("Existe el nodo 15 = " + (findValue(15)? "TRUE" : "FALSE"));
        System.out.println("Agregamos valor = 15");
        insert(15);
        System.out.println("Arbol esta equilibrado = " + ((getFactor()>1 || getFactor()<-1)? "FALSE" : "TRUE"));
        System.out.println();

        System.out.println("Arbol InOrder con factor equilibrio");
        inOrderFactor(root);
        System.out.println();
        System.out.print("Nodos desequilibrados = ");
        for (Map.Entry<Integer, Integer> n : unbalanced.entrySet()) {
            System.out.print(n.getKey() + "(fb  = " + n.getValue() + ") ");
        }
    
        

    }
}
