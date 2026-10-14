package clinicaveterinaria.service;

import clinicaveterinaria.model.Veterinario;
import clinicaveterinaria.repository.BaseDatos;

import java.util.List;

public class VeterinarioCrudService {
    private final BaseDatos baseDatos;
    private AuditoriaService auditoriaservice;

    public VeterinarioCrudService(BaseDatos baseDatos,AuditoriaService auditoriaservice) {
        this.baseDatos = baseDatos;
        this.auditoriaservice = auditoriaservice;
    }

    public void crearVeterinario(Veterinario veterinario) {
        baseDatos.getVeterinarios().add(veterinario);
        auditoriaservice.registrarOperacion("crearVeterinario");
    }

    public Veterinario obtenerVeterinario(int id) {
        for (Veterinario veterinario : baseDatos.getVeterinarios()) {
            if (veterinario.getId() == id) {
                return veterinario;
            }
        }
        return null;
    }

    public void actualizarVeterinario(Veterinario veterinario) {
        eliminarVeterinario(veterinario.getId());
        crearVeterinario(veterinario);
    }

    public void eliminarVeterinario(int id) {
        baseDatos.getVeterinarios().removeIf(veterinario -> veterinario.getId() == id);
        auditoriaservice.registrarOperacion("eliminarVeterinario");
    }

    public List<Veterinario> listarVeterinarios() {
        return baseDatos.getVeterinarios();
    }
}
