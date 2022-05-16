package Main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 *
 * @author lmamc
 */
public class ManejadorCitas {

    public ManejadorCitas(String pathCitas) {
        this.pathCitas = pathCitas;
    }
    private String pathCitas;

    public ArrayList<CitaMedica> leerArchivoCitas() throws FileNotFoundException {
        // ScoreData is the array where we can read the core from file
        ArrayList<CitaMedica> citaMedica = new ArrayList<>();
        File file = new File(pathCitas);
        // If the file is empty or is not exist return the dataList
        if (!file.exists() || file.length() == 0) {
            return citaMedica;
        }
        // Start to parser
        JSONTokener parser = new JSONTokener(new FileInputStream(file));
        //Initial the JSONArray
        JSONArray jsonList = new JSONArray(parser);
        System.out.println("NUMERO DE REGISTROS TOTALES: " + jsonList.length());
        for (int i = 0; i < jsonList.length(); i++) {
            JSONObject jsonObject = (JSONObject) jsonList.get(i);
            CitaMedica userData = new CitaMedica() {
            };
            userData.setEspecialidad(jsonObject.getString("Especialidad"));
            userData.setFechaEmision(jsonObject.getString("FechaEmision"));
            userData.setNombreMedico(jsonObject.getString("NombreMedico"));
            userData.setFechaCita(jsonObject.getString("FechaCita"));
            userData.setCodigoCita(jsonObject.getString("CodigoCita"));
            userData.setDisponibilidad(jsonObject.getBoolean("Disponibilidad"));
            userData.setNumeroDeCedula(jsonObject.getString("NumeroDeCedula"));
            citaMedica.add(userData);
        }
        return citaMedica;
    }

    public void mostrarCitaEliminada(CitaMedica cm) {
        System.out.println("\nLa cita medica: ");
        System.out.println("Nombre de cedula del solicitante: " + cm.getNumeroDeCedula());
        System.out.println("Fecha de emision del documento: " + cm.getFechaEmision());
        System.out.println("Fecha de la cita cancelada:" + cm.getFechaCita());
        System.out.println("Se ha cancelado exitosamente.");
    }

    ;
    
    public void mostrarCitaAgendada(CitaMedica cm) {
        System.out.println("\nLa cita medica: ");
        System.out.println("Nombre de cedula del solicitante: " + cm.getNumeroDeCedula());
        System.out.println("Fecha de emision del documento: " + cm.getFechaEmision());
        System.out.println("Fecha de la cita:" + cm.getFechaCita());
    }

    ;
    
    
    public void reservarCita(String numeroDeCedula) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<CitaMedica> citas = leerArchivoCitas();
        ArrayList<CitaMedica> citasDisponible = new ArrayList<CitaMedica>();
        
        CitasDisponibles cd = new CitasDisponibles();
        citasDisponible = cd.mostrarCitasDisponibles(citas);

        System.out.println("Ingrese el numero de la cita que desea agendar:");
        int citaSeleccionada = sc.nextInt();
        int index = citaSeleccionada;
        int i = 0;
        CitasAgendadas ca = new CitasAgendadas();
        
        for(CitaMedica cita : citas){
            
            if(citasDisponible.get(index).getCodigoCita().equals(cita.getCodigoCita())){
                citas.get(i).setDisponibilidad(false);
                mostrarCitaAgendada(citas.get(i));
            }
            i++;
        }
        sobreescribirArchivo(citas);
    }

    
    
    public void eliminarCita(String numeroDeCedula) throws FileNotFoundException, IOException {

        Scanner sc = new Scanner(System.in);
        ArrayList<CitaMedica> citas = leerArchivoCitas();
        ArrayList<CitaMedica> citasNoDisponible = new ArrayList<CitaMedica>();
        
        CitasAgendadas cd = new CitasAgendadas();
        citasNoDisponible = cd.visualizarCitasAgendadas(citas, numeroDeCedula);

        System.out.println("Ingrese el numero de la cita que desea cancelar:");
        int citaSeleccionada = sc.nextInt();
        int index = citaSeleccionada;
        int i = 0;
        for(CitaMedica cita : citas){
            
            if(citasNoDisponible.get(index).getCodigoCita().equals(cita.getCodigoCita())){
                citas.get(i).setDisponibilidad(true);
                mostrarCitaEliminada(citas.get(i));
            }
            i++;
        }
        sobreescribirArchivo(citas);

    }

    ;
       
public void sobreescribirArchivo(ArrayList<CitaMedica> dataList) throws IOException {
        File outputFile = new File(pathCitas);
        outputFile.getParentFile().mkdir();
        outputFile.createNewFile();
        JSONArray jsonList = new JSONArray();
        
        
        for (CitaMedica user : dataList){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Especialidad", user.getEspecialidad());
            jsonObject.put("FechaEmision", user.getFechaEmision());
            jsonObject.put("NombreMedico", user.getNombreMedico());
            jsonObject.put("FechaCita", user.getFechaCita());
            jsonObject.put("CodigoCita", user.getCodigoCita());
            jsonObject.put("Disponibilidad", user.isDisponibilidad());
            jsonObject.put("NumeroDeCedula", user.getNumeroDeCedula());
             jsonList.put(jsonObject);
         }
         // Create the buffer to write
         BufferedWriter bufferWriter = Files.newBufferedWriter(
                 Paths.get(outputFile.toURI()));
         
         jsonList.write(bufferWriter);
         bufferWriter.close();
    }

}
