import java.util.LinkedList;

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
                    menuEstudiantes();
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
                    PedirDatos(num);
                    break;
                case 2:
                    PedirDatos(num);
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

    public void PedirDatos(int n) {
        int num = 0;
        do {
            String menu = "\n1. Añadir estudiante"
                    + "\n2. Pasar al siguiente menú"
                    + "\n\nDigite la opción deseada:";
            num = Integer.parseInt(jp.showInputDialog(menu));
            switch (num) {
                case 1:
                    if (n == 1) {
                        EstudianteIngenieria.DatosIng();

                    } else {
                        EstudianteDiseno.DatosDis();
                    }
                    break;
                case 2:
                    if (n == 1) {
                        menuEstudiantesIngenieria();
                    } else {
                        menuEstudiantesDiseno();
                    }
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
                    ComputadorPortatil.PrestarEquipo(EstudianteIngenieria.getLista());
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
                    menuEstudiantes();
                    break;
                default:
                    jp.showMessageDialog(null, "Seleccionaste una opción incorrecta, por favor intenta de nuevo.");
                    break;
            }
        } while (num != 5);
    }

}