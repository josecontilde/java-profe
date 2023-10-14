
package views;


import Conexion.Conexion;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class viewOperacion extends javax.swing.JFrame {
    Conexion cx = new Conexion("profesorroberto");
    DefaultComboBoxModel modeloBox;
    
    
    public viewOperacion() {
        initComponents();
        this.txtBienvenida.setText("BIENVENIDO ROBERTO :) ");
        this.setLocationRelativeTo(null);
        /*try {
            String queryCount="select count(nombre) from instituto";
            Statement st = cx.conectar().createStatement();
            ResultSet rsc = st.executeQuery(queryCount);
            int total;
            if(rsc.next()){
                total = rsc.getInt(1);
            }
            else{
                total = 0;
                JOptionPane.showMessageDialog(null, "ERROR EN EL CONTEO");
                rsc.close();
            }
            
            
            String query="select nombre from instituto";
            try (ResultSet rsq = st.executeQuery(query)) {
                String[] insti =new String[total];
                int count = 0;
                while(rsq.next()){
                    
                    insti[count]=rsq.getString(1);
                    count++;
                }
                modeloBox = new DefaultComboBoxModel(insti);
                cmbInsti.setModel(modeloBox);
            }
        } catch (Exception e) {
            System.out.println("error: "+e);
            JOptionPane.showMessageDialog(null, "ERROR - "+e);
        }*/
        
    }
    private int count(String tabla, String valor){
        String queryCount="select count(distinct("+valor+")) from "+tabla;
        
        int total=0;
        try{
            Statement st = cx.conectar().createStatement();
            ResultSet rsc = st.executeQuery(queryCount);
            if(rsc.next()){
                total = rsc.getInt(1);
                if(total==0)
                    total++;
            }
            else{
                total = 0;
                JOptionPane.showMessageDialog(null, "ERROR EN EL CONTEO");
                rsc.close();
            }
            
        }catch(Exception e){
            
        }
        return total;
    }
    private int countCurso(String nombreInsti, String valor, String estado){
        
        String queryCount="select count(distinct(curso."+valor+")) from instituto "
                + "inner join curso "
                + "on instituto.id = curso.id_insti "
                + "where curso.estado= '"+estado+"' and "
                + "instituto.nombre = '"+nombreInsti+"' ";
        int total=0;
        try{
            Statement st = cx.conectar().createStatement();
            ResultSet rsc = st.executeQuery(queryCount);
            if(rsc.next()){
                total = rsc.getInt(1);
                if(total==0)
                    total++;
            }
            else{
                total = 0;
                JOptionPane.showMessageDialog(null, "ERROR EN EL CONTEO");
                rsc.close();
            }
            
        }catch(Exception e){
            
        }
        return total;
    }
    private int countSemestre(String curso, String insti){
        
        String queryCount="SELECT count(distinct(curso.semestre)) FROM curso "
                + "INNER JOIN instituto "
                + "on instituto.id = curso.id_insti "
                + "WHERE instituto.nombre = '"+insti+"' and "
                + "curso.nombre='"+curso+"' ";
        int total=0;
        try{
            Statement st = cx.conectar().createStatement();
            ResultSet rsc = st.executeQuery(queryCount);
            if(rsc.next()){
                total = rsc.getInt(1);
                if(total==0)
                    total++;
            }
            else{
                total = 0;
                JOptionPane.showMessageDialog(null, "ERROR EN EL CONTEO");
                rsc.close();
            }
            
        }catch(Exception e){
            
        }
        return total;
    }
    public void buscarValor(javax.swing.JComboBox comboBox ,String valor ,String tabla){
        try {
            Statement st = cx.conectar().createStatement();
            String query="select "+valor+" from "+tabla+" ";
            try (ResultSet rsq = st.executeQuery(query)) {
                String[] valores =new String[count(tabla, valor)];
                int count = 0;
                while(rsq.next()){
                    valores[count]=rsq.getString(1);
                    count++;
                    
                }
                
                modeloBox = new DefaultComboBoxModel(valores);
                comboBox.setModel(modeloBox);
            }catch (Exception e){
                System.out.println("error: "+e);
                JOptionPane.showMessageDialog(null, "ERROR OBTENER VALORES DE ComboBox - "+e);
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println("error: "+e);
            JOptionPane.showMessageDialog(null, "ERROR ENTRAR BASE DE DATOS - "+e);
        }
        
        //Eliminamos combobox
//        String[] clear= new String[10];
//        for(int i=0;i<10;i++){
//            clear[i]="";
//            
//        }modeloBox = new DefaultComboBoxModel(clear);
//        comboBox.setModel(modeloBox);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtBienvenida = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cmbInsti = new javax.swing.JComboBox<>();
        btnactualizarInsti = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cmbCurso = new javax.swing.JComboBox<>();
        btnVer = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        cmbSemestre = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Insti/Uni:");

        cmbInsti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbInstiActionPerformed(evt);
            }
        });

        btnactualizarInsti.setText("Actualizar");
        btnactualizarInsti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarInstiActionPerformed(evt);
            }
        });

        jLabel1.setText("Curso:");

        cmbCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCursoActionPerformed(evt);
            }
        });

        btnVer.setText("Gestionar");
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel3.setText("Semestre");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbInsti, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnactualizarInsti)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVer)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbInsti, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnactualizarInsti))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                        .addComponent(btnAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(btnVer)
                        .addGap(21, 21, 21))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(370, Short.MAX_VALUE)
                .addComponent(txtBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(166, 166, 166))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        viewAgregar vagre = new viewAgregar();
        vagre.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        // TODO add your handling code here:
        viewVer vver = new viewVer();
        vver.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVerActionPerformed

    private void btnactualizarInstiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarInstiActionPerformed
        // TODO add your handling code here:
        try {
            Statement st = cx.conectar().createStatement();
            String query="select nombre from instituto";
            try (ResultSet rsq = st.executeQuery(query)) {
                String[] insti =new String[count("instituto","id")];
                int count = 0;
                while(rsq.next()){
                    
                    insti[count]=rsq.getString(1);
                    count++;
                    
                }
                
                modeloBox = new DefaultComboBoxModel(insti);
                cmbInsti.setModel(modeloBox);
            }
        } catch (Exception e) {
            System.out.println("error: "+e);
            JOptionPane.showMessageDialog(null, "ERROR - "+e);
        }
        
        //Eliminamos combobox
        String[] clear= new String[10];
        for(int i=0;i<10;i++){
            clear[i]="";
            
        }modeloBox = new DefaultComboBoxModel(clear);
        cmbCurso.setModel(modeloBox);
        cmbSemestre.setModel(modeloBox);
    }//GEN-LAST:event_btnactualizarInstiActionPerformed

    private void cmbInstiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbInstiActionPerformed
        // TODO add your handling code here:
        String insti = String.valueOf(cmbInsti.getSelectedItem());
        String[] curso = new String[countCurso(insti, "nombre", "a")];
        try {
            
            String query="SELECT distinct(curso.nombre) "
                    + "FROM curso INNER JOIN instituto "
                    + "on instituto.id = curso.id_insti "
                    + "where instituto.nombre like '%"+insti+"%' and "
                    + "curso.estado ='a'";
            Statement st = cx.conectar().createStatement();
            ResultSet rs = st.executeQuery(query);
            int count = 0;
            while(rs.next()){
            curso[count]=rs.getString(1);
            count++;
            }
            
            modeloBox = new DefaultComboBoxModel(curso);
            cmbCurso.setModel(modeloBox);
            
        } catch (Exception e) {
            System.out.println("error cmb: "+e);
            JOptionPane.showMessageDialog(null, "ERROR - "+e);
        }

    }//GEN-LAST:event_cmbInstiActionPerformed

    private void cmbCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCursoActionPerformed
