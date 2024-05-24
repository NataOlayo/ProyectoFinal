import java.util.LinkedList;

import javax.print.FlavorException;
import javax.swing.JOptionPane;

public class EstudianteIngenieria {

    String cedula;
    String nombre;
    String apellido;
    String telefono;
    int numeroSemestre;
    float promedioAcumulado;
    String serial;
    static JOptionPane jp = new JOptionPane();
    static LinkedList<EstudianteIngenieria> lista = new LinkedList<>();

    public EstudianteIngenieria(String cedula, String nombre, String apellido, String telefono, int numeroSemestre,
            float promedioAcumulado, String serial) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.numeroSemestre = numeroSemestre;
        this.promedioAcumulado = promedioAcumulado;
        this.serial = serial;
    }

    public static void DatosIng() {
        String cedula = jp.showInputDialog("Ingrese la cédula:\n");
        String nombre = jp.showInputDialog("Ingrese su nombre:\n");
        String apellido = jp.showInputDialog("Ingrese su apellido:\n");
        String telefono = jp.showInputDialog("Ingrese su teléfono:\n");
        int semestre = validacion.ValidarNumeroSemestre();
        float promedio = validacion.ValidarPromedio();
        EstudianteIngenieria estudiante = new EstudianteIngenieria(cedula, nombre, apellido, telefono, semestre,
                promedio, null);
        if (validacion.ValidarDatosEstudianteIngeniera(estudiante)) {
            lista.add(estudiante);
            jp.showMessageDialog(null, "¡Estudiante agregado exitosamente!");
        }
    }

    public static void recibirLista(LinkedList<EstudianteIngenieria> listaa) {
        for (EstudianteIngenieria estudianteIngenieria : listaa) {
            lista.add(estudianteIngenieria);
        }
    }

    public String getCedula() {
        return this.cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getNumeroSemestre() {
        return this.numeroSemestre;
    }

    public void setNumeroSemestre(int numeroSemestre) {
        this.numeroSemestre = numeroSemestre;
    }

    public float getPromedioAcumulado() {
        return this.promedioAcumulado;
    }

    public void setPromedioAcumulado(float promedioAcumulado) {
        this.promedioAcumulado = promedioAcumulado;
    }

    public String getSerial() {
        return this.serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public static LinkedList<EstudianteIngenieria> getLista() {
        return lista;
    }
}