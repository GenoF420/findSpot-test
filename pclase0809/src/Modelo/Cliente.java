package Modelo;

public class Cliente {
  private int rut;
  private char dv;
  private String nombre;
  private String email;
  private String direccion;
  private int telefono;

    public Cliente() {
    }

    public Cliente(int rut, char dv, String nombre, String email, String direccion, int telefono) {
        this.rut = rut;
        this.dv = dv;
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public char getDv() {
        return dv;
    }

    public void setDv(char dv) {
        this.dv = dv;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
  //haremos el metodo Mostrar()
    public void Mostrar(){
        System.out.println(this.rut+"-"+this.dv+" "+this.nombre+" "+this.direccion);
    }
    
}
