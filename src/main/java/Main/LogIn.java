package Main;

import java.util.ArrayList;

enum estadoCampos{
    registrado,
    noRegistrado,
}
enum metodosConfirmacion{
    sms,
    correoElectronico,
    whatsapp,
    llamada,
}
public class LogIn {

    //this.manejadorUsuarios.comprobarRegistro(usuario, password)

    public boolean comprobarRegistro (String usuario, String password){
        return false;
    }

    public String recuperarContrasenia(String usuario){
        return "";
    }
    public estadoCampos verificarCamposEnArchivos(String usuario, String password){
        return null;
    }

    public boolean validarCorreoElectronico(Paciente paciente ) {

     return false;
    }
    public String obtenerPasswordActual(Paciente p){

        return "2020";
    }
}
