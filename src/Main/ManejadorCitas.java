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
             CitaMedica userData = new CitaMedica();
             userData.setNombre(jsonObject.getString("Especialidad"));
             userData.setApellido(jsonObject.getString("FechaEmision"));
             userData.setNumeroCedula(jsonObject.getString("NombreMedico"));
             userData.setMotivoCita(jsonObject.getString("FechaCita"));
             userData.setClave(jsonObject.getString("CodigoCita"));
             userData.setClave(jsonObject.getString("Disponibilidad"));
             citaMedica.add(userData);
         }
         return citaMedica;
    }
    public static  void mostrarCitaEliminada(CitaMedica cm){
        System.out.println("La cita medica: ");
        System.out.println("Nombre");
    };
    
    public static void mostrarCitaAgendada(){};
    
    public static void reservarCita(){};
    
    public static void eliminarCita(){};
    
    public static void sobreEscribirArchivo(){};
    
    
    
}
