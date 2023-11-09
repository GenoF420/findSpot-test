package Modelo;
import java.util.ArrayList;
import java.util.List;

public class Productos {
   public List<Producto> productos=new ArrayList<Producto>();  /*esta es una lista de productos */
    
    public Productos(){}
    
    public void AddProducto(Producto p){
        this.productos.add(p); //este es el agregar de las listas
    }
    
    public void MostrarProductos(){
        System.out.println("\nLista de Productos Disponibles \n");
        for(int i=0;i<productos.size();i++)
            productos.get(i).Mostrar();
    }
     public int SearchProducto(int c){
        int posicion=-1;
        for(int i=0;i<productos.size();i++)
            if(productos.get(i).getCodigo()==c)
                  posicion=i;
        return posicion;
    }
}
