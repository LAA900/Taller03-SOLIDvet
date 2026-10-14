package clinicaveterinaria.service;

import clinicaveterinaria.model.Cita;
import clinicaveterinaria.model.Factura;
import clinicaveterinaria.model.Mascota;
import clinicaveterinaria.model.Veterinario;
import clinicaveterinaria.repository.BaseDatos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReporteService {
    private final BaseDatos baseDatos;
    private AuditoriaService auditoriaservice;

    public ReporteService(BaseDatos baseDatos,AuditoriaService auditoriaservice) {
        this.baseDatos = baseDatos;
        this.auditoriaservice = auditoriaservice;
    }

    public List<Cita> generarReporteCitasPorVeterinario(int veterinarioId) {
        List<Cita> resultado = new ArrayList<>();
        for (Cita cita : baseDatos.getCitas()) {
            if (cita.getVeterinario().getId() == veterinarioId) {
                resultado.add(cita);
            }
        }
        return resultado;
    }

    public List<Mascota> generarReporteMascotasPorDueno(String duenoNombre) {
        List<Mascota> resultado = new ArrayList<>();
        for (Mascota mascota : baseDatos.getMascotas()) {
            if (mascota.getDueno().equalsIgnoreCase(duenoNombre)) {
                resultado.add(mascota);
            }
        }
        return resultado;
    }

    public double calcularIngresosMensual() {
        double total = 0;
        int mesActual = LocalDate.now().getMonthValue();
        int anioActual = LocalDate.now().getYear();
        for (Factura factura : baseDatos.getFacturas()) {
            if (factura.isPagada()
                    && factura.getFecha().getMonthValue() == mesActual
                    && factura.getFecha().getYear() == anioActual) {
                total += factura.getMonto();
            }
        }
        return total;
    }
    
    public String crearReporte(Veterinario vet,Cita cita) {
        return "Reporte: " + vet.nombre + " atendio a " +
                cita.getMascota().getNombre() + " con diagnostico " + cita.getDiagnostico();
    }
    
    public String generarResumenOperaciones() {
        return "Resumen interno: " + auditoriaservice.getAuditoria();
    }
    
}
