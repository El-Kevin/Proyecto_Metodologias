/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class CitasDisponibles extends CitaMedica{
    private int numeroCitasDisponibles;
    private ArrayList<CitaMedica> citasDisponibles;

    public CitasDisponibles(String numeroDeCedula , String especialidad, String fechaEmision, String nombreMedico, String fechaCita, String codigoCita) {
        super(numeroDeCedula, especialidad, fechaEmision, nombreMedico, fechaCita, codigoCita, true);
    }
    
    
    public int calcularDiasFaltantes() {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaF = super.getFechaCita();
        final LocalDate fechaDestino = LocalDate.parse(fechaF, formatter);
        final LocalDate fechaOrigen = LocalDate.now();
        final long res = ChronoUnit.DAYS.between(fechaOrigen, fechaDestino);
        
        int dias = (int) res;
        return dias;
        
    }
    
    public void mostrarCitasDisponibles(){
         for(int i = 0; i<citasDisponibles.size(); i++){
            System.out.println("\n" + citasDisponibles.get(i));
        }
        
    }
    
}
