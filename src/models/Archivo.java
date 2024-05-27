package models;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Archivo {

    public void escribirInformacion(ArbolBinario arbol, String nombreArchivo) {
        try (FileWriter fichero = new FileWriter(nombreArchivo)){
            PrintWriter pw = new PrintWriter(fichero);
            escribirConDireccion(arbol.getRaiz(), pw);
            escribirSinDireccion(arbol.getRaiz(), pw);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void escribirConDireccion(Nodo nodo, PrintWriter pw) {
        if (nodo != null) {
            if (!nodo.getEmployee().getDirection().isEmpty()) {
                pw.println(nodo.getEmployee());
            }
            escribirConDireccion(nodo.getIzquierdo(), pw);
            escribirConDireccion(nodo.getDerecho(), pw);
        }
    }

    private void escribirSinDireccion(Nodo nodo, PrintWriter pw) {
        if (nodo != null) {
            if (nodo.getEmployee().getDirection().isEmpty()) {
                pw.println(nodo.getEmployee());
            }
            escribirSinDireccion(nodo.getIzquierdo(), pw);
            escribirSinDireccion(nodo.getDerecho(), pw);
        }
    }
}
