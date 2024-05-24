import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class ArchivosInventario {

    static LinkedList<EstudianteDiseno> listaDis = new LinkedList<>();
    static LinkedList<EstudianteIngenieria> listaIng = new LinkedList<>();
    static LinkedList<TabletaGrafica> listaTab = new LinkedList<>();
    static LinkedList<ComputadorPortatil> listaComp = new LinkedList<>();
    static JOptionPane jp = new JOptionPane();

    static int CantidadCompus = 0;
    static int CantidadTabletas = 0;
    static int CompusPrestados = 0;
    static int TabletasPrestadas = 0;

    public static void ImprimirInventarioArchivo() {
        FileWriter archivo = null;
        PrintWriter impresor = null;
        try {
            archivo = new FileWriter("Inventario.txt");
            impresor = new PrintWriter(archivo);
            impresor.println("Computadores totales: " + CantidadCompus);
            impresor.println("Comutadores prestados: " + CantidadTabletas);
            impresor.println("Computadores disponibles: " + (CantidadCompus - CompusPrestados));
            impresor.println("\nTabletas totales: " + CantidadCompus);
            impresor.println("Tabletas prestadas: " + CantidadCompus);
            impresor.println("Tabletas disponibles: " + (CantidadTabletas - TabletasPrestadas));
            jp.showMessageDialog(null, "El archivo se ha exportado correctamente en Inventario.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void ImprimirInventario() {
        String Inventario = "Computadores totales: " + CantidadCompus + "\n" +
                "Tabletas totales: " + CantidadTabletas + "\n" +
                "Computadores prestados: " + CompusPrestados + "\n" +
                "Tabletas prestadas: " + TabletasPrestadas + "\n" +
                "Computadores disponibles: " + (CantidadCompus - CompusPrestados)
                + "\n" +
                "Tabletas disponibles: " + (CantidadTabletas - TabletasPrestadas);
        jp.showMessageDialog(null, Inventario);
    }

    public static void ExportarArchivo() {
        FileWriter archivo = null;
        PrintWriter impresor = null;
        try {
            archivo = new FileWriter("EstudiantesExportados.txt");
            impresor = new PrintWriter(archivo);
            for (EstudianteIngenieria estudianteIngenieria : EstudianteIngenieria.lista) {
                impresor.println("Estudiante de Ingeniería: ");
                impresor.println("Cédula: " + estudianteIngenieria.getCedula());
                impresor.println("Nombre: " + estudianteIngenieria.getNombre());
                impresor.println("Apellido: " + estudianteIngenieria.getApellido());
                impresor.println("Teléfono: " + estudianteIngenieria.getTelefono());
                impresor.println("Número Semestre: " + estudianteIngenieria.getNumeroSemestre());
                impresor.println("Promedio Acumulado: " + estudianteIngenieria.getPromedioAcumulado());
                impresor.println("Serial: " + estudianteIngenieria.getSerial());
                impresor.println("------------");
                if (estudianteIngenieria.getSerial() != "0") {
                    for (ComputadorPortatil computadorPortatil : ComputadorPortatil.listaCompu) {
                        if (computadorPortatil.getSerial().equals(estudianteIngenieria.getSerial())) {
                            impresor.println("Computador Portátil: ");
                            impresor.println("Serial: " + computadorPortatil.getSerial());
                            impresor.println("Marca: " + computadorPortatil.getMarca());
                            impresor.println("Tamaño: " + computadorPortatil.getTamaño());
                            impresor.println("Precio: " + computadorPortatil.getPrecio());
                            impresor.println("Sistema Operativo: " + computadorPortatil.getSistemaOperativo());
                            impresor.println("Procesador: " + computadorPortatil.getProcesador());
                            impresor.println("------------");
                        }
                    }
                }
            }
            for (EstudianteDiseno estudianteDiseno : EstudianteDiseno.lista) {
                impresor.println("Estudiante de Diseño: ");
                impresor.println("Cédula: " + estudianteDiseno.getCedula());
                impresor.println("Nombre: " + estudianteDiseno.getNombre());
                impresor.println("Apellido: " + estudianteDiseno.getApellido());
                impresor.println("Teléfono: " + estudianteDiseno.getTelefono());
                impresor.println("Modalidad Estudio: " + estudianteDiseno.getModalidadEstudio());
                impresor.println("Cantidad Asignaturas: " + estudianteDiseno.getCantAsignaturas());
                impresor.println("Serial: " + estudianteDiseno.getSerial());
                impresor.println("------------");
                if (estudianteDiseno.getSerial() != "0") {
                    for (TabletaGrafica tabletaGrafica : TabletaGrafica.listaTablet) {
                        if (tabletaGrafica.getSerial().equals(estudianteDiseno.getSerial())) {
                            impresor.println("Tableta Gráfica: ");
                            impresor.println("Serial: " + tabletaGrafica.getSerial());
                            impresor.println("Marca: " + tabletaGrafica.getMarca());
                            impresor.println("Tamaño: " + tabletaGrafica.getTamaño());
                            impresor.println("Precio: " + tabletaGrafica.getPrecio());
                            impresor.println("Almacenamiento: " + tabletaGrafica.getAlmacenamiento());
                            impresor.println("Peso: " + tabletaGrafica.getPeso());
                        }
                    }
                }
            }

            JOptionPane.showMessageDialog(null,
                    "El archivo ha sido exportado correctamente, nombre del archivo: EstudiantesExportados.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
