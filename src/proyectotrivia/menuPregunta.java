/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyectotrivia;

/**
 *
 * @author JERO
 */
public class menuPregunta extends javax.swing.JFrame {
    
       private Partidas p;
       
       private Preguntas pregActual;

    public menuPregunta(Partidas partida) {
        initComponents();
       
         p=partida;
        pregActual=p.siguientePregunta();
          
        mostrarPregunta();

    
    }
    
    private void procesarRespuesta(String respuesta){
    
        //verificar respuesta
        System.out.println("RESPONDISTE");
       pregActual= p.siguientePregunta();
        System.out.println(pregActual);
      
        mostrarPregunta();
        
        
    }
    
    private void mostrarPregunta(){
        
        
        panelVerdaderoFalso.setVisible(false);
        
        
        switch(pregActual.tipoPregunta){
        
           case 1 : panelVerdaderoFalso.setVisible(true);
           
           case 2 : 
               
            //   panelMultipleChoice.setVisible(true);
           
           
           case 3 : ;
           
        
        }
        
        System.out.println("Mostrando: " + pregActual.enunciado);
        lblPregunta.setText(pregActual.enunciado);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPregunta = new javax.swing.JLabel();
        panelVerdaderoFalso = new javax.swing.JPanel();
        btnVerdadero = new javax.swing.JButton();
        btnFalso = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        opcion3MultipleChoice = new javax.swing.JButton();
        opcion1MultipleChoice = new javax.swing.JButton();
        opcion2MultipleChoice = new javax.swing.JButton();
        opcion4MultipleChoice = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnVerdadero.setText("VERDADERO");
        btnVerdadero.addActionListener(this::btnVerdaderoActionPerformed);

        btnFalso.setText("FALSO");
        btnFalso.addActionListener(this::btnFalsoActionPerformed);

        javax.swing.GroupLayout panelVerdaderoFalsoLayout = new javax.swing.GroupLayout(panelVerdaderoFalso);
        panelVerdaderoFalso.setLayout(panelVerdaderoFalsoLayout);
        panelVerdaderoFalsoLayout.setHorizontalGroup(
            panelVerdaderoFalsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVerdaderoFalsoLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(btnFalso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVerdadero)
                .addGap(38, 38, 38))
        );
        panelVerdaderoFalsoLayout.setVerticalGroup(
            panelVerdaderoFalsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVerdaderoFalsoLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(panelVerdaderoFalsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFalso)
                    .addComponent(btnVerdadero))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(opcion2MultipleChoice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                        .addComponent(opcion4MultipleChoice))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(opcion1MultipleChoice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(opcion3MultipleChoice)))
                .addGap(52, 52, 52))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(opcion3MultipleChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(opcion1MultipleChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(opcion2MultipleChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opcion4MultipleChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelVerdaderoFalso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(lblPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 27, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(panelVerdaderoFalso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerdaderoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerdaderoActionPerformed
        procesarRespuesta("TRUE");
    }//GEN-LAST:event_btnVerdaderoActionPerformed

    private void btnFalsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFalsoActionPerformed
       procesarRespuesta("FALSE");
    }//GEN-LAST:event_btnFalsoActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFalso;
    private javax.swing.JButton btnVerdadero;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblPregunta;
    private javax.swing.JButton opcion1MultipleChoice;
    private javax.swing.JButton opcion2MultipleChoice;
    private javax.swing.JButton opcion3MultipleChoice;
    private javax.swing.JButton opcion4MultipleChoice;
    private javax.swing.JPanel panelVerdaderoFalso;
    // End of variables declaration//GEN-END:variables
}