//        // TODO add your handling code here:
        String insti = String.valueOf(cmbInsti.getSelectedItem());
        String curso = String.valueOf(cmbCurso.getSelectedItem());
        String[] semestre = new String[countSemestre(curso, insti)];
        try {
            
            String query="SELECT DISTINCT(curso.semestre) "
                    + "FROM curso INNER JOIN instituto "
                    + "on instituto.id = curso.id_insti "
                    + "where instituto.nombre like '%"+insti+"%' and "
                    + "curso.nombre like '%"+curso+"%' and curso.estado ='a'";
            Statement st = cx.conectar().createStatement();
            ResultSet rs = st.executeQuery(query);
            int count = 0;
            while(rs.next()){
            semestre[count]=rs.getString(1);
            count++;
            }
            
            modeloBox = new DefaultComboBoxModel(semestre);
            cmbSemestre.setModel(modeloBox);
            
        } catch (Exception e) {
            System.out.println("error cmb: "+e);
            JOptionPane.showMessageDialog(null, "ERROR - "+e);
        }
    }//GEN-LAST:event_cmbCursoActionPerformed

    
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
            java.util.logging.Logger.getLogger(viewOperacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewOperacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewOperacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewOperacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewOperacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnVer;
    private javax.swing.JButton btnactualizarInsti;
    private javax.swing.JComboBox<String> cmbCurso;
    private javax.swing.JComboBox<String> cmbInsti;
    private javax.swing.JComboBox<String> cmbSemestre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel txtBienvenida;
    // End of variables declaration//GEN-END:variables
}
