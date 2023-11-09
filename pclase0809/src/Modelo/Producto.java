
package Modelo;

public class Producto {
  private int codigo;
  private String subcategoria;
  private String descripcion;
  private int precio;
  private int tipo; //1 si se vende por unidad y 2 si se vende por gramos
  private int unidad;

    public Producto() {
    }

    public Producto(int codigo, String subcategoria, String descripcion, int precio, int tipo, int unidad) {
        this.codigo = codigo;
        this.subcategoria = subcategoria;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipo = tipo;
        this.unidad = unidad;
    }

    public int getUnidad() {
        return unidad;
    }

    public void setUnidad(int unidad) {
        this.unidad = unidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
  
    public void Mostrar(){
        System.out.println(this.codigo+" "+this.descripcion);
    }
  
}
