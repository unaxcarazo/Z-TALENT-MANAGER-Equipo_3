/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package s.z_talent_manager.vista;

/**
 *
 * @author DAW1
 */
public class FrmAdminCrearUsuario extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmAdminCrearUsuario.class.getName());

    /**
     * Creates new form FrmCrearUsuarioPrueba
     */
    public FrmAdminCrearUsuario() {
        initComponents();

        // ContentPane responsivo
        getContentPane().setLayout(new java.awt.BorderLayout());
        getContentPane().add(pnlPrincipal, java.awt.BorderLayout.CENTER);
        pnlPrincipal.setPreferredSize(null);
        pnlHeader.setPreferredSize(null);

        // Centrar en pantalla
        setSize(700, 600);
        java.awt.Dimension pantalla = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((pantalla.width - getWidth()) / 2, (pantalla.height - getHeight()) / 2);
        setResizable(true);

        // Reemplazar AbsoluteLayout por GridBagLayout responsivo
        pnlCentral.removeAll();
        pnlCentral.setLayout(new java.awt.GridBagLayout());
        pnlCentral.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 60, 30, 60));

        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.insets = new java.awt.Insets(8, 10, 8, 10);
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        java.awt.Color bgField = new java.awt.Color(248, 253, 249);
        java.awt.Color borderColor = new java.awt.Color(184, 240, 212);
        java.awt.Font lblFont = new java.awt.Font("SansSerif", 1, 14);
        java.awt.Color lblColor = new java.awt.Color(7, 48, 26);

        // Estilo campos
        for (javax.swing.JTextField txt : new javax.swing.JTextField[]{
            txtNombre, txtApellidos, txtNomUsu, txtCorreo,
            txtRepCorreo, txtCreaContr, txtRepContr}) {
            txt.setBackground(bgField);
            txt.setBorder(javax.swing.BorderFactory.createLineBorder(borderColor));
            txt.setMargin(new java.awt.Insets(5, 10, 5, 10));
            txt.setPreferredSize(new java.awt.Dimension(0, 35));
        }

        // Estilo labels
        for (javax.swing.JLabel lbl : new javax.swing.JLabel[]{
            lblNombre, lblApellidos, lblNomUsu, lblCorreo,
            lblRepCorreo, lblCreaContr, lblRepContr}) {
            lbl.setFont(lblFont);
            lbl.setForeground(lblColor);
        }

        // ── Fila 0: Nombre | Apellidos ──
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        pnlCentral.add(lblNombre, gbc);
        gbc.gridx = 1;
        pnlCentral.add(lblApellidos, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        pnlCentral.add(txtNombre, gbc);
        gbc.gridx = 1;
        pnlCentral.add(txtApellidos, gbc);

        // ── Fila 2: Nombre Usuario (ocupa las 2 columnas) ──
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        pnlCentral.add(lblNomUsu, gbc);
        gbc.gridy = 3;
        pnlCentral.add(txtNomUsu, gbc);

        // ── Fila 4: Correo | Repite Correo ──
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 4;
        pnlCentral.add(lblCorreo, gbc);
        gbc.gridx = 1;
        pnlCentral.add(lblRepCorreo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        pnlCentral.add(txtCorreo, gbc);
        gbc.gridx = 1;
        pnlCentral.add(txtRepCorreo, gbc);

        // ── Fila 6: Contraseña | Repite Contraseña ──
        gbc.gridx = 0;
        gbc.gridy = 6;
        pnlCentral.add(lblCreaContr, gbc);
        gbc.gridx = 1;
        pnlCentral.add(lblRepContr, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        pnlCentral.add(txtCreaContr, gbc);
        gbc.gridx = 1;
        pnlCentral.add(txtRepContr, gbc);

        // ── Fila 8: Botón centrado ──
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.fill = java.awt.GridBagConstraints.NONE;
        gbc.anchor = java.awt.GridBagConstraints.CENTER;
        btnCrearCuenta.setPreferredSize(new java.awt.Dimension(160, 40));
        btnCrearCuenta.setBackground(new java.awt.Color(51, 153, 102));
        btnCrearCuenta.setForeground(java.awt.Color.WHITE);
        btnCrearCuenta.setFont(new java.awt.Font("SansSerif", 1, 14));
        pnlCentral.add(btnCrearCuenta, gbc);

        // Acción botón Crear Cuenta
        btnCrearCuenta.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearCandidato();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        bntVolver = new javax.swing.JButton();
        pnlCentral = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblApellidos = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        lblNomUsu = new javax.swing.JLabel();
        txtNomUsu = new javax.swing.JTextField();
        lblCorreo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        lblRepCorreo = new javax.swing.JLabel();
        txtRepCorreo = new javax.swing.JTextField();
        lblCreaContr = new javax.swing.JLabel();
        txtCreaContr = new javax.swing.JTextField();
        lblRepContr = new javax.swing.JLabel();
        txtRepContr = new javax.swing.JTextField();
        btnCrearCuenta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlPrincipal.setBackground(new java.awt.Color(211, 254, 234));
        pnlPrincipal.setLayout(new java.awt.BorderLayout());

        pnlHeader.setBackground(new java.awt.Color(255, 255, 255));
        pnlHeader.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(184, 240, 212)));
        pnlHeader.setPreferredSize(new java.awt.Dimension(769, 110));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo.png"))); // NOI18N
        lblLogo.setPreferredSize(new java.awt.Dimension(400, 100));

        bntVolver.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        bntVolver.setForeground(new java.awt.Color(51, 153, 102));
        bntVolver.setText("VOLVER");
        bntVolver.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 102)));
        bntVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                .addComponent(bntVolver)
                .addGap(103, 103, 103))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHeaderLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlHeaderLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(bntVolver)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(23, 23, 23))
        );

        pnlPrincipal.add(pnlHeader, java.awt.BorderLayout.PAGE_START);

        pnlCentral.setBackground(new java.awt.Color(211, 254, 234));
        pnlCentral.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(184, 240, 212), 1, true));
        pnlCentral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombre.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(7, 48, 26));
        lblNombre.setText("Nombre :");
        lblNombre.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblNombre.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlCentral.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        txtNombre.setBackground(new java.awt.Color(248, 253, 249));
        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(184, 240, 212)));
        txtNombre.setMargin(new java.awt.Insets(5, 10, 5, 10));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        pnlCentral.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 150, 30));

        lblApellidos.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblApellidos.setForeground(new java.awt.Color(7, 48, 26));
        lblApellidos.setText("Apellidos :");
        lblApellidos.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblApellidos.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlCentral.add(lblApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, -1, -1));

        txtApellidos.setBackground(new java.awt.Color(248, 253, 249));
        txtApellidos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(184, 240, 212)));
        txtApellidos.setMargin(new java.awt.Insets(5, 10, 5, 10));
        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });
        pnlCentral.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 150, 30));

        lblNomUsu.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblNomUsu.setForeground(new java.awt.Color(7, 48, 26));
        lblNomUsu.setText("Nombre Usuario :");
        lblNomUsu.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblNomUsu.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlCentral.add(lblNomUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        txtNomUsu.setBackground(new java.awt.Color(248, 253, 249));
        txtNomUsu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(184, 240, 212)));
        txtNomUsu.setMargin(new java.awt.Insets(5, 10, 5, 10));
        txtNomUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomUsuActionPerformed(evt);
            }
        });
        pnlCentral.add(txtNomUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 150, 30));

        lblCorreo.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblCorreo.setForeground(new java.awt.Color(7, 48, 26));
        lblCorreo.setText("Correo electrónico :");
        lblCorreo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblCorreo.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlCentral.add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        txtCorreo.setBackground(new java.awt.Color(248, 253, 249));
        txtCorreo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(184, 240, 212)));
        txtCorreo.setMargin(new java.awt.Insets(5, 10, 5, 10));
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        pnlCentral.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 210, 30));

        lblRepCorreo.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblRepCorreo.setForeground(new java.awt.Color(7, 48, 26));
        lblRepCorreo.setText("Repite Correo electrónico :");
        lblRepCorreo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblRepCorreo.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlCentral.add(lblRepCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, -1, -1));

        txtRepCorreo.setBackground(new java.awt.Color(248, 253, 249));
        txtRepCorreo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(184, 240, 212)));
        txtRepCorreo.setMargin(new java.awt.Insets(5, 10, 5, 10));
        txtRepCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRepCorreoActionPerformed(evt);
            }
        });
        pnlCentral.add(txtRepCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 220, 30));

        lblCreaContr.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblCreaContr.setForeground(new java.awt.Color(7, 48, 26));
        lblCreaContr.setText("Crear Contraseña : ");
        lblCreaContr.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblCreaContr.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlCentral.add(lblCreaContr, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        txtCreaContr.setBackground(new java.awt.Color(248, 253, 249));
        txtCreaContr.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(184, 240, 212)));
        txtCreaContr.setMargin(new java.awt.Insets(5, 10, 5, 10));
        txtCreaContr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCreaContrActionPerformed(evt);
            }
        });
        pnlCentral.add(txtCreaContr, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 210, 30));

        lblRepContr.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblRepContr.setForeground(new java.awt.Color(7, 48, 26));
        lblRepContr.setText("Repite Contraseña :");
        lblRepContr.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblRepContr.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlCentral.add(lblRepContr, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, -1, -1));

        txtRepContr.setBackground(new java.awt.Color(248, 253, 249));
        txtRepContr.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(184, 240, 212)));
        txtRepContr.setMargin(new java.awt.Insets(5, 10, 5, 10));
        txtRepContr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRepContrActionPerformed(evt);
            }
        });
        pnlCentral.add(txtRepContr, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 220, 30));

        btnCrearCuenta.setBackground(new java.awt.Color(51, 153, 102));
        btnCrearCuenta.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnCrearCuenta.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearCuenta.setText("Crear Cuenta");
        btnCrearCuenta.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnCrearCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrearCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCuentaActionPerformed(evt);
            }
        });
        pnlCentral.add(btnCrearCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 370, -1, -1));

        pnlPrincipal.add(pnlCentral, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1062, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 536, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setSize(new java.awt.Dimension(1078, 545));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bntVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_bntVolverActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void txtNomUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomUsuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomUsuActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtRepCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRepCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRepCorreoActionPerformed

    private void txtCreaContrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCreaContrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCreaContrActionPerformed

    private void txtRepContrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRepContrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRepContrActionPerformed

    private void btnCrearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCrearCuentaActionPerformed

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
    }

    private void crearCandidato() {
        // Validaciones básicas
        if (txtNombre.getText().isBlank() || txtApellidos.getText().isBlank()
                || txtCorreo.getText().isBlank() || txtCreaContr.getText().isBlank()) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Por favor rellena todos los campos obligatorios.",
                    "Campos vacíos", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!txtCorreo.getText().equals(txtRepCorreo.getText())) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Los correos no coinciden.",
                    "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!txtCreaContr.getText().equals(txtRepContr.getText())) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Las contraseñas no coinciden.",
                    "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            jakarta.persistence.EntityManager em
                    = s.z_talent_manager.util.JPAUtil.getEntityManager();

            // ✅ Verificar si el email ya existe usando tu UsuarioDAO
            s.z_talent_manager.dao.UsuarioDAO usuarioDao
                    = new s.z_talent_manager.dao.Usuarioimpl();
            s.z_talent_manager.modelo.Usuario usuarioExistente
                    = usuarioDao.getUsuarioPorEmail(em, txtCorreo.getText().trim());

            if (usuarioExistente != null) {
                javax.swing.JOptionPane.showMessageDialog(this,
                        "Ya existe un usuario con ese correo electrónico.",
                        "Email duplicado", javax.swing.JOptionPane.WARNING_MESSAGE);
                em.close();
                return;
            }

            // ✅ Crear objeto Candidato
            s.z_talent_manager.modelo.Candidato candidato
                    = new s.z_talent_manager.modelo.Candidato();
            candidato.setNombre(txtNombre.getText().trim());
            candidato.setApellidos(txtApellidos.getText().trim());
            candidato.setEmail(txtCorreo.getText().trim());
            candidato.setContraseña(txtCreaContr.getText().trim());
            candidato.setAdministrador(false);
            candidato.setFechaCreacion(java.time.LocalDate.now());

            // ✅ Guardar en BD
            jakarta.persistence.EntityTransaction tx = em.getTransaction();
            tx.begin();
            s.z_talent_manager.dao.CandidatoDAO dao
                    = new s.z_talent_manager.dao.CandidatoImpl();
            dao.nuevoCandidato(em, candidato);
            tx.commit();
            em.close();

            javax.swing.JOptionPane.showMessageDialog(this,
                    "Candidato creado correctamente.",
                    "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            this.dispose();

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Error al crear el candidato: " + e.getMessage(),
                    "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntVolver;
    private javax.swing.JButton btnCrearCuenta;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblCreaContr;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNomUsu;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRepContr;
    private javax.swing.JLabel lblRepCorreo;
    private javax.swing.JPanel pnlCentral;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtCreaContr;
    private javax.swing.JTextField txtNomUsu;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRepContr;
    private javax.swing.JTextField txtRepCorreo;
    // End of variables declaration//GEN-END:variables
}
