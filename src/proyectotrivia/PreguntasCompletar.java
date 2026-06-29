/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotrivia;

/**
 *
 * @author JERO
 */
public class PreguntasCompletar extends Preguntas {

    private String textoCorrecto;
    
    public PreguntasCompletar() {
    }

    public PreguntasCompletar(String textoCorrecto) {
        this.textoCorrecto = textoCorrecto;
    }

    public PreguntasCompletar(String textoCorrecto, int idPregunta, int idCategoria, String enunciado, int tipoPregunta, int dificultad) {
        super(idPregunta, idCategoria, enunciado, tipoPregunta, dificultad);
        this.textoCorrecto = textoCorrecto;
    }

    public String getTextoCorrecto() {
        return textoCorrecto;
    }

    public void setTextoCorrecto(String textoCorrecto) {
        this.textoCorrecto = textoCorrecto;
    }

    

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public int getTipoPregunta() {
        return tipoPregunta;
    }

    public void setTipoPregunta(int tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }
 
    //METODOS FUNCIONALIDADES
     @Override
    public boolean verificarRespuesta(String respuestaUsuario){
    
    if((respuestaUsuario.toUpperCase().trim()).equals(textoCorrecto.toUpperCase().trim()))
            return true;
        else
            return false;
        
      
    }
    
    
}
