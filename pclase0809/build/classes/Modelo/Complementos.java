
package Modelo;
import java.util.Scanner;


/* aca dejaré las funciones varias para que el main quede ordenado solamente */
public class Complementos {
    public int numero_solicitudes;
    public Scanner teclado;    
    public Complementos(){
        this.numero_solicitudes=1520; /*iniciamos las solicitudes en 1520 solo para que parezca que vendemos harto.*/
        this.teclado=new Scanner(System.in); /*es para tener la variable scanner disponible y no tener que crearla siempre */
    }
    
    /* metodo para dejar registrado unos datos y no tener que digitar a cada momento */
    /* en términos prácticos se dice que se ingresaron en duro */ 
    public void Inicializar(Clientes C, Productos P){
        Cliente cliente; //variable objeto cliente
        Producto producto; //variable objeto producto
        cliente=new Cliente(21001,'1',"Juan Perez","jperez@duoc.cl","Varas666",55521);
        C.AddCliente(cliente);
        cliente=new Cliente(22002,'1',"Ana Perez","aperez@duoc.cl","Varas666",55522);
        C.AddCliente(cliente);
        cliente=new Cliente(23003,'1',"Marta Rojas","mrojas@duoc.cl","Varas666",55523);
        C.AddCliente(cliente);
        cliente=new Cliente(24004,'1',"David Jimenez","djimenez@duoc.cl","Varas666",55524);
        C.AddCliente(cliente);
        producto=new Producto(100,"Verduras","Tomates",1000,2,1000);
        P.AddProducto(producto);
        producto=new Producto(101,"Verduras","Tomates",1000,2,1000);
        P.AddProducto(producto);
        producto=new Producto(102,"Frutas","Piñas",1500,1,1);
        P.AddProducto(producto);
        producto=new Producto(103,"Frutas","Granadas",1000,1,4);
        P.AddProducto(producto);
        producto=new Producto(104,"Frutas","Platanos",1000,2,1000);
        P.AddProducto(producto);
        producto=new Producto(105,"Frutas","Duraznos",2000,2,1000);
        P.AddProducto(producto);
    }
    
    /*muestra el menu y retorna la opcion leida */
    public int Menu(){
        int op=-1;
        System.out.println("1... Hacer Pedido");
        System.out.println("2... Ver Pedido");
        System.out.println("3... Realizar descuento");
        System.out.println("4... Obtener Numero Solicitud");
        System.out.println("5... Actualizar Estado pedido ");
        System.out.println("6... Salir");
        System.out.print("Ingrese su opción: ");
        op=teclado.nextInt();
        return op;
    }    
    
    /* metodo que trata de simular el limpiar pantalla */
    public void Clear(int linea){
        for(int i=0;i<=linea;i++)
            System.out.println("");
    }
    
    /* hace una detención hasta que se presione el enter */
    public void Pausa(){
        System.out.println("Presione enter para continuar");
        teclado.nextLine();
    }
    
    /*es para borrar los enter despues de leer un entero */
    public void BorrarEnter(){
        teclado.nextLine();
    }
    
} //fin de la clase
