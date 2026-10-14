/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaveterinaria.model;

import clinicaveterinaria.interfaces.ITratamiento;

/**
 *
 * @author aleja
 */
public class FisioterapiaTratamiento extends Tratamiento implements ITratamiento {
    
    private int id;
    private TipoTratamiento tipo;
    private String descripcion;
    private double costo;

    public FisioterapiaTratamiento(int id, TipoTratamiento tipo, String descripcion, double costo) {
        super(id, TipoTratamiento.VACUNA,
              "", costo);
    }

    @Override
    public double calcularCostoFinal() {
        return costo * 0.95;
    }

    @Override
    public String obtenerIndicaciones() {
        return "Repetir sesiones dos veces por semana.";
    }
    
    @Override
    public String prepararSala() {
        return "Preparar camilla y bandas elasticas.";
    }
    
    @Override
    public double calcularConImpuestos() {
        return costo * 1.05;
    }
}
