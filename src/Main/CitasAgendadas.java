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
 */public class CitasAgendadas extends CitaMedica {

    private int numeroCitasAgendadas;
    private ArrayList<CitaMedica> citasAgendadas;

    public int getNumeroCitasAgendadas() {
        return numeroCitasAgendadas;
    }

    public void setNumeroCitasAgendadas(int numeroCitasAgendadas) {
        this.numeroCitasAgendadas = numeroCitasAgendadas;
    }

    public ArrayList<CitaMedica> getCitasAgendadas() {
        return citasAgendadas;
    }

    public void setCitasAgendadas(ArrayList<CitaMedica> citasAgendadas) {
        this.citasAgendadas = citasAgendadas;
    }

    public CitasAgendadas(String numeroDeCedula, String especialidad, String fechaEmision, String nombreMedico, String fechaCita, String codigoCita, boolean disponibilidad) {
        super(numeroDeCedula, especialidad, fechaEmision, nombreMedico, fechaCita, codigoCita, false);
    }

    public CitasAgendadas() {
        citasAgendadas = new ArrayList<CitaMedica>();
        numeroCitasAgendadas = citasAgendadas.size();
    }
    
   
    

    

    public void actualizarCitasAgendadas( ArrayList<CitaMedica> citasMedicas, String cedula) {
        // Refactor 4
        for (int i = 0; i < citasMedicas.size(); i++) {
            // Reemplazando las partes de la expresión if en variables separadas
            final boolean citaNoDisponible = !citasMedicas.get(i).isDisponibilidad(); 
            final boolean cedulaCoincide = cedula.equals(citasMedicas.get(i).getNumeroDeCedula());
            // Expresion simplificada
            if (citaNoDisponible && cedulaCoincide) {
                this.citasAgendadas.add(citasMedicas.get(i));
            }
        }

    }

    public ArrayList<CitaMedica> visualizarCitasAgendadas(ArrayList<CitaMedica> citasMedicas, String cedula) {
        actualizarCitasAgendadas(citasMedicas, cedula);
        imprimirListaCitasAgendadas();
        return citasAgendadas;
    }
    
    public void imprimirListaCitasAgendadas() {
    //Extract method - Refactoring composing methods 5
        for (int j = 0; j < this.citasAgendadas.size(); j++) {
            
             CitaMedica cm = citasAgendadas.get(j);
            System.out.print("\n" + (j) +".- ");
            System.out.println("Nombre de cedula del solicitante: " + cm.getNumeroDeCedula());
            System.out.println("Fecha de emision del documento:" + cm.getFechaEmision());
            System.out.println("Fecha de la cita:" + cm.getFechaCita());
        }
        
    }
}