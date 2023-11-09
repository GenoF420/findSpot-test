
package Modelo;
import java.util.ArrayList;
import java.util.List;


public class Solicitud {
   int numero;
   String fecha;
   Cliente cliente;
   int total;
   int estado; //1 ingresada 2 procesando 3 en ruta 4 entregada
   List<String> productos;

    public Solicitud() {
        this.estado=1;
        this.productos=new ArrayList<String>();
    }

    public Solicitud(int numero, String fecha, Cliente cliente, int total) {
        this.numero = numero;
        this.fecha = fecha;
        this.cliente = cliente;
        this.total = total;
        this.estado=1;
        this.productos = new ArrayList<String>();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<String> getProductos() {
        return productos;
    }

    public void setProductos(String p) {
        this.productos.add(p); //productos[0]=cadena productos[1]
    }
    
     public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
   
    public String EstadoPalabras(){
        //1 ingresada 2 procesando 3 en ruta 4 entregada
        String estadopalabras="";
        switch(this.estado){
            case 1:estadopalabras="Ingresada";
                   break;
            case 2:estadopalabras="Procesando";
                   break;
            case 3:estadopalabras="En Ruta";
                   break;
            case 4:estadopalabras="Entregado";
                   break;
        }
        return estadopalabras;
    }
    public void Mostrar(){
        System.out.println("N°: "+this.numero);
        System.out.println("Fecha: "+this.fecha);
        System.out.println("Estado: "+this.EstadoPalabras());
        System.out.println("Productos: "+this.productos);
        System.out.println("Total: "+this.total);
    }
    public void MostrarResumen(){
        System.out.println("<<*********************************************************>>");
        System.out.println("Sr. "+this.cliente.getNombre()+ " el detalle de su compra es:");
        System.out.println("N° Pedido: "+this.numero);
        System.out.println("Fecha Pedido: "+this.fecha);
        System.out.println("Estado: "+this.EstadoPalabras());
        System.out.println("Total: "+this.total);
        System.out.println("Sus productos pedidos: "+this.productos);
        System.out.println("<<*********************************************************>>");
    }
}
