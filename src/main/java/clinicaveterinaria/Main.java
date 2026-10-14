package clinicaveterinaria;

import clinicaveterinaria.interfaces.ITratamiento;
import clinicaveterinaria.model.*;
import clinicaveterinaria.repository.*;
import clinicaveterinaria.service.*;


import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        BaseDatos baseDatos = new BaseDatos();
        DirectoVeterinario veterinarioService = new DirectoVeterinario();
        Clinica clinica = new Clinica(veterinarioService, baseDatos);
        AuditoriaService auditoria = new AuditoriaService();
        GestorReportesClinica gestorReportes = new GestorReportesClinica(auditoria);
        MascotaService mascotaService = new MascotaService(baseDatos,auditoria);
        VeterinarioCrudService veterinarioCrudService = new VeterinarioCrudService(baseDatos,auditoria);
        ReservaService reservaService = new ReservaService(baseDatos);
        DiagnosticoService diagnosticoService = new DiagnosticoService();
        FacturacionService facturacionService = new FacturacionService(baseDatos);
        TratamientoService tratamientoService = new TratamientoService(baseDatos,auditoria);
        ReporteService reporteService = new ReporteService(baseDatos,auditoria);
        /*
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
        new Clinica(veterinarioService, baseDatos).agendarConsultaRapida(mascota, veterinario);
        new ServicioClinicaCompleto(baseDatos,auditoria).calcularTratamiento(tratamiento);
        */
    
        
    // PRUEBAS

        // 1. Crear mascota y veterinario
        Mascota mascota = new Mascota(1, "Tigrito", TipoAnimal.GATO, 4, "Luis Lucio");

        Veterinario veterinario = new Veterinario(1, "Dr. Walter", "Medicina gatuna", true);

        mascotaService.crearMascota(mascota);
        veterinarioCrudService.crearVeterinario(veterinario);

        System.out.println("=== mascota y veterinario ===");
        System.out.println(mascotaService.obtenerMascota(1));
        System.out.println(veterinarioCrudService.obtenerVeterinario(1));

        // 2. Reservar una cita
        Cita cita = clinica.agendarConsultaRapida(mascota, veterinario);

        System.out.println("\n=== cita reservada ===");
        System.out.println(cita);

        // 3. Registrar diagnóstico
        diagnosticoService.diagnosticar(
                cita, "Paciente estable para tratamiento.");

        System.out.println("\n=== diagnostico ===");
        System.out.println(cita);

        // 4. Crear tratamiento
        Tratamiento tratamiento = new CirugiaTratamiento(
                1, TipoTratamiento.CIRUGIA,
                "Esterilizacion", 120.0);

        tratamientoService.crearTratamiento(tratamiento);

        System.out.println("\n=== tratamiento ===");
        System.out.println("Indicaciones: "
                + tratamiento.obtenerIndicaciones());

        System.out.println("Preparacion: "
                + tratamientoService.prepararSala(tratamiento));

        System.out.println("Costo final: "
                + tratamiento.calcularCostoFinal());

        System.out.println("Costo con impuestos: "
                + new CalculadoraCostoTratamiento()
                        .calcularConImpuestos(tratamiento));

        // 5. Generar factura
        Factura factura = facturacionService.generarFactura(
                1, cita, tratamiento.calcularCostoFinal());

        factura.setPagada(true);

        System.out.println("\n=== factura ===");
        System.out.println(factura);

        // 6. Generar reportes
        System.out.println("\n=== reportes ===");

        System.out.println("Citas del Dr. Ruiz: "
                + reporteService
                        .generarReporteCitasPorVeterinario(1).size());

        System.out.println("Mascotas de Ana Perez: "
                + reporteService
                        .generarReporteMascotasPorDueno("Ana Perez").size());

        System.out.println("Ingresos del mes: "
                + reporteService.calcularIngresosMensual());

        // 7. Mostrar auditoria
        System.out.println("\n=== auditoria ===");
        gestorReportes.imprimirResumenOperaciones();

        System.out.println("\n=== Fin ===");
    
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
