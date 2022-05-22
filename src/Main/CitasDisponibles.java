
package Main;


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

    public CitasDisponibles() {
         citasDisponibles = new ArrayList<>();
         numeroCitasDisponibles = citasDisponibles.size();
    }

    public int getNumeroCitasDisponibles() {
        return numeroCitasDisponibles;
    }

    public void setNumeroCitasDisponibles(int numeroCitasDisponibles) {
        this.numeroCitasDisponibles = numeroCitasDisponibles;
    }

    public ArrayList<CitaMedica> getCitasDisponibles() {
        return citasDisponibles;
    }

    public void setCitasDisponibles(ArrayList<CitaMedica> citasDisponibles) {
        this.citasDisponibles = citasDisponibles;
    }
    
    
    
   
    // Replace Method with Method Object - Refactoring methods 7
    public ArrayList<CitaMedica> mostrarCitasDisponibles(ArrayList<CitaMedica> citasMedicas){
         for(int i = 0; i<citasMedicas.size(); i++){
             if(citasMedicas.get(i).isDisponibilidad() == true){
                 citasDisponibles.add(citasMedicas.get(i));
             }
        }
         
         for(int j = 0; j<citasDisponibles.size(); j++){
                CitaMedica cm = citasDisponibles.get(j);
            System.out.print("\n" + (j) +".- "                   
                   );
      
        System.out.println("Nombre de cedula del solicitante: " + cm.getNumeroDeCedula());
        System.out.println("Fecha de emision del documento: " + cm.getFechaEmision());
        System.out.println("Fecha de la cita cancelada:" + cm.getFechaCita());
         }
        return citasDisponibles;
    }
    
}