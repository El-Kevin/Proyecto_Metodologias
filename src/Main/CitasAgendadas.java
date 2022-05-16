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
    
   
    

    public int calcularDiasFaltantes() {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaF = super.getFechaCita();
        final LocalDate fechaDestino = LocalDate.parse(fechaF, formatter);
        final LocalDate fechaOrigen = LocalDate.now();
        final long res = ChronoUnit.DAYS.between(fechaOrigen, fechaDestino);

        int dias = (int) res;
        return dias;

    }

    public void consultarCitasAgendadas(String cedula, ArrayList<CitaMedica> citasMedicas) {

        for (int i = 0; i < citasMedicas.size(); i++) {
            if (citasMedicas.get(i).isDisponibilidad() == false) {
                citasAgendadas.add(citasMedicas.get(i));
                if (cedula.equals(super.getNumeroDeCedula())) {
                    System.out.println("\n" + citasAgendadas.get(i));

                }
            }

        }

    }

    public ArrayList<CitaMedica> visualizarCitasAgendadas(ArrayList<CitaMedica> citasMedicas, String cedula) {
        for (int i = 0; i < citasMedicas.size(); i++) {
            if (citasMedicas.get(i).isDisponibilidad() == false && cedula.equals(citasMedicas.get(i).getNumeroDeCedula())) {
                citasAgendadas.add(citasMedicas.get(i));
            }
        }

        for (int j = 0; j < citasAgendadas.size(); j++) {
            
             CitaMedica cm = citasAgendadas.get(j);
            System.out.print("\n" + (j) +".- "                   
                   );
      
        System.out.println("Nombre de cedula del solicitante: " + cm.getNumeroDeCedula());
        System.out.println("Fecha de emision del documento: " + cm.getFechaEmision());
        System.out.println("Fecha de la cita cancelada:" + cm.getFechaCita());
        //System.out.println("Se ha agendado exitosamente. Restan " + cm.calcularDiasFaltantes() + "");
        }
        return citasAgendadas;

    }
}