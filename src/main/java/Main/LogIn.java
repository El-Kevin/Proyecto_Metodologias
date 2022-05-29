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

    public metodosConfirmacion[] metodosConfirmacionUtilizados(Paciente paciente ) {
        metodosConfirmacion[] mc = new metodosConfirmacion[2];
        mc[0] = metodosConfirmacion.whatsapp;
        mc[1] = metodosConfirmacion.sms;
    //validar que la direccion de email sea correcta
     return mc;
    }
    public String obtenerPasswordActual(Paciente p){

        return "2020";
    }
}
