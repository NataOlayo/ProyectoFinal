import java.util.LinkedList;
import javax.swing.JOptionPane;

public class TabletaGrafica {

    String serial;
    String marca;
    float tamaño;
    float precio;
    String almacenamiento;
    float peso;
    static JOptionPane jp = new JOptionPane();
    static LinkedList<TabletaGrafica> listaTablet = new LinkedList<>();

    public TabletaGrafica(String serial, String marca, float tamaño, float precio, String almacenamiento, float peso) {
        this.serial = serial;
        this.marca = marca;
        this.tamaño = tamaño;
        this.precio = precio;
        this.almacenamiento = almacenamiento;
        this.peso = peso;
    }

    public static void PrestarEquipo(LinkedList<EstudianteDiseno> lista) {
        int almace = 0;
        String almacenamiento = "";
        String serial = jp.showInputDialog("Ingrese el serial del equipo: ");
        String marca = jp.showInputDialog("Ingrese la marca:");
        float tamaño = Float.parseFloat(jp.showInputDialog("Ingrese el tamaño:"));
        float precio = Float.parseFloat(jp.showInputDialog("Ingrese el precio: "));
        String opciones = "Digite el número de la opción que corresponda al almacenamiento de la tableta:"
                + "\n1. 256 GB"
                + "\n2. 512 GB"
                + "\n3. 1TB";
        do {
            almace = Integer.parseInt(jp.showInputDialog(opciones));
            if (almace == 1) {
                almacenamiento = "256 GB";
            } else if (almace == 2) {
                almacenamiento = "512 GB";
            } else if (almace == 3) {
                almacenamiento = "1 TB";
            } else {
                jp.showMessageDialog(null, "Almacenamiento no exitente, por favor intente de nuevo.");
                almace = 0;
            }
        } while (almace == 0);
        float peso = Float.parseFloat(jp.showInputDialog("Ingrese el peso:"));
        TabletaGrafica Tableta = new TabletaGrafica(serial, marca, tamaño, precio, almacenamiento, peso);
        if (validacion.ValidarDatosTabletaGrafica(Tableta)) {
            listaTablet.add(Tableta);
            int cent = 1;
            do {
                String cedula = jp.showInputDialog("Ingrese la cédula del estudiante que va a realizar el prestamo:\n");
                for (EstudianteDiseno estudianteDiseno : lista) {
                    if (estudianteDiseno.getCedula().equals(cedula)) {
                        estudianteDiseno.setSerial(serial);
                        jp.showMessageDialog(null, "¡Prestamo exitoso!");
                        cent = 1;
                        break;
                    } else {
                        jp.showMessageDialog(null, "Estudiante no existente, por favor intente de nuevo.");
                        cent = 0;
                    }
                }
            } while (cent == 0);
        }

    }

    public static void ModificarPrestamo(LinkedList<EstudianteDiseno> lista) {
        int opcion = 0;
        do {
            String buscar = jp.showInputDialog(
                    "Ingrese la cédula del estudiante o serial de la tableta que tiene prestada al cual se le hara la modificación:");
            for (EstudianteDiseno estudianteDiseno : lista) {
                if (estudianteDiseno.getCedula().equals(buscar)
                        || estudianteDiseno.getSerial().equals(buscar)) {
                    do {
                        String menu = "Digite el número de la opción a elegir: "
                                + "\n1. Modificar serial"
                                + "\n2. Modificar marca"
                                + "\n3. Modificar tamaño"
                                + "\n4. Modificar precio"
                                + "\n5. Modificar almacenamiento"
                                + "\n6. Modificar peso"
                                + "\n0. Volver al menú anterior";
                        opcion = Integer.parseInt(jp.showInputDialog(menu));
                        switch (opcion) {
                            case 1:
                                String serial = jp
                                        .showInputDialog("Ingrese la modificación del serial de la tableta: ");
                                estudianteDiseno.setSerial(serial);
                                jp.showMessageDialog(null, "¡Modificación exitosa!");
                                break;
                            case 2:
                                String marca = jp
                                        .showInputDialog("Ingrese la modificación de la marca de la tableta: ");
                                for (TabletaGrafica tabletaGrafica : listaTablet) {
                                    if (estudianteDiseno.getSerial().equals(tabletaGrafica.getSerial()))
                                        tabletaGrafica.setMarca(marca);
                                }
                                jp.showMessageDialog(null, "¡Modificación exitosa!");
                                break;
                            case 3:
                                float tamaño = Float.parseFloat(
                                        jp.showInputDialog("Ingrese la modificación del tamaño de la tableta: "));
                                for (TabletaGrafica tabletaGrafica : listaTablet) {
                                    if (estudianteDiseno.getSerial().equals(tabletaGrafica.getSerial()))
                                        tabletaGrafica.setTamaño(tamaño);

                                }
                                jp.showMessageDialog(null, "¡Modificación exitosa!");
                                break;
                            case 4:
                                float precio = Float.parseFloat(
                                        jp.showInputDialog("Ingrese la modificación del precio de la tableta:\n"));
                                for (TabletaGrafica tabletaGrafica : listaTablet) {
                                    if (estudianteDiseno.getSerial().equals(tabletaGrafica.getSerial()))
                                        tabletaGrafica.setPrecio(precio);
                                }
                                jp.showMessageDialog(null, "¡Modificación exitosa!");
                                break;
                            case 5:
                                int almace = 0;
                                String almacenamiento = "";
                                String opciones = "Digite el número de la opción que corresponda al almacenamiento de la tableta:"
                                        + "\n1. 256 GB"
                                        + "\n2. 512 GB"
                                        + "\n3. 1TB";
                                do {
                                    almace = Integer.parseInt(jp.showInputDialog(opciones));
                                    if (almace == 1) {
                                        almacenamiento = "256 GB";
                                    } else if (almace == 2) {
                                        almacenamiento = "512 GB";
                                    } else if (almace == 3) {
                                        almacenamiento = "1 TB";
                                    } else {
                                        jp.showMessageDialog(null,
                                                "Almacenamiento no exitente, por favor intente de nuevo.");
                                        almace = 0;
                                    }
                                } while (almace == 0);
                                for (TabletaGrafica tabletaGrafica : listaTablet) {
                                    if (estudianteDiseno.getSerial().equals(tabletaGrafica.getSerial()))
                                        tabletaGrafica.setAlmacenamiento(almacenamiento);
                                }
                                jp.showMessageDialog(null, "¡Modificación exitosa!");
                                break;
                            case 6:
                                float peso = Float.parseFloat(
                                        jp.showInputDialog("Ingrese la modificación del peso de la tableta:"));
                                for (TabletaGrafica tabletaGrafica : listaTablet) {
                                    if (estudianteDiseno.getSerial().equals(tabletaGrafica.getSerial())) {
                                        tabletaGrafica.setPeso(peso);
                                    }
                                }
                                jp.showMessageDialog(null, "¡Modificación exitosa!");
                                break;
                            case 0:
                                jp.showMessageDialog(null, "Volviendo al menú anterior...");
                                menu men = new menu();
                                men.menuEstudiantesDiseno(2);
                                break;
                            default:
                                jp.showMessageDialog(null, "Opción incorrecta, por favor intente de nuevo.");
                                break;
                        }
                    } while (opcion != 0);
                } else {
                    jp.showMessageDialog(null, "Estudiante no existente, por favor intente de nuevo.");
                    opcion = 0;
                }
            }
        } while (opcion == 0);

    }

