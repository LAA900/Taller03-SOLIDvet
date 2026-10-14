package clinicaveterinaria.model;

import clinicaveterinaria.interfaces.Caminador;
import clinicaveterinaria.interfaces.Volador;


public class Pajaro extends Animal implements Volador, Caminador{
    public Pajaro(int id, String nombre) {
        super(id, nombre, TipoAnimal.PAJARO);
    }

    @Override
    public void volar() {
        System.out.println("Volando");;
    }

    @Override
    public void caminar() {
        System.out.println("Caminando");;
    }
}
