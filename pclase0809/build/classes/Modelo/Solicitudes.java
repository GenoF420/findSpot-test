
package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Solicitudes {
   public List<Solicitud> solicitudes=new ArrayList<Solicitud>();
    
    public Solicitudes(){}
    
    public void AddSolicitud(Solicitud s){
        this.solicitudes.add(s); //este es el agregar de las listas
    } 
    
    public void VerPedido(int numero){
        for(int i=0;i<solicitudes.size();i++){
            if(solicitudes.get(i).getNumero()==numero)
                solicitudes.get(i).Mostrar();
        }
    }

    public int SearchPedido(int numpedido){
     int posicion=-1;
      for(int i=0;i<solicitudes.size();i++){
          if(solicitudes.get(i).getNumero()==numpedido)
                 posicion=i;
      }
      return posicion;
    }

    public int SearchPedido(int rut,String fecha){
     int posicion=-1;
      for(int i=0;i<solicitudes.size();i++){
          if(solicitudes.get(i).getRut()==rut && solicitudes.get(i).getFecha().equals(fecha))
                 posicion=i;
      }
      return posicion;
    }


   public void VerPedidosActivos(){
        for(int i=0;i<solicitudes.size();i++){
            if(solicitudes.get(i).getEstado()!=4)
                solicitudes.get(i).Mostrar();
        }
    }
}
