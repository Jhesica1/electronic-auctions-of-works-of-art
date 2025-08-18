package proyectofinal;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author JANDY
 */
public class v1 extends javax.swing.JFrame{

     v2 v2=new v2();
     v3 v3=new v3();
     String nom;
     String pat;
     String mat;
     String correo;
     private String tipoC,auten;
     private ArchExpositor archExpositor = new ArchExpositor();
     private ArchivoComprador archiComprador = new ArchivoComprador();
     private Expositor expositor;
     Admin admin=new Admin ();    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(v1.class.getName());

    /**
     * Creates new form interfaz1
     */
    public v1() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        TABLA_COMP = new javax.swing.JTable();
        TABLA_EXP = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lb_Login = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        AGREGAR_NOMBRE = new javax.swing.JTextField();
        AGREGAR_CONTRASEÑA = new javax.swing.JPasswordField();
        TipoU = new javax.swing.JComboBox<>();
        btn_Registrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        AGREGAR_PATERNO = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        AGREGAR_MATERNO = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        AGREGAR_CORREO = new javax.swing.JTextField();
        btn_Ingresar1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        TABLA_COMP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "NOMBRE", "PATERNO", "MATERNO", "CORREO", "CONTRASEÑA", "TIPO DE PAGO"
            }
        ));

        TABLA_EXP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "NOMBRE", "PATERNO", "MATERNO", "AUTEN", "CORREO"
            }
        ));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(350, 120));
        setMaximumSize(new java.awt.Dimension(646, 390));
        setMinimumSize(new java.awt.Dimension(646, 390));
        setPreferredSize(new java.awt.Dimension(646, 450));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(29, 32, 63));

        jPanel2.setBackground(new java.awt.Color(81, 170, 204));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, new java.awt.Color(204, 204, 204), java.awt.Color.white, java.awt.Color.white));

        lb_Login.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        lb_Login.setForeground(new java.awt.Color(255, 255, 255));
        lb_Login.setText("Login");

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Usuario:");

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Correo:");

        AGREGAR_NOMBRE.setBackground(new java.awt.Color(149, 187, 201));
        AGREGAR_NOMBRE.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        AGREGAR_NOMBRE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AGREGAR_NOMBREActionPerformed(evt);
            }
        });

        AGREGAR_CONTRASEÑA.setBackground(new java.awt.Color(149, 187, 201));
        AGREGAR_CONTRASEÑA.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        AGREGAR_CONTRASEÑA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AGREGAR_CONTRASEÑAActionPerformed(evt);
            }
        });

        TipoU.setBackground(new java.awt.Color(149, 187, 201));
        TipoU.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        TipoU.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Comprador", "Expositor", "Admin" }));
        TipoU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipoUActionPerformed(evt);
            }
        });

        btn_Registrar.setBackground(new java.awt.Color(150, 150, 150));
        btn_Registrar.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btn_Registrar.setForeground(new java.awt.Color(51, 51, 51));
        btn_Registrar.setText("Registrar");
        btn_Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegistrarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Paterno:");

        AGREGAR_PATERNO.setBackground(new java.awt.Color(149, 187, 201));
        AGREGAR_PATERNO.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Materno:");

        AGREGAR_MATERNO.setBackground(new java.awt.Color(149, 187, 201));
        AGREGAR_MATERNO.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        AGREGAR_MATERNO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AGREGAR_MATERNOActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Contraseña:");

        AGREGAR_CORREO.setBackground(new java.awt.Color(149, 187, 201));
        AGREGAR_CORREO.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        AGREGAR_CORREO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AGREGAR_CORREOActionPerformed(evt);
            }
        });

        btn_Ingresar1.setBackground(new java.awt.Color(150, 150, 150));
        btn_Ingresar1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btn_Ingresar1.setForeground(new java.awt.Color(51, 51, 51));
        btn_Ingresar1.setText("Ingresar");
        btn_Ingresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Ingresar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TipoU, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AGREGAR_NOMBRE)
                            .addComponent(AGREGAR_CONTRASEÑA)
                            .addComponent(AGREGAR_PATERNO)
                            .addComponent(AGREGAR_MATERNO)
                            .addComponent(AGREGAR_CORREO)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(lb_Login)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 19, Short.MAX_VALUE)
                .addComponent(btn_Ingresar1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_Login)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TipoU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(AGREGAR_NOMBRE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(AGREGAR_PATERNO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AGREGAR_MATERNO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AGREGAR_CORREO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(AGREGAR_CONTRASEÑA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Ingresar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinal/IMAGEN_LOGO.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel7)))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AGREGAR_NOMBREActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AGREGAR_NOMBREActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AGREGAR_NOMBREActionPerformed

    private void TipoUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipoUActionPerformed
        
    }//GEN-LAST:event_TipoUActionPerformed
    

    private void btn_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegistrarActionPerformed
            String tipoUsuario = TipoU.getSelectedItem().toString().toUpperCase();
            String nombre = AGREGAR_NOMBRE.getText(); 
            String contraseña = new String(AGREGAR_CONTRASEÑA.getPassword()); 
            

            switch(tipoUsuario) {
                case "COMPRADOR":
                    try{
                        nom = AGREGAR_NOMBRE.getText().trim();
                        pat = AGREGAR_PATERNO.getText().trim();
                        mat = AGREGAR_MATERNO.getText().trim();
                        correo = AGREGAR_CORREO.getText().trim();
                        


                        archiComprador.adicionar(nom, pat, mat,correo);
                        JOptionPane.showMessageDialog(this,"Registrado!");

                        DefaultTableModel modelo= (DefaultTableModel)TABLA_COMP.getModel();
                        Object[] fila={nom, pat, mat,correo};
                        modelo.addRow(fila);

                        AGREGAR_NOMBRE.setText("");
                        AGREGAR_PATERNO.setText("");
                        AGREGAR_MATERNO.setText("");
                        AGREGAR_CORREO.setText("");
                        AGREGAR_CONTRASEÑA.setText("");

                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(this, "Error al agregar comprador: " + e.getMessage());
                    }
                    v2.setV1(this);  
                    v2.setVisible(true);
                    this.setVisible(false);
                    break;

                case "EXPOSITOR":
                    try{
                        nom = AGREGAR_NOMBRE.getText().trim();
                        pat = AGREGAR_PATERNO.getText().trim();
                        mat = AGREGAR_MATERNO.getText().trim();
                        correo = AGREGAR_CORREO.getText().trim();
                        


                        archExpositor.adicionar(nom, pat, mat,correo);
                        JOptionPane.showMessageDialog(this,"Registrado!");

                        DefaultTableModel modelo= (DefaultTableModel)TABLA_EXP.getModel();
                        Object[] fila={nom, pat, mat,correo};
                        modelo.addRow(fila);

                        AGREGAR_NOMBRE.setText("");
                        AGREGAR_PATERNO.setText("");
                        AGREGAR_MATERNO.setText("");
                        AGREGAR_CORREO.setText("");
                        AGREGAR_CONTRASEÑA.setText("");

                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(this, "Error al agregar expositor: " + e.getMessage());
                    }
                    v3.setV1(this);
                    v3.setVisible(true);
                    this.setVisible(false);
                    break;

                case "ADMIN":
                    if ("ADMIN1".equals(nombre) && "123".equals(contraseña)) {
                        admin.setV1(this);
                        admin.setVisible(true);
                        this.setVisible(false);
                    }
                    break;
            }

    
    }//GEN-LAST:event_btn_RegistrarActionPerformed

    private void AGREGAR_CONTRASEÑAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AGREGAR_CONTRASEÑAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AGREGAR_CONTRASEÑAActionPerformed

    private void AGREGAR_MATERNOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AGREGAR_MATERNOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AGREGAR_MATERNOActionPerformed

    private void AGREGAR_CORREOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AGREGAR_CORREOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AGREGAR_CORREOActionPerformed

    private void btn_Ingresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Ingresar1ActionPerformed
        // TODO add your handling code here:
        String tipoUsuario = TipoU.getSelectedItem().toString().toUpperCase();
        String nombre = AGREGAR_NOMBRE.getText(); 
        String contraseña = new String(AGREGAR_CONTRASEÑA.getPassword()); 
    
        switch(tipoUsuario) {
            case "COMPRADOR":
                try {
                    nom = AGREGAR_NOMBRE.getText().trim();
                    pat = AGREGAR_PATERNO.getText().trim();
                    mat = AGREGAR_MATERNO.getText().trim();

                    if (archiComprador.buscarComprador(nom, pat, mat)) {
                        v2.setV1(this);  
                        v2.setVisible(true);
                        this.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Credenciales incorrectas o comprador no registrado.");
                    }
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(this, "Error al validar comprador: " + e.getMessage());
                }
                break;

            case "EXPOSITOR":
                try {
                    nom = AGREGAR_NOMBRE.getText().trim();
                    pat = AGREGAR_PATERNO.getText().trim();
                    mat = AGREGAR_MATERNO.getText().trim();

                    if (archExpositor.buscarExpositor(nom, pat, mat)) {
                        v3.setV1(this);
                        v3.setVisible(true);
                        this.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Credenciales incorrectas o comprador no registrado.");
                    }
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(this, "Error al validar comprador: " + e.getMessage());
                }
                break;
                

            case "ADMIN":
                if ("ADMIN1".equals(nombre) && "123".equals(contraseña)) {
                    admin.setV1(this);
                    admin.setVisible(true);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciales de administrador incorrectas.");
                }
                break;
        }
        
        
    }//GEN-LAST:event_btn_Ingresar1ActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new v1().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField AGREGAR_CONTRASEÑA;
    private javax.swing.JTextField AGREGAR_CORREO;
    private javax.swing.JTextField AGREGAR_MATERNO;
    private javax.swing.JTextField AGREGAR_NOMBRE;
    private javax.swing.JTextField AGREGAR_PATERNO;
    private javax.swing.JTable TABLA_COMP;
    private javax.swing.JTable TABLA_EXP;
    private javax.swing.JComboBox<String> TipoU;
    private javax.swing.JButton btn_Ingresar1;
    private javax.swing.JButton btn_Registrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lb_Login;
    // End of variables declaration//GEN-END:variables

    

     
  
}
