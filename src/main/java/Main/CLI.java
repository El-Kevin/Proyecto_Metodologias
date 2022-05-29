/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author HOME
 */
public class CLI {

    private boolean claveAutenticada;

    private CitaMedica citaMedica;
    String directorioUsuarios = System.getProperty("user.dir") + "\\src\\resources\\data.json";
    String directorioCitas = System.getProperty("user.dir") + "\\src\\resources\\citas_data.json";
    ManejadorCitas manejadorCita = new ManejadorCitas(directorioCitas);
    ManejadorUsuarios manejadorUsuarios = new ManejadorUsuarios(directorioUsuarios);

    public CLI() {
    }

    public CLI(boolean claveAutenticada, CitaMedica citaMedica) {
        this.claveAutenticada = claveAutenticada;
        this.citaMedica = citaMedica;
    }


    //Refactor 1
    public boolean verificarPaciente(String usuario, String password) throws FileNotFoundException {
        LogIn login = new LogIn();
        return true;//login.;

    }

    ;

    public void agendarCita(String numeroDeCedula) throws IOException {

        manejadorCita.reservarCita(numeroDeCedula);

    }

    public void cancelarCita(String numeroDeCedula) throws IOException {

        manejadorCita.eliminarCita(numeroDeCedula);

    }
}