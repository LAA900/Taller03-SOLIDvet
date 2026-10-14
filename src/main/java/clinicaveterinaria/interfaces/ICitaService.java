/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaveterinaria.interfaces;

import clinicaveterinaria.model.Cita;

/**
 *
 * @author aleja
 */
public interface ICitaService {
    
        void crearCita(Cita cita);

        Cita obtenerCita(int id);

        void cancelarCita(int id);
    
}
