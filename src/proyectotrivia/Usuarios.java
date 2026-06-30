/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotrivia;

/**
 *
 * @author JERO
 */
public class Usuarios  {
    int idUsuario;
    String nombre;
    String contraseña;

    public Usuarios() {
    }

    public Usuarios(int idUsuario, String nombre, String contraseña) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
   /*public void insertarUsuario(){


        Conexion c = new Conexion(nombre, nombre, nombre, nombre);
        if(existeUsuario(txtNombre.getText())){

            String nombre = txtNombre.getText();
            String contrasenia = txtApellido.getText();

            String sql = "INSERT INTO usuarios (nombre, apellido)"
                    + " VALUES ('" + nombre + "' , '" + apellido + "')";
        }
    }*/
}
