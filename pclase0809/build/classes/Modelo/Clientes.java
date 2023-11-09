
package Modelo;

import java.util.ArrayList;
import java.util.List;


public class Clientes {
    public List<Cliente> clientes=new ArrayList<Cliente>(); /*es una lista de clientes, esto para evitar usar los arreglos pues ustedes al parecer estan mas familiarizados con listas*/
    
    public Clientes(){}
    
    public void AddCliente(Cliente c){
        this.clientes.add(c); //este es el agregar de las listas
    }
    
    public int SearchCliente(int rut){
        int posicion=-1;
        for(int i=0;i<clientes.size();i++)
            if(clientes.get(i).getRut()==rut) //clientes[i].getRut()
                  posicion=i;
        return posicion;
    }
}
