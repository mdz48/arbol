package models;

public class ArbolBinario {
    Nodo raiz;

    public void setRaiz(Nodo raiz) {
        if (this.raiz == null)
            this.raiz = raiz;
        else
            System.out.println("Solo puede existir una raíz");
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public boolean validarRaiz() {
        return raiz != null && raiz.getEmployee() != null;
    }

    public void preorden(Nodo raiz) {
        if (raiz != null) {
            System.out.println(raiz.getEmployee());
            preorden(raiz.getIzquierdo());
            preorden(raiz.getDerecho());
        }
    }

    public void inorden(Nodo raiz) {
        if (raiz != null) {
            inorden(raiz.getIzquierdo());
            System.out.println(raiz.getEmployee());
            inorden(raiz.getDerecho());
        }
    }

    public void postorden(Nodo raiz) {
        if (raiz != null) {
            postorden(raiz.getIzquierdo());
            postorden(raiz.getDerecho());
            System.out.println(raiz.getEmployee());
        }
    }

    public void visualizarRecorridos() {
        System.out.println("Preorden");
        preorden(raiz);
        System.out.println("Inorden");
        inorden(raiz);
        System.out.println("Postorden");
        postorden(raiz);
    }

    public void insertarNodo(Nodo raiz, Employee employee) {
        if (validarRaiz()) {
            if (employee.getAfiliation() < raiz.getEmployee().getAfiliation()) {
                if (raiz.getIzquierdo() == null) {
                    Nodo nodoNuevo = new Nodo(employee);
                    raiz.setIzquierdo(nodoNuevo);
                } else {
                    insertarNodo(raiz.getIzquierdo(), employee);
                }
            } else if (employee.getAfiliation() > raiz.getEmployee().getAfiliation()) {
                if (raiz.getDerecho() == null) {
                    Nodo nodoNuevo = new Nodo(employee);
                    raiz.setDerecho(nodoNuevo);
                } else {
                    insertarNodo(raiz.getDerecho(), employee);
                }
            } else {
                System.out.println("Ya existe");
            }
        } else {
            System.out.println("Falta definir la raíz");
        }
    }
}
