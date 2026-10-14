package clinicaveterinaria.service;

import clinicaveterinaria.model.Factura;
import clinicaveterinaria.repository.BaseDatos;

import java.util.List;

public class FacturaService {
    private final BaseDatos baseDatos;
    private AuditoriaService auditoriaservice;

    public FacturaService(BaseDatos baseDatos,AuditoriaService auditoriaservice) {
        this.baseDatos = baseDatos;
        this.auditoriaservice = auditoriaservice;
    }

    public void crearFactura(Factura factura) {
        baseDatos.getFacturas().add(factura);
        auditoriaservice.registrarOperacion("crearFactura");
    }

    public Factura obtenerFactura(int id) {
        for (Factura factura : baseDatos.getFacturas()) {
            if (factura.getId() == id) {
                return factura;
            }
        }
        return null;
    }

    public void actualizarFactura(Factura factura) {
        eliminarFactura(factura.getId());
        crearFactura(factura);
    }

    public void eliminarFactura(int id) {
        baseDatos.getFacturas().removeIf(factura -> factura.getId() == id);
        auditoriaservice.registrarOperacion("eliminarFactura");
    }

    public void pagarFactura(int id) {
        Factura factura = obtenerFactura(id);
        if (factura != null) {
            factura.setPagada(true);
        }
    }

    public List<Factura> listarFacturas() {
        return baseDatos.getFacturas();
    }
}
