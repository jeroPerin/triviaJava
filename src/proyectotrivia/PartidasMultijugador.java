/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotrivia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author JERO
 */
public class PartidasMultijugador extends Partidas{
    
    int idUsuario1;
    int puntajeFinal1;
    int indicePregunta1;
    Preguntas preguntasPartida1[] = new Preguntas[5];
    Respuestas respuestasPartida1[] = new Respuestas[5];
    
    int idUsuario2;
    int puntajeFinal2;
    int indicePregunta2;
    Preguntas preguntasPartida2[] = new Preguntas[5];
    Respuestas respuestasPartida2[] = new Respuestas[5];
    
    int turno;

    public PartidasMultijugador() {
    }

    public PartidasMultijugador(int idUsuario1, int puntajeFinal1, int idUsuario2, int puntajeFinal2, int idPartida, boolean finalizada) {
        super(idPartida, finalizada);
        this.idUsuario1 = idUsuario1;
        this.puntajeFinal1 = puntajeFinal1;
        this.idUsuario2 = idUsuario2;
        this.puntajeFinal2 = puntajeFinal2;
    }

    public int getIdUsuario1() {
        return idUsuario1;
    }

    public void setIdUsuario1(int idUsuario1) {
        this.idUsuario1 = idUsuario1;
    }

    public int getPuntajeFinal1() {
        return puntajeFinal1;
    }

    public void setPuntajeFinal1(int puntajeFinal1) {
        this.puntajeFinal1 = puntajeFinal1;
    }

    public int getIdUsuario2() {
        return idUsuario2;
    }

    public void setIdUsuario2(int idUsuario2) {
        this.idUsuario2 = idUsuario2;
    }

    public int getPuntajeFinal2() {
        return puntajeFinal2;
    }

    public void setPuntajeFinal2(int puntajeFinal2) {
        this.puntajeFinal2 = puntajeFinal2;
    }
    
    @Override
    public void iniciarPartida(){
   
        try {

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/triviaProyecto",
                    "root",
                    ""
            );
       
        
                String sql = "SELECT * FROM preguntas ORDER BY RAND() LIMIT 10";

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        int pos1 = 0;
        int pos2 = 0;

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

                        if(pos1 == 5){
                             preguntasPartida2[pos2] = new PreguntasVerdaderoFalso(opcionCorrecta, idPregunta, idCategoria, enunciado,tipo,dificultad);
                             pos2++;
                        }else{
                            preguntasPartida1[pos1] = new PreguntasVerdaderoFalso(opcionCorrecta, idPregunta, idCategoria, enunciado,tipo,dificultad);
                            pos1++;
                        }
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

                        if(pos1 == 5){
                             preguntasPartida2[pos2] = new PreguntasMultipleChoice(opcion1, opcion2, opcion3, opcion4, opcionCorrecta, idPregunta, idCategoria, 
                                    enunciado,tipo, dificultad);
                             pos2++;
                        }else{
                            preguntasPartida1[pos1] = new PreguntasMultipleChoice(opcion1, opcion2, opcion3, opcion4, opcionCorrecta, idPregunta, idCategoria, 
                                    enunciado,tipo, dificultad
                            );
                            pos1++;
                        }
                    }

                    break;
                    
                    case 3: // Pregunta completar

                    Statement stCom = con.createStatement();

                    String sqlCom =  "SELECT * FROM preguntasCompletar " + "WHERE idPregunta = " + idPregunta;

                    ResultSet rsCom = stCom.executeQuery(sqlCom);

                    if(rsCom.next()){
                            System.out.println("Encontrada pregunta completar");
                        String textoCorrecto =
                            rsCom.getString("textoCorrecto");

                        if(pos1 == 5){
                             preguntasPartida2[pos2] = new PreguntasCompletar(textoCorrecto, idPregunta, idCategoria, enunciado,tipo,dificultad);
                             pos2++;
                        }else{
                            preguntasPartida1[pos1] = new PreguntasCompletar(textoCorrecto, idPregunta, idCategoria, enunciado,tipo,dificultad);
                            pos1++;
                        }
                    }
                    break;
            }
        }
        turno=1;
        puntajeFinal1=0;
        puntajeFinal2=0;
        indicePregunta1=5;
        indicePregunta2=5;        
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    };
    public void finalizarPartida(){};
    public void calcularPuntaje(){};
    
    @Override
    public Preguntas siguientePregunta(){
        
       Preguntas p = new Preguntas();
        if(turno==1){
            turno=2;
            p = preguntasPartida1[--indicePregunta1];
        }else{
            turno=1;
            p = preguntasPartida2[--indicePregunta2];
        }
        
    };
    
}
