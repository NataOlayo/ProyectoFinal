import javax.swing.JOptionPane;

public class validacion {
    static JOptionPane jp = new JOptionPane();

    public static boolean NoContieneCaracteresEspeciales(String cadena) {
        if (cadena == null) {
            return false;
        }
        for (char c : cadena.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean NoContieneCaracteresEspeciales_Digitos(String cadena) {
        if (cadena == null) {
            return false;
        }
        for (char c : cadena.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean NoContieneCaracteresEspeciales_Letras(String cadena) {
        if (cadena == null) {
            return false;
        }
        for (char c : cadena.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static float ValidarTamaño() {
        String tamaño = jp.showInputDialog("Ingrese el tamaño(pulgadas): ");
        while (!NoContieneCaracteresEspeciales_Letras(tamaño)) {
            jp.showMessageDialog(null, "Solo debe contener números");
            tamaño = jp.showInputDialog("Ingrese el tamaño(pulgadas): ");
        }
        return Float.parseFloat(tamaño);
    }

    public static float ValidarPrecio() {
        String precio = jp.showInputDialog("Ingrese el precio($): ");
        while (!NoContieneCaracteresEspeciales_Letras(precio)) {
            jp.showMessageDialog(null, "Solo debe contener números");
            precio = jp.showInputDialog("Ingrese el precio($): ");
        }
        return Float.parseFloat(precio);
    }

    public static float ValidarPromedio() {
        String promedio = jp.showInputDialog("Ingrese el promedio: ");
        while (!NoContieneCaracteresEspeciales_Letras(promedio)) {
            jp.showMessageDialog(null, "Solo debe contener números");
            promedio = jp.showInputDialog("Ingrese el promedio: ");
        }
        return Float.parseFloat(promedio);
    }

    public static int ValidarAsignaturas() {
        String cantAsignaturas = jp.showInputDialog("Ingrese la cantidad de asignaturas: ");
        while (!NoContieneCaracteresEspeciales_Letras(cantAsignaturas)) {
            jp.showMessageDialog(null, "Solo debe contener números");
            cantAsignaturas = jp.showInputDialog("Ingrese la cantidad de asignaturas: ");
        }
        return Integer.parseInt(cantAsignaturas);
    }

    public static int ValidarNumeroSemestre() {
        String semestre = "";
        if (NoContieneCaracteresEspeciales_Letras(semestre)) {
            do {
                semestre = jp.showInputDialog("Ingrese el semestre que está cursando:\n");
                if (Integer.parseInt(semestre) >= 11) {
                    jp.showMessageDialog(null, "Semestre no válido, por favor intente de nuevo.");
                }
            } while (Integer.parseInt(semestre) >= 11);
        } else {
            jp.showMessageDialog(null, "Solo debe contener números");
        }
        return Integer.parseInt(semestre);
    }

    public static String ValidarModalidad() {
        String modalidad = "";
        int modalidadEstudio = 0;
        String opciones = "Digite el número de la opción que corresponda al modalidad de estudio :"
                + "\n1. Virtual"
                + "\n2. Presencial";
        do {
            modalidadEstudio = Integer.parseInt(jp.showInputDialog(opciones));
            switch (modalidadEstudio) {
                case 1:
                    modalidad = "Virtual";
                    break;
                case 2:
                    modalidad = "Presencial";
                    break;
                default:
                    jp.showMessageDialog(null,
                            "Almacenamiento no existente, por favor intente de nuevo.");
                    break;
            }
        } while (modalidadEstudio == 0);
        return modalidad;
    }

    public static boolean ValidarDatosEstudianteIngeniera(EstudianteIngenieria estudiante) {
        boolean valido = true;
        if (!NoContieneCaracteresEspeciales_Letras(estudiante.getCedula())) {
            jp.showMessageDialog(null, "La cédula solo debe contener dígitos");
            valido = false;
        }

        for (EstudianteIngenieria estudianteIngenieria : EstudianteIngenieria.getLista()) {
            if (estudianteIngenieria.getCedula().equals(estudiante.getCedula())) {
                jp.showMessageDialog(null, "Cédula ya registrada");
                valido = false;
            }
        }

        if (!NoContieneCaracteresEspeciales_Digitos(estudiante.getNombre())) {
            jp.showMessageDialog(null, "El nombre solo debe contener letras");
            valido = false;
        }

        if (!NoContieneCaracteresEspeciales_Digitos(estudiante.getApellido())) {
            jp.showMessageDialog(null, "El apellido solo debe contener letras");
            valido = false;
        }

        if (!NoContieneCaracteresEspeciales_Letras(estudiante.getTelefono())) {
            jp.showMessageDialog(null, "El teléfono solo debe contener dígitos");
            valido = false;
        }

        return valido;
    }

    public static boolean ValidarDatosEstudianteDiseño(EstudianteDiseno estudiante) {
        boolean valido = true;
        if (!NoContieneCaracteresEspeciales_Letras(estudiante.getCedula())) {
            jp.showMessageDialog(null, "La cédula solo debe contener dígitos");
            valido = false;
        }

        for (EstudianteDiseno estudianteDiseno : EstudianteDiseno.getLista()) {
            if (estudianteDiseno.getCedula().equals(estudiante.getCedula())) {
                jp.showMessageDialog(null, "Cédula ya registrada");
                valido = false;
            }
        }

        if (!NoContieneCaracteresEspeciales_Digitos(estudiante.getNombre())) {
            jp.showMessageDialog(null, "El nombre solo debe contener letras");
            valido = false;
        }

        if (!NoContieneCaracteresEspeciales_Digitos(estudiante.getApellido())) {
            jp.showMessageDialog(null, "El apellido solo debe contener letras");
            valido = false;
        }

        if (!NoContieneCaracteresEspeciales_Letras(estudiante.getTelefono())) {
            jp.showMessageDialog(null, "El teléfono solo debe contener dígitos");
            valido = false;
        }
        return valido;
    }

    public static boolean ValidarDatosComputadorPortatil(ComputadorPortatil computador) {
        boolean valido = true;
        if (!NoContieneCaracteresEspeciales(computador.getSerial())) {
            jp.showMessageDialog(null, "El serial no debe contener caracteres especiales");
            valido = false;
        }

        for (ComputadorPortatil computadorPortatil : ComputadorPortatil.getListaCompu()) {
            if (computadorPortatil.getSerial().equals(computador.getSerial())
                    && (computadorPortatil.getSerial() != null)) {
                jp.showMessageDialog(null, "Serial ya registrado");
                valido = false;
            }
        }

        if (!NoContieneCaracteresEspeciales_Digitos(computador.getMarca())) {
            jp.showMessageDialog(null, "La marca solo debe contener letras");
            valido = false;
        }

        return valido;
    }

    public static boolean ValidarDatosTabletaGrafica(TabletaGrafica tableta) {
        boolean valido = true;
        if (!NoContieneCaracteresEspeciales(tableta.getSerial())) {
            jp.showMessageDialog(null, "El serial no debe contener caracteres especiales");
            valido = false;
        }

        for (TabletaGrafica tabletaGrafica : TabletaGrafica.getListaTablet()) {
            if (tabletaGrafica.getSerial().equals(tableta.getSerial())
                    && (tabletaGrafica.getSerial() != null)) {
                jp.showMessageDialog(null, "Serial ya registrado");
                valido = false;
            }
        }

        if (!NoContieneCaracteresEspeciales_Digitos(tableta.getMarca())) {
            jp.showMessageDialog(null, "La marca solo debe contener letras");
            valido = false;
        }
        return valido;
    }
}
