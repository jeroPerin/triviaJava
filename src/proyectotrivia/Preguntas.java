/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotrivia;

/**
 *
 * @author JERO
 */
abstract public class Preguntas {
    
    int idPregunta;
    int idCategoria;
    String enunciado;
    int tipoPregunta; 
    int dificultad ; // 1 facil -2 intermedia - 3 dificil

    public Preguntas() {
    }
    
    public Preguntas(int idPregunta, int idCategoria, String enunciado, int tipoPregunta, int dificultad) {
        this.idPregunta = idPregunta;
        this.idCategoria = idCategoria;
        this.enunciado = enunciado;
        this.tipoPregunta = tipoPregunta;
        this.dificultad = dificultad;
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
    
   public abstract boolean verificarRespuesta(String respuestaUsuario);
    
}
