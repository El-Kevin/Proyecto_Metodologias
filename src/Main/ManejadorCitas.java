/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
/**
 *
 * @author lmamc
 */
public class ManejadorCitas {
    private String pathCitas;
    
    
         public ArrayList<CitaMedica> leerArchivoUsuarios() throws FileNotFoundException{
        // ScoreData is the array where we can read the core from file
        ArrayList <CitaMedica> citaMedica = new ArrayList<CitaMedica>();
                File file = new File(pathCitas);
        // If the file is empty or is not exist return the dataList
         if(!file.exists() || file.length() == 0){
             return citaMedica;
         }
         // Start to parser
         JSONTokener parser = new JSONTokener(new FileInputStream(file));
         //Initial the JSONArray
         JSONArray jsonList = new JSONArray(parser);
         
         for (int i = 0; i < jsonList.length(); i++){
             JSONObject jsonObject = (JSONObject) jsonList.get(i);
             CitaMedica userData = new CitaMedica() {};
             userData.setEspecialidad(jsonObject.getString("Especialidad"));
             userData.setFechaEmision(jsonObject.getString("FechaEmision"));
             userData.setNombreMedico(jsonObject.getString("NombreMedico"));
             userData.setFechaCita(jsonObject.getString("FechaCita"));
             userData.setCodigoCita(jsonObject.getString("CodigoCita"));
             userData.setDisponibilidad(jsonObject.getBoolean("Disponibilidad"));
             citaMedica.add(userData);
         }
         return citaMedica;
    }
    public static  void mostrarCitaEliminada(CitaMedica cm){
        System.out.println("La cita medica: ");
        System.out.println("Nombre de cedula del solicitante: " + cm.getNumeroDeCedula());
        System.out.println("Fecha de emision del documento: "+ cm.getFechaEmision());
        System.out.println("Fecha de la cita cancelada:" + cm.getFechaCita());
        System.out.println("Se ha cancelado exitosamente.");
    };
    
    public static void mostrarCitaAgendada(CitasAgendadas cm){
        System.out.println("La cita medica: ");
        System.out.println("Nombre de cedula del solicitante: " + cm.getNumeroDeCedula());
        System.out.println("Fecha de emision del documento: "+ cm.getFechaEmision());
        System.out.println("Fecha de la cita cancelada:" + cm.getFechaCita());
        System.out.println("Se ha agendado exitosamente. Restan " +cm.calcularDiasFaltantes() + "");
    };
    
    public static void reservarCita(){
        
    };
    
    public static void eliminarCita(){};
    
    public static void sobreEscribirArchivo(){};
    
    
    
}
