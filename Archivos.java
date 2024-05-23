import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Archivos {

    static LinkedList<EstudianteDiseno> listaDis = new LinkedList<>();
    static LinkedList<EstudianteIngenieria> listaIng = new LinkedList<>();
    static LinkedList<TabletaGrafica> listaTab = new LinkedList<>();
    static LinkedList<ComputadorPortatil> listaComp = new LinkedList<>();
    static JOptionPane jp = new JOptionPane();

    public static void LeerArchivo() {
        String nombreArchivo = jp.showInputDialog("Ingrese el nombre del archivo: ");
        try {
            File file = new File(nombreArchivo);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                if (line.equals("Estudiante de Ingenieria")) {
                    String cedula = bufferedReader.readLine().split(": ")[1].trim();
                    String nombre = bufferedReader.readLine().split(": ")[1].trim();
                    String apellido = bufferedReader.readLine().split(": ")[1].trim();
                    String telefono = bufferedReader.readLine().split(": ")[1].trim();
                    int semestre = Integer.parseInt(bufferedReader.readLine().split(": ")[1].trim());
                    float promedio = Float.parseFloat(bufferedReader.readLine().split(": ")[1].trim());
                    String serial = bufferedReader.readLine().split(": ")[1].trim();
                    EstudianteIngenieria estudianteIngenieria = new EstudianteIngenieria(cedula, nombre, apellido,
                            telefono, semestre, promedio, serial);
                    listaIng.add(estudianteIngenieria);

                }
                if (line.equals("Estudiante de Diseño")) {
                    String cedula = bufferedReader.readLine().split(": ")[1].trim();
                    String nombre = bufferedReader.readLine().split(": ")[1].trim();
                    String apellido = bufferedReader.readLine().split(": ")[1].trim();
                    String telefono = bufferedReader.readLine().split(": ")[1].trim();
                    String modalidadEstudio = bufferedReader.readLine().split(": ")[1].trim();
                    int cantAsignaturas = Integer.parseInt(bufferedReader.readLine().split(": ")[1].trim());
                    String serial = bufferedReader.readLine().split(": ")[1].trim();
                    EstudianteDiseno estudianteDiseno = new EstudianteDiseno(cedula, nombre, apellido, telefono,
                            modalidadEstudio, cantAsignaturas, serial);
                    listaDis.add(estudianteDiseno);
                }
                if (line.equals("Computador Portatil")) {
                    String serial = bufferedReader.readLine().split(": ")[1].trim();
                    String marca = bufferedReader.readLine().split(": ")[1].trim();
                    float tamaño = Float.parseFloat(bufferedReader.readLine().split(": ")[1].trim());
                    float precio = Float.parseFloat(bufferedReader.readLine().split(": ")[1].trim());
                    String sistemaOperativo = bufferedReader.readLine().split(": ")[1].trim();
                    String procesador = bufferedReader.readLine().split(": ")[1].trim();
                    ComputadorPortatil computadorPortatil = new ComputadorPortatil(serial, marca, tamaño, precio,
                            sistemaOperativo, procesador);
                    listaComp.add(computadorPortatil);
                }
                if (line.equals("Tableta Grafica")) {
                    String serial = bufferedReader.readLine().split(": ")[1].trim();
                    String marca = bufferedReader.readLine().split(": ")[1].trim();
                    float tamaño = Float.parseFloat(bufferedReader.readLine().split(": ")[1].trim());
                    float precio = Float.parseFloat(bufferedReader.readLine().split(": ")[1].trim());
                    String almacenamiento = bufferedReader.readLine().split(": ")[1].trim();
                    float peso = Float.parseFloat(bufferedReader.readLine().split(": ")[1].trim());
                    TabletaGrafica tabletaGrafica = new TabletaGrafica(serial, marca, tamaño, precio, almacenamiento,
                            peso);
                    listaTab.add(tabletaGrafica);
                }
            }
            EstudianteIngenieria.recibirLista(listaIng);
            EstudianteDiseno.recibirLista(listaDis);
            ComputadorPortatil.recibirLista(listaComp);
            TabletaGrafica.recibirLista(listaTab);

        } catch (

        IOException e) {
            jp.showMessageDialog(null, "Archivo no encontrado, " + e.getMessage());
            LeerArchivo();
        }
    }
}
