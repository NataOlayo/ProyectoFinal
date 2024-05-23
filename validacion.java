import javax.swing.JOptionPane;

public class validacion {
    static JOptionPane jp = new JOptionPane();

    public static boolean NoContieneCaracteresEspeciales(String cadena) {
        for (char c : cadena.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean NoContieneCaracteresEspeciales_Digitos(String cadena) {
        for (char c : cadena.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean NoContieneCaracteresEspeciales_Letras(String cadena) {
        for (char c : cadena.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static int ValidarNumeroSemestre() {
        int semestre = 0;
        do {
            semestre = Integer.parseInt(jp.showInputDialog("Ingrese el semestre que está cursando:\n"));
            if (semestre >= 11) {
                jp.showMessageDialog(null, "Semestre no válido, por favor intente de nuevo.");
            }
        } while (semestre >= 11);
        return semestre;
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
                default:
                    jp.showMessageDialog(null,
                            "Almacenamiento no exitente, por favor intente de nuevo.");
                    break;
            }
        } while (modalidadEstudio == 0);
        return "";
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
            if (estudianteIngenieria.getSerial().equals(estudiante.getSerial())
                    && (estudianteIngenieria.getSerial() != "0")) {
                jp.showMessageDialog(null, "Serial ya registrado");
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

        if (!NoContieneCaracteresEspeciales(estudiante.getSerial())) {
            jp.showMessageDialog(null, "El serial solo debe contener dígitos");
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
            if (estudianteDiseno.getSerial().equals(estudiante.getSerial())
                    && (estudianteDiseno.getSerial() != "0")) {
                jp.showMessageDialog(null, "Serial ya registrado");
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

        if (!NoContieneCaracteresEspeciales(estudiante.getSerial())) {
            jp.showMessageDialog(null, "El serial solo debe contener dígitos");
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
                    && (computadorPortatil.getSerial() != "0")) {
                jp.showMessageDialog(null, "Serial ya registrado");
                valido = false;
            }
        }

        if (!NoContieneCaracteresEspeciales_Digitos(computador.getMarca())) {
            jp.showMessageDialog(null, "La marca solo debe contener letras");
            valido = false;
        }

        if (!NoContieneCaracteresEspeciales(computador.getSistemaOperativo())) {
            jp.showMessageDialog(null, "El sistema operativo no debe contener caracteres especiales");
            valido = false;
        }

        if (!NoContieneCaracteresEspeciales(computador.getProcesador())) {
            jp.showMessageDialog(null, "El procesador no debe contener caracteres especiales");
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
                    && (tabletaGrafica.getSerial() != "0")) {
                jp.showMessageDialog(null, "Serial ya registrado");
                valido = false;
            }
        }

        if (!NoContieneCaracteresEspeciales_Digitos(tableta.getMarca())) {
            jp.showMessageDialog(null, "La marca solo debe contener letras");
            valido = false;
        }

        if (!NoContieneCaracteresEspeciales(tableta.getAlmacenamiento())) {
            jp.showMessageDialog(null, "El almacenamiento no debe contener caracteres especiales");
            valido = false;
        }

        return valido;
    }
}
