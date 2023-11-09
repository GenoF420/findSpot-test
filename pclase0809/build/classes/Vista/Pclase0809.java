package Vista;
import Modelo.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Set;

public class Pclase0809 {  
   
    public static void main(String[] args) {
       /* variables globales del main */     
       Clientes ListaClientes=new Clientes(); //aca se almacenan los clientes
       Productos ListaProductos=new Productos(); //aca se almacena los productos
       Solicitudes ListaSolicitudes=new Solicitudes();//aca se almacenan las solicitudes
       Complementos varios=new Complementos(); //es un objeto que tiene las funciones y variables generales
       Cliente c; //variable del tipo cliente
       Producto p; //variable del tipo producto
       Solicitud s; //variable del tipo solicitud
       varios.Inicializar(ListaClientes,ListaProductos); //esto es solo para llenar datos y no tener que escribir
       int opcion;
       do{ 
           varios.Clear(20);
           opcion=varios.Menu();
           switch(opcion){
               case 1:
                      /* para realizar la compra el cliente debe estar registrado */
                      String respuesta="S";
                      String listaproductos="";
                      int total=0;
                      int totalparcial=0;
                      varios.Clear(20);
                      System.out.print("Ingrese su Rut: ");
                      int rut=varios.teclado.nextInt();
                      int posicion=ListaClientes.SearchCliente(rut);//obtengo el indice del cliente en la lista, sino está devuelve -1
                      if(posicion==-1){ //esto quiere decir que el cliente no está registrado
                          System.out.println("\n Atención: Usted se debe registrar previamente\n");
                          varios.teclado.nextLine();
                          varios.Pausa();
                          break; /*este break permite salir del case 1 */
                      }
                      c=ListaClientes.clientes.get(posicion);//Listacliente.clientes[i] 
                      s=new Solicitud();
                      varios.numero_solicitudes++;
                      while(respuesta.equalsIgnoreCase("S")) 
                          varios.Clear(20);
                          System.out.println("Bienvenido : "+c.getNombre()+"\n");
                          System.out.println("Su Pedido hasta el momento es "+s.getProductos());
                          listaproductos="";
                          ListaProductos.MostrarProductos();
                          System.out.print("Ingrese Codigo del Producto a comprar: ");
                          int cod=varios.teclado.nextInt();
                          int pos=ListaProductos.SearchProducto(cod);
                          p=ListaProductos.productos.get(pos);
                          System.out.print("Ingrese Cantidad de Producto solicitado: ");
                          int cantidad=varios.teclado.nextInt();
                          varios.BorrarEnter();
                          totalparcial=p.getPrecio()*cantidad;
                          total=total+totalparcial;
                          listaproductos=p.getCodigo()+" "+p.getDescripcion()+" "+cantidad+" "+totalparcial; //aca armo la cadena solicitada en la actividad
                          s.setProductos(listaproductos);
                          System.out.print("Desea continuar comprando (S/N): ");
                          respuesta=varios.teclado.nextLine();
                      }
                      s.setNumero(varios.numero_solicitudes);
                      String fecha = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()); //obtengo la fecha
                      s.setFecha(fecha);
                      s.setCliente(c);
                      s.setTotal(total);
                      ListaSolicitudes.AddSolicitud(s);
                      s.MostrarResumen();
                      varios.Pausa();
                      break;
               case 2:varios.Clear(20);
                      System.out.println("Ingrese Número de Pedido: ");
                      int npedido=varios.teclado.nextInt();
                      varios.BorrarEnter();
                      ListaSolicitudes.VerPedido(npedido);
                      varios.Pausa();
                      break;
               case 3:varios.Clear(20);
                      System.out.println("Ingrese Número de Pedido: ");
                      int npedido=varios.teclado.nextInt();
                      varios.BorrarEnter();
                      int pos=ListaSolicitudes.SearchPedido(npedido);
                      if(pos==-1){
                         System.out.println("Número de Solicitud incorrecto");
                         varios.Pausa();
                      }
                      else{
                         System.out.print("Ingrese Porcentaje de Descuento: ");
                         int descuento=varios.teclado.nextInt();
                         int total=ListaSolicitudes.get(pos).getTotal();
                         int descuento=int(total*(descuento/100));
                         System.out.println("El total original es: "+total);
                         System.out.println("El descuento es "+descuento);
                         System.out.println("El total final es "+total-descuento);
                         ListaSolicitudes.get(pos).setTotal(total-descuento);
                         varios.Pausa();
                      }                      
                      break;
               case 4:/*debe ingresar rut del cliente y fecha del pedido para encontrar el número del pedido. recuerde que un cliente puede tener varios pedidos*/
                       int pos=ListaSolicitudes.SearchPedido(rut,fecha);
                      break;
               case 5:/*debe mostrar pedidos activos y luego ingresar número de pedido y actualizar su estado a lo que corresponda.*/
                      break;
           }
           
       }while(opcion!=6);
        varios.Clear(30);
    }
    
}
