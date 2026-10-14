package clinicaveterinaria;

import clinicaveterinaria.interfaces.ITratamiento;
import clinicaveterinaria.model.*;
import clinicaveterinaria.repository.*;
import clinicaveterinaria.service.*;


import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        BaseDatos baseDatos = new BaseDatos();
        AuditoriaService auditoria = new AuditoriaService();
        MascotaService mascotaService = new MascotaService(baseDatos,auditoria);
        VeterinarioCrudService veterinarioCrudService = new VeterinarioCrudService(baseDatos,auditoria);
        ReservaService reservaService = new ReservaService(baseDatos);
        DiagnosticoService diagnosticoService = new DiagnosticoService();
        FacturacionService facturacionService = new FacturacionService(baseDatos);
        TratamientoService tratamientoService = new TratamientoService(baseDatos,auditoria);
        ReporteService reporteService = new ReporteService(baseDatos,auditoria);

        Mascota mascota = new Mascota(1, "Luna", TipoAnimal.PERRO, 4, "Ana Perez");
        Veterinario veterinario = new Veterinario(1, "Dr. Ruiz", "Medicina general", true);
        Tratamiento tratamiento = new CirugiaTratamiento(1, TipoTratamiento.CIRUGIA, "Esterilizacion", 120.0);

        mascotaService.crearMascota(mascota);
        veterinarioCrudService.crearVeterinario(veterinario);
        tratamientoService.crearTratamiento(tratamiento);

        Cita cita = reservaService.reservarCita(1, mascota, veterinario, LocalDate.now());
        diagnosticoService.diagnosticar(cita, "Paciente estable para tratamiento.");
        Factura factura = facturacionService.generarFactura(1, cita, tratamiento.calcularCostoFinal());
        factura.setPagada(true);

        System.out.println("=== ClinicaVeterinaria funcionando ===");
        System.out.println(mascotaService.obtenerMascota(1));
        System.out.println(cita);
        System.out.println(factura);
        System.out.println("Preparacion: " + tratamientoService.prepararSala((ITratamiento) tratamiento));
        System.out.println("Costo con impuestos: " + new CalculadoraCostoTratamiento().calcularConImpuestos((ITratamiento) tratamiento));
        System.out.println("Citas Dr. Ruiz: " + reporteService.generarReporteCitasPorVeterinario(1).size());
        System.out.println("Mascotas de Ana Perez: " + reporteService.generarReporteMascotasPorDueno("Ana Perez").size());
        System.out.println("Ingresos del mes: " + reporteService.calcularIngresosMensual());

        demostrarViolacionesSinRomperEjecucion(reporteService, diagnosticoService, reservaService, veterinario, mascota, tratamiento);
        new Clinica().agendarConsultaRapida(mascota, veterinario);
        new ServicioClinicaCompleto(baseDatos,auditoria).calcularTratamiento(tratamiento);
    }

    private static void demostrarViolacionesSinRomperEjecucion(ReporteService reporteService, DiagnosticoService diagnosticoService, ReservaService reservaService, Veterinario veterinario, Mascota mascota, Tratamiento tratamiento) {
        Cita citaDesdeModelo = reservaService.reservarCita(veterinario, 2, mascota, LocalDate.now().plusDays(1));
        diagnosticoService.diagnosticar(citaDesdeModelo, "Ejemplo de SRP violado desde el modelo.");
        System.out.println(reporteService.crearReporte(veterinario, citaDesdeModelo));

        Pez pez = new Pez(3, "Nemo");
        pez.nadar();
        System.out.println("El pez heredó caminar() y volar(), aunque no debe usarlos.");
        System.out.println("Tratamiento OCP violado pero funcional: " + tratamiento.obtenerIndicaciones());
    }
}
