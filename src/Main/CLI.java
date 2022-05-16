/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author HOME
 */
public class CLI {
    
    private boolean claveAutenticada;

    private CitaMedica citaMedica;
    String directorio = System.getProperty("user.dir") + "\\src\\resources\\data.json";
    String directorioCitas = System.getProperty("user.dir") + "\\src\\resources\\citas_data.json";
    ManejadorCitas manejadorCita= new ManejadorCitas(directorioCitas);
    ManejadorUsuarios manejadorUsuarios= new ManejadorUsuarios(directorio);
    public CLI() {
    }

    public CLI(boolean claveAutenticada, CitaMedica citaMedica) {
        this.claveAutenticada = claveAutenticada;
        this.citaMedica = citaMedica;
    }

    public boolean verificarPaciente(String Usuario, String password) throws FileNotFoundException{
        if(this.manejadorUsuarios.comprobarRegistro(Usuario, password)== true){
            System.out.println("Ha ingresado el sistema exitosamente");
            return true;
        }else{
            System.out.println("Error al ingresar las credenciales");
            return false;
        }
    }
    public void agendarCita(String numeroDeCedula) throws IOException{
        manejadorCita.reservarCita(numeroDeCedula);
        
    }
    public void cancelarCita(String numeroDeCedula) throws IOException{
        manejadorCita.eliminarCita(numeroDeCedula);
        
    }
}