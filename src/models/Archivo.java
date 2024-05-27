package models;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
public class Archivo {

    public void escribirInformacion(ArbolBinario arbol, String nombreArchivo) {
        try (FileWriter fichero = new FileWriter(nombreArchivo)){
            PrintWriter pw= new PrintWriter(fichero);
            escribirNodo(arbol.getRaiz(), pw);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void escribirNodo(Nodo nodo, PrintWriter pw) {
        if (nodo !=null) {
            pw.println(nodo.getEmployee());
            escribirNodo(nodo.getIzquierdo(), pw);
            escribirNodo(nodo.getDerecho(), pw);
        }
    }
}