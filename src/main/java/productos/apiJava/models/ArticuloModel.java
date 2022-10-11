package productos.apiJava.models;

import javax.persistence.*;

@Entity
@Table(name = "productos")
public class ArticuloModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long _id;

    private String codigo;
    private String producto;
    private String detalle;
    private String linea;
    private Long valor;
    private Long descuento;
    private Boolean promocion;

       /**Seters */
    public void setId(Long _id) {
        this._id = _id;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public void setDescuento(Long descuento) {
        this.descuento = descuento;
    }

    public void setPromocion(Boolean promocion) {
        this.promocion = promocion;
    }

    /**Getters */
    public Long getId() {
        return _id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getProducto() {
        return producto;
    }

    public String getDetalle() {
        return detalle;
    }

    public String getLinea() {
        return linea;
    }

    public Long getValor() {
        return valor;
    }

    public Long getDescuento() {
        return descuento;
    }

    public Boolean getPromocion() {
        return promocion;
    }

}
