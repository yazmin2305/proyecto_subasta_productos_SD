package models;

/**
 *
 * @author YazminG, ErikaC
 */
public class Subasta {
    private Integer codigo;
    private Float valor_actual;
    private String estado;
    private Producto objProducto;
    
    public Subasta(){}

    public Subasta(Integer codigo, Float valor_actual, String estado, Producto objProducto) {
        this.codigo = codigo;
        this.valor_actual = valor_actual;
        this.estado = estado;
        this.objProducto = objProducto;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Float getValor_actual() {
        return valor_actual;
    }

    public void setValor_actual(Float valor_actual) {
        this.valor_actual = valor_actual;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Producto getObjProducto() {
        return objProducto;
    }

    public void setObjProducto(Producto objProducto) {
        this.objProducto = objProducto;
    }
    
    
}
