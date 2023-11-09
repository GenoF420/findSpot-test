
package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Solicitudes {
   public List<Solicitud> solicitudes=new ArrayList<Solicitud>();
    
    public Solicitudes(){}
    
    public void AddSolicitud(Solicitud s){
        this.solicitudes.add(s); //este es el agregar de las listas
    } 
    
    public Solicitud VerPedido(int numero){
        for(int i=0;i<solicitudes.size();i++){
            if(solicitudes.get(i).getNumero()==numero)
                solicitudes.get(i).Mostrar();
        }
        return solicitudes.get(numero);
    }

    public int SearchPedido(int numpedido){
     int posicion=-1;
      for(int i=0;i<solicitudes.size();i++){
          if(solicitudes.get(i).getNumero()==numpedido)
                 posicion=i;
      }
      return posicion;
    }

    public List<Integer> SearchPedido(int rut,String fecha){
     List<Integer> posiciones = new ArrayList<Integer>();
     for(int i=0;i<solicitudes.size();i++){
         if(solicitudes.get(i).getCliente().getRut()==rut && solicitudes.get(i).getFecha().equals(fecha))
                posiciones.add(i);
     }
      return posiciones;
    }


   public void VerPedidosActivos(){
        for(int i=0;i<solicitudes.size();i++){
            if(solicitudes.get(i).getEstado()!=4)
                solicitudes.get(i).Mostrar();
        }
    }
}
