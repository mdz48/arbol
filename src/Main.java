import models.ArbolBinario;
import models.Employee;
import models.Nodo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        Scanner entrada = new Scanner(System.in);
        initialize(arbol);

        int opc;
        do {
            System.out.println("1. Agregar nodos\n2. Imprimir recorridos\n3. Ver empleados con dirección\n4. Ver empleados sin dirección\n5. Salir");
            opc = entrada.nextInt();
            entrada.nextLine();
            switch (opc) {
                case 1:
                    System.out.println("Ingresa el nombre del empleado");
                    String nombre = entrada.nextLine();
                    System.out.println("Ingresa la dirección del empleado");
                    String direccion = entrada.nextLine();
                    System.out.println("Ingresa el número de afiliación del empleado");
                    int afiliacion = entrada.nextInt();
                    entrada.nextLine();
                    Employee employee = new Employee(nombre, afiliacion, direccion);
                    arbol.insertarNodo(arbol.getRaiz(), employee);
                    break;
                case 2:
                    arbol.visualizarRecorridos();
                    break;
                case 3:
                    arbol.visualizarConDireccion();
                    break;
                case 4:
                    arbol.visualizarSinDireccion();
                    break;
            }
        } while (opc != 5);
    }

    public static void initialize(ArbolBinario arbol){
        Employee rootEmployee = new Employee("Primero", 123, "Primero");
        Nodo rootNode = new Nodo(rootEmployee);
        arbol.setRaiz(rootNode);
        Employee emp1 = new Employee("Mario", 233306, "Segundo");
        Employee emp2 = new Employee("Capiña", 233500, "");
        Employee emp3 = new Employee("Cerezaso", 233503, "Cuarto");
        arbol.insertarNodo(arbol.getRaiz(), emp1);
        arbol.insertarNodo(arbol.getRaiz(), emp2);
        arbol.insertarNodo(arbol.getRaiz(), emp3);
    }
}
