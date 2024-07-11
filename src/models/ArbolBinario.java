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
        if (raiz.getEmployee() != null)
            return true;
        return false;
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

    public void visualizarConDireccion() {
        System.out.println("Empleados con dirección:");
        visualizarConDireccion(raiz);
    }

    private void visualizarConDireccion(Nodo raiz) {
        if (raiz != null) {
            if (!raiz.getEmployee().getDirection().isEmpty()) {
                System.out.println(raiz.getEmployee());
            }
            visualizarConDireccion(raiz.getIzquierdo());
            visualizarConDireccion(raiz.getDerecho());
        }
    }

    public void visualizarSinDireccion() {
        System.out.println("Empleados sin dirección:");
        visualizarSinDireccion(raiz);
    }

    private void visualizarSinDireccion(Nodo raiz) {
        if (raiz != null) {
            if (raiz.getEmployee().getDirection().isEmpty()) {
                System.out.println(raiz.getEmployee());
            }
            visualizarSinDireccion(raiz.getIzquierdo());
            visualizarSinDireccion(raiz.getDerecho());
        }
    }

    public boolean existeAfiliacion(Nodo raiz, int afiliacion) {
        if (raiz == null) {
            return false;
        }
        if (raiz.getEmployee().getAfiliation() == afiliacion) {
            return true;
        }
        return existeAfiliacion(raiz.getIzquierdo(), afiliacion) || existeAfiliacion(raiz.getDerecho(), afiliacion);
    }

    public boolean busqueda(Nodo raiz, int dato) {
        if (raiz == null) {
            return false;
        }
        if (raiz.getEmployee().getAfiliation() == dato) {
            return true;
        }
        return busqueda(raiz.getIzquierdo(), dato) || busqueda(raiz.getDerecho(), dato);
    }

    public void visualizarRecorridos() {
        System.out.println("Preorden");
        preorden(raiz);
        System.out.println("Inorden");
        inorden(raiz);
        System.out.println("Postorden");
        postorden(raiz);
    }

    public void insertarNodo(Nodo nodo, Employee employee) {
        if (existeAfiliacion(raiz, employee.getAfiliation())) {
            System.out.println("El número de afiliación ya existe: " + employee.getAfiliation());
        } else {
            if (validarRaiz()) {
                if (employee.getAfiliation() < nodo.getEmployee().getAfiliation()) {
                    if (nodo.getIzquierdo() == null) {
                        Nodo nodoNuevo = new Nodo(employee);
                        nodo.setIzquierdo(nodoNuevo);
                    } else {
                        insertarNodo(nodo.getIzquierdo(), employee);
                    }
                } else if (employee.getAfiliation() > nodo.getEmployee().getAfiliation()) {
                    if (nodo.getDerecho() == null) {
                        Nodo nodoNuevo = new Nodo(employee);
                        nodo.setDerecho(nodoNuevo);
                    } else {
                        insertarNodo(nodo.getDerecho(), employee);
                    }
                } else {
                    System.out.println("Ya existe");
                }
            } else {
                System.out.println("Falta definir la raíz");
            }
        }
    }
}
