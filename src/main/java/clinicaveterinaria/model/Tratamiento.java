package clinicaveterinaria.model;

import clinicaveterinaria.interfaces.ITratamiento;
import java.util.Objects;


public abstract class Tratamiento implements ITratamiento{
    private int id;
    private TipoTratamiento tipo;
    private String descripcion;
    private double costo;

    public Tratamiento(int id, TipoTratamiento tipo, String descripcion, double costo) {
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.costo = costo;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoTratamiento getTipo() {
        return tipo;
    }

    public void setTipo(TipoTratamiento tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Tratamiento)) {
            return false;
        }
        Tratamiento that = (Tratamiento) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Tratamiento{" +
                "id=" + id +
                ", tipo=" + tipo +
                ", descripcion='" + descripcion + '\'' +
                ", costo=" + costo +
                '}';
    }

    @Override
    public abstract double calcularCostoFinal();

    @Override
    public abstract String obtenerIndicaciones();

    @Override
    public abstract String prepararSala();

    @Override
    public abstract double calcularConImpuestos();
}
