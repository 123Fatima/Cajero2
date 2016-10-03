/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajero;

/**
 *
 * @author intel
 */
public class Metodos {
    private String nombre;
    private String clave;
    private float sueldo;
    private float Cantidad;

    public float getCantidad() {
        return Cantidad;
    }

    public void setCantidad(float Cantidad) {
        this.Cantidad = Cantidad;
    }
    
    public Metodos(){
        this.nombre = "";
        this.clave = "";
        this.sueldo = 0;
        this.Cantidad = 0;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setClave(String clave){
        this.clave = clave;
    }
    
    public String getClave(){
        return clave;
    }
    
    public void setSueldo(float sueldo){
        this.sueldo = sueldo;
    }
    
    public float getSueldo(){
        return sueldo;
    }
    
}
