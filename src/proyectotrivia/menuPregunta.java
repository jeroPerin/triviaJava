/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyectotrivia;
import javax.swing.Timer;
import java.awt.Cursor;
/**
 *
 * @author JERO
 */
public class menuPregunta extends javax.swing.JFrame {
    
       private Partidas p;
       private int jugador;
       private Preguntas pregActual;
       private boolean eraMiTurno = false;
       private boolean respuestaCorrecta;
       private Timer timer;
       
    public menuPregunta(Partidas partida, int idJugador,int numJugador) {
        initComponents();
        
        getContentPane().setBackground(new java.awt.Color(30, 58, 95));
        
        btnCompletar5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnFalso.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnVerdadero.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        p=partida;
        if(p instanceof PartidasMultijugador){
        timer = new Timer(200, e -> {
            actualizarPantalla();
        });
         timer.start();
         
         lblJugador.setText("J" + numJugador);
         
         
        }

        
        
        panelVerdaderoFalso.setBounds(480, 30, 110, 510);
            panelMultipleChoice.setBounds(480, 30, 110, 510);
            panelCompletar5.setBounds(480, 30, 110, 510);
        
        jugador=idJugador;
         
        pregActual=p.siguientePregunta();
        System.out.println(pregActual);
          
        mostrarPregunta();

    
    }
    
    private void procesarRespuesta(String respuesta){
    
        
        System.out.println(respuesta);
        
        p.guardarRespuesta(respuesta.toUpperCase());

        pregActual= p.siguientePregunta();
        
        if(pregActual == null){
        p.finalizarPartida();
        menuFinalPartida m = new menuFinalPartida(p);
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        dispose();
        return;
            }
        System.out.println(pregActual);
      
        
        if(p instanceof PartidasSolitario)
        mostrarPregunta();
        
    }
    
    private void mostrarPregunta(){
        
        
            ocultarPaneles();
            
        
        switch(pregActual.tipoPregunta){
        
           case 1 : panelVerdaderoFalso.setVisible(true);break;
           
           case 2 : 
            PreguntasMultipleChoice preguntaMC = (PreguntasMultipleChoice) pregActual;

            opcion1MultipleChoice.setText(preguntaMC.getOpcion1());
            opcion2MultipleChoice.setText(preguntaMC.getOpcion2());
            opcion3MultipleChoice.setText(preguntaMC.getOpcion3());
            opcion4MultipleChoice.setText(preguntaMC.getOpcion4());

             
              
            panelMultipleChoice.setVisible(true);break;
           
           case 3 : panelCompletar5.setVisible(true);break ;
           
        
        }
        
        System.out.println("Mostrando: " + pregActual.enunciado);
        lblPregunta.setText(pregActual.enunciado);
    }

    private void actualizarPantalla(){
    
        boolean esMiTurno = ((PartidasMultijugador)p).getTurno() == jugador;
        
          if( esMiTurno && !eraMiTurno  ){

                 
                mostrarPregunta();
                eraMiTurno=true;
            }
            
                
              if(!eraMiTurno)
              
              { 
                  ocultarPaneles();
                lblPregunta.setText("Esperando al otro jugador...");
            }
    
               eraMiTurno = esMiTurno;
    }
    
    private void ocultarPaneles(){
        
        txtCompletar5.setText("");
        panelVerdaderoFalso.setVisible(false);
        panelMultipleChoice.setVisible(false);
        panelCompletar5.setVisible(false);
    
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPregunta = new javax.swing.JLabel();
        panelVerdaderoFalso = new javax.swing.JPanel();
        btnVerdadero = new RoundedButton();
        btnFalso = new RoundedButton();
        lblJugador = new javax.swing.JLabel();
        panelCompletar5 = new javax.swing.JPanel();
        txtCompletar5 = new javax.swing.JTextField();
        lblCompletar5 = new javax.swing.JLabel();
        btnCompletar5 = new RoundedButton();
        panelMultipleChoice = new javax.swing.JPanel();
        opcion3MultipleChoice = new RoundedButton();
        opcion1MultipleChoice = new RoundedButton();
        opcion2MultipleChoice = new RoundedButton();
        opcion4MultipleChoice = new RoundedButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(650, 300));

        lblPregunta.setBackground(new java.awt.Color(255, 255, 255));
        lblPregunta.setFont(new java.awt.Font("Sitka Text", 0, 20)); // NOI18N
        lblPregunta.setForeground(new java.awt.Color(255, 255, 255));
        lblPregunta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        panelVerdaderoFalso.setBackground(new java.awt.Color(30, 58, 95));

        btnVerdadero.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        btnVerdadero.setText("VERDADERO");
        btnVerdadero.addActionListener(this::btnVerdaderoActionPerformed);

        btnFalso.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        btnFalso.setText("FALSO");
        btnFalso.addActionListener(this::btnFalsoActionPerformed);

