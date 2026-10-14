/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaveterinaria.interfaces;

import clinicaveterinaria.model.Factura;

/**
 *
 * @author aleja
 */
public interface IFacturaService {
    void crearFactura(Factura factura);

    void pagarFactura(int id);
    
}
