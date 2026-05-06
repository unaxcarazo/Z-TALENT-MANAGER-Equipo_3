/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s.z_talent_manager.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import s.z_talent_manager.modelo.CandidatoIdioma;
import s.z_talent_manager.modelo.CandidatoTecnica;
import s.z_talent_manager.modelo.CandidatoTransversal;

/**
 *
 * @author fabia
 */
public class FrmCompetencias extends JPanel {
    
        // ── Paleta ───────────────────────────────────────────────────
    private static final Color VERDE_OSCURO = new Color(7,   48,  26);
    private static final Color VERDE_BASE   = new Color(51,  153, 102);
    private static final Color VERDE_MEDIO  = new Color(102, 204, 153);
    private static final Color VERDE_CLARO  = new Color(211, 254, 234);
    private static final Color BLANCO       = Color.WHITE;

    // ── Niveles transversales ────────────────────────────────────
    private static final String[] NIVELES = {
        "Ninguno", "Muy bajo", "Bajo", "Intermedio", "Alto", "Muy alto"
    };

    // ── Tabla idiomas ────────────────────────────────────────────
    private JTable tablaIdiomas;
    private DefaultTableModel modeloIdiomas;

    // ── ComboBox idioma ──────────────────────────────────────────
    private JComboBox<String> cmbIdioma;
    private JComboBox<String> cmbOral;
    private JComboBox<String> cmbEscrita;
    private JComboBox<String> cmbAuditiva;
    private JComboBox<String> cmbLectura;

    // ── Panel técnicas ───────────────────────────────────────────
    private JPanel panelTecnicas;
    private List<String> listaTecnicas = new ArrayList<>();

    // ── TextField transversales (solo lectura) ───────────────────
    private JTextField txtAutonomia;
    private JTextField txtLiderazgo;
    private JTextField txtResolucion;
    private JTextField txtGestion;
    private JTextField txtCreatividad;
    private JTextField txtTrabajo;
    private JTextField txtPensamiento;
    private JTextField txtAdaptabilidad;
    private JTextField txtComunicacion;

