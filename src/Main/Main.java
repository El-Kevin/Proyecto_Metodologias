/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author HOME
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Hola ANTHOOOOOOOOOOOOOOOONyyyy");

        Paciente p1 = new Paciente("0707079653", "Anthony", "Chamba", "LA FERROVIARIA", "DOLOR ESPALDA", "2020");
        Paciente p2 = new Paciente("1715487921", "Vannesa", "Cardoso", "ATUCUCHO", "DESCONOCIDO", "0501");
        Paciente p3 = new Paciente("0701422487", "Antonio", "Chamba", "EL RECREO", "MUSCULAR", "1369");
        String directorio = System.getProperty("user.dir") + "\\src\\resources\\data.json";
        
        ManejadorUsuarios mu = new ManejadorUsuarios( directorio );
        ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
        pacientes.add(p1);
        pacientes.add(p2);
        pacientes.add(p3);

        mu.sobreescribirArchivo(pacientes);


    }
}