        javax.swing.GroupLayout panelVerdaderoFalsoLayout = new javax.swing.GroupLayout(panelVerdaderoFalso);
        panelVerdaderoFalso.setLayout(panelVerdaderoFalsoLayout);
        panelVerdaderoFalsoLayout.setHorizontalGroup(
            panelVerdaderoFalsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVerdaderoFalsoLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnFalso, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125)
                .addComponent(btnVerdadero)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        panelVerdaderoFalsoLayout.setVerticalGroup(
            panelVerdaderoFalsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVerdaderoFalsoLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(panelVerdaderoFalsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFalso, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerdadero, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        lblJugador.setBackground(new java.awt.Color(255, 255, 255));
        lblJugador.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N

        panelCompletar5.setBackground(new java.awt.Color(30, 58, 95));

        txtCompletar5.setBackground(new java.awt.Color(153, 204, 255));
        txtCompletar5.addActionListener(this::txtCompletarActionPerformed);

        lblCompletar5.setBackground(new java.awt.Color(255, 255, 255));
        lblCompletar5.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        lblCompletar5.setForeground(new java.awt.Color(255, 255, 255));
        lblCompletar5.setText("Completa:");

        btnCompletar5.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        btnCompletar5.setText("RESPONDER");
        btnCompletar5.addActionListener(this::btnCompletarActionPerformed);

        javax.swing.GroupLayout panelCompletar5Layout = new javax.swing.GroupLayout(panelCompletar5);
        panelCompletar5.setLayout(panelCompletar5Layout);
        panelCompletar5Layout.setHorizontalGroup(
            panelCompletar5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCompletar5Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(lblCompletar5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCompletar5, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCompletar5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCompletar5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
        );
        panelCompletar5Layout.setVerticalGroup(
            panelCompletar5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCompletar5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCompletar5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCompletar5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCompletar5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCompletar5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        panelMultipleChoice.setBackground(new java.awt.Color(30, 58, 95));

        opcion3MultipleChoice.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        opcion3MultipleChoice.addActionListener(this::opcion3MultipleChoiceActionPerformed);

        opcion1MultipleChoice.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        opcion1MultipleChoice.addActionListener(this::opcion1MultipleChoiceActionPerformed);

        opcion2MultipleChoice.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        opcion2MultipleChoice.addActionListener(this::opcion2MultipleChoiceActionPerformed);

        opcion4MultipleChoice.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        opcion4MultipleChoice.addActionListener(this::opcion4MultipleChoiceActionPerformed);

        javax.swing.GroupLayout panelMultipleChoiceLayout = new javax.swing.GroupLayout(panelMultipleChoice);
        panelMultipleChoice.setLayout(panelMultipleChoiceLayout);
        panelMultipleChoiceLayout.setHorizontalGroup(
            panelMultipleChoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMultipleChoiceLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(panelMultipleChoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(opcion1MultipleChoice, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(opcion2MultipleChoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(panelMultipleChoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(opcion3MultipleChoice, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(opcion4MultipleChoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(41, 41, 41))
        );
        panelMultipleChoiceLayout.setVerticalGroup(
            panelMultipleChoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMultipleChoiceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMultipleChoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opcion1MultipleChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opcion3MultipleChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(panelMultipleChoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(opcion2MultipleChoice, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(opcion4MultipleChoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(panelMultipleChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelVerdaderoFalso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelCompletar5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(207, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblPregunta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(lblPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(panelMultipleChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelCompletar5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelVerdaderoFalso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opcion4MultipleChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion4MultipleChoiceActionPerformed
        // TODO add your handling code here:
        procesarRespuesta(opcion4MultipleChoice.getText());
    }//GEN-LAST:event_opcion4MultipleChoiceActionPerformed

    private void opcion2MultipleChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion2MultipleChoiceActionPerformed
        // TODO add your handling code here:
        procesarRespuesta(opcion2MultipleChoice.getText());
    }//GEN-LAST:event_opcion2MultipleChoiceActionPerformed

    private void opcion1MultipleChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion1MultipleChoiceActionPerformed
        // TODO add your handling code here:
        procesarRespuesta(opcion1MultipleChoice.getText());
    }//GEN-LAST:event_opcion1MultipleChoiceActionPerformed

    private void opcion3MultipleChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion3MultipleChoiceActionPerformed
        // TODO add your handling code here:
        procesarRespuesta(opcion3MultipleChoice.getText());
    }//GEN-LAST:event_opcion3MultipleChoiceActionPerformed

    private void btnFalsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFalsoActionPerformed
        procesarRespuesta("FALSE");
    }//GEN-LAST:event_btnFalsoActionPerformed

    private void btnVerdaderoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerdaderoActionPerformed
        procesarRespuesta("TRUE");
    }//GEN-LAST:event_btnVerdaderoActionPerformed

    private void btnCompletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompletarActionPerformed
        // TODO add your handling code here:
        procesarRespuesta(txtCompletar5.getText());
    }//GEN-LAST:event_btnCompletarActionPerformed

    private void txtCompletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCompletarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCompletarActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCompletar5;
    private javax.swing.JButton btnFalso;
    private javax.swing.JButton btnVerdadero;
    private javax.swing.JLabel lblCompletar5;
    private javax.swing.JLabel lblJugador;
    private javax.swing.JLabel lblPregunta;
    private javax.swing.JButton opcion1MultipleChoice;
    private javax.swing.JButton opcion2MultipleChoice;
    private javax.swing.JButton opcion3MultipleChoice;
    private javax.swing.JButton opcion4MultipleChoice;
    private javax.swing.JPanel panelCompletar5;
    private javax.swing.JPanel panelMultipleChoice;
    private javax.swing.JPanel panelVerdaderoFalso;
    private javax.swing.JTextField txtCompletar5;
    // End of variables declaration//GEN-END:variables
}
