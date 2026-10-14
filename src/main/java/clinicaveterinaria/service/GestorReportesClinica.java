/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaveterinaria.service;

import clinicaveterinaria.repository.BaseDatos;
/**
 *
 * @author aleja
 */

public class GestorReportesClinica {
    private final AuditoriaService auditoriaService;

    public GestorReportesClinica(AuditoriaService auditoriaService) {
        this.auditoriaService = auditoriaService;
    }

    public void imprimirResumenOperaciones() {
        System.out.println(
            "Resumen interno: " + auditoriaService.getAuditoria()
        );
    }
    
    //Separe la auditoria de BaseDatos porque pense que lo pedian en el SRP, igual la inyeccion se puede hacer
}
