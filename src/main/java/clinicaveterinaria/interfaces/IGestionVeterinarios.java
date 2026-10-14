/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaveterinaria.interfaces;

import clinicaveterinaria.model.Veterinario;

/**
 *
 * @author aleja
 */
public interface IGestionVeterinarios {
    void actualizarVeterinario(Veterinario veterinario);
    void eliminarVeterinario(int id);
    
}
