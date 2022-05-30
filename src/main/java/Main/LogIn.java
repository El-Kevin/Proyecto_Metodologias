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
    private String directorioUsuarios = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.json";
                                                                        /*/src/main/java/resources/data.json*/
    private String directorioCitas = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\citas_data.json";


    private ManejadorCitas manejadorCita = new ManejadorCitas(directorioCitas);
    private ManejadorUsuarios manejadorUsuarios = new ManejadorUsuarios(directorioUsuarios);

    //this.manejadorUsuarios.comprobarRegistro(usuario, password)

    public boolean comprobarRegistro(String usuario, String password) throws FileNotFoundException {
        estadoCampos estado =  verificarCamposEnArchivos(usuario, password);
        if (estado == estadoCampos.registrado) {
                return this.manejadorUsuarios.comprobarRegistro(usuario, password);

        }
        else {
            System.out.println(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.json");
            System.out.println("El paciente no se encuentra registrado");
        }
        //refactor 1 extract varible

        return false;
    }

    public String recuperarContrasenia(String usuario) {
        //refactor 2 inline method
        String contraseniaPorDefecto = "Uv-" + usuario;
        return contraseniaPorDefecto;
    }

    public estadoCampos verificarCamposEnArchivos(String usuario, String password) throws FileNotFoundException {
        System.out.println("In method verificarCamposEnArchivos");
        ArrayList<Paciente> lista = manejadorUsuarios.leerArchivoUsuarios();
        System.out.println("lista.length = " + lista.size());
            for (Paciente p : lista) {
                System.out.println("In method for loop");
                if (p.getNumeroCedula().equals(usuario)) {
                    System.out.println("In method conditional");
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

        Matcher mather = pattern.matcher(email);

        if (mather.find() == true) {
            return true;
        } else {
            return false;
        }

    }

    // 6
    public boolean enviarMensajeConfirmacion(Paciente paciente) {
        //Refactor 4
        int min_val = 10;
        int max_val = 1200;
        double randomTime = Math.random() * ( max_val - min_val );
        int randomTimeAsInt = (int) randomTime;
        try {
            Thread.sleep(randomTimeAsInt);
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
