package Vista;
import Modelo.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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
                      while(respuesta.equalsIgnoreCase("S")){
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
                      int npedidos=varios.teclado.nextInt();
                      varios.BorrarEnter();
                      int pos=ListaSolicitudes.SearchPedido(npedidos);
                      if(pos==-1){
                         System.out.println("Número de Solicitud incorrecto");
                         varios.Pausa();
                      }
                      else{
                         System.out.print("Ingrese Porcentaje de Descuento: ");
                         int descuento=varios.teclado.nextInt();
                         int totalgeneral=ListaSolicitudes.solicitudes.get(pos).getTotal();
                         int descuentos=(int)(totalgeneral*(descuento/100));
                         System.out.println("El total original es: "+totalgeneral);
                         System.out.println("El descuento es "+descuentos);
                         System.out.println("El total final es "+(totalgeneral-descuentos));
                         ListaSolicitudes.solicitudes.get(pos).setTotal(totalgeneral-descuentos);
                         varios.Pausa();
                      }                      
                      break;
               case 4:
                   try {
                       varios.Clear(20);
                       System.out.print("Rut Del Cliente: ");
                       int _rut = varios.teclado.nextInt();
                       String _fecha = varios.teclado.nextLine();
                       varios.BorrarEnter();
                       List<Integer> _solicitudes = ListaSolicitudes.SearchPedido(_rut, _fecha);
                       if (_solicitudes.isEmpty()) {
                           System.out.println("No se encontraron datos.");
                           break;
                       }
                       for (int index : _solicitudes) {
                           System.out.println("Solicitud encontrada numero: " + index);
                       }
                       varios.BorrarEnter();
                       varios.Pausa();
                       break;
                   }
                   catch (Exception e) {
                       System.out.println("Datos invalidos");
                   }
                      break;
               case 5:/*debe mostrar pedidos activos y luego ingresar número de pedido y actualizar su estado a lo que corresponda.*/
                   List<Integer> solicitudes_no_activas = new ArrayList<Integer>();

                   for (Solicitud solicitud: ListaSolicitudes.solicitudes) {
                       if (solicitud.getEstado() == 4) {
                           continue;
                       }
                       solicitudes_no_activas.add(solicitud.getNumero());
                       System.out.println("ID: " + solicitud.getNumero() + " Estado: " + solicitud.getEstado() + " Cliente: " + solicitud.getCliente().getNombre() + " Total: " + solicitud.getTotal());
                   }

                   if (solicitudes_no_activas.isEmpty())
                   {
                       System.out.println("no hay solicitudes activas.");
                       break;
                   }

                   System.out.print("ID a modificar: ");

                   int _id = varios.teclado.nextInt();
                   varios.BorrarEnter();
                   if (!solicitudes_no_activas.contains(_id)) {
                       System.out.println("ID Invalida");
                       break;
                   }

                   int posicion_solicitud = ListaSolicitudes.SearchPedido(_id);

                   Solicitud solicitud = ListaSolicitudes.solicitudes.get(posicion_solicitud);

                   int _nuevo_estado = SolicitarEstado(ListaSolicitudes, varios);

                   switch (_nuevo_estado) {
                       case 1: case 2: case 3: case 4:
                           ListaSolicitudes.solicitudes.get(posicion_solicitud).setEstado(_nuevo_estado);
                           break;
                       default:
                           return;
                   }

                   ListaSolicitudes.solicitudes.get(posicion_solicitud).MostrarResumen();
                   varios.Pausa();
                   break;
               case 6:
                   int total6 = 0;

                   int _estado = SolicitarEstado(ListaSolicitudes, varios);

                   if (_estado == -1)
                   {
                       System.out.println("Estado invalido.");
                   }

                   for (Solicitud solicitud6: ListaSolicitudes.solicitudes) {
                       if (solicitud6.getEstado() != _estado) {
                           continue;
                       }
                       System.out.println("ID: " + solicitud6.getNumero() + " Cliente: " + solicitud6.getCliente().getNombre() + " Total: $" + solicitud6.getTotal());
                       total6 += solicitud6.getTotal();
                   }
                   System.out.println("Total entre todos las solicitudes: $" + total6);
                   varios.Pausa();
                   break;
               case 7:
                   System.out.print("RUT del cliente (SIN DIGITO VERIFICADOR): ");
                   int rut7 = varios.teclado.nextInt();
                   varios.BorrarEnter();

                   System.out.print("Digito Verificador del cliente: ");
                   String digito7 = varios.teclado.nextLine();

                   System.out.print("Nombre del cliente: ");
                   String nombre7 = varios.teclado.nextLine();

                   if (nombre7.length() < 5) {
                       System.out.println("Nombre debe contener mas de 5 caracteres.");
                       varios.Pausa();
                       break;
                   }

                   System.out.print("Direccion del cliente: ");
                   String direccion7 = varios.teclado.nextLine();

                   if (direccion7.length() < 10) {
                       System.out.println("Dirreccion debe contener mas de 5 caracteres.");
                       varios.Pausa();
                       break;
                   }

                   System.out.print("Numero del cliente: ");
                   int numero7 = varios.teclado.nextInt();
                   varios.BorrarEnter();

                   if (numero7 == 0) {
                       System.out.println("Numero no puede estar vacio.");
                       varios.Pausa();
                       break;
                   }

                   System.out.print("Correo del cliente: ");
                   String correo7 = varios.teclado.nextLine();

                   if (correo7.length() == 0) {
                       System.out.println("Correo no puede estar vacio");
                       varios.Pausa();
                       break;
                   }

                   ListaClientes.AddCliente(new Cliente(rut7, digito7.charAt(0), nombre7, correo7, direccion7, numero7));

                   System.out.println("Cliente anadido satisfactoriamente.");
                   varios.BorrarEnter();
                   varios.Pausa();
                   break;
               case 8:
                   varios.BorrarEnter();
                   int id8 = ListaProductos.productos.size() + 1;

                   System.out.print("Categoria del producto: ");
                   String subcategoria8 = varios.teclado.nextLine();

                   System.out.print("Descripcion del producto: ");
                   String descripcion8 = varios.teclado.nextLine();;

                   System.out.print("Precio del producto: ");
                   int precio8 = varios.teclado.nextInt();
                   varios.BorrarEnter();

                   System.out.print("Tipo del producto: ");
                   int tipo8 = varios.teclado.nextInt();
                   varios.BorrarEnter();

                   System.out.print("Unidad del producto: ");
                   int unidad8 = varios.teclado.nextInt();
                   varios.BorrarEnter();

                   ListaProductos.AddProducto(new Producto(id8, subcategoria8, descripcion8, precio8, tipo8, unidad8));

                   System.out.println("Producto anadido satisfactoriamente.");

                   ListaProductos.productos.get(ListaProductos.SearchProducto(id8)).Mostrar();

                   varios.BorrarEnter();
                   varios.Pausa();
                   break;
               case 9:
                   System.out.println("Datos del Alumno");
                   System.out.println("Nombre: Matias Canovas");
                   System.out.println("RUT: 20.444.907-4");
                   System.out.println("Correo: ma.canovas@duocuc.cl");

                   varios.BorrarEnter();
                   varios.Pausa();
                   break;
               default:
                   System.out.println("Opcion invalida.");
                   break;
           }
           
       }while(opcion!=10);
        varios.Clear(30);
    }

    private static int SolicitarEstado(Solicitudes solicitudes, Complementos varios) {
        System.out.println("1... Ingresado.");
        System.out.println("2... Procesando.");
        System.out.println("3... En Ruta.");
        System.out.println("4... Entregado.");
        System.out.print("Estado: ");
        int _estado = varios.teclado.nextInt();
        varios.BorrarEnter();
        if (_estado <= 0 || _estado >= 5) {
            return -1;
        }
        return _estado;
    }

}