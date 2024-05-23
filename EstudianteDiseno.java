import java.util.LinkedList;

import javax.swing.JOptionPane;

public class EstudianteDiseno {

    String cedula;
    String nombre;
    String apellido;
    String telefono;
    String modalidadEstudio;
    int cantAsignaturas;
    String serial;

    public EstudianteDiseno(String cedula, String nombre, String apellido, String telefono, String modalidadEstudio,
            int cantAsignaturas, String serial) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.modalidadEstudio = modalidadEstudio;
        this.cantAsignaturas = cantAsignaturas;
        this.serial = serial;
    }

    static LinkedList<EstudianteDiseno> lista = new LinkedList<>();

    public static void DatosDis() {
        JOptionPane jp = new JOptionPane();
        String cedula = jp.showInputDialog("Ingrese la cédula:\n");
        String nombre = jp.showInputDialog("Ingrese su nombre:\n");
        String apellido = jp.showInputDialog("Ingrese su apellido:\n");
        String telefono = jp.showInputDialog("Ingrese su teléfono:\n");
        String modalidadEstudio = validacion.ValidarModalidad();
        int cantAsignaturas = Integer
                .parseInt(jp.showInputDialog("Ingrese la cantidad de asignaturas que está cursando:\n"));
        String serial = jp.showInputDialog("Ingrese el serial de su equipo. (En caso de no tener ingrese un cero(0)):");
        EstudianteDiseno estudiante = new EstudianteDiseno(cedula, nombre, apellido, telefono, modalidadEstudio,
                cantAsignaturas, serial);
        if (validacion.ValidarDatosEstudianteDiseño(estudiante)) {
            lista.add(estudiante);
        }
    }

    public static void recibirLista(LinkedList<EstudianteDiseno> listaa) {
        lista = listaa;
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

    public String getModalidadEstudio() {
        return this.modalidadEstudio;
    }

    public void setModalidadEstudio(String modalidadEstudio) {
        this.modalidadEstudio = modalidadEstudio;
    }

    public int getCantAsignaturas() {
        return this.cantAsignaturas;
    }

    public void setCantAsignaturas(int cantAsignaturas) {
        this.cantAsignaturas = cantAsignaturas;
    }

    public String getSerial() {
        return this.serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public static LinkedList<EstudianteDiseno> getLista() {
        return lista;
    }

}
