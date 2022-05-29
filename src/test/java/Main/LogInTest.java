package Main;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LogInTest {
    private LogIn login = null;
    private Paciente paciente = null;
    @Before
    public void setUp(){
        this.login = new LogIn();
        this.paciente = new Paciente("0707079653", "Anthony", "Chamba",
                "La Ferroviaria", "Obstetricia", "2020");
    }
        //Unit test 1
        @Test
        public void given_0707079653_2020_when_compruebaRegistro_thenTrue () {
           //LogIn login = new LogIn();
           String usuario = "0707079653";
           String password =  "2020";
           boolean actual = login.comprobarRegistro(usuario, password);
           assertTrue(actual);

        };

        // Unit test 2
    @Test
        public void given_0707079653_when_recuperaContrasenia_then_Uv_0707079653(){
            String expected = "Uv-0707079653";
            String actual = login.recuperarContrasenia("0707079653");
            assertEquals(expected, actual);
    }


    //Unit test 3
    @Test
        public void given_0707079653_2020_when_verificaCamposEnArchivos_thenOk(){
        estadoCampos actual = login.verificarCamposEnArchivos("0707079653", "2020");
        assertNotNull(actual);
    }

    //Unit test 4
    @Test
        public void given_paciente_when_metodosValidarCorreoElectronico_thenOk(){
        boolean actual = login.validarCorreoElectronico(paciente);
        assertTrue(actual);
    }
//Pregunta de nuevo de los datos del paciente, y compararlos.

    // Unit test 5
    @Test()
    public void given_2020_2022_when_comparaPasswords_then_no(){

        String actual = login.obtenerPasswordActual(paciente);
        String notExpected = "2020";
        assertNotSame(notExpected, actual);
    }





    //Prueba de excepcion y timeout con correo electronico e ingreso al archivo




}