    public FrmCompetencias() {
        setBackground(VERDE_CLARO);
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder(16, 20, 16, 20));
        construirUI();
    }

    private void construirUI() {
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(6, 8, 6, 8);
        g.anchor = GridBagConstraints.NORTHWEST;
        g.fill   = GridBagConstraints.HORIZONTAL;

        // ── Título principal ─────────────────────────────────────
        JLabel lblTitulo = new JLabel("COMPETENCIAS", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setForeground(VERDE_OSCURO);
        g.gridx = 0; g.gridy = 0; g.gridwidth = 2;
        g.anchor = GridBagConstraints.CENTER;
        add(lblTitulo, g);
        g.gridwidth = 1;
        g.anchor = GridBagConstraints.NORTHWEST;

        // COLUMNA 0 — Idiomas
        g.gridx = 0; g.gridy = 1;
        g.weightx = 0.5; g.weighty = 1.0;
        g.fill = GridBagConstraints.BOTH;
        add(construirPanelIdiomas(), g);

        // COLUMNA 1 — Técnicas + Transversales
        g.gridx = 1; g.gridy = 1;
        g.weightx = 0.5; g.weighty = 1.0;
        g.fill = GridBagConstraints.BOTH;
        add(construirPanelDerecho(), g);
    }

    // ════════════════════════════════════════════════════════════
    // PANEL IDIOMAS
    // ════════════════════════════════════════════════════════════
    private JPanel construirPanelIdiomas() {
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setOpaque(false);

    GridBagConstraints g = new GridBagConstraints();
    g.insets = new Insets(4, 4, 4, 4);
    g.fill   = GridBagConstraints.HORIZONTAL;
    g.anchor = GridBagConstraints.NORTHWEST;

    JLabel lbl = new JLabel("Idioma", SwingConstants.CENTER);
    lbl.setFont(new Font("Arial", Font.BOLD, 17));
    lbl.setForeground(VERDE_OSCURO);
    g.gridx = 0; g.gridy = 0; g.gridwidth = 5;
    g.anchor = GridBagConstraints.CENTER;
    panel.add(lbl, g);
    g.gridwidth = 1;
    g.anchor = GridBagConstraints.NORTHWEST;

    String[] cols = {
        "Idioma", 
        "Oral", 
        "Escritura", 
        "Auditiva", 
        "Lectura"};
    modeloIdiomas = new DefaultTableModel(cols, 0) {
        @Override public boolean isCellEditable(int r, int c) { return false; }
    };

    tablaIdiomas = new JTable(modeloIdiomas);
    tablaIdiomas.setBackground(BLANCO);
    tablaIdiomas.setForeground(VERDE_OSCURO);
    tablaIdiomas.setFont(new Font("Arial", Font.PLAIN, 12));
    tablaIdiomas.setRowHeight(34);
    tablaIdiomas.setSelectionBackground(VERDE_MEDIO);
    tablaIdiomas.setSelectionForeground(VERDE_OSCURO);
    tablaIdiomas.setGridColor(new Color(220, 220, 220));
    tablaIdiomas.setShowGrid(true);
    tablaIdiomas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    JTableHeader header = tablaIdiomas.getTableHeader();
    header.setBackground(VERDE_OSCURO);
    header.setForeground(VERDE_CLARO);
    header.setFont(new Font("Arial", Font.BOLD, 12));
    header.setReorderingAllowed(false);

    JScrollPane scroll = new JScrollPane(tablaIdiomas);
    scroll.setBorder(BorderFactory.createLineBorder(VERDE_BASE, 1));
    scroll.setPreferredSize(new Dimension(420, 220));

    g.gridx = 0; g.gridy = 1; g.gridwidth = 5;
    g.fill = GridBagConstraints.BOTH;
    g.weightx = 1.0; g.weighty = 1.0;
    panel.add(scroll, g);
    g.gridwidth = 1; g.weighty = 0;
    g.fill = GridBagConstraints.HORIZONTAL;

    String[] idiomas = {
        "Ninguno", 
        "Inglés", 
        "Castellano", 
        "Francés", 
        "Alemán"};
    String[] nivelesIdioma = {
        "Ninguno", 
        "Nativo", 
        "Básico A1", 
        "Básico A2",                
        "Intermedio B1", 
        "Intermedio B2", 
        "Avanzado C1",
        "Avanzado C2"};

    cmbIdioma   = crearComboBox(idiomas);
    cmbOral     = crearComboBox(nivelesIdioma);
    cmbEscrita  = crearComboBox(nivelesIdioma);
    cmbAuditiva = crearComboBox(nivelesIdioma);
    cmbLectura  = crearComboBox(nivelesIdioma);

    String[] labels = {
        "Idioma", 
        "Oral", 
        "Escrita", 
        "Auditiva", 
        "Lectura"};
    JComboBox<?>[] combos = {
        cmbIdioma, 
        cmbOral, 
        cmbEscrita, 
        cmbAuditiva, 
        cmbLectura};

    for (int i = 0; i < labels.length; i++) {
        JPanel col = new JPanel();
        col.setLayout(new BoxLayout(col, BoxLayout.Y_AXIS));
        col.setOpaque(false);

        JLabel lblCol = new JLabel(labels[i]);
        lblCol.setFont(new Font("Arial", Font.PLAIN, 11));
        lblCol.setForeground(VERDE_OSCURO);
        lblCol.setAlignmentX(Component.LEFT_ALIGNMENT);
        combos[i].setAlignmentX(Component.LEFT_ALIGNMENT);

        col.add(lblCol);
        col.add(Box.createVerticalStrut(2));
        col.add(combos[i]);

        g.gridx = i; g.gridy = 2; g.weightx = 1.0;
        panel.add(col, g);
    }

    // ── Botones añadir/eliminar (izquierda) + editar (derecha) ───
    JButton btnAñadir = crearBoton("Añadir idioma");
    btnAñadir.addActionListener(e -> {
        String idioma   = (String) cmbIdioma.getSelectedItem();
        String oral     = (String) cmbOral.getSelectedItem();
        String escrita  = (String) cmbEscrita.getSelectedItem();
        String auditiva = (String) cmbAuditiva.getSelectedItem();
        String lectura  = (String) cmbLectura.getSelectedItem();

        if (!"Ninguno".equals(idioma)) {
            modeloIdiomas.addRow(new Object[]{
                idioma, oral, escrita, auditiva, lectura
            });
            cmbIdioma.setSelectedIndex(0);
            cmbOral.setSelectedIndex(0);
            cmbEscrita.setSelectedIndex(0);
            cmbAuditiva.setSelectedIndex(0);
            cmbLectura.setSelectedIndex(0);
        }
    });

    JButton btnEliminar = crearBoton("Eliminar idioma");
        btnEliminar.addActionListener(e -> {
        int filaSeleccionada = tablaIdiomas.getSelectedRow();
        if (filaSeleccionada != -1) {
            int confirmar = JOptionPane.showConfirmDialog(
                this,
                "¿Estás seguro de que quieres eliminar este idioma?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
            );
            if (confirmar == JOptionPane.YES_OPTION) {
                modeloIdiomas.removeRow(filaSeleccionada);
            }
        } else {
            JOptionPane.showMessageDialog(
                this,
                "Selecciona un idioma de la tabla para eliminar.",
                "Sin selección",
                JOptionPane.WARNING_MESSAGE
            );
        }
    });

     // Botón editar → abre ventana edición
       JButton btnEditar = crearBoton("Editar");
        btnEditar.addActionListener(e -> {
        Window ventanaActual = SwingUtilities.getWindowAncestor(this);
        ventanaActual.setVisible(false);

       FrmCompetenciaModificar frameEditar = new FrmCompetenciaModificar();
        frameEditar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameEditar.setLocationRelativeTo(null);
        frameEditar.setVisible(true);

        frameEditar.addWindowListener(new WindowAdapter() {
            @Override public void windowClosed(WindowEvent e) {
                ventanaActual.setVisible(true);
            }
        });
    });

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 4));
        panelBotones.setOpaque(false);
        panelBotones.add(btnAñadir);
        panelBotones.add(btnEditar);
        g.gridx = 0; g.gridy = 3; g.gridwidth = 5;
        g.weightx = 0; g.fill = GridBagConstraints.HORIZONTAL;
        panel.add(panelBotones, g);
        
          // Panel izquierda: Añadir + Eliminar
        JPanel panelBotonesIzq = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 4));
        panelBotonesIzq.setOpaque(false);
        panelBotonesIzq.add(btnAñadir);
        panelBotonesIzq.add(btnEliminar);

        
        return panel;

        }



    // ════════════════════════════════════════════════════════════
    // PANEL DERECHO — Técnicas + Transversales
    // ════════════════════════════════════════════════════════════
    private JPanel construirPanelDerecho() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false);

        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(4, 6, 4, 6);
        g.fill   = GridBagConstraints.HORIZONTAL;
        g.anchor = GridBagConstraints.NORTHWEST;
        g.weightx = 1.0;

        // ── Técnicas ─────────────────────────────────────────────
        JLabel lblTecnicas = new JLabel("Técnicas");
        lblTecnicas.setFont(new Font("Arial", Font.BOLD, 17));
        lblTecnicas.setForeground(VERDE_OSCURO);
        g.gridx = 0; g.gridy = 0; g.gridwidth = 3;
        panel.add(lblTecnicas, g);

        panelTecnicas = new JPanel(new WrapLayout(FlowLayout.LEFT, 6, 6));
        panelTecnicas.setBackground(BLANCO);
        panelTecnicas.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
            BorderFactory.createEmptyBorder(6, 6, 6, 6)
        ));

        JLabel lblCompLabel = new JLabel("Competencias");
        lblCompLabel.setFont(new Font("Arial", Font.PLAIN, 11));
        lblCompLabel.setForeground(new Color(180, 180, 180));
        panelTecnicas.add(lblCompLabel);

        JScrollPane scrollTec = new JScrollPane(panelTecnicas);
        scrollTec.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 1));
        scrollTec.setPreferredSize(new Dimension(0, 120));

        g.gridy = 1; g.gridwidth = 3;
        g.fill = GridBagConstraints.BOTH;
        g.weighty = 0.3;
        panel.add(scrollTec, g);
        g.weighty = 0;
        g.fill = GridBagConstraints.HORIZONTAL;

        // ── Transversales ─────────────────────────────────────────
        JLabel lblTransversal = new JLabel("Transversal");
        lblTransversal.setFont(new Font("Arial", Font.BOLD, 17));
        lblTransversal.setForeground(VERDE_OSCURO);
        g.gridy = 2; g.gridwidth = 3;
        panel.add(lblTransversal, g);

        String[] nombresTransv = {
            "Autonomía",           "Liderazgo",     "Resolución de problemas",
            "Gestión del tiempo",  "Creatividad",   "Trabajo en equipo",
            "Pensamiento crítico", "Adaptabilidad", "Comunicación efectiva"
        };

        txtAutonomia     = crearTextFieldTransversal();
        txtLiderazgo     = crearTextFieldTransversal();
        txtResolucion    = crearTextFieldTransversal();
        txtGestion       = crearTextFieldTransversal();
        txtCreatividad   = crearTextFieldTransversal();
        txtTrabajo       = crearTextFieldTransversal();
        txtPensamiento   = crearTextFieldTransversal();
        txtAdaptabilidad = crearTextFieldTransversal();
        txtComunicacion  = crearTextFieldTransversal();

        JTextField[] txtTransv = {
            txtAutonomia, txtLiderazgo, txtResolucion,
            txtGestion,   txtCreatividad, txtTrabajo,
            txtPensamiento, txtAdaptabilidad, txtComunicacion
        };

        int col = 0;
        int row = 3;
        for (int i = 0; i < nombresTransv.length; i++) {
            JPanel celda = new JPanel();
            celda.setLayout(new BoxLayout(celda, BoxLayout.Y_AXIS));
            celda.setOpaque(false);

            JLabel lbl = new JLabel(nombresTransv[i]);
            lbl.setFont(new Font("Arial", Font.PLAIN, 10));
            lbl.setForeground(VERDE_OSCURO);
            lbl.setAlignmentX(Component.LEFT_ALIGNMENT);
            txtTransv[i].setAlignmentX(Component.LEFT_ALIGNMENT);

            celda.add(lbl);
            celda.add(Box.createVerticalStrut(2));
            celda.add(txtTransv[i]);

            g.gridx = col; g.gridy = row;
            g.gridwidth = 1;
            g.weightx = 1.0 / 3.0;
            g.insets = new Insets(4, 4, 4, 4);
            panel.add(celda, g);

            col++;
            if (col == 3) { col = 0; row++; }
        }

        return panel;
    }

    // ── Método público para cargar datos de BD ────────────────────
    public void cargarTecnicas(List<String> tecnicas) {
        listaTecnicas.clear();
        listaTecnicas.addAll(tecnicas);
        actualizarChipsTecnicas();
    }

    public void actualizarChipsTecnicas() {
        panelTecnicas.removeAll();
        if (listaTecnicas.isEmpty()) {
            JLabel lbl = new JLabel("Competencias");
            lbl.setFont(new Font("Arial", Font.PLAIN, 11));
            lbl.setForeground(new Color(180, 180, 180));
            panelTecnicas.add(lbl);
        } else {
            for (String tec : listaTecnicas) {
                panelTecnicas.add(crearChip(tec));
            }
        }
        panelTecnicas.revalidate();
        panelTecnicas.repaint();
    }

    private JLabel crearChip(String texto) {
        JLabel chip = new JLabel(texto);
        chip.setFont(new Font("Arial", Font.PLAIN, 12));
        chip.setForeground(BLANCO);
        chip.setBackground(VERDE_BASE);
        chip.setOpaque(true);
        chip.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(VERDE_OSCURO, 1),
            BorderFactory.createEmptyBorder(4, 10, 4, 10)
        ));
        return chip;
    }

    public void cargarDatos(
            List<CandidatoIdioma>      idiomas,
            List<CandidatoTecnica>     tecnicas,
            List<CandidatoTransversal> transversales) {

        // Idiomas
        modeloIdiomas.setRowCount(0);
        if (idiomas != null) {
            for (CandidatoIdioma ci : idiomas) {
                modeloIdiomas.addRow(new Object[]{
                    ci.getIdioma()         != null ? ci.getIdioma().getNombre() : "",
                    ci.getSpeakingLevel()  != null ? ci.getSpeakingLevel()      : "",
                    ci.getWritingLevel()   != null ? ci.getWritingLevel()       : "",
                    ci.getListeningLevel() != null ? ci.getListeningLevel()     : "",
                    ci.getReadingLevel()   != null ? ci.getReadingLevel()       : ""
                });
            }
        }

        // Técnicas
        listaTecnicas.clear();
        if (tecnicas != null) {
            for (CandidatoTecnica ct : tecnicas) {
                if (ct.getCompetenciaTecnica() != null) {
                    listaTecnicas.add(ct.getCompetenciaTecnica().getNombre());
                }
            }
        }
        actualizarChipsTecnicas();

        // Transversales
        if (transversales == null) return;

        for (CandidatoTransversal ct : transversales) {
            if (ct.getTransversal() == null) continue;
            String nombre = ct.getTransversal().getNombre();
            String nivel  = ct.getNivelTr() != null ? ct.getNivelTr() : "Ninguno";

            switch (nombre) {
                case "Autonomía":               txtAutonomia.setText(nivel);     break;
                case "Liderazgo":               txtLiderazgo.setText(nivel);     break;
                case "Resolución de problemas": txtResolucion.setText(nivel);    break;
                case "Gestión del tiempo":      txtGestion.setText(nivel);       break;
                case "Creatividad":             txtCreatividad.setText(nivel);   break;
                case "Trabajo en equipo":       txtTrabajo.setText(nivel);       break;
                case "Pensamiento crítico":     txtPensamiento.setText(nivel);   break;
                case "Adaptabilidad":           txtAdaptabilidad.setText(nivel); break;
                case "Comunicación efectiva":   txtComunicacion.setText(nivel);  break;
            }
        }
    }

    // ── Helper: TextField transversal solo lectura ────────────────
    private JTextField crearTextFieldTransversal() {
        JTextField f = new JTextField("Ninguno");
        f.setBackground(BLANCO);
        f.setForeground(VERDE_OSCURO);
        f.setFont(new Font("Arial", Font.PLAIN, 12));
        f.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
            BorderFactory.createEmptyBorder(4, 8, 4, 8)
        ));
        f.setEditable(false);
        f.setFocusable(false);
        return f;
    }

    // ── Helper: ComboBox con estilo paleta ────────────────────────
    private JComboBox<String> crearComboBox(String[] opciones) {
        JComboBox<String> cmb = new JComboBox<>(opciones);
        cmb.setBackground(BLANCO);
        cmb.setForeground(VERDE_OSCURO);
        cmb.setFont(new Font("Arial", Font.PLAIN, 12));
        cmb.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 1));
        return cmb;
    }

    // ── Helper: botón con estilo paleta ──────────────────────────
    private JButton crearBoton(String texto) {
        JButton btn = new JButton(texto);
        btn.setBackground(VERDE_BASE);
        btn.setForeground(BLANCO);
        btn.setFont(new Font("Arial", Font.BOLD, 13));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setOpaque(true);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return btn;
    }

    // ── WrapLayout ────────────────────────────────────────────────
    private static class WrapLayout extends FlowLayout {
        public WrapLayout(int align, int hgap, int vgap) {
            super(align, hgap, vgap);
        }
        @Override public Dimension preferredLayoutSize(Container target) {
            return layoutSize(target, true);
        }
        @Override public Dimension minimumLayoutSize(Container target) {
            return layoutSize(target, false);
        }
        private Dimension layoutSize(Container target, boolean preferred) {
            synchronized (target.getTreeLock()) {
                int width = target.getWidth();
                if (width == 0) width = Integer.MAX_VALUE;
                Insets insets = target.getInsets();
                int maxWidth = width - insets.left - insets.right - getHgap() * 2;
                int x = 0, y = insets.top + getVgap(), rowH = 0;
                for (Component comp : target.getComponents()) {
                    if (!comp.isVisible()) continue;
                    Dimension d = preferred ? comp.getPreferredSize() : comp.getMinimumSize();
                    if (x + d.width > maxWidth) { y += rowH + getVgap(); x = 0; rowH = 0; }
                    x += d.width + getHgap();
                    rowH = Math.max(rowH, d.height);
                }
                y += rowH + insets.bottom + getVgap();
                return new Dimension(width, y);
            }
        }
    }

    // ── Main para pruebas ─────────────────────────────────────────
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Competencias - Test");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new FrmCompetencias());
            frame.setSize(1000, 620);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}





