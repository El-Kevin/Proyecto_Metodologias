/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HOME
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        CLI cli = new CLI();
        String usuario = "";
        String clave = "";
        
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------Sistema gestor de citas de hospital---------------------");
        System.out.println("----------Ingresar sus credenciales----------");
      
       while(cli.verificarPaciente(usuario, clave)==false){
        System.out.println("Usuario");
        usuario = sc.nextLine();
        System.out.println("Contraseña");
        clave = sc.nextLine();
       }
       
        if(cli.verificarPaciente(usuario, clave)){
            System.out.println("Seleccione una de las siguientes opciones:\n"
                               +"1.- Agendar Cita\n"
                               +"2.- Cancelar Cita\n"
                               +"3.- Salir\n"
                               +"Opcion:"
            );
            int opcion = sc.nextInt();
            if (opcion == 1){
            cli.agendarCita(usuario);
            }
            if (opcion == 2){
            cli.cancelarCita(usuario);
            }
        }
        System.out.println("---------------------Gracias por su atencion---------------------");
    }
}

