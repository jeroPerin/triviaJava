/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotrivia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author JERO
 */
public class PartidasSolitario extends Partidas {
          
    int idUsuario;
    int puntajeFinal;
    int indicePregunta;
    Preguntas[] preguntasPartida = new PreguntasVerdaderoFalso[5] ;
    Respuestas[] respuestasPartida = new Respuestas[5];
    
    

    public PartidasSolitario() {
    }

    public PartidasSolitario(int idUsuario, int puntajeFinal) {
        this.idUsuario = idUsuario;
        this.puntajeFinal = puntajeFinal;
    }

    public PartidasSolitario(int idUsuario, int puntajeFinal, int idPartida, boolean finalizada) {
        super(idPartida, finalizada);
        this.idUsuario = idUsuario;
        this.puntajeFinal = puntajeFinal;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getPuntajeFinal() {
        return puntajeFinal;
    }

    public void setPuntajeFinal(int puntajeFinal) {
        this.puntajeFinal = puntajeFinal;
    }
    
    

    @Override
    public void iniciarPartida(){
   
        try {

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/practicasqlgrafica",
                    "root",
                    ""
            );
        String sql = "SELECT * FROM preguntas ORDER BY RAND() LIMIT 5";

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next()){
            //boolean opcionCorrecta, int idPregunta, int idCategoria, String enunciado, int tipoPregunta, int dificultad

            //aca vendria el switch dependiendo el tipo de pregunta, por ahora solo VoF
           boolean op = rs.getBoolean("opcionCorrecta");
           int idPregunta = rs.getInt("idPregunta");
           int idCategoria = rs.getInt("idCategoria");
           int dificultad = rs.getInt("dificultad");
           String enunciado = rs.getString("enunciado");
           int tipo = rs.getInt("tipoPregunta");

           Preguntas p = new PreguntasVerdaderoFalso(op,idPregunta,idCategoria,enunciado,tipo,dificultad);
           //Guardamos la pregunta en el array 
            for(int i =0;i<preguntasPartida.length;i++)
                preguntasPartida[i] = p;
        }
        puntajeFinal=0;
        indicePregunta=0;
        
        
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        
      
    
    
    };
    
    public void aumentarIndice(){ indicePregunta++;}
    
    public void finalizarPartida(){
    
    
    };
    public void calcularPuntaje(){
    
    };
    public Preguntas siguientePregunta(){
        
     return preguntasPartida[indicePregunta];
        
    
    }
}