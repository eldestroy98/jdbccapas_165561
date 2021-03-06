/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbccapas_165561;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Srneno
 */
public class FrameSocio extends javax.swing.JFrame {
   ConnectionFactory connectionFactory= new MySQLConnection("localhost","club nautico",3306,"root","operation7");
   private SocioDAO socioDao;
   List<Socio> lista;
    
  
    /**
     * Creates new form FrameSocio
     */
    public FrameSocio(ConnectionFactory connectionFactory) throws Exception {
        initComponents();
         socioDao=new SocioDAOImp1(connectionFactory);
       
         this.lista= socioDao.getAll();
         
         this.TextoDni.setText("");
        this.TextoNombre.setText("");
        this.TextoId.setText("");
        this.TextoBuscar.setText("");
        refresh();
               
      
     
    }

    private FrameSocio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void refresh() throws Exception{
        this.lista= socioDao.getAll(); 
        this.jTable1.removeAll();
       DefaultTableModel acumular= new DefaultTableModel();

        int aux= 0;
        for(Socio s :lista){
            s=lista.get(aux);
            Object[] ObjAux = {s.getId(),s.getDni(),s.getNombre()};
            acumular.addRow(ObjAux);
            aux++;
            
            
        }
         
    }
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TextoBuscar = new javax.swing.JTextField();
        TextoId = new javax.swing.JTextField();
        TextoDni = new javax.swing.JTextField();
        TextoNombre = new javax.swing.JTextField();
        BotonGuardar = new javax.swing.JButton();
        BotonBorrar = new javax.swing.JButton();
        BotonSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        botonBuscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TextoBuscar.setBackground(new java.awt.Color(153, 153, 255));
        TextoBuscar.setForeground(new java.awt.Color(0, 0, 0));
        TextoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextoBuscarActionPerformed(evt);
            }
        });

        TextoId.setBackground(new java.awt.Color(153, 153, 255));
        TextoId.setForeground(new java.awt.Color(0, 0, 0));
        TextoId.setEnabled(false);

        TextoDni.setBackground(new java.awt.Color(153, 153, 255));
        TextoDni.setForeground(new java.awt.Color(0, 0, 0));

        TextoNombre.setBackground(new java.awt.Color(153, 153, 255));
        TextoNombre.setForeground(new java.awt.Color(0, 0, 0));
        TextoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextoNombreActionPerformed(evt);
            }
        });

        BotonGuardar.setText("GUARDAR");
        BotonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGuardarActionPerformed(evt);
            }
        });

        BotonBorrar.setText("BORRAR TEXTO");
        BotonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBorrarActionPerformed(evt);
            }
        });

        BotonSalir.setText("SALIR");
        BotonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSalirActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "dni", "nombre"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("ID:");
        jLabel1.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("DNI:");

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("Nombre:");

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        jLabel4.setText("ID a buscar:");

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("MENU DE SOCIOS");

        jButton1.setText("GUARDAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(TextoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonBuscar)
                .addGap(215, 215, 215))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextoId)
                            .addComponent(TextoDni)
                            .addComponent(TextoNombre))
                        .addGap(124, 124, 124))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(174, 174, 174)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(BotonGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotonBorrar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(BotonSalir)
                        .addGap(139, 139, 139))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar)
                    .addComponent(jLabel4))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TextoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TextoDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TextoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BotonGuardar)
                            .addComponent(BotonBorrar)
                            .addComponent(BotonSalir))
                        .addGap(55, 55, 55))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextoBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextoBuscarActionPerformed

    private void BotonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGuardarActionPerformed
        if (this.TextoDni.getText()!=""&& this.TextoNombre.getText()!="") {
            Socio texto=null;
            texto.setdni(this.TextoDni.getText());
            texto.setNombre(this.TextoNombre.getText());
        try {
            socioDao.add(texto);
        } catch (Exception ex) {
            
        }
            }else{
            System.out.println("No poner valores nulos");
        }
        
       try {
           refresh();
       } catch (Exception ex) {
           Logger.getLogger(FrameSocio.class.getName()).log(Level.SEVERE, null, ex);
       }
            
  
    }//GEN-LAST:event_BotonGuardarActionPerformed

    private void BotonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSalirActionPerformed
       dispose();
    }//GEN-LAST:event_BotonSalirActionPerformed

    private void TextoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextoNombreActionPerformed

    private void BotonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBorrarActionPerformed
      this.TextoDni.setText("");
      this.TextoNombre.setText("");
      this.TextoId.setText("");
      this.TextoBuscar.setText("");
      
    }//GEN-LAST:event_BotonBorrarActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
            int aux= Integer.parseInt(this.TextoBuscar.getText());
        try {
            Socio e=socioDao.find(aux);
            this.TextoId.setText(e.getId()+"");
            this.TextoDni.setText(e.getDni());
            this.TextoNombre.setText(e.getNombre());
        } catch (Exception ex) {
            Logger.getLogger(FrameSocio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        //this.jTable1.getSelectionModel().addListSelectionListener(this.jTable1.getSelectedRow());
        
        
    }//GEN-LAST:event_jTable1MouseClicked
//    this.jTable1.addMouseListener(){
//        new MouseAdapter{
//            public void mouse clicked(){
//                int row= table.getSelectedRow();
//            }
//        }
//    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameSocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameSocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameSocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameSocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameSocio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonBorrar;
    private javax.swing.JButton BotonGuardar;
    private javax.swing.JButton BotonSalir;
    private javax.swing.JTextField TextoBuscar;
    private javax.swing.JTextField TextoDni;
    private javax.swing.JTextField TextoId;
    private javax.swing.JTextField TextoNombre;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
