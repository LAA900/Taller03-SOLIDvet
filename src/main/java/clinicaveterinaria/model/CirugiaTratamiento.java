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
public class CirugiaTratamiento extends Tratamiento implements ITratamiento {
    
    private int id;
    private TipoTratamiento tipo;
    private String descripcion;
    private double costo;

    public CirugiaTratamiento(int id, TipoTratamiento tipo, String descripcion, double costo) {
        super(id, TipoTratamiento.VACUNA,
              "", costo);
    }

    @Override
    public double calcularCostoFinal() {
        return costo * 1.25 + 80.0;
    }

    @Override
    public String obtenerIndicaciones() {
        return "Ayuno previo y control postoperatorio.";
    }
    
    @Override
    public String prepararSala() {
        return "Preparar quirofano y anestesia.";
    }
    
    @Override
    public double calcularConImpuestos() {
        return costo * 1.35;
    }
    
}
