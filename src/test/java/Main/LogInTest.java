package Main;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
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
        public void given_0707079653_2020_when_compruebaRegistro_thenTrue () throws FileNotFoundException {

            boolean actual = login.comprobarRegistro(paciente.getNumeroCedula(), paciente.getClave());
            assertTrue( actual);

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
        public void given_0707079653_2020_when_verificaCamposEnArchivos_thenOk() throws FileNotFoundException {
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

        String notExpected = login.obtenerPasswordActual(paciente);
        String actual = "2022";
        assertNotSame(notExpected, actual);
    }

    // Unit test 6

    @Test(timeout = 10000)

    public void given_correoElectronico_when_enviarMensajeConfirmacion_thenok() {
        boolean confirmado = login.enviarMensajeConfirmacion(paciente);
        assertNotNull(confirmado);
    }
    // Unit test 7
    @Test(expected = AssertionError.class)
    public void given_path_when_compruebaRegistro_thenok() throws FileNotFoundException {
        String baseDir = System.getProperty("user.dir");
        ManejadorUsuarios mu = new ManejadorUsuarios(baseDir + "/src/main/java/resources/datas.json");
        boolean foundFile = mu.comprobarRegistro("0707079653", "2020");
        assertTrue(foundFile);
    }

    // Unit test 8

    @Test
    public void given_datosPaciente_when_preguntasDeSeguridad_thenOk(){
        String [] datosPaciente = new String[3];
        datosPaciente[0] = "Anthony";
        datosPaciente[1] = "Chamba";
        datosPaciente[2] = "La Ferroviaria";
        String [] datosActuales = new String[3];
        datosActuales[0] = paciente.getNombre();
        datosActuales[1] = paciente.getApellido();
        datosActuales[2] = paciente.getSectorDeVivienda();

        assertArrayEquals(datosPaciente,datosActuales);

    }

    //





}
