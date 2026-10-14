package clinicaveterinaria.service;

import clinicaveterinaria.model.Cita;
import clinicaveterinaria.model.EstadoCita;
import clinicaveterinaria.model.Mascota;
import clinicaveterinaria.model.Veterinario;
import clinicaveterinaria.repository.BaseDatos;

import java.time.LocalDate;

public class ReservaService {
    private final BaseDatos baseDatos;

    public ReservaService(BaseDatos baseDatos) {
        this.baseDatos = baseDatos;
    }

    public Cita reservarCita(int id, Mascota mascota, Veterinario veterinario, LocalDate fecha) {
        Cita cita = new Cita(id, mascota, veterinario, fecha, "Pendiente", EstadoCita.PROGRAMADA);
        baseDatos.getCitas().add(cita);
        veterinario.setDisponible(false);
        return cita;
    }
    
    public Cita reservarCita(Veterinario vet, int citaId, Mascota mascota, LocalDate fecha) {
        vet.disponible = false;
        return new Cita(citaId, mascota, vet, fecha, "Pendiente", EstadoCita.PROGRAMADA);
    }
}
