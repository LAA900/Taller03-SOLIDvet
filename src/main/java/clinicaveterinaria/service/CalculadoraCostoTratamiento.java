package clinicaveterinaria.service;

import clinicaveterinaria.interfaces.ITratamiento;
import clinicaveterinaria.model.TipoTratamiento;
import clinicaveterinaria.model.Tratamiento;


public class CalculadoraCostoTratamiento {
    public double calcularConImpuestos(ITratamiento tratamiento) {
        return tratamiento.calcularConImpuestos();
    }
}
