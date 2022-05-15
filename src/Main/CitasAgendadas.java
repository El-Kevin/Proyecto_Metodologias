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
public class CitasAgendadas extends CitaMedica {

    private int numeroCitasAgendadas;
    private ArrayList<CitaMedica> citasAgendadas;

    public CitasAgendadas(String especialidad, String fechaEmision, String nombreMedico, String fechaCita, String codigoCita, boolean disponibilidad) {
        super(especialidad, fechaEmision, nombreMedico, fechaCita, codigoCita, false);
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

    public void consultarCitasAgendadas() {
        for(int i = 0; i<citasAgendadas.size(); i++){
            System.out.println("\n" + citasAgendadas.get(i));
        }

    }

    public void visualizarCitasAgendadas() {

    }
}
