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

    public void visualizarCitasAgendadas(ArrayList<CitaMedica> citasMedicas) {
        for (int i = 0; i < citasMedicas.size(); i++) {
            if (citasMedicas.get(i).isDisponibilidad() == true) {
                citasAgendadas.add(citasMedicas.get(i));
            }
        }

        for (int j = 0; j < citasAgendadas.size(); j++) {
            System.out.println("\n" + citasAgendadas.get(j));
        }

    }
}
