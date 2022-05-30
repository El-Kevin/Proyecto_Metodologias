package Main;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

enum estadoCampos {
    registrado,
    noRegistrado,
}

public class LogIn {
    private String directorioUsuarios = System.getProperty("user.dir") + "/src/main/java/resources/data.json";
                                                                        /*/src/main/java/resources/data.json*/



    private ManejadorUsuarios manejadorUsuarios = new ManejadorUsuarios(directorioUsuarios);



    public boolean comprobarRegistro(String usuario, String password) throws FileNotFoundException {
       //Refactor 1
        if (verificarCamposEnArchivos(usuario, password) == estadoCampos.registrado) {
            return this.manejadorUsuarios.comprobarRegistro(usuario, password);
        }
        else {
            System.out.println("El paciente no se encuentra registrado");
        }

        return false;
    }

    public String recuperarContrasenia(String usuario) {
        //refactor 2
        return "Uv-" + usuario;
    }

    public estadoCampos verificarCamposEnArchivos(String usuario, String password) throws FileNotFoundException {

        ArrayList<Paciente> lista = manejadorUsuarios.leerArchivoUsuarios();
            for (Paciente p : lista) {
                if (p.getNumeroCedula().equals(usuario)) {
                    return estadoCampos.registrado;
                }
            }

        return estadoCampos.noRegistrado;
    }

    public boolean validarCorreoElectronico(Paciente paciente) {
        //Refactor 3
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");


        String email = paciente.getNombre().toLowerCase() + "." + paciente.getApellido().toLowerCase() + paciente.getNumeroCedula().substring(6) + "@msp.gob.ec";
        System.out.println("Email del paciente :  " + email );
        Matcher mather = pattern.matcher(email);
    //refactor 3
        return mather.find();

    }


    public boolean enviarMensajeConfirmacion(Paciente paciente) {
        //refactor 4
        int min_val = 10;
        int max_val = 999;
        double randomTime = Math.random() * ( max_val - min_val );
        try {
            Thread.sleep((int) randomTime);
            System.out.println("Mensaje de confirmacion enviado con exito");
            return true;

        } catch (InterruptedException ie) {
            ie.printStackTrace();
            System.out.println("El mensaje de confirmacion no se pudo enviar");
        }
        return false;
    }

    // 5
    public String obtenerPasswordActual(Paciente p) {
        return p.getClave();
    }

    public String obtenerPasswordNueva() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la nueva contrasenia");
        String nueva = scanner.nextLine();
        return nueva;
    }

    public String[] preguntarDatos(Paciente p) {
        Scanner scanner = new Scanner(System.in);
        String [] datos = new String [3];
        System.out.println("Por favor, responda a las siguientes preguntas\n de acuerdo con los datos que registro en el sistema");
        System.out.println("¿Cual es su nombre?");
        datos [0] = scanner.nextLine();
        System.out.println("¿Cual es su apellido?");
        datos [1] = scanner.nextLine();
        System.out.println("¿Cual es el sector donde vive?");
        datos [2] = scanner.nextLine();
        return datos;
    }


}
