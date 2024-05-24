import java.util.LinkedList;

import javax.sound.sampled.FloatControl;
import javax.swing.JOptionPane;

public class ComputadorPortatil {

    String serial;
    String marca;
    float tamaño;
    float precio;
    String sistemaOperativo;
    String procesador;
    static JOptionPane jp = new JOptionPane();
    static LinkedList<ComputadorPortatil> listaCompu = new LinkedList<>();

    public ComputadorPortatil(String serial, String marca, float tamaño, float precio, String sistemaOperativo,
            String procesador) {
        this.serial = serial;
        this.marca = marca;
        this.tamaño = tamaño;
        this.precio = precio;
        this.sistemaOperativo = sistemaOperativo;
        this.procesador = procesador;
    }

    public static void PrestarEquipo(LinkedList<EstudianteIngenieria> lista) {
        String sistemOpera = "", procesador = "";
        String serial = jp.showInputDialog("Ingrese el serial del equipo:\n");
        String marca = jp.showInputDialog("Ingrese la marca:\n");
        Float tamaño = validacion.ValidarTamaño();
        Float precio = validacion.ValidarPrecio();
        String opciones = "Digite el número de la opción que corresponda al sistema operativo del computador:"
                + "\n1. Windows 7"
                + "\n2. Windows 10"
                + "\n3.Windows 11";
        int sistemaOperativo = 1;
        do {
            sistemaOperativo = Integer.parseInt(jp.showInputDialog(opciones));
            if (sistemaOperativo == 1) {
                sistemOpera = "Windows 7";
            } else if (sistemaOperativo == 2) {
                sistemOpera = "Windows 10";
            } else if (sistemaOperativo == 3) {
                sistemOpera = "Windows 11";
            } else {
                jp.showMessageDialog(null, "Sistema operativo no exitente, por favor intente de nuevo.");
                sistemaOperativo = 0;
            }
        } while (sistemaOperativo == 0);
        opciones = "Digite el número de la opción que corresponda al procesador del computador:"
                + "\n1. AMD Ryzen"
                + "\n2. Intel® Core™ i5";
        int Procesador = 1;
        do {
            Procesador = Integer.parseInt(jp.showInputDialog(opciones));
            if (Procesador == 1) {
                procesador = "1. AMD Ryzen";
            } else if (Procesador == 2) {
                procesador = "Intel® Core™ i5";
            } else {
                jp.showMessageDialog(null, "Procesador no exitente, por favor intente de nuevo.");
                Procesador = 0;
            }
        } while (Procesador == 0);
        ComputadorPortatil compu = new ComputadorPortatil(serial, marca, tamaño,
                precio, sistemOpera, procesador);
        if (validacion.ValidarDatosComputadorPortatil(compu)) {
            listaCompu.add(compu);
            ArchivosInventario.CompusPrestados++;
            int cent = 1, cent2 = 0;
            do {
                String cedula = jp.showInputDialog("Ingrese la cédula del estudiante que va a realizar el prestamo:\n");
                for (EstudianteIngenieria estudianteIngenieria : lista) {
                    if (estudianteIngenieria.getCedula().equals(cedula)
                            && estudianteIngenieria.getSerial() == null) {
                        estudianteIngenieria.setSerial(serial);
                        jp.showMessageDialog(null, "¡Prestamo exitoso!");
                        cent = 1;
                        cent2 = cent;
                        break;
                    }
                }
                if (cent2 == 0) {
                    jp.showMessageDialog(null,
                            "Estudiante no existente o ya cuenta con un prestamo, por favor intente de nuevo.");
                    cent = 0;
                }
            } while (cent == 0);
        }
    }

