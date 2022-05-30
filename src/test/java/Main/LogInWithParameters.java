package Main;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class LogInWithParameters {
    private String usuario, password;
    private boolean expected;

    @Parameterized.Parameters
    public static Iterable<Object[]> parameters(){
        List<Object[]> objects = new ArrayList<Object[]>();
        objects.add(new Object[]{"0707079653", "2020", true});
        objects.add(new Object[]{"1715487921", "0501", true});
        objects.add(new Object[]{"0701422487", "1369", true});
        return objects;
    }
    public LogInWithParameters(String usuario, String password, boolean expected){
        this.usuario = usuario;
        this.password = password;
        this.expected = expected;
    }

    @Test
    public void given_usuario_password_when_compruebaRegistro_thenTrue () throws FileNotFoundException {
       LogIn login = new LogIn();
        boolean actual = login.comprobarRegistro(usuario, password);
        assertTrue( actual);

    };



}
