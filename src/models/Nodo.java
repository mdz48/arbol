package models;

public class Nodo {
    private Employee employee = new Employee();
    public Nodo izquierdo;
    public Nodo derecho;

    public Nodo(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Nodo() {}

    public Nodo getIzquierdo() {
        return izquierdo;
    }

    public Nodo getDerecho() {
        return derecho;
    }


    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }
}