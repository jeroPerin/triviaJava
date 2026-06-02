/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotrivia;

/**
 *
 * @author JERO
 */
public class Preguntas {
    
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
    
    
    
}
