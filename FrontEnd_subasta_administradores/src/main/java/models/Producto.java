package models;

/**
 *
 * @author YazminG, ErikaC
 */
public class Producto {
    private Integer codigo;
    private String nombre;
    private Float valor_inicial;
    private String estado;
    
    public Producto(){}

    public Producto(Integer codigo, String nombre, Float valor_inicial, String estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.valor_inicial = valor_inicial;
        this.estado = estado;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getValor_inicial() {
        return valor_inicial;
    }

    public void setValor_inicial(Float valor_inicial) {
        this.valor_inicial = valor_inicial;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