    public static void DevolucionEquipo(LinkedList<EstudianteDiseno> lista) {
        int cent = 0;
        do {
            String buscar = jp
                    .showInputDialog("Ingrese la cédula del estudiante o serial de la tableta que va a devolver: ");
            for (EstudianteDiseno estudianteDiseno : lista) {
                if (estudianteDiseno.getCedula().equals(buscar)
                        || estudianteDiseno.getSerial().equals(buscar)) {
                    for (TabletaGrafica tabletaGrafica : listaTablet) {
                        if (tabletaGrafica.getSerial().equals(estudianteDiseno.getSerial())) {
                            listaTablet.remove();
                            cent = 1;
                            break;
                        }
                    }
                    lista.remove();
                    break;
                }
            }
            if (cent == 0) {
                jp.showMessageDialog(null, "Busqueda no encontrada, por favor intente de nuevo.");
            }
        } while (cent == 0);
    }

    public static void BuscarEquipo(LinkedList<EstudianteDiseno> lista) {
        int cent = 0;
        StringBuilder mensaje = new StringBuilder();
        do {
            String buscar = jp.showInputDialog("Ingrese la cédula del estudiante o serial del equipo a buscar: ");
            for (EstudianteDiseno estudianteDiseno : lista) {
                if (estudianteDiseno.getCedula().equals(buscar)
                        || estudianteDiseno.getSerial().equals(buscar)) {
                    for (TabletaGrafica tabletaGrafica : listaTablet) {
                        if (estudianteDiseno.getSerial().equals(tabletaGrafica.getSerial())) {
                            mensaje.append("Serial: ").append(tabletaGrafica.getSerial()).append("\n");
                            mensaje.append("Marca: ").append(tabletaGrafica.getMarca()).append("\n");
                            mensaje.append("Tamaño: ").append(tabletaGrafica.getTamaño()).append("\n");
                            mensaje.append("Precio: ").append(tabletaGrafica.getPrecio()).append("\n");
                            mensaje.append("Almacenamiento: ").append(tabletaGrafica.getAlmacenamiento())
                                    .append("\n");
                            mensaje.append("Peso: ").append(tabletaGrafica.getPeso());
                        }
                    }
                    cent = 1;
                    break;
                }
            }
            if (cent == 0)
                jp.showMessageDialog(null, "Busqueda no encontrada, por favor intente de nuevo.");
        } while (cent == 0);
        JOptionPane.showMessageDialog(null, mensaje.toString(), "Computador portatil: ",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void recibirLista(LinkedList<TabletaGrafica> lista) {
        listaTablet = lista;
    }

    public String getSerial() {
        return this.serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getTamaño() {
        return this.tamaño;
    }

    public void setTamaño(float tamaño) {
        this.tamaño = tamaño;
    }

    public float getPrecio() {
        return this.precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getAlmacenamiento() {
        return this.almacenamiento;
    }

    public void setAlmacenamiento(String almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public float getPeso() {
        return this.peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public static LinkedList<TabletaGrafica> getListaTablet() {
        return listaTablet;
    }

    public void setListaTablet(LinkedList<TabletaGrafica> listaTablet) {
        this.listaTablet = listaTablet;
    }
}
