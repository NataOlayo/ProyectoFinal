import javax.swing.JOptionPane;

public class menu {

    JOptionPane jp = new JOptionPane();

    public void ComportamientoPrograma() {

        int num = 0;
        do {
            String menu = "\n1. Ejecutar programa por consola"
                    + "\n2. Ejecutar el programa con archivos"
                    + "\n0. Finalizar el programa "
                    + "\n\nDigite la opción deseada:";
            num = Integer.parseInt(jp.showInputDialog(menu));
            switch (num) {
                case 1:
                    Datos(num);
                    break;
                case 2:
                    break;
                case 0:
                    jp.showMessageDialog(null, "Hasta pronto.");
                    break;
                default:
                    jp.showMessageDialog(null, "Seleccionaste una opción incorrecta, por favor intenta de nuevo.");
                    break;
            }
        } while (num != 0);

    }

    public void Datos(int n) {
        int num = 0;
        do {
            String menu = "\n1. Añadir estudiante"
                    + "\n2. Pasar al siguiente menú"
                    + "\n\nDigite la opción deseada:";
            num = Integer.parseInt(jp.showInputDialog(menu));
            switch (num) {
                case 1:
                    String cedula = jp.showInputDialog("Ingrese la cédula:\n");
                    String nombre = jp.showInputDialog("Ingrese su nombre:\n");
                    String apellido = jp.showInputDialog("Ingrese su apellido:\n");
                    String telefono = jp.showInputDialog("Ingrese su teléfono:\n");
                    int semestre = Integer.parseInt(jp.showInputDialog("Ingrese el semestre que está cursando:\n"));
                    float promedio = Float.parseFloat(jp.showInputDialog("Ingrese el promedio acumulado:\n"));
                    String serial = jp.showInputDialog(
                            "Ingrese el serial de su equipo. (En caso de no tener ingrese un cero(0))");

                    break;
                case 2:
                    menuEstudiantes();
                    break;
                case 0:
                    jp.showMessageDialog(null, "Hasta pronto.");
                    break;
                default:
                    jp.showMessageDialog(null, "Seleccionaste una opción incorrecta, por favor intenta de nuevo.");
                    break;
            }
        } while (num != 0);

    }

    public void menuEstudiantes() {

        int num = 0;
        do {
            String menu = "Elija el tipo de estudiante:\n"
                    + "\n1. Estudiante Ingeniera"
                    + "\n2. Estudiante Diseño"
                    + "\n3. Inventario total"
                    + "\n0. Finalizar el programa "
                    + "\n\nDigite la opción deseada:";
            num = Integer.parseInt(jp.showInputDialog(menu));
            switch (num) {
                case 1:
                    menuEstudiantesIngenieria();
                    break;
                case 2:
                    menuEstudiantesDiseno();
                    break;
                case 3:
                    break;
                case 0:
                    jp.showMessageDialog(null, "Hasta pronto.");
                    break;
                default:
                    jp.showMessageDialog(null, "Seleccionaste una opción incorrecta, por favor intenta de nuevo.");
                    break;
            }
        } while (num != 0);

    }

    public void menuEstudiantesIngenieria() {
        int num = 0;
        do {
            String menu = "1. Prestar un equipo"
                    + "\n2. Modificar préstamo de equipo. (Por serial o cédula)"
                    + "\n3. Devolución de equipo. (Por serial o cédula)"
                    + "\n4. Buscar equipo. (Por serial o cédula)"
                    + "\n5. Volver al menú principal"
                    + "\n\nDigite la opción deseada:";
            num = Integer.parseInt(jp.showInputDialog(menu));
            switch (num) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    jp.showMessageDialog(null, "Volviendo al menú principal...");
                    break;
                default:
                    jp.showMessageDialog(null, "Seleccionaste una opción incorrecta, por favor intenta de nuevo.");
                    break;
            }
        } while (num != 5);
    }

    public void menuEstudiantesDiseno() {
        int num = 0;
        do {
            String menu = "1. Prestar un equipo"
                    + "\n2. Modificar préstamo de equipo. (Por serial o cédula)"
                    + "\n3. Devolución de equipo. (Por serial o cédula)"
                    + "\n4. Buscar equipo. (Por serial o cédula)"
                    + "\n5. Volver al menú principal"
                    + "\n\nDigite la opción deseada:";
            num = Integer.parseInt(jp.showInputDialog(menu));
            switch (num) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    jp.showMessageDialog(null, "Volviendo al menú principal...");
                    break;
                default:
                    jp.showMessageDialog(null, "Seleccionaste una opción incorrecta, por favor intenta de nuevo.");
                    break;
            }
        } while (num != 5);
    }

}