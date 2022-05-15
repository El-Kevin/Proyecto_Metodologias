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
        ArrayList<CitaMedica> citaMedica = new ArrayList<CitaMedica>();
        File file = new File(pathCitas);
        // If the file is empty or is not exist return the dataList
        if (!file.exists() || file.length() == 0) {
            return citaMedica;
        }
        // Start to parser
        JSONTokener parser = new JSONTokener(new FileInputStream(file));
        //Initial the JSONArray
        JSONArray jsonList = new JSONArray(parser);

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
        System.out.println("La cita medica: ");
        System.out.println("Nombre de cedula del solicitante: " + cm.getNumeroDeCedula());
        System.out.println("Fecha de emision del documento: " + cm.getFechaEmision());
        System.out.println("Fecha de la cita cancelada:" + cm.getFechaCita());
        System.out.println("Se ha cancelado exitosamente.");
    }

    ;
    
    public void mostrarCitaAgendada(CitasAgendadas cm) {
        System.out.println("La cita medica: ");
        System.out.println("Nombre de cedula del solicitante: " + cm.getNumeroDeCedula());
        System.out.println("Fecha de emision del documento: " + cm.getFechaEmision());
        System.out.println("Fecha de la cita cancelada:" + cm.getFechaCita());
        System.out.println("Se ha agendado exitosamente. Restan " + cm.calcularDiasFaltantes() + "");
    }

    ;
    
    public void reservarCita() {
        //cd = getCitasDisponibles();
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el numero de la cita que desea agendar:");
        int cita = sc.nextInt();
        ArrayList<CitaMedica> cm = new ArrayList<CitaMedica>();
        //cm.add(cd.get(cita))
        //sobreescribirArchivo(cm);

    }

    ;
    
    public void eliminarCita() {
    }

    ;
    
       
public void sobreescribirArchivo(ArrayList<CitaMedica> dataList) throws IOException {
        File outputFile = new File(pathCitas);
        // Create the parent directory
        outputFile.getParentFile().mkdir();
        // Create the file into the parent directory
        outputFile.createNewFile();
        JSONArray jsonList = new JSONArray();
        ArrayList<CitaMedica> users = leerArchivoCitas();
        for (int i = 0; i < users.size(); i++) {
            System.out.println("Cita " + i);
        
    }
        for (int i = 0; i < users.size(); i++) {
            CitaMedica temp = users.get(i);
            for (CitaMedica cm : dataList) {
                if (cm.getCodigoCita().equals(temp.getCodigoCita())) {
                    users.remove(i);

                }
            }
        }
            jsonList.put(users);
        for (CitaMedica user : dataList) {

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
