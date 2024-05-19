import java.util.LinkedList;

public class ComputadorPortatil {

    String serial;
    String marca;
    float tamaño;
    float precio;
    String sistemaOperativo;
    String procesador;

    public ComputadorPortatil(String serial, String marca, float tamaño, float precio, String sistemaOperativo,
            String procesador) {
        this.serial = serial;
        this.marca = marca;
        this.tamaño = tamaño;
        this.precio = precio;
        this.sistemaOperativo = sistemaOperativo;
        this.procesador = procesador;
    }

    public static LinkedList<EstudianteIngenieria> PrestarEquipo(LinkedList<EstudianteIngenieria> lista) {

        for (EstudianteIngenieria estudianteIngenieria : lista) {

        }
        return lista;
    }

    public static void ModificarPrestamo() {

    }

    public static void BuscarEquipo() {

    }

}
