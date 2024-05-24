import java.util.LinkedList;

import javax.swing.JOptionPane;

public class menu {

    JOptionPane jp = new JOptionPane();

    public void ComportamientoPrograma() {
        ArchivosInventario.CantidadCompus = Integer
                .parseInt(jp.showInputDialog("ingrese la cantidad de computadores disponibles: "));
        ArchivosInventario.CantidadTabletas = Integer
                .parseInt(jp.showInputDialog("Ingrese la cantidad de tabletas disponibles: "));
        int num = 0;
        do {
            String menu = "\n1. Ejecutar programa por consola"
                    + "\n2. Ejecutar el programa con archivos"
                    + "\n0. Finalizar el programa "
                    + "\n\nDigite la opción deseada:";
            num = Integer.parseInt(jp.showInputDialog(menu));
            switch (num) {
                case 1:
                    menuEstudiantes(num);
                    break;
                case 2:
                    ArchivosInventario.LeerArchivo();
                    menuEstudiantes(num);
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

    public void menuEstudiantes(int n) {

        int num = 0;
        do {
            String menu = "Elija una opción:\n"
                    + "\n1. Estudiante Ingeniera"
                    + "\n2. Estudiante Diseño"
                    + "\n3. Inventario total"
                    + "\n4. Exportar archivo"
                    + "\n0. Finalizar el programa "
                    + "\n\nDigite la opción deseada:";
            num = Integer.parseInt(jp.showInputDialog(menu));
            switch (num) {
                case 1:
                    if (n == 1) {
                        PedirDatos(num);
                    } else {
                        menuEstudiantesIngenieria(num);
                    }
                    break;
                case 2:
                    if (n == 1) {
                        PedirDatos(num);
                    } else {
                        menuEstudiantesDiseno(num);
                    }
                    break;
                case 3:
                    if (n == 1) {
                        ArchivosInventario.ImprimirInventario();
                    } else {
                        ArchivosInventario.ImprimirInventarioArchivo();
                    }
                    break;
                case 4:
                    ArchivosInventario.ExportarArchivo();
                    break;
                case 0:
                    jp.showMessageDialog(null, "Hasta pronto.");
                    System.exit(0);
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
                        menuEstudiantesIngenieria(n);
                    } else {
                        menuEstudiantesDiseno(n);
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

    public void menuEstudiantesIngenieria(int n) {
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
                    ComputadorPortatil.ModificarPrestamo(EstudianteIngenieria.getLista(), n);
                    break;
                case 3:
                    ComputadorPortatil.DevolucionEquipo(EstudianteIngenieria.getLista());
                    break;
                case 4:
                    ComputadorPortatil.BuscarEquipo(EstudianteIngenieria.getLista());
                    break;
                case 5:
                    jp.showMessageDialog(null, "Volviendo al menú principal...");
                    menuEstudiantes(n);
                    break;
                default:
                    jp.showMessageDialog(null, "Seleccionaste una opción incorrecta, por favor intenta de nuevo.");
                    break;
            }
        } while (num != 5);
    }

    public void menuEstudiantesDiseno(int n) {
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
                    TabletaGrafica.PrestarEquipo(EstudianteDiseno.getLista());
                    break;
                case 2:
                    TabletaGrafica.ModificarPrestamo(EstudianteDiseno.getLista());
                    break;
                case 3:
                    TabletaGrafica.DevolucionEquipo(EstudianteDiseno.getLista());
                    break;
                case 4:
                    TabletaGrafica.BuscarEquipo(EstudianteDiseno.getLista());
                    break;
                case 5:
                    jp.showMessageDialog(null, "Volviendo al menú principal...");
                    menuEstudiantes(n);
                    break;
                default:
                    jp.showMessageDialog(null, "Seleccionaste una opción incorrecta, por favor intenta de nuevo.");
                    break;
            }
        } while (num != 5);
    }

}