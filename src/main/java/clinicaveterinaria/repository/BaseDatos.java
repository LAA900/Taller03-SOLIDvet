package clinicaveterinaria.repository;

import clinicaveterinaria.interfaces.IBaseDatos;
import clinicaveterinaria.model.Cita;
import clinicaveterinaria.model.Factura;
import clinicaveterinaria.model.Mascota;
import clinicaveterinaria.model.Tratamiento;
import clinicaveterinaria.model.Veterinario;

import java.util.ArrayList; 
import java.util.List; 


public class BaseDatos implements IBaseDatos {
    private final List<Mascota> mascotas = new ArrayList<>();
    private final List<Veterinario> veterinarios = new ArrayList<>();
    private final List<Cita> citas = new ArrayList<>();
    private final List<Tratamiento> tratamientos = new ArrayList<>();
    private final List<Factura> facturas = new ArrayList<>();

    @Override
    public List<Mascota> getMascotas() {
        return mascotas;
    }

    @Override
    public List<Veterinario> getVeterinarios() {
        return veterinarios;
    }

    @Override
    public List<Cita> getCitas() {
        return citas;
    }

    @Override
    public List<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    @Override
    public List<Factura> getFacturas() {
        return facturas;
    }

}
