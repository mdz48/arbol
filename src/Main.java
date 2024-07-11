import models.ArbolBinario;
import models.Archivo;
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
            System.out.println("1. Agregar nodos\n2. Imprimir recorridos\n3. Ver empleados con dirección\n4. Ver empleados sin dirección\n5. Guardar en archivo\n6. Busqueda \n 7. Salir \nSeleccione la opción: ");
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
                case 5:
                    Archivo archivo = new Archivo();
                    archivo.escribirInformacion(arbol, "empleados.txt");
                    System.out.println("Información guardada en empleados.txt");
                    break;
                case 6:
                    System.out.println("Ingresa el numero de afiliación a buscar");
                    if (arbol.busqueda(arbol.getRaiz(), entrada.nextInt())){
                        System.out.println("Se encontró");
                    } else {
                        System.out.println("No existe");
                    }

            }
        } while (opc != 7);
    }

    public static void initialize(ArbolBinario arbol){
        Employee rootEmployee = new Employee("Luna", 122313, "Albania Baja");
        Nodo rootNode = new Nodo(rootEmployee);
        arbol.setRaiz(rootNode);
        Employee emp1 = new Employee("Mario", 233306, "Albania Alta");
        Employee emp2 = new Employee("Leonardo", 233500, "");
        Employee emp3 = new Employee("Juan", 233503, "Los Pájaros");
        Employee emp4 = new Employee("Pedro", 300123, "");
        arbol.insertarNodo(arbol.getRaiz(), emp1);
        arbol.insertarNodo(arbol.getRaiz(), emp2);
        arbol.insertarNodo(arbol.getRaiz(), emp3);
        arbol.insertarNodo(arbol.getRaiz(), emp4);
    }
}