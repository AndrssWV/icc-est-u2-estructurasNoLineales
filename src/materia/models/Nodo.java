package materia.models;

public class Nodo {
    private int valor;
    private Nodo siguiente;
    private Nodo anterior;
    
    public Nodo(int valor, Nodo siguiente, Nodo anterior) {
        this.valor = valor;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Nodo getRight() {
        return siguiente;
    }

    public void setRight(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getLeft() {
        return anterior;
    }

    public void setLeft(Nodo anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return "Nodo [valor=" + valor + ", siguiente=" + siguiente + ", anterior=" + anterior + "]";
    }

}
