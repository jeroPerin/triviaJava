/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotrivia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Alumno
 */
public class Conexion {
    Connection conectar = null;

    private String servidor;
    private String database ;
    private String usuario;
    private String password;
    private String url = "";
    private Connection conn = null;
    private Statement stm;
    private ResultSet rs;
    
    public Conexion() {
    }

    public Conexion(String servidor, String database, String usuario, String password) {
        try {
            this.servidor = servidor;
            this.database = database;
            this.usuario = usuario;
            this.password = password;
            Class.forName("com.mysql.jdbc.Driver");
            url = "jdbc:mysql://" + servidor + ":3306/" + database;
            conn = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexion a Base de Datos " + url + " . . . . . Conexion abierta");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }

    public Connection getconexion() {
        return conn;
    }

    public Connection cerrarConexion() {
        try {
            conn.close();
            System.out.println("Cerrando conexion a " + url + " . . . .  Conexion cerrada!");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        conn = null;
        return conn;
    }

    public ResultSet consultar(String consultaSql) throws SQLException {
        stm = conn.createStatement();
        rs = stm.executeQuery(consultaSql);
        return rs;
    }

    public void insertar(String sql) {
        try {
            stm = conn.createStatement();
            stm.executeUpdate(sql);
            System.out.println(sql);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void actualizar(String sql) throws SQLException {
        Statement st = conn.createStatement();
        st.executeUpdate(sql);
        }
}