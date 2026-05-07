/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package s.z_talent_manager.vista;

/**
 *
 * @author DAW1
 */
public class FrmPanelAdmin extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmPanelAdmin.class.getName());

    /**
     * Creates new form Prueba2
     */
    public FrmPanelAdmin() {
        initComponents();
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);

        // ContentPane ocupa todo
        getContentPane().setLayout(new java.awt.BorderLayout());
        getContentPane().add(pnlPrincipal, java.awt.BorderLayout.CENTER);
        pnlPrincipal.setPreferredSize(null);
        pnlHeader.setPreferredSize(null);

        // Quitar los paneles que vamos a reorganizar
        pnlPrincipal.remove(pnlHeader);
        pnlPrincipal.remove(pnlCentral);
        pnlPrincipal.remove(pnlContenido);

        // Panel superior ÚNICO
        javax.swing.JPanel pnlNorth = new javax.swing.JPanel(new java.awt.BorderLayout());
        pnlNorth.setBackground(new java.awt.Color(211, 254, 234));
        pnlNorth.add(pnlHeader, java.awt.BorderLayout.NORTH);

        javax.swing.JPanel pnlMid = new javax.swing.JPanel();
        pnlMid.setLayout(new javax.swing.BoxLayout(pnlMid, javax.swing.BoxLayout.Y_AXIS));
        pnlMid.setBackground(new java.awt.Color(211, 254, 234));
        pnlMid.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 30, 10, 30));

        lblBienvenida.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        pnlMid.add(lblBienvenida);

        javax.swing.JPanel pnlSearchWrapper = new javax.swing.JPanel(
                new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 8));
        pnlSearchWrapper.setBackground(new java.awt.Color(211, 254, 234));
        txtSearch.setPreferredSize(new java.awt.Dimension(500, 36));
        pnlSearchWrapper.add(txtSearch);
        pnlMid.add(pnlSearchWrapper);

        javax.swing.JPanel pnlBtnWrapper = new javax.swing.JPanel(
                new java.awt.FlowLayout(java.awt.FlowLayout.CENTER));
        pnlBtnWrapper.setBackground(new java.awt.Color(211, 254, 234));
        bntCrearCandidato.setPreferredSize(new java.awt.Dimension(160, 40));
        pnlBtnWrapper.add(bntCrearCandidato);
        pnlMid.add(pnlBtnWrapper);

        pnlNorth.add(pnlMid, java.awt.BorderLayout.CENTER);

        // FIX TOGGLES - tamaño fijo para que quepan de 2 en 2
        java.awt.Dimension tglSize = new java.awt.Dimension(120, 26);
        tglJavaScript.setPreferredSize(tglSize);
        tglJavaScript.setMaximumSize(tglSize);
        tglPython.setPreferredSize(tglSize);
        tglPython.setMaximumSize(tglSize);
        tglReact.setPreferredSize(tglSize);
        tglReact.setMaximumSize(tglSize);
        tglNoode.setPreferredSize(tglSize);
        tglNoode.setMaximumSize(tglSize);
        tglJavaSql.setPreferredSize(tglSize);
        tglJavaSql.setMaximumSize(tglSize);
        tglApache.setPreferredSize(tglSize);
        tglApache.setMaximumSize(tglSize);
        tglAws.setPreferredSize(tglSize);
        tglAws.setMaximumSize(tglSize);
        tglKubernetes.setPreferredSize(tglSize);
        tglKubernetes.setMaximumSize(tglSize);
        tglLinux.setPreferredSize(tglSize);
        tglLinux.setMaximumSize(tglSize);
        tglDocker.setPreferredSize(tglSize);
        tglDocker.setMaximumSize(tglSize);
        tglFigma.setPreferredSize(tglSize);
        tglFigma.setMaximumSize(tglSize);
        tglAdobe.setPreferredSize(tglSize);
        tglAdobe.setMaximumSize(tglSize);
        tglCss.setPreferredSize(tglSize);
        tglCss.setMaximumSize(tglSize);
        tglGoogle.setPreferredSize(tglSize);
        tglGoogle.setMaximumSize(tglSize);
        tglMeta.setPreferredSize(tglSize);
        tglMeta.setMaximumSize(tglSize);
        tglAds.setPreferredSize(tglSize);
        tglAds.setMaximumSize(tglSize);

        // FIX SCROLL - los paneles deben alinearse y expandirse correctamente
        pnlCompTec.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
        pnlIdioma.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
        pnlTituloTr.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
        pnlCompTec.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        pnlIdioma.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        pnlTituloTr.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        pnlDesarrollo.setPreferredSize(new java.awt.Dimension(260, 180));
        pnlDesarrollo.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 180));
        pnlDiseño.setPreferredSize(new java.awt.Dimension(260, 120));
        pnlDiseño.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 120));

        // FIX SCROLL - envolver pnlFiltros en un panel de ancho fijo
        pnlContenido.remove(pnlFiltros);
        pnlFiltros.setPreferredSize(new java.awt.Dimension(270, 800)); // ← ancho fijo, altura grande

        javax.swing.JScrollPane scrollFiltros = new javax.swing.JScrollPane();
        scrollFiltros.setPreferredSize(new java.awt.Dimension(290, 0));
        scrollFiltros.setMinimumSize(new java.awt.Dimension(290, 0));
        scrollFiltros.setHorizontalScrollBarPolicy(
                javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollFiltros.setVerticalScrollBarPolicy(
                javax.swing.JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollFiltros.setBorder(javax.swing.BorderFactory.createLineBorder(
                new java.awt.Color(184, 240, 212)));
        scrollFiltros.getVerticalScrollBar().setUnitIncrement(16);
        scrollFiltros.setViewportView(pnlFiltros); // ← asignar DESPUÉS de crear el scroll

        pnlContenido.setPreferredSize(null);
        pnlContenido.add(scrollFiltros, java.awt.BorderLayout.WEST);

        tablaContenidos.setPreferredSize(null);
        tablaContenidos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);

        pnlPrincipal.add(pnlNorth, java.awt.BorderLayout.NORTH);
        pnlPrincipal.add(pnlContenido, java.awt.BorderLayout.CENTER);

        // Placeholder Search
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                if (txtSearch.getText().equals("Search...")) {
                    txtSearch.setText("");
                    txtSearch.setForeground(new java.awt.Color(7, 48, 26));
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (txtSearch.getText().isBlank()) {
                    txtSearch.setText("Search...");
                    txtSearch.setForeground(new java.awt.Color(74, 122, 96));
                }
            }
        });

        // Filtro en tiempo real
        javax.swing.table.TableRowSorter<javax.swing.table.DefaultTableModel> sorter
                = new javax.swing.table.TableRowSorter<>(
                        (javax.swing.table.DefaultTableModel) tablaContenidos.getModel());
        tablaContenidos.setRowSorter(sorter);

        txtSearch.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            private void filtrar() {
                String texto = txtSearch.getText().trim();
                if (texto.isEmpty() || texto.equals("Search...")) {
                    sorter.setRowFilter(null);
                    return;
                }
                try {
                    sorter.setRowFilter(javax.swing.RowFilter.regexFilter(
                            "(?i)" + java.util.regex.Pattern.quote(texto)));
                } catch (java.util.regex.PatternSyntaxException e) {
                }
            }

            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                filtrar();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                filtrar();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                filtrar();
            }
        });

        cargarTabla();
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
        pnlLogo = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        pnlBotones = new javax.swing.JPanel();
        btnContr = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        pnlCentral = new javax.swing.JPanel();
        lblBienvenida = new javax.swing.JLabel();
        pnlCrearCandidato = new javax.swing.JPanel();
        bntCrearCandidato = new javax.swing.JButton();
        pnlBusqueda = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        pnlContenido = new javax.swing.JPanel();
        pnlFiltros = new javax.swing.JPanel();
        pnlCompTec = new javax.swing.JPanel();
        lblCompTec = new javax.swing.JLabel();
        pnlDesarrollo = new javax.swing.JPanel();
        tglJavaScript = new javax.swing.JToggleButton();
        tglPython = new javax.swing.JToggleButton();
        tglReact = new javax.swing.JToggleButton();
        tglNoode = new javax.swing.JToggleButton();
        tglJavaSql = new javax.swing.JToggleButton();
        tglApache = new javax.swing.JToggleButton();
        tglAws = new javax.swing.JToggleButton();
        tglKubernetes = new javax.swing.JToggleButton();
        tglLinux = new javax.swing.JToggleButton();
        tglDocker = new javax.swing.JToggleButton();
        pnlDiseño = new javax.swing.JPanel();
        tglFigma = new javax.swing.JToggleButton();
        tglAdobe = new javax.swing.JToggleButton();
        tglCss = new javax.swing.JToggleButton();
        tglGoogle = new javax.swing.JToggleButton();
        tglMeta = new javax.swing.JToggleButton();
        tglAds = new javax.swing.JToggleButton();
        pnlIdioma = new javax.swing.JPanel();
        lblIdioma = new javax.swing.JLabel();
        pnlIdiomas = new javax.swing.JPanel();
        chkEusk = new javax.swing.JCheckBox();
        chkEsp = new javax.swing.JCheckBox();
        chkIng = new javax.swing.JCheckBox();
        chkFra = new javax.swing.JCheckBox();
        chkAle = new javax.swing.JCheckBox();
        pnlTituloTr = new javax.swing.JPanel();
        lblTransversales = new javax.swing.JLabel();
        pnlTransversales = new javax.swing.JPanel();
        chkTraEqui = new javax.swing.JCheckBox();
        chkComu = new javax.swing.JCheckBox();
        chkGstTmp = new javax.swing.JCheckBox();
        chkLider = new javax.swing.JCheckBox();
        chkAdap = new javax.swing.JCheckBox();
        chkCrea = new javax.swing.JCheckBox();
        chkPensCrit = new javax.swing.JCheckBox();
        chkAut = new javax.swing.JCheckBox();
        chkReso = new javax.swing.JCheckBox();
        srpnTabla = new javax.swing.JScrollPane();
        tablaContenidos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlPrincipal.setBackground(new java.awt.Color(211, 254, 234));
        pnlPrincipal.setPreferredSize(new java.awt.Dimension(800, 600));
        pnlPrincipal.setLayout(new java.awt.BorderLayout());

        pnlHeader.setBackground(new java.awt.Color(211, 254, 234));
        pnlHeader.setPreferredSize(new java.awt.Dimension(1100, 90));
        pnlHeader.setLayout(new java.awt.BorderLayout());

        pnlLogo.setBackground(new java.awt.Color(211, 254, 234));

        lblLogo.setBackground(new java.awt.Color(211, 254, 234));
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo.png"))); // NOI18N
        lblLogo.setPreferredSize(new java.awt.Dimension(400, 85));
        pnlLogo.add(lblLogo);

        pnlHeader.add(pnlLogo, java.awt.BorderLayout.WEST);

        pnlBotones.setBackground(new java.awt.Color(211, 254, 234));
        pnlBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnContr.setBackground(new java.awt.Color(211, 254, 234));
        btnContr.setForeground(new java.awt.Color(7, 48, 26));
        btnContr.setText("CAMBIAR CONTRASEÑA");
        btnContr.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnContr.setFocusPainted(false);
        btnContr.setPreferredSize(new java.awt.Dimension(180, 35));
        btnContr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContrActionPerformed(evt);
            }
        });
        pnlBotones.add(btnContr);

        btnSalir.setBackground(new java.awt.Color(211, 254, 234));
        btnSalir.setForeground(new java.awt.Color(7, 48, 26));
        btnSalir.setText("SALIR");
        btnSalir.setFocusPainted(false);
        btnSalir.setPreferredSize(new java.awt.Dimension(100, 35));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        pnlBotones.add(btnSalir);

        pnlHeader.add(pnlBotones, java.awt.BorderLayout.EAST);

        pnlPrincipal.add(pnlHeader, java.awt.BorderLayout.PAGE_START);

        pnlCentral.setBackground(new java.awt.Color(211, 254, 234));
        pnlCentral.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 30, 10, 30));
        pnlCentral.setPreferredSize(new java.awt.Dimension(284, 90));
        pnlCentral.setLayout(new java.awt.BorderLayout());

        lblBienvenida.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        lblBienvenida.setForeground(new java.awt.Color(7, 48, 26));
        lblBienvenida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBienvenida.setText("!Bienvenida/o, Admin!");
        lblBienvenida.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblBienvenida.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnlCentral.add(lblBienvenida, java.awt.BorderLayout.NORTH);

        pnlCrearCandidato.setBackground(new java.awt.Color(211, 254, 234));
        pnlCrearCandidato.setPreferredSize(new java.awt.Dimension(0, 45));

        bntCrearCandidato.setBackground(new java.awt.Color(51, 153, 102));
        bntCrearCandidato.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        bntCrearCandidato.setForeground(new java.awt.Color(255, 255, 255));
        bntCrearCandidato.setText("Crear Candidato");
        bntCrearCandidato.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntCrearCandidato.setFocusPainted(false);
        bntCrearCandidato.setMaximumSize(new java.awt.Dimension(50, 30));
        bntCrearCandidato.setMinimumSize(new java.awt.Dimension(49, 29));
        bntCrearCandidato.setPreferredSize(new java.awt.Dimension(50, 30));
        bntCrearCandidato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCrearCandidatoActionPerformed(evt);
            }
        });

        pnlBusqueda.setBackground(new java.awt.Color(211, 254, 234));
        pnlBusqueda.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 10, 0));

        txtSearch.setBackground(new java.awt.Color(248, 253, 249));
        txtSearch.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(74, 122, 96));
        txtSearch.setText("Search...");
        txtSearch.setFocusTraversalPolicyProvider(true);
        txtSearch.setPreferredSize(new java.awt.Dimension(700, 36));
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        pnlBusqueda.add(txtSearch);

        javax.swing.GroupLayout pnlCrearCandidatoLayout = new javax.swing.GroupLayout(pnlCrearCandidato);
        pnlCrearCandidato.setLayout(pnlCrearCandidatoLayout);
        pnlCrearCandidatoLayout.setHorizontalGroup(
            pnlCrearCandidatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCrearCandidatoLayout.createSequentialGroup()
                .addGroup(pnlCrearCandidatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 843, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlCrearCandidatoLayout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addComponent(bntCrearCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlCrearCandidatoLayout.setVerticalGroup(
            pnlCrearCandidatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCrearCandidatoLayout.createSequentialGroup()
                .addComponent(pnlBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bntCrearCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlCentral.add(pnlCrearCandidato, java.awt.BorderLayout.CENTER);

        pnlPrincipal.add(pnlCentral, java.awt.BorderLayout.CENTER);

        pnlContenido.setBackground(new java.awt.Color(211, 254, 234));
        pnlContenido.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 20, 10, 20));
        pnlContenido.setPreferredSize(new java.awt.Dimension(0, 500));
        pnlContenido.setLayout(new java.awt.BorderLayout());

        pnlFiltros.setBackground(new java.awt.Color(244, 253, 248));
        pnlFiltros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(184, 240, 212)));
        pnlFiltros.setPreferredSize(new java.awt.Dimension(240, 0));
        pnlFiltros.setLayout(new javax.swing.BoxLayout(pnlFiltros, javax.swing.BoxLayout.Y_AXIS));

        pnlCompTec.setBackground(new java.awt.Color(244, 253, 248));
        pnlCompTec.setPreferredSize(new java.awt.Dimension(220, 296));
        pnlCompTec.setLayout(new java.awt.BorderLayout());

        lblCompTec.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        lblCompTec.setForeground(new java.awt.Color(7, 48, 26));
        lblCompTec.setText("Competencia Técnica");
        pnlCompTec.add(lblCompTec, java.awt.BorderLayout.NORTH);

        pnlDesarrollo.setBackground(new java.awt.Color(244, 253, 248));
        pnlDesarrollo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Desarrollo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13), new java.awt.Color(42, 74, 56))); // NOI18N
        pnlDesarrollo.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        pnlDesarrollo.setLayout(new java.awt.GridLayout(0, 2, 2, 2));

        tglJavaScript.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tglJavaScript.setForeground(new java.awt.Color(42, 74, 56));
        tglJavaScript.setText("JavaScript");
        tglJavaScript.setPreferredSize(new java.awt.Dimension(110, 22));
        tglJavaScript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglJavaScriptActionPerformed(evt);
            }
        });
        pnlDesarrollo.add(tglJavaScript);

        tglPython.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tglPython.setForeground(new java.awt.Color(42, 74, 56));
        tglPython.setText("Python");
        tglPython.setPreferredSize(new java.awt.Dimension(110, 22));
        tglPython.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglPythonActionPerformed(evt);
            }
        });
        pnlDesarrollo.add(tglPython);

        tglReact.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tglReact.setForeground(new java.awt.Color(42, 74, 56));
        tglReact.setText("React");
        tglReact.setPreferredSize(new java.awt.Dimension(110, 22));
        tglReact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglReactActionPerformed(evt);
            }
        });
        pnlDesarrollo.add(tglReact);

        tglNoode.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tglNoode.setForeground(new java.awt.Color(42, 74, 56));
        tglNoode.setText("Noode.js");
        tglNoode.setPreferredSize(new java.awt.Dimension(110, 22));
        tglNoode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglNoodeActionPerformed(evt);
            }
        });
        pnlDesarrollo.add(tglNoode);

        tglJavaSql.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tglJavaSql.setForeground(new java.awt.Color(42, 74, 56));
        tglJavaSql.setText("SQL");
        tglJavaSql.setPreferredSize(new java.awt.Dimension(110, 22));
        tglJavaSql.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglJavaSqlActionPerformed(evt);
            }
        });
        pnlDesarrollo.add(tglJavaSql);

        tglApache.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tglApache.setForeground(new java.awt.Color(42, 74, 56));
        tglApache.setText("Apache Spark");
        tglApache.setPreferredSize(new java.awt.Dimension(110, 22));
        tglApache.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglApacheActionPerformed(evt);
            }
        });
        pnlDesarrollo.add(tglApache);

        tglAws.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tglAws.setForeground(new java.awt.Color(42, 74, 56));
        tglAws.setText("AWS");
        tglAws.setPreferredSize(new java.awt.Dimension(110, 22));
        tglAws.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglAwsActionPerformed(evt);
            }
        });
        pnlDesarrollo.add(tglAws);

        tglKubernetes.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tglKubernetes.setForeground(new java.awt.Color(42, 74, 56));
        tglKubernetes.setText("Kubernetes");
        tglKubernetes.setPreferredSize(new java.awt.Dimension(110, 22));
        tglKubernetes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglKubernetesActionPerformed(evt);
            }
        });
        pnlDesarrollo.add(tglKubernetes);

        tglLinux.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tglLinux.setForeground(new java.awt.Color(42, 74, 56));
        tglLinux.setText("Linux");
        tglLinux.setPreferredSize(new java.awt.Dimension(110, 22));
        tglLinux.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglLinuxActionPerformed(evt);
            }
        });
        pnlDesarrollo.add(tglLinux);

        tglDocker.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tglDocker.setForeground(new java.awt.Color(42, 74, 56));
        tglDocker.setText("Docker");
        tglDocker.setPreferredSize(new java.awt.Dimension(110, 22));
        tglDocker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglDockerActionPerformed(evt);
            }
        });
        pnlDesarrollo.add(tglDocker);

        pnlCompTec.add(pnlDesarrollo, java.awt.BorderLayout.CENTER);

        pnlDiseño.setBackground(new java.awt.Color(244, 253, 248));
        pnlDiseño.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Diseño", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13), new java.awt.Color(42, 74, 56))); // NOI18N
        pnlDiseño.setForeground(new java.awt.Color(42, 74, 56));
        pnlDiseño.setFocusable(false);
        pnlDiseño.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        pnlDiseño.setPreferredSize(new java.awt.Dimension(260, 110));
        pnlDiseño.setLayout(new java.awt.GridLayout(0, 2, 2, 2));

        tglFigma.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tglFigma.setForeground(new java.awt.Color(42, 74, 56));
        tglFigma.setText("Figma");
        tglFigma.setPreferredSize(new java.awt.Dimension(110, 22));
        tglFigma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglFigmaActionPerformed(evt);
            }
        });
        pnlDiseño.add(tglFigma);

        tglAdobe.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tglAdobe.setForeground(new java.awt.Color(42, 74, 56));
        tglAdobe.setText("Adobe XD");
        tglAdobe.setPreferredSize(new java.awt.Dimension(110, 22));
        tglAdobe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglAdobeActionPerformed(evt);
            }
        });
        pnlDiseño.add(tglAdobe);

        tglCss.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tglCss.setForeground(new java.awt.Color(42, 74, 56));
        tglCss.setText("CSS/Tailwind");
        tglCss.setPreferredSize(new java.awt.Dimension(110, 22));
        tglCss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglCssActionPerformed(evt);
            }
        });
        pnlDiseño.add(tglCss);

        tglGoogle.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tglGoogle.setForeground(new java.awt.Color(42, 74, 56));
        tglGoogle.setText("GoogleAnalytics");
        tglGoogle.setPreferredSize(new java.awt.Dimension(110, 22));
        tglGoogle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglGoogleActionPerformed(evt);
            }
        });
        pnlDiseño.add(tglGoogle);

        tglMeta.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tglMeta.setForeground(new java.awt.Color(42, 74, 56));
        tglMeta.setText("Meta");
        tglMeta.setPreferredSize(new java.awt.Dimension(110, 22));
        tglMeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglMetaActionPerformed(evt);
            }
        });
        pnlDiseño.add(tglMeta);

        tglAds.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tglAds.setForeground(new java.awt.Color(42, 74, 56));
        tglAds.setText("ADS");
        tglAds.setPreferredSize(new java.awt.Dimension(110, 22));
        tglAds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglAdsActionPerformed(evt);
            }
        });
        pnlDiseño.add(tglAds);

        pnlCompTec.add(pnlDiseño, java.awt.BorderLayout.SOUTH);

        pnlFiltros.add(pnlCompTec);

        pnlIdioma.setBackground(new java.awt.Color(244, 253, 248));
        pnlIdioma.setLayout(new java.awt.BorderLayout());

        lblIdioma.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        lblIdioma.setForeground(new java.awt.Color(7, 48, 26));
        lblIdioma.setText("Idioma");
        lblIdioma.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblIdioma.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlIdioma.add(lblIdioma, java.awt.BorderLayout.PAGE_START);

        pnlIdiomas.setBackground(new java.awt.Color(244, 253, 248));
        pnlIdiomas.setLayout(new java.awt.GridLayout(0, 2, 2, 0));

        chkEusk.setBackground(new java.awt.Color(244, 253, 248));
        chkEusk.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        chkEusk.setForeground(new java.awt.Color(42, 74, 56));
        chkEusk.setText("Euskera");
        chkEusk.setFocusPainted(false);
        chkEusk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkEuskActionPerformed(evt);
            }
        });
        pnlIdiomas.add(chkEusk);

        chkEsp.setBackground(new java.awt.Color(244, 253, 248));
        chkEsp.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        chkEsp.setForeground(new java.awt.Color(42, 74, 56));
        chkEsp.setText("Español");
        chkEsp.setFocusPainted(false);
        chkEsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkEspActionPerformed(evt);
            }
        });
        pnlIdiomas.add(chkEsp);

        chkIng.setBackground(new java.awt.Color(244, 253, 248));
        chkIng.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        chkIng.setForeground(new java.awt.Color(42, 74, 56));
        chkIng.setText("Inglés");
        chkIng.setFocusPainted(false);
        chkIng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkIngActionPerformed(evt);
            }
        });
        pnlIdiomas.add(chkIng);

        chkFra.setBackground(new java.awt.Color(244, 253, 248));
        chkFra.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        chkFra.setForeground(new java.awt.Color(42, 74, 56));
        chkFra.setText("Francés");
        chkFra.setFocusPainted(false);
        chkFra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkFraActionPerformed(evt);
            }
        });
        pnlIdiomas.add(chkFra);

        chkAle.setBackground(new java.awt.Color(244, 253, 248));
        chkAle.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        chkAle.setForeground(new java.awt.Color(42, 74, 56));
        chkAle.setText("Alemán");
        chkAle.setFocusPainted(false);
        chkAle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkAleActionPerformed(evt);
            }
        });
        pnlIdiomas.add(chkAle);

        pnlIdioma.add(pnlIdiomas, java.awt.BorderLayout.CENTER);

        pnlFiltros.add(pnlIdioma);

        pnlTituloTr.setBackground(new java.awt.Color(244, 253, 248));
        pnlTituloTr.setLayout(new java.awt.BorderLayout());

        lblTransversales.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        lblTransversales.setForeground(new java.awt.Color(7, 48, 26));
        lblTransversales.setText("Transversales");
        pnlTituloTr.add(lblTransversales, java.awt.BorderLayout.PAGE_START);

        pnlTransversales.setBackground(new java.awt.Color(244, 253, 248));
        pnlTransversales.setLayout(new java.awt.GridLayout(0, 2, 2, 2));

        chkTraEqui.setBackground(new java.awt.Color(244, 253, 248));
        chkTraEqui.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        chkTraEqui.setForeground(new java.awt.Color(42, 74, 56));
        chkTraEqui.setText("Trabajo en equipo");
        chkTraEqui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkTraEquiActionPerformed(evt);
            }
        });
        pnlTransversales.add(chkTraEqui);

        chkComu.setBackground(new java.awt.Color(244, 253, 248));
        chkComu.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        chkComu.setForeground(new java.awt.Color(42, 74, 56));
        chkComu.setText("Comunicación efectiva");
        chkComu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkComuActionPerformed(evt);
            }
        });
        pnlTransversales.add(chkComu);

        chkGstTmp.setBackground(new java.awt.Color(244, 253, 248));
        chkGstTmp.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        chkGstTmp.setForeground(new java.awt.Color(42, 74, 56));
        chkGstTmp.setText("Gestión del tiempo");
        chkGstTmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkGstTmpActionPerformed(evt);
            }
        });
        pnlTransversales.add(chkGstTmp);

        chkLider.setBackground(new java.awt.Color(244, 253, 248));
        chkLider.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        chkLider.setForeground(new java.awt.Color(42, 74, 56));
        chkLider.setText("Liderazgo");
        chkLider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkLiderActionPerformed(evt);
            }
        });
        pnlTransversales.add(chkLider);

        chkAdap.setBackground(new java.awt.Color(244, 253, 248));
        chkAdap.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        chkAdap.setForeground(new java.awt.Color(42, 74, 56));
        chkAdap.setText("Adaptabilidad");
        chkAdap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkAdapActionPerformed(evt);
            }
        });
        pnlTransversales.add(chkAdap);

        chkCrea.setBackground(new java.awt.Color(244, 253, 248));
        chkCrea.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        chkCrea.setForeground(new java.awt.Color(42, 74, 56));
        chkCrea.setText("Creatividad");
        chkCrea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkCreaActionPerformed(evt);
            }
        });
        pnlTransversales.add(chkCrea);

        chkPensCrit.setBackground(new java.awt.Color(244, 253, 248));
        chkPensCrit.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        chkPensCrit.setForeground(new java.awt.Color(42, 74, 56));
        chkPensCrit.setText("Pensamineto Crítico");
        chkPensCrit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkPensCritActionPerformed(evt);
            }
        });
        pnlTransversales.add(chkPensCrit);

        chkAut.setBackground(new java.awt.Color(244, 253, 248));
        chkAut.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        chkAut.setForeground(new java.awt.Color(42, 74, 56));
        chkAut.setText("Autonomía");
        chkAut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkAutActionPerformed(evt);
            }
        });
        pnlTransversales.add(chkAut);

        chkReso.setBackground(new java.awt.Color(244, 253, 248));
        chkReso.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        chkReso.setForeground(new java.awt.Color(42, 74, 56));
        chkReso.setText("Resolución de problemas");
        chkReso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkResoActionPerformed(evt);
            }
        });
        pnlTransversales.add(chkReso);

        pnlTituloTr.add(pnlTransversales, java.awt.BorderLayout.CENTER);

        pnlFiltros.add(pnlTituloTr);

        pnlContenido.add(pnlFiltros, java.awt.BorderLayout.WEST);

        tablaContenidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellidos", "Email", "Titulacion", "Competencias", "Idiomas", "Transversales"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaContenidos.setPreferredSize(new java.awt.Dimension(400, 80));
        srpnTabla.setViewportView(tablaContenidos);

        pnlContenido.add(srpnTabla, java.awt.BorderLayout.CENTER);

        pnlPrincipal.add(pnlContenido, java.awt.BorderLayout.SOUTH);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 968, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 818, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 23, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnContrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContrActionPerformed
        FrmContraseñaOlvidada frm = new FrmContraseñaOlvidada();
        frm.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frm.setSize(700, 600);
        frm.setVisible(true);
        // Cuando se cierre FrmAdminCrearUsuario, refresca la tabla
        frm.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                cargarTabla(); // ← recarga los candidatos automáticamente
            }
        });
    }//GEN-LAST:event_btnContrActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int respuesta = javax.swing.JOptionPane.showConfirmDialog(
                this,
                "¿Estás seguro de que quieres cerrar sesión?",
                "Cerrar Sesión",
                javax.swing.JOptionPane.YES_NO_OPTION,
                javax.swing.JOptionPane.QUESTION_MESSAGE
        );

        if (respuesta == javax.swing.JOptionPane.YES_OPTION) {
            new FrmLogin().setVisible(true);
            this.dispose();
            // Aquí abres tu pantalla de Login, por ejemplo:
            // new FrmLogin().setVisible(true);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void bntCrearCandidatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCrearCandidatoActionPerformed
        FrmAdminCrearUsuario frm = new FrmAdminCrearUsuario();
        frm.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frm.setLocationRelativeTo(null);
        frm.setSize(700, 600);
        frm.setVisible(true);
        // Cuando se cierre FrmAdminCrearUsuario, refresca la tabla
        frm.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                cargarTabla(); // ← recarga los candidatos automáticamente
            }
        });
    }//GEN-LAST:event_bntCrearCandidatoActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void chkEuskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkEuskActionPerformed
        aplicarFiltros();
    }//GEN-LAST:event_chkEuskActionPerformed

    private void chkEspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkEspActionPerformed
        aplicarFiltros();
    }//GEN-LAST:event_chkEspActionPerformed

    private void chkIngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkIngActionPerformed
        aplicarFiltros();
    }//GEN-LAST:event_chkIngActionPerformed

    private void chkFraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkFraActionPerformed
        aplicarFiltros();
    }//GEN-LAST:event_chkFraActionPerformed

    private void chkAleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkAleActionPerformed
        aplicarFiltros();
    }//GEN-LAST:event_chkAleActionPerformed

    private void chkResoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkResoActionPerformed
        aplicarFiltros();
    }//GEN-LAST:event_chkResoActionPerformed

    private void tglJavaScriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglJavaScriptActionPerformed
        aplicarFiltros();
    }//GEN-LAST:event_tglJavaScriptActionPerformed

    private void tglPythonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglPythonActionPerformed
        aplicarFiltros();
    }//GEN-LAST:event_tglPythonActionPerformed

    private void tglFigmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglFigmaActionPerformed
        aplicarFiltros();
    }//GEN-LAST:event_tglFigmaActionPerformed

    private void tglAdobeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglAdobeActionPerformed
        aplicarFiltros();
    }//GEN-LAST:event_tglAdobeActionPerformed

    private void tglReactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglReactActionPerformed
        aplicarFiltros();
    }//GEN-LAST:event_tglReactActionPerformed

    private void tglNoodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglNoodeActionPerformed
        aplicarFiltros();
    }//GEN-LAST:event_tglNoodeActionPerformed

    private void tglJavaSqlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglJavaSqlActionPerformed
        aplicarFiltros();
    }//GEN-LAST:event_tglJavaSqlActionPerformed

    private void tglApacheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglApacheActionPerformed
        aplicarFiltros();
    }//GEN-LAST:event_tglApacheActionPerformed

    private void tglAwsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglAwsActionPerformed
        aplicarFiltros();
    }//GEN-LAST:event_tglAwsActionPerformed

    private void tglKubernetesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglKubernetesActionPerformed
        aplicarFiltros();
    }//GEN-LAST:event_tglKubernetesActionPerformed

    private void tglLinuxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglLinuxActionPerformed
        aplicarFiltros();
    }//GEN-LAST:event_tglLinuxActionPerformed

    private void tglDockerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglDockerActionPerformed
        aplicarFiltros();
    }//GEN-LAST:event_tglDockerActionPerformed

    private void tglCssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglCssActionPerformed
        aplicarFiltros();
    }//GEN-LAST:event_tglCssActionPerformed

    private void tglGoogleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglGoogleActionPerformed
        aplicarFiltros();
    }//GEN-LAST:event_tglGoogleActionPerformed

    private void tglMetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglMetaActionPerformed
        aplicarFiltros();
    }//GEN-LAST:event_tglMetaActionPerformed

    private void tglAdsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglAdsActionPerformed
        aplicarFiltros();
    }//GEN-LAST:event_tglAdsActionPerformed

    private void chkGstTmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkGstTmpActionPerformed
        aplicarFiltros();
    }//GEN-LAST:event_chkGstTmpActionPerformed

    private void chkLiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkLiderActionPerformed
        aplicarFiltros();
    }//GEN-LAST:event_chkLiderActionPerformed

    private void chkAdapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkAdapActionPerformed
        aplicarFiltros();
    }//GEN-LAST:event_chkAdapActionPerformed

    private void chkCreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkCreaActionPerformed
        aplicarFiltros();
    }//GEN-LAST:event_chkCreaActionPerformed

    private void chkPensCritActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkPensCritActionPerformed
        aplicarFiltros();
    }//GEN-LAST:event_chkPensCritActionPerformed

    private void chkAutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkAutActionPerformed
        aplicarFiltros();
    }//GEN-LAST:event_chkAutActionPerformed

    private void chkTraEquiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkTraEquiActionPerformed
        aplicarFiltros();
    }//GEN-LAST:event_chkTraEquiActionPerformed

    private void chkComuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkComuActionPerformed
        aplicarFiltros();
    }//GEN-LAST:event_chkComuActionPerformed

    private void cargarTabla() {
        javax.swing.table.DefaultTableModel modelo
                = (javax.swing.table.DefaultTableModel) tablaContenidos.getModel();

        modelo.setRowCount(0); // Limpiar filas existentes

        try {
            jakarta.persistence.EntityManager em = s.z_talent_manager.util.JPAUtil.getEntityManager();
            s.z_talent_manager.dao.CandidatoDAO dao = new s.z_talent_manager.dao.CandidatoImpl();
            java.util.List<s.z_talent_manager.modelo.Candidato> candidatos = dao.getCandidatos(em);

            for (s.z_talent_manager.modelo.Candidato ca : candidatos) {

                // Titulacion
                String titulaciones = ca.getCandidatoTitulaciones() == null ? ""
                        : ca.getCandidatoTitulaciones().stream()
                                .map(ct -> ct.getTitulacion().getTipoEstudio())
                                .collect(java.util.stream.Collectors.joining(", "));

                // Competencias técnicas
                String competencias = ca.getCandidatoTecnicas() == null ? ""
                        : ca.getCandidatoTecnicas().stream()
                                .map(ct -> ct.getCompetenciaTecnica().getNombre())
                                .collect(java.util.stream.Collectors.joining(", "));

                // Idiomas
                String idiomas = ca.getCandidatoIdiomas() == null ? ""
                        : ca.getCandidatoIdiomas().stream()
                                .map(ci -> ci.getIdioma().getNombre())
                                .collect(java.util.stream.Collectors.joining(", "));

                // Transversales
                String transversales = ca.getCandidatoTransversales() == null ? ""
                        : ca.getCandidatoTransversales().stream()
                                .map(ctr -> ctr.getTransversal().getNombre())
                                .collect(java.util.stream.Collectors.joining(", "));

                modelo.addRow(new Object[]{
                    ca.getNombre(),
                    ca.getApellidos(),
                    ca.getEmail(),
                    titulaciones,
                    competencias,
                    idiomas,
                    transversales
                });
            }

            em.close();

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Error al cargar candidatos: " + e.getMessage(),
                    "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }

        tablaContenidos.addMouseMotionListener(
                new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseMoved(java.awt.event.MouseEvent e
            ) {
                int fila = tablaContenidos.rowAtPoint(e.getPoint());
                int col = tablaContenidos.columnAtPoint(e.getPoint());
                if (fila >= 0 && col >= 0) {
                    Object valor = tablaContenidos.getValueAt(fila, col);
                    if (valor != null && !valor.toString().isBlank()) {
                        tablaContenidos.setToolTipText(valor.toString());
                    } else {
                        tablaContenidos.setToolTipText(null);
                    }
                }
            }
        }
        );
    }

    private void aplicarFiltros() {
        javax.swing.table.TableRowSorter<javax.swing.table.DefaultTableModel> sorter
                = (javax.swing.table.TableRowSorter<javax.swing.table.DefaultTableModel>) tablaContenidos.getRowSorter();

        // Recoger competencias técnicas seleccionadas (toggles)
        java.util.List<String> tecnicas = new java.util.ArrayList<>();
        if (tglJavaScript.isSelected()) {
            tecnicas.add("JavaScript");
        }
        if (tglPython.isSelected()) {
            tecnicas.add("Python");
        }
        if (tglReact.isSelected()) {
            tecnicas.add("React");
        }
        if (tglNoode.isSelected()) {
            tecnicas.add("Node.js");
        }
        if (tglJavaSql.isSelected()) {
            tecnicas.add("SQL");
        }
        if (tglApache.isSelected()) {
            tecnicas.add("Apache Spark");
        }
        if (tglAws.isSelected()) {
            tecnicas.add("AWS");
        }
        if (tglKubernetes.isSelected()) {
            tecnicas.add("Kubernetes");
        }
        if (tglLinux.isSelected()) {
            tecnicas.add("Linux");
        }
        if (tglDocker.isSelected()) {
            tecnicas.add("Docker");
        }
        if (tglFigma.isSelected()) {
            tecnicas.add("Figma");
        }
        if (tglAdobe.isSelected()) {
            tecnicas.add("Adobe XD");
        }
        if (tglCss.isSelected()) {
            tecnicas.add("CSS / Tailwind");
        }
        if (tglGoogle.isSelected()) {
            tecnicas.add("Google Analytics");
        }
        if (tglMeta.isSelected()) {
            tecnicas.add("Meta");
        }
        if (tglAds.isSelected()) {
            tecnicas.add("ADS");
        }

        // Recoger idiomas seleccionados (checkboxes)
        java.util.List<String> idiomas = new java.util.ArrayList<>();
        if (chkEusk.isSelected()) {
            idiomas.add("Euskera");
        }
        if (chkEsp.isSelected()) {
            idiomas.add("Español");
        }
        if (chkIng.isSelected()) {
            idiomas.add("Inglés");
        }
        if (chkFra.isSelected()) {
            idiomas.add("Francés");
        }
        if (chkAle.isSelected()) {
            idiomas.add("Alemán");
        }

        // Recoger transversales seleccionados (checkboxes)
        java.util.List<String> transversales = new java.util.ArrayList<>();
        if (chkTraEqui.isSelected()) {
            transversales.add("Trabajo en equipo");
        }
        if (chkComu.isSelected()) {
            transversales.add("Comunicación efectiva");
        }
        if (chkGstTmp.isSelected()) {
            transversales.add("Gestión del tiempo");
        }
        if (chkLider.isSelected()) {
            transversales.add("Liderazgo");
        }
        if (chkAdap.isSelected()) {
            transversales.add("Adaptabilidad");
        }
        if (chkCrea.isSelected()) {
            transversales.add("Creatividad");
        }
        if (chkPensCrit.isSelected()) {
            transversales.add("Pensamiento Crítico");
        }
        if (chkAut.isSelected()) {
            transversales.add("Autonomía");
        }
        if (chkReso.isSelected()) {
            transversales.add("Resolución de problemas");
        }

        // Si no hay nada seleccionado, quitar filtro
        if (tecnicas.isEmpty() && idiomas.isEmpty() && transversales.isEmpty()) {
            sorter.setRowFilter(null);
            return;
        }

        // Aplicar filtro combinado
        sorter.setRowFilter(new javax.swing.RowFilter<javax.swing.table.DefaultTableModel, Integer>() {
            @Override
            public boolean include(Entry<? extends javax.swing.table.DefaultTableModel, ? extends Integer> entry) {
                // Columna 4 = Competencias, 5 = Idiomas, 6 = Transversales
                String compFila = entry.getStringValue(4).toLowerCase();
                String idioFila = entry.getStringValue(5).toLowerCase();
                String transFila = entry.getStringValue(6).toLowerCase();

                // Cada filtro activo debe cumplirse (AND entre categorías)
                for (String t : tecnicas) {
                    if (!compFila.contains(t.toLowerCase())) {
                        return false;
                    }
                }
                for (String i : idiomas) {
                    if (!idioFila.contains(i.toLowerCase())) {
                        return false;
                    }
                }
                for (String tr : transversales) {
                    if (!transFila.contains(tr.toLowerCase())) {
                        return false;
                    }
                }
                return true;
            }
        });
    }

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
        java.awt.EventQueue.invokeLater(() -> new FrmPanelAdmin().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntCrearCandidato;
    private javax.swing.JButton btnContr;
    private javax.swing.JButton btnSalir;
    private javax.swing.JCheckBox chkAdap;
    private javax.swing.JCheckBox chkAle;
    private javax.swing.JCheckBox chkAut;
    private javax.swing.JCheckBox chkComu;
    private javax.swing.JCheckBox chkCrea;
    private javax.swing.JCheckBox chkEsp;
    private javax.swing.JCheckBox chkEusk;
    private javax.swing.JCheckBox chkFra;
    private javax.swing.JCheckBox chkGstTmp;
    private javax.swing.JCheckBox chkIng;
    private javax.swing.JCheckBox chkLider;
    private javax.swing.JCheckBox chkPensCrit;
    private javax.swing.JCheckBox chkReso;
    private javax.swing.JCheckBox chkTraEqui;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JLabel lblCompTec;
    private javax.swing.JLabel lblIdioma;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblTransversales;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlBusqueda;
    private javax.swing.JPanel pnlCentral;
    private javax.swing.JPanel pnlCompTec;
    private javax.swing.JPanel pnlContenido;
    private javax.swing.JPanel pnlCrearCandidato;
    private javax.swing.JPanel pnlDesarrollo;
    private javax.swing.JPanel pnlDiseño;
    private javax.swing.JPanel pnlFiltros;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlIdioma;
    private javax.swing.JPanel pnlIdiomas;
    private javax.swing.JPanel pnlLogo;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlTituloTr;
    private javax.swing.JPanel pnlTransversales;
    private javax.swing.JScrollPane srpnTabla;
    private javax.swing.JTable tablaContenidos;
    private javax.swing.JToggleButton tglAdobe;
    private javax.swing.JToggleButton tglAds;
    private javax.swing.JToggleButton tglApache;
    private javax.swing.JToggleButton tglAws;
    private javax.swing.JToggleButton tglCss;
    private javax.swing.JToggleButton tglDocker;
    private javax.swing.JToggleButton tglFigma;
    private javax.swing.JToggleButton tglGoogle;
    private javax.swing.JToggleButton tglJavaScript;
    private javax.swing.JToggleButton tglJavaSql;
    private javax.swing.JToggleButton tglKubernetes;
    private javax.swing.JToggleButton tglLinux;
    private javax.swing.JToggleButton tglMeta;
    private javax.swing.JToggleButton tglNoode;
    private javax.swing.JToggleButton tglPython;
    private javax.swing.JToggleButton tglReact;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

}
