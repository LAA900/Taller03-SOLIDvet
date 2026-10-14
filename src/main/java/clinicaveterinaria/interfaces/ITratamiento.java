package clinicaveterinaria.interfaces;

public interface ITratamiento {
    double calcularCostoFinal();

    String obtenerIndicaciones();
    
    String prepararSala();
    
    double calcularConImpuestos();
}
