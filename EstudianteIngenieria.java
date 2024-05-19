public class EstudianteIngenieria {

    String cedula;
    String nombre;
    String apellido;
    String telefono;
    int numeroSemestre;
    float promedioAcumulado;
    String serial;

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

}