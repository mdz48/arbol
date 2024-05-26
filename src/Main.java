import models.ArbolBinario;
import models.Employee;
import models.Nodo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        Scanner entrada = new Scanner(System.in);
        Employee rootEmployee = new Employee("Primero", 123, "Primero");
        Nodo rootNode = new Nodo(rootEmployee);
        arbol.setRaiz(rootNode);
        Employee emp1 = new Employee("Mario", 233306, "Segundo");
        Employee emp2 = new Employee("Capiña", 233500, "Tercero");
        arbol.insertarNodo(arbol.getRaiz(), emp1);
        arbol.insertarNodo(arbol.getRaiz(), emp2);

        int opc;
        do {
            System.out.println("1. Crear raíz\n2. Agregar nodos\n3. Imprimir recorridos\n4. Salir");
            opc = entrada.nextInt();
            entrada.nextLine();
            switch (opc) {
                case 1:
                    String nombre = entrada.nextLine();
                    System.out.println("Ingresa la dirección del empleado");
                    String direccion = entrada.nextLine();
                    System.out.println("Ingresa el número de afiliación del empleado");
                    int afiliacion = entrada.nextInt();
                    entrada.nextLine();
                    Employee employee = new Employee(nombre, afiliacion, direccion);
                    arbol.insertarNodo(arbol.getRaiz(), employee);
                    break;
                case 3:
                    arbol.visualizarRecorridos();
                    break;
            }
        } while (opc != 4);
    }
}
