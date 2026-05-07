/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package s.z_talent_manager.vista;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JToggleButton;
import s.z_talent_manager.modelo.Candidato;
import s.z_talent_manager.modelo.CandidatoTecnica;
import s.z_talent_manager.modelo.CandidatoTransversal;
import s.z_talent_manager.modelo.CompetenciaTecnica;
import s.z_talent_manager.modelo.Sesion;
import s.z_talent_manager.modelo.Transversal;
import s.z_talent_manager.servicio.ZTalentManagerServicio;

/**
 *
 * @author DAW1
 */
public class FrmCompetenciaModificar extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmCompetenciaModificar.class.getName());
    
    // Niveles reutilizables
    private static final String[] NIVELES = {
        "Ninguno", "Muy bajo", "Bajo", "Intermedio", "Alto", "Muy alto"
    };

    // Mapa nombre-técnica 
    private java.util.Map<String, JToggleButton> toggleMap;

    // Mapa nombre-transversal 
    private java.util.Map<String, javax.swing.JComboBox<String>> comboTransvMap;

    
    /**
     * Creates new form FrmCompetenciaModificar
     */
    public FrmCompetenciaModificar() {
        initComponents();
        setTitle("Modificar Competencias");
        setLocationRelativeTo(null);
        construirMapas();
        rellenarCombosNiveles();
        precargarEstado();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    
}
    
    // ── Construir mapas nombre→componente ────────────────────────
    private void construirMapas() {

        // ── Técnicas ─────────────────────────────────────────────
        toggleMap = new java.util.LinkedHashMap<>();
        toggleMap.put("Figma",            tbtnFigma);
        toggleMap.put("Adobe XD",         tbtnAdobeXd);
        toggleMap.put("Google Analytics", tbtnGoogleAnalytics);
        toggleMap.put("Meta",             tbtnMeta);
        toggleMap.put("CSS / Tailwind",   tbtnTailwind);
        toggleMap.put("ADS",              tbtnAds);
        toggleMap.put("SQL",              tbtnSQL);
        toggleMap.put("JavaScript",       tbtnJavaScript);
        toggleMap.put("Python",           tbtnPython);
        toggleMap.put("Apache Spark",     tbtnApacheSpark);
        toggleMap.put("React",            tbtnReact);
        toggleMap.put("Linux",            tbtnLinux);
        toggleMap.put("AWS",              tbtnAWS);
        toggleMap.put("MongoDB",          tbtnMongoDB);
        toggleMap.put("Kubernetes",       tbtnKubernetes);
        toggleMap.put("Docker",           tbtnDocker);

        // ── Transversales ─────────────────────────────────────────
        comboTransvMap = new java.util.LinkedHashMap<>();
        comboTransvMap.put("Autonomía",                cmbAtunomia);
        comboTransvMap.put("Liderazgo",               cmbLiderazgo);
        comboTransvMap.put("Resolución de problemas", cmbResolucionDeProblemas);
        comboTransvMap.put("Gestión del tiempo",      cmbGestionDeTiempo);
        comboTransvMap.put("Creatividad",             cmbCreatividad);
        comboTransvMap.put("Trabajo en equipo",       cmbTrabajoEnEquipo);
        comboTransvMap.put("Pensamiento crítico",     cmbPensamientoCritico);
        comboTransvMap.put("Adaptabilidad",           cmbAdaptabilidad);
        comboTransvMap.put("Comunicación efectiva",   cmbComunicacionEfectiva);
    }

    // ── Rellenar los combos transversales con los niveles ────────
    private void rellenarCombosNiveles() {
        for (javax.swing.JComboBox<String> cmb : comboTransvMap.values()) {
            cmb.removeAllItems();
            for (String nivel : NIVELES) {
                cmb.addItem(nivel);
            }
        }
    }

    // ── Pre-cargar el estado actual del candidato ────────────────
    private void precargarEstado() {
        if (!(Sesion.getUsuario() instanceof Candidato)) return;

    Integer idCandidato = ((Candidato) Sesion.getUsuario()).getIdUsuario();

    Candidato c = ZTalentManagerServicio.getServicio().getCandidato(idCandidato);
    if (c == null) return;

    // ── Técnicas ─────────────────────────────────────────────────
    if (c.getCandidatoTecnicas() != null) {
        for (CandidatoTecnica ct : c.getCandidatoTecnicas()) {
            if (ct.getCompetenciaTecnica() == null) continue;
            JToggleButton btn = toggleMap.get(ct.getCompetenciaTecnica().getNombre());
            if (btn != null) btn.setSelected(true);
        }
    }

    // ── Transversales ─────────────────────────────────────────────
    if (c.getCandidatoTransversales() != null) {
        for (CandidatoTransversal ct : c.getCandidatoTransversales()) {
            if (ct.getTransversal() == null) continue;
            String nombre = ct.getTransversal().getNombre();
            String nivel  = ct.getNivelTr() != null ? ct.getNivelTr() : "Ninguno";
            javax.swing.JComboBox<String> cmb = comboTransvMap.get(nombre);
            if (cmb != null) cmb.setSelectedItem(nivel);
        }
    }
}

    // ── GUARDAR ──────────────────────────────────────────────────
    private void guardar() {
        if (!(Sesion.getUsuario() instanceof Candidato)) return;

        try {
            Integer idCandidato = ((Candidato) Sesion.getUsuario()).getIdUsuario();
            // Releer desde BD para trabajar con el objeto gestionado
            Candidato c = ZTalentManagerServicio.getServicio().getCandidato(idCandidato);

            ZTalentManagerServicio srv = ZTalentManagerServicio.getServicio();

            // ── Reconstruir técnicas ──────────────────────────────
            if (c.getCandidatoTecnicas() == null) {
                c.setCandidatoTecnicas(new ArrayList<>());
            }
            c.getCandidatoTecnicas().clear();

            for (java.util.Map.Entry<String, JToggleButton> entry : toggleMap.entrySet()) {
                if (!entry.getValue().isSelected()) continue;

                String nombreTec = entry.getKey();
                CompetenciaTecnica ct = srv.getCompetenciaTecnicaPorNombre(nombreTec);
                if (ct == null) continue; 

                CandidatoTecnica nuevaCt = new CandidatoTecnica();
                nuevaCt.setCandidato(c);
                nuevaCt.setCompetenciaTecnica(ct);
                // nivelTe no se gestiona en esta pantalla; se deja null o vacío
                c.getCandidatoTecnicas().add(nuevaCt);
            }

            // ── Reconstruir transversales ─────────────────────────
            if (c.getCandidatoTransversales() == null) {
                c.setCandidatoTransversales(new ArrayList<>());
            }
            c.getCandidatoTransversales().clear();

            for (java.util.Map.Entry<String, javax.swing.JComboBox<String>> entry
                    : comboTransvMap.entrySet()) {

                String nombreTrv = entry.getKey();
                String nivel = (String) entry.getValue().getSelectedItem();
                if (nivel == null || "Ninguno".equals(nivel)) continue;

                Transversal trv = srv.getTransversalPorNombre(nombreTrv);
                if (trv == null) continue;

                CandidatoTransversal nuevaTrv = new CandidatoTransversal();
                nuevaTrv.setCandidato(c);
                nuevaTrv.setTransversal(trv);
                nuevaTrv.setNivelTr(nivel);
                c.getCandidatoTransversales().add(nuevaTrv);
            }

            // ── Persistir ─────────────────────────────────────────
            srv.modificarCandidato(c);

            // ── Refrescar sesión con datos limpios desde BD ───────
            Candidato actualizado = srv.getCandidato(idCandidato);
            Sesion.setUsuario(actualizado);

            javax.swing.JOptionPane.showMessageDialog(this,
                    "Competencias guardadas correctamente.");
            dispose(); 

        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Error al guardar: " + ex.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        tbtnFigma = new javax.swing.JToggleButton();
        tbtnAdobeXd = new javax.swing.JToggleButton();
        tbtnGoogleAnalytics = new javax.swing.JToggleButton();
        tbtnMeta = new javax.swing.JToggleButton();
        tbtnTailwind = new javax.swing.JToggleButton();
        tbtnAds = new javax.swing.JToggleButton();
        tbtnSQL = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        tbtnJavaScript = new javax.swing.JToggleButton();
        tbtnPython = new javax.swing.JToggleButton();
        tbtnApacheSpark = new javax.swing.JToggleButton();
        tbtnReact = new javax.swing.JToggleButton();
        tbtnLinux = new javax.swing.JToggleButton();
        tbtnAWS = new javax.swing.JToggleButton();
        tbtnMongoDB = new javax.swing.JToggleButton();
        tbtnKubernetes = new javax.swing.JToggleButton();
        tbtnDocker = new javax.swing.JToggleButton();
        jSeparator3 = new javax.swing.JSeparator();
        btnGuardar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbResolucionDeProblemas = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cmbAtunomia = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cmbAdaptabilidad = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cmbTrabajoEnEquipo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cmbGestionDeTiempo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cmbCreatividad = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cmbPensamientoCritico = new javax.swing.JComboBox<>();
        cmbLiderazgo = new javax.swing.JComboBox<>();
        cmbComunicacionEfectiva = new javax.swing.JComboBox<>();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(222, 229, 227));
        setPreferredSize(new java.awt.Dimension(800, 650));

        jPanel1.setBackground(new java.awt.Color(233, 239, 237));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(7, 48, 26));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CAPACIDADES TÉCNICAS");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(7, 48, 26));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("COMPETENCIAS");

        jSeparator2.setForeground(new java.awt.Color(153, 153, 153));

        jPanel4.setLayout(new java.awt.BorderLayout());

        tbtnFigma.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tbtnFigma.setForeground(new java.awt.Color(42, 74, 56));
        tbtnFigma.setText("Figma");
        tbtnFigma.setPreferredSize(new java.awt.Dimension(40, 15));
        tbtnFigma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnFigmaActionPerformed(evt);
            }
        });

        tbtnAdobeXd.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tbtnAdobeXd.setForeground(new java.awt.Color(42, 74, 56));
        tbtnAdobeXd.setText("Adobe XD");
        tbtnAdobeXd.setPreferredSize(new java.awt.Dimension(40, 15));
        tbtnAdobeXd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnAdobeXdActionPerformed(evt);
            }
        });

        tbtnGoogleAnalytics.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tbtnGoogleAnalytics.setForeground(new java.awt.Color(42, 74, 56));
        tbtnGoogleAnalytics.setText("Google Analytics");
        tbtnGoogleAnalytics.setPreferredSize(new java.awt.Dimension(40, 15));
        tbtnGoogleAnalytics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnGoogleAnalyticsActionPerformed(evt);
            }
        });

        tbtnMeta.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tbtnMeta.setForeground(new java.awt.Color(42, 74, 56));
        tbtnMeta.setText("Meta");
        tbtnMeta.setPreferredSize(new java.awt.Dimension(40, 15));
        tbtnMeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnMetaActionPerformed(evt);
            }
        });

        tbtnTailwind.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tbtnTailwind.setForeground(new java.awt.Color(42, 74, 56));
        tbtnTailwind.setText("CSS / Tailwind");
        tbtnTailwind.setPreferredSize(new java.awt.Dimension(40, 15));
        tbtnTailwind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnTailwindActionPerformed(evt);
            }
        });

        tbtnAds.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tbtnAds.setForeground(new java.awt.Color(42, 74, 56));
        tbtnAds.setText("ADS");
        tbtnAds.setPreferredSize(new java.awt.Dimension(40, 15));
        tbtnAds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnAdsActionPerformed(evt);
            }
        });

        tbtnSQL.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tbtnSQL.setForeground(new java.awt.Color(42, 74, 56));
        tbtnSQL.setText("SQL");
        tbtnSQL.setPreferredSize(new java.awt.Dimension(40, 15));
        tbtnSQL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnSQLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tbtnFigma, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tbtnAds, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tbtnSQL, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tbtnAdobeXd, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tbtnTailwind, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tbtnGoogleAnalytics, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tbtnMeta, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbtnSQL, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbtnAds, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbtnFigma, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbtnTailwind, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbtnAdobeXd, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbtnGoogleAnalytics, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbtnMeta, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        tbtnJavaScript.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tbtnJavaScript.setForeground(new java.awt.Color(42, 74, 56));
        tbtnJavaScript.setText("JavaScript");
        tbtnJavaScript.setPreferredSize(new java.awt.Dimension(40, 15));
        tbtnJavaScript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnJavaScriptActionPerformed(evt);
            }
        });

        tbtnPython.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tbtnPython.setForeground(new java.awt.Color(42, 74, 56));
        tbtnPython.setText("Python");
        tbtnPython.setPreferredSize(new java.awt.Dimension(40, 15));
        tbtnPython.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnPythonActionPerformed(evt);
            }
        });

        tbtnApacheSpark.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tbtnApacheSpark.setForeground(new java.awt.Color(42, 74, 56));
        tbtnApacheSpark.setText("Apache Spark");
        tbtnApacheSpark.setPreferredSize(new java.awt.Dimension(40, 15));
        tbtnApacheSpark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnApacheSparkActionPerformed(evt);
            }
        });

        tbtnReact.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tbtnReact.setForeground(new java.awt.Color(42, 74, 56));
        tbtnReact.setText("React");
        tbtnReact.setPreferredSize(new java.awt.Dimension(40, 15));
        tbtnReact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnReactActionPerformed(evt);
            }
        });

        tbtnLinux.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tbtnLinux.setForeground(new java.awt.Color(42, 74, 56));
        tbtnLinux.setText("Linux");
        tbtnLinux.setPreferredSize(new java.awt.Dimension(40, 15));
        tbtnLinux.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnLinuxActionPerformed(evt);
            }
        });

        tbtnAWS.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tbtnAWS.setForeground(new java.awt.Color(42, 74, 56));
        tbtnAWS.setText("AWS");
        tbtnAWS.setPreferredSize(new java.awt.Dimension(40, 15));
        tbtnAWS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnAWSActionPerformed(evt);
            }
        });

        tbtnMongoDB.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tbtnMongoDB.setForeground(new java.awt.Color(42, 74, 56));
        tbtnMongoDB.setText("MongoDB");
        tbtnMongoDB.setPreferredSize(new java.awt.Dimension(40, 15));
        tbtnMongoDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnMongoDBActionPerformed(evt);
            }
        });

        tbtnKubernetes.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tbtnKubernetes.setForeground(new java.awt.Color(42, 74, 56));
        tbtnKubernetes.setText("Kubernetes");
        tbtnKubernetes.setPreferredSize(new java.awt.Dimension(40, 15));
        tbtnKubernetes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnKubernetesActionPerformed(evt);
            }
        });

        tbtnDocker.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tbtnDocker.setForeground(new java.awt.Color(42, 74, 56));
        tbtnDocker.setText("Docker");
        tbtnDocker.setPreferredSize(new java.awt.Dimension(40, 15));
        tbtnDocker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnDockerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tbtnJavaScript, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tbtnAWS, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tbtnMongoDB, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tbtnPython, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tbtnLinux, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tbtnKubernetes, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tbtnApacheSpark, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tbtnReact, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tbtnDocker, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbtnMongoDB, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbtnAWS, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbtnJavaScript, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tbtnLinux, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tbtnKubernetes, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tbtnPython, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbtnApacheSpark, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbtnReact, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbtnDocker, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSeparator3.setForeground(new java.awt.Color(153, 153, 153));

        btnGuardar.setBackground(new java.awt.Color(7, 48, 26));
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(7, 48, 26));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CAPACIDADES TRANSVERSALES");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(7, 48, 26));
        jLabel4.setText("Resolución de problemas");

        cmbResolucionDeProblemas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbResolucionDeProblemasActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(7, 48, 26));
        jLabel5.setText("Autonomía");

        cmbAtunomia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAtunomiaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(7, 48, 26));
        jLabel6.setText("Adaptabilidad");

        cmbAdaptabilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAdaptabilidadActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(7, 48, 26));
        jLabel7.setText("Trabajo en equipo");

        cmbTrabajoEnEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTrabajoEnEquipoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(7, 48, 26));
        jLabel8.setText("Gestión del tiempo");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(7, 48, 26));
        jLabel9.setText("Creatividad");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(7, 48, 26));
        jLabel10.setText("Comunicacion efectiva");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(7, 48, 26));
        jLabel11.setText("Liderazgo");

        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(7, 48, 26));
        jLabel12.setText("Pensamiento crítico");

        cmbPensamientoCritico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPensamientoCriticoActionPerformed(evt);
            }
        });

        cmbLiderazgo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLiderazgoActionPerformed(evt);
            }
        });

        cmbComunicacionEfectiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbComunicacionEfectivaActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setForeground(new java.awt.Color(7, 48, 26));
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 808, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 808, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(cmbAtunomia, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(cmbTrabajoEnEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(cmbResolucionDeProblemas, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(cmbGestionDeTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(54, 54, 54)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(cmbAdaptabilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbCreatividad, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(cmbComunicacionEfectiva, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(cmbLiderazgo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(54, 54, 54)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbPensamientoCritico, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))))))
                .addContainerGap(439, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addGap(512, 512, 512))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(214, 214, 214)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(423, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbGestionDeTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbResolucionDeProblemas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbAtunomia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbAdaptabilidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbTrabajoEnEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbCreatividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbLiderazgo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbComunicacionEfectiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbPensamientoCritico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(15, 15, 15))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(jLabel2)
                    .addContainerGap(634, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1259, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbtnApacheSparkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnApacheSparkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbtnApacheSparkActionPerformed

    private void tbtnMongoDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnMongoDBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbtnMongoDBActionPerformed

    private void tbtnPythonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnPythonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbtnPythonActionPerformed

    private void tbtnLinuxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnLinuxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbtnLinuxActionPerformed

    private void tbtnReactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnReactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbtnReactActionPerformed

    private void tbtnAWSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnAWSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbtnAWSActionPerformed

    private void tbtnJavaScriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnJavaScriptActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbtnJavaScriptActionPerformed

    private void tbtnKubernetesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnKubernetesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbtnKubernetesActionPerformed

    private void tbtnDockerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnDockerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbtnDockerActionPerformed

    private void tbtnFigmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnFigmaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbtnFigmaActionPerformed

    private void tbtnAdobeXdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnAdobeXdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbtnAdobeXdActionPerformed

    private void tbtnGoogleAnalyticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnGoogleAnalyticsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbtnGoogleAnalyticsActionPerformed

    private void tbtnMetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnMetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbtnMetaActionPerformed

    private void tbtnTailwindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnTailwindActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbtnTailwindActionPerformed

    private void tbtnAdsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnAdsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbtnAdsActionPerformed

    private void tbtnSQLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnSQLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbtnSQLActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cmbAtunomiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAtunomiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbAtunomiaActionPerformed

    private void cmbResolucionDeProblemasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbResolucionDeProblemasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbResolucionDeProblemasActionPerformed

    private void cmbAdaptabilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAdaptabilidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbAdaptabilidadActionPerformed

    private void cmbTrabajoEnEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTrabajoEnEquipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTrabajoEnEquipoActionPerformed

    private void cmbComunicacionEfectivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbComunicacionEfectivaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbComunicacionEfectivaActionPerformed

    private void cmbLiderazgoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLiderazgoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbLiderazgoActionPerformed

    private void cmbPensamientoCriticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPensamientoCriticoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPensamientoCriticoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new FrmCompetenciaModificar().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbAdaptabilidad;
    private javax.swing.JComboBox<String> cmbAtunomia;
    private javax.swing.JComboBox<String> cmbComunicacionEfectiva;
    private javax.swing.JComboBox<String> cmbCreatividad;
    private javax.swing.JComboBox<String> cmbGestionDeTiempo;
    private javax.swing.JComboBox<String> cmbLiderazgo;
    private javax.swing.JComboBox<String> cmbPensamientoCritico;
    private javax.swing.JComboBox<String> cmbResolucionDeProblemas;
    private javax.swing.JComboBox<String> cmbTrabajoEnEquipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JToggleButton tbtnAWS;
    private javax.swing.JToggleButton tbtnAdobeXd;
    private javax.swing.JToggleButton tbtnAds;
    private javax.swing.JToggleButton tbtnApacheSpark;
    private javax.swing.JToggleButton tbtnDocker;
    private javax.swing.JToggleButton tbtnFigma;
    private javax.swing.JToggleButton tbtnGoogleAnalytics;
    private javax.swing.JToggleButton tbtnJavaScript;
    private javax.swing.JToggleButton tbtnKubernetes;
    private javax.swing.JToggleButton tbtnLinux;
    private javax.swing.JToggleButton tbtnMeta;
    private javax.swing.JToggleButton tbtnMongoDB;
    private javax.swing.JToggleButton tbtnPython;
    private javax.swing.JToggleButton tbtnReact;
    private javax.swing.JToggleButton tbtnSQL;
    private javax.swing.JToggleButton tbtnTailwind;
    // End of variables declaration//GEN-END:variables
}
