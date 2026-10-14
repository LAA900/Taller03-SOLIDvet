package clinicaveterinaria.service;

import clinicaveterinaria.model.Cita;
import clinicaveterinaria.model.Factura;
import clinicaveterinaria.repository.BaseDatos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FacturacionService {
    private final BaseDatos baseDatos;
    private final List<Factura> facturas = new ArrayList<>();

    public FacturacionService(BaseDatos baseDatos) {
        this.baseDatos = baseDatos;
    }

    public Factura generarFactura(int id, Cita cita, double monto) {
        Factura factura = new Factura(id, cita, monto, LocalDate.now(), false);
        baseDatos.getFacturas().add(factura);
        return factura;
    }
    
    public Factura generarFactura(int facturaId, Cita cita, double monto, LocalDate fecha) {
        return new Factura(facturaId, cita, monto, fecha, false);
    }
    
    public double calcularIngresosMensual() {
        double total = 0;
        int mesActual = LocalDate.now().getMonthValue();
        int anioActual = LocalDate.now().getYear();
        for (Factura factura : facturas) {
            if (factura.isPagada()
                    && factura.getFecha().getMonthValue() == mesActual
                    && factura.getFecha().getYear() == anioActual) {
                total += factura.getMonto();
            }
        }
        return total;
    }
}
