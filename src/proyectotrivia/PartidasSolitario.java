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
    Preguntas[] preguntasPartida = new Preguntas[5] ;
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
                    "jdbc:mysql://localhost:3306/triviaProyecto",
                    "root",
                    ""
            );
       
        
                String sql = "SELECT * FROM preguntas ORDER BY RAND() LIMIT 5";

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        int pos = 0;

        while(rs.next()){

            int idPregunta = rs.getInt("idPregunta");
            int idCategoria = rs.getInt("idCategoria");
            int dificultad = rs.getInt("dificultad");
            String enunciado = rs.getString("enunciado");
            int tipo = rs.getInt("tipo");

            System.out.println("ID = " + idPregunta);
        System.out.println("TIPO = " + tipo);
            
            switch(tipo){

                case 1: // Verdadero/Falso

                    Statement stVF = con.createStatement();

                    String sqlVF =  "SELECT * FROM preguntas_vf " + "WHERE idPregunta = " + idPregunta;

                    ResultSet rsVF = stVF.executeQuery(sqlVF);

                    if(rsVF.next()){
                            System.out.println("Encontrada pregunta hija vf");
                        boolean opcionCorrecta =
                            rsVF.getBoolean("opcionCorrecta");

                        preguntasPartida[pos] = new PreguntasVerdaderoFalso(opcionCorrecta, idPregunta, idCategoria, enunciado,tipo,dificultad);
                    }

                    break;

                case 2: // Multiple Choice
                    
                    Statement stMC = con.createStatement();

                    String sqlMC =
                        "SELECT * FROM preguntasmultiplechoice " + "WHERE idPregunta = " + idPregunta;
                        System.out.println(sqlMC);
                    ResultSet rsMC = stMC.executeQuery(sqlMC);

                    if(rsMC.next()){
                            System.out.println("Encontrada pregunta mc");
                        String opcion1 = rsMC.getString("opcion1");
                        String opcion2 = rsMC.getString("opcion2");
                        String opcion3 = rsMC.getString("opcion3");
                        String opcion4 = rsMC.getString("opcion4");
                        String opcionCorrecta = rsMC.getString("opcionCorrecta");

                        preguntasPartida[pos] =
                            new PreguntasMultipleChoice(
                                opcion1,
                                opcion2,
                                opcion3,
                                opcion4,
                                opcionCorrecta,
                                idPregunta,
                                idCategoria,
                                enunciado,
                                tipo,
                                dificultad
                            );
                    }

                    break;
                    
                    case 3: // Completar

                    Statement stCom = con.createStatement();

                    String sqlCom =  "SELECT * FROM preguntasCompletar " + "WHERE idPregunta = " + idPregunta;

                    ResultSet rsCom = stCom.executeQuery(sqlCom);

                    if(rsCom.next()){
                            System.out.println("Encontrada pregunta completar");
                        String textoCorrecto =
                            rsCom.getString("textoCorrecto");

                        preguntasPartida[pos] = new PreguntasCompletar(textoCorrecto, idPregunta, idCategoria, enunciado,tipo,dificultad);
                    }

                    break;
                    
            }

            pos++;
        }
        puntajeFinal=0;
        indicePregunta=5;
        for(int i = 0; i < preguntasPartida.length; i++){
    System.out.println(i + " -> " + preguntasPartida[i]);
}
        
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    };
    
    
    
    public void finalizarPartida(){
    
    
    };
    public void calcularPuntaje(){
    
    };
    public Preguntas siguientePregunta(){
        
       
       indicePregunta--; 
     return preguntasPartida[indicePregunta];
        
    
    }
}