    public static void ModificarPrestamo(LinkedList<EstudianteIngenieria> lista, int n) {
        int opcion = 0;
        do {
            String buscar = jp.showInputDialog(
                    "Ingrese la cédula del estudiante o serial de equipo que tiene prestado el computador al cual se le hara la modificación:");
            for (EstudianteIngenieria estudianteIngenieria : lista) {
                if (estudianteIngenieria.getCedula().equals(buscar)
                        || estudianteIngenieria.getSerial().equals(buscar)) {
                    do {
                        MostrarCompu(lista, buscar);
                        String menu = "Digite el número de la opción a elegir(el serial no puede ser modificado): "
                                + "\n1. Modificar marca"
                                + "\n2. Modificar tamaño"
                                + "\n3. Modificar precio"
                                + "\n4. Modificar sistema operativo"
                                + "\n5. Modificar procesador"
                                + "\n0. Volver al menú anterior";
                        opcion = Integer.parseInt(jp.showInputDialog(menu));
                        switch (opcion) {
                            case 1:
                                String marca = jp.showInputDialog("Ingrese la modificación de la marca del equipo: ");
                                if (validacion.NoContieneCaracteresEspeciales_Digitos(marca)) {
                                    for (ComputadorPortatil computadorPortatil : listaCompu) {
                                        if (estudianteIngenieria.getSerial().equals(computadorPortatil.getSerial()))
                                            computadorPortatil.setMarca(marca);
                                    }
                                    jp.showMessageDialog(null, "¡Modificación exitosa!");
                                } else {
                                    jp.showMessageDialog(null, "Solo debe contener letras");
                                }
                                break;
                            case 2:
                                String tamaño = jp
                                        .showInputDialog("Ingrese la modificación del tamaño del equipo(pulgadas): ");
                                if (validacion.NoContieneCaracteresEspeciales_Letras(tamaño)) {
                                    for (ComputadorPortatil computadorPortatil : listaCompu) {
                                        if (estudianteIngenieria.getSerial().equals(computadorPortatil.getSerial()))
                                            computadorPortatil.setTamaño(Float.parseFloat(tamaño));

                                    }
                                    jp.showMessageDialog(null, "¡Modificación exitosa!");
                                } else {
                                    jp.showMessageDialog(null, "Solo debe contener números");
                                }
                                break;

                            case 3:
                                String precio = jp
                                        .showInputDialog("Ingrese la modificación del precio del equipo($):\n");
                                if (validacion.NoContieneCaracteresEspeciales_Letras(precio)) {
                                    for (ComputadorPortatil computadorPortatil : listaCompu) {
                                        if (estudianteIngenieria.getSerial().equals(computadorPortatil.getSerial()))
                                            computadorPortatil.setPrecio(Float.parseFloat(precio));
                                    }
                                    jp.showMessageDialog(null, "¡Modificación exitosa!");
                                } else {
                                    jp.showMessageDialog(null, "Solo debe contener números");
                                }
                                break;
                            case 4:
                                String sistemOpera = "";
                                String opciones = "Digite el número de la opción que corresponda a la modificación del sistema operativo del computador:"
                                        + "\n1. Windows 7"
                                        + "\n2. Windows 10"
                                        + "\n3. Windows 11";
                                int sistemaOperativo = 1;
                                do {
                                    sistemaOperativo = Integer.parseInt(jp.showInputDialog(opciones));
                                    if (sistemaOperativo == 1) {
                                        sistemOpera = "Windows 7";
                                    } else if (sistemaOperativo == 2) {
                                        sistemOpera = "Windows 10";
                                    } else if (sistemaOperativo == 3) {
                                        sistemOpera = "Windows 11";
                                    } else {
                                        jp.showMessageDialog(null,
                                                "Sistema operativo no exitente, por favor intente de nuevo.");
                                        sistemaOperativo = 0;
                                    }
                                } while (sistemaOperativo == 0);
                                for (ComputadorPortatil computadorPortatil : listaCompu) {
                                    if (estudianteIngenieria.getSerial().equals(computadorPortatil.getSerial()))
                                        computadorPortatil.setSistemaOperativo(sistemOpera);
                                }
                                jp.showMessageDialog(null, "¡Modificación exitosa!");
                                break;
                            case 5:
                                opciones = "Digite el número de la opción que corresponda a la modificación del procesador del computador:"
                                        + "\n1. AMD Ryzen"
                                        + "\n2. Intel® Core™ i5";
                                String procesador = "";
                                int Procesador = 1;
                                do {
                                    Procesador = Integer.parseInt(jp.showInputDialog(opciones));
                                    if (Procesador == 1) {
                                        procesador = "AMD Ryzen";
                                    } else if (Procesador == 2) {
                                        procesador = "Intel® Core™ i5";
                                    } else {
                                        jp.showMessageDialog(null,
                                                "Procesador no exitente, por favor intente de nuevo.");
                                        Procesador = 0;
                                    }
                                } while (Procesador == 0);
                                for (ComputadorPortatil computadorPortatil : listaCompu) {
                                    if (estudianteIngenieria.getSerial().equals(computadorPortatil.getSerial()))
                                        computadorPortatil.setProcesador(procesador);
                                }
                                jp.showMessageDialog(null, "¡Modificación exitosa!");
                                break;
                            case 0:
                                jp.showMessageDialog(null, "Volviendo al menú anterior...");
                                menu men = new menu();
                                men.menuEstudiantesIngenieria(n);
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

    public static void DevolucionEquipo(LinkedList<EstudianteIngenieria> lista) {
        int cent = 0;
        do {
            String buscar = jp
                    .showInputDialog("Ingrese la cédula del estudiante o serial del equipo que va a devolver: ");
            for (EstudianteIngenieria estudianteIngenieria : lista) {
                if (estudianteIngenieria.getCedula().equals(buscar)
                        || estudianteIngenieria.getSerial().equals(buscar)) {
                    for (ComputadorPortatil computadorPortatil : listaCompu) {
                        if (computadorPortatil.getSerial().equals(estudianteIngenieria.getSerial())) {
                            listaCompu.remove(computadorPortatil);
                            ArchivosInventario.CompusPrestados--;
                            cent = 1;
                            break;
                        }
                    }
                    estudianteIngenieria.setSerial(null);
                    break;
                }
            }
            if (cent == 0) {
                jp.showMessageDialog(null, "Busqueda no encontrada, por favor intente de nuevo.");
            }
        } while (cent == 0);
    }

    public static void BuscarEquipo(LinkedList<EstudianteIngenieria> lista) {
        int cent = 0;
        StringBuilder mensaje = new StringBuilder();
        do {
            String buscar = jp.showInputDialog("Ingrese la cédula del estudiante o serial del equipo a buscar: ");
            for (EstudianteIngenieria estudianteIngenieria : lista) {
                if (estudianteIngenieria.getCedula().equals(buscar)
                        || estudianteIngenieria.getSerial().equals(buscar)) {
                    for (ComputadorPortatil computadorPortatil : listaCompu) {
                        if (estudianteIngenieria.getSerial().equals(computadorPortatil.getSerial())) {
                            mensaje.append("Serial: ").append(computadorPortatil.getSerial()).append("\n");
                            mensaje.append("Marca: ").append(computadorPortatil.getMarca()).append("\n");
                            mensaje.append("Tamaño: ").append(computadorPortatil.getTamaño()).append("\n");
                            mensaje.append("Precio: ").append(computadorPortatil.getPrecio()).append("\n");
                            mensaje.append("Sistema operativo: ").append(computadorPortatil.getSistemaOperativo())
                                    .append("\n");
                            mensaje.append("Procesador: ").append(computadorPortatil.getProcesador());
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

    public static void MostrarCompu(LinkedList<EstudianteIngenieria> lista, String buscar) {
        StringBuilder mensaje = new StringBuilder();
        for (EstudianteIngenieria estudianteIngenieria : lista) {
            if (estudianteIngenieria.getCedula().equals(buscar)
                    || estudianteIngenieria.getSerial().equals(buscar)) {
                for (ComputadorPortatil computadorPortatil : listaCompu) {
                    if (estudianteIngenieria.getSerial().equals(computadorPortatil.getSerial())) {
                        mensaje.append("Serial: ").append(computadorPortatil.getSerial()).append("\n");
                        mensaje.append("Marca: ").append(computadorPortatil.getMarca()).append("\n");
                        mensaje.append("Tamaño: ").append(computadorPortatil.getTamaño()).append("\n");
                        mensaje.append("Precio: ").append(computadorPortatil.getPrecio()).append("\n");
                        mensaje.append("Sistema operativo: ").append(computadorPortatil.getSistemaOperativo())
                                .append("\n");
                        mensaje.append("Procesador: ").append(computadorPortatil.getProcesador());
                    }
                }
                break;
            }
        }
        JOptionPane.showMessageDialog(null, mensaje.toString(), "Computador portatil: ",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void recibirLista(LinkedList<ComputadorPortatil> lista) {
        listaCompu = lista;
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

    public String getSistemaOperativo() {
        return this.sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public String getProcesador() {
        return this.procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public static LinkedList<ComputadorPortatil> getListaCompu() {
        return listaCompu;
    }

}