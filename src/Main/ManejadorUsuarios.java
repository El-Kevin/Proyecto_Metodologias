
package Main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
//import javax.swing.filechooser.FileSystemView;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;




/**
 *
 * @author Anthony Chamba
 */
public class ManejadorUsuarios {
    
    private String pathUsuarios;
    public ManejadorUsuarios(String pathUsuarios){
    this.pathUsuarios = pathUsuarios;};
    
    public String getPathUsuarios() {
        return this.pathUsuarios;
    };
    
    
    
public void sobreescribirArchivo(ArrayList<Paciente> dataList) throws IOException{
        File outputFile = new File(pathUsuarios);
        // Create the parent directory
        outputFile.getParentFile().mkdir();
        // Create the file into the parent directory
        outputFile.createNewFile();
        JSONArray jsonList = new JSONArray();
        ArrayList<Paciente> users = leerArchivoUsuarios();
         
         for (int i = 0; i < users.size(); i++){
             Paciente temp = users.get(i);
             for (Paciente p : dataList) {
                 if (p.getNumeroCedula().equals(temp.getNumeroCedula())){
                     users.remove(i);
                     
             }
         }}
        
        
    
         for (Paciente user : dataList){
             JSONObject jsonObject = new JSONObject();
             jsonObject.put("Nombre", user.getNombre());
             jsonObject.put("Apellido", user.getApellido());
             jsonObject.put("Cedula", user.getNumeroCedula());
             jsonObject.put("MotivoCita", user.getMotivoCita());
             jsonObject.put("Clave", user.getClave());
             jsonList.put(jsonObject);
         }
         // Create the buffer to write
         BufferedWriter bufferWriter = Files.newBufferedWriter(
         Paths.get(outputFile.toURI()));
         
         jsonList.write(bufferWriter);
         bufferWriter.close();
       
    }
    
    
     public ArrayList<Paciente> leerArchivoUsuarios() throws FileNotFoundException{
        // ScoreData is the array where we can read the core from file
        ArrayList <Paciente> pacientes = new ArrayList<Paciente>();
                File file = new File(pathUsuarios);
        // If the file is empty or is not exist return the dataList
         if(!file.exists() || file.length() == 0){
             return pacientes;
         }
         // Start to parser
         JSONTokener parser = new JSONTokener(new FileInputStream(file));
         //Initial the JSONArray
         JSONArray jsonList = new JSONArray(parser);
         
         for (int i = 0; i < jsonList.length(); i++){
             JSONObject jsonObject = (JSONObject) jsonList.get(i);
             Paciente userData = new Paciente();
             userData.setNombre(jsonObject.getString("Nombre"));
             userData.setApellido(jsonObject.getString("Apellido"));
             userData.setNumeroCedula(jsonObject.getString("Cedula"));
             userData.setMotivoCita(jsonObject.getString("MotivoCita"));
             userData.setClave(jsonObject.getString("Clave"));
             pacientes.add(userData);
         }
         return pacientes;
    }
    public void comprobarRegistro(String Usuario, String password) throws FileNotFoundException{
        ArrayList<Paciente> listaPaciente = new ArrayList<Paciente>();
        listaPaciente = leerArchivoUsuarios();
        
        for (Paciente User : listaPaciente){
            if(User.getNumeroCedula().equalsIgnoreCase(Usuario) && User.getClave().equalsIgnoreCase(password) ){  
                System.out.print("Ha ingresado con exito");
                break;
            }
        }
    }
    
} 
