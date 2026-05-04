/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s.z_talent_manager.vista;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import s.z_talent_manager.modelo.Experiencia;

/**
 *
 * @author fabia
 */
public class FrmExperiencias extends JPanel {

    // ── Paleta ───────────────────────────────────────────────────
    private static final Color VERDE_OSCURO = new Color(7,   48,  26);
    private static final Color VERDE_BASE   = new Color(51,  153, 102);
    private static final Color VERDE_MEDIO  = new Color(102, 204, 153);
    private static final Color VERDE_CLARO  = new Color(211, 254, 234);
    private static final Color BLANCO       = Color.WHITE;

    // ── Tabla ────────────────────────────────────────────────────
    private JTable tabla;
    private DefaultTableModel modeloTabla;

    // ── Campos solo lectura ──────────────────────────────────────
    private JTextField txtPuesto;
    private JTextField txtCompania;
    private JTextField txtFechaInicio;
    private JTextField txtFechaFin;
    private JCheckBox  chkEnCurso;
    private JTextArea  txAreaDescripcion;

    public FrmExperiencias() {
        setBackground(VERDE_CLARO);
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 24, 20, 24));
        construirUI();
    }

    private void construirUI() {
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(6, 8, 6, 8);
        g.anchor = GridBagConstraints.NORTHWEST;

        // ── Título ───────────────────────────────────────────────
        JLabel lblTitulo = new JLabel("EXPERIENCIAS", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setForeground(VERDE_OSCURO);
        g.gridx = 0; g.gridy = 0; g.gridwidth = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        g.anchor = GridBagConstraints.CENTER;
        add(lblTitulo, g);
        g.gridwidth = 1;
        g.anchor = GridBagConstraints.NORTHWEST;

        // ════════════════════════════════════════════════
        // COLUMNA 0 — Tabla + botón Editar
        // ════════════════════════════════════════════════
       
        String[] columnas = {"Compañía", "Puesto", "Fecha inicio", "Fecha fin", "En curso", "Descripción"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override public boolean isCellEditable(int row, int col) { return false; }
            @Override public Class<?> getColumnClass(int col) {
                return col == 4 ? Boolean.class : String.class;
            }
        };

        tabla = new JTable(modeloTabla);
        tabla.setBackground(BLANCO);
        tabla.setForeground(VERDE_OSCURO);
        tabla.setFont(new Font("Arial", Font.PLAIN, 13));
        tabla.setRowHeight(36);
        tabla.setSelectionBackground(VERDE_MEDIO);
        tabla.setSelectionForeground(VERDE_OSCURO);
        tabla.setGridColor(new Color(220, 220, 220));
        tabla.setShowGrid(true);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JTableHeader header = tabla.getTableHeader();
        header.setBackground(VERDE_OSCURO);
        header.setForeground(VERDE_CLARO);
        header.setFont(new Font("Arial", Font.BOLD, 13));
        header.setReorderingAllowed(false);

        // Se oculta la columna "Descripción" de la vista para que no rompa la tabla.
        tabla.getColumnModel().removeColumn(tabla.getColumnModel().getColumn(5));

        tabla.getColumnModel().getColumn(0).setPreferredWidth(120);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(70);

        tabla.getColumnModel().getColumn(4).setCellRenderer(
            new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(
                        JTable t, Object val, boolean sel, boolean foc, int r, int c) {
                    JCheckBox cb = new JCheckBox();
                    cb.setSelected(Boolean.TRUE.equals(val));
                    cb.setHorizontalAlignment(SwingConstants.CENTER);
                    cb.setBackground(sel ? VERDE_MEDIO : BLANCO);
                    return cb;
                }
            }
        );

        tabla.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) cargarFilaEnFormulario();
        });

        JScrollPane scrollTabla = new JScrollPane(tabla);
        scrollTabla.setBorder(BorderFactory.createLineBorder(
            new Color(220, 220, 220), 1));
        scrollTabla.setPreferredSize(new Dimension(460, 280));

        g.gridx = 0; g.gridy = 1;
        g.fill = GridBagConstraints.BOTH;
        g.weightx = 0.55; g.weighty = 1.0;
        add(scrollTabla, g);

        // ── Botón Editar bajo la tabla ────────────────────────────
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 4));
        panelBotones.setOpaque(false);

        JButton btnEditar = crearBoton("Editar");
        btnEditar.addActionListener(e -> {
        Window ventanaActual = SwingUtilities.getWindowAncestor(this);
        ventanaActual.setVisible(false);

        FrmExperienciaLaboralModificacion frameEditar = 
            new FrmExperienciaLaboralModificacion();  
        frameEditar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameEditar.setLocationRelativeTo(null);
        frameEditar.setVisible(true);

        frameEditar.addWindowListener(new WindowAdapter() {
            @Override public void windowClosed(WindowEvent e) {
                tabla.clearSelection();
                limpiarFormulario();
                ventanaActual.setVisible(true);
            }
        });
    });

        panelBotones.add(btnEditar);

        g.gridx = 0; g.gridy = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        g.weightx = 0; g.weighty = 0;
        add(panelBotones, g);

        // ════════════════════════════════════════════════
        // COLUMNA 1 — Formulario solo lectura
        // ════════════════════════════════════════════════

        JPanel formulario = new JPanel(new GridBagLayout());
        formulario.setOpaque(false);

        GridBagConstraints f = new GridBagConstraints();
        f.insets  = new Insets(5, 6, 5, 6);
        f.fill    = GridBagConstraints.HORIZONTAL;
        f.anchor  = GridBagConstraints.NORTHWEST;
        f.weightx = 1.0;

        // Puesto
        txtPuesto = crearTextField("Puesto");
        f.gridx = 0; f.gridy = 0; f.gridwidth = 2;
        formulario.add(crearFila("PUESTO", txtPuesto), f);

        // Compañía
        txtCompania = crearTextField("Compañía");
        f.gridy = 1;
        formulario.add(crearFila("COMPAÑÍA", txtCompania), f);

        // Fecha inicio
        txtFechaInicio = crearTextField("dd/mm/aaaa");
        f.gridy = 2;
        formulario.add(crearFila("FECHA INICIO", txtFechaInicio), f);

        // Fecha fin + checkbox En curso
        txtFechaFin = crearTextField("dd/mm/aaaa");
        chkEnCurso = new JCheckBox("En curso");
        chkEnCurso.setOpaque(false);
        chkEnCurso.setForeground(VERDE_OSCURO);
        chkEnCurso.setFont(new Font("Arial", Font.PLAIN, 12));
        chkEnCurso.setEnabled(true);
        chkEnCurso.addActionListener(e -> {
            if (chkEnCurso.isSelected()) {
                txtFechaFin.setText("En curso");
                txtFechaFin.setForeground(new Color(180, 180, 180));
            } else {
                txtFechaFin.setText("dd/mm/aaaa");
                txtFechaFin.setForeground(new Color(180, 180, 180));
            }
        });

        JPanel panelFechaFin = new JPanel(new BorderLayout(8, 0));
        panelFechaFin.setOpaque(false);
        panelFechaFin.add(txtFechaFin, BorderLayout.CENTER);
        panelFechaFin.add(chkEnCurso,  BorderLayout.EAST);
        panelFechaFin.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel filaFechaFin = new JPanel();
        filaFechaFin.setLayout(new BoxLayout(filaFechaFin, BoxLayout.Y_AXIS));
        filaFechaFin.setOpaque(false);
        JLabel lblFechaFin = new JLabel("FECHA FINALIZACIÓN");
        lblFechaFin.setFont(new Font("Arial", Font.PLAIN, 11));
        lblFechaFin.setForeground(VERDE_OSCURO);
        lblFechaFin.setAlignmentX(Component.LEFT_ALIGNMENT);
        filaFechaFin.add(lblFechaFin);
        filaFechaFin.add(Box.createVerticalStrut(3));
        filaFechaFin.add(panelFechaFin);

        f.gridy = 3; f.gridwidth = 2;
        formulario.add(filaFechaFin, f);

        // TextArea descripción
        txAreaDescripcion = new JTextArea(5, 20);
        txAreaDescripcion.setLineWrap(true);
        txAreaDescripcion.setWrapStyleWord(true);
        txAreaDescripcion.setBackground(BLANCO);
        txAreaDescripcion.setForeground(new Color(180, 180, 180));
        txAreaDescripcion.setFont(new Font("Arial", Font.PLAIN, 13));
        txAreaDescripcion.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
        txAreaDescripcion.setEditable(false);
        txAreaDescripcion.setFocusable(false);
        txAreaDescripcion.setText("Descripción...");

        JScrollPane scrollDesc = new JScrollPane(txAreaDescripcion);
        scrollDesc.setBorder(BorderFactory.createLineBorder(
            new Color(220, 220, 220), 1));

        JPanel filaDesc = new JPanel();
        filaDesc.setLayout(new BoxLayout(filaDesc, BoxLayout.Y_AXIS));
        filaDesc.setOpaque(false);
        JLabel lblDesc = new JLabel("PRINCIPALES ACTIVIDADES Y RESPONSABILIDADES");
        lblDesc.setFont(new Font("Arial", Font.PLAIN, 11));
        lblDesc.setForeground(VERDE_OSCURO);
        lblDesc.setAlignmentX(Component.LEFT_ALIGNMENT);
        scrollDesc.setAlignmentX(Component.LEFT_ALIGNMENT);
        filaDesc.add(lblDesc);
        filaDesc.add(Box.createVerticalStrut(3));
        filaDesc.add(scrollDesc);

        f.gridy = 4; f.gridwidth = 2;
        f.fill = GridBagConstraints.BOTH;
        f.weighty = 1.0;
        formulario.add(filaDesc, f);
        f.fill = GridBagConstraints.HORIZONTAL;
        f.weighty = 0;

        g.gridx = 1; g.gridy = 1;
        g.gridheight = 2;
        g.fill = GridBagConstraints.BOTH;
        g.weightx = 0.45; g.weighty = 1.0;
        add(formulario, g);
    }

    // ── CARGAR DATOS BBDD ─────────────────
    public void cargarDatos(List<Experiencia> experiencias) {
        modeloTabla.setRowCount(0);
        if (experiencias == null) return;

        for (Experiencia exp : experiencias) {
            boolean enCurso = exp.getFechaFin() == null;
            
            modeloTabla.addRow(new Object[]{
                exp.getCompañia()    != null ? exp.getCompañia()    : "",
                exp.getPuesto()      != null ? exp.getPuesto()      : "",
                exp.getFechaInicio() != null ? exp.getFechaInicio().toString() : "",
                enCurso ? "" : exp.getFechaFin().toString(),
                enCurso,
                exp.getDescripcion() != null ? exp.getDescripcion() : "" 
            });
        }
    }

    // ── Cargar fila seleccionada en formulario ────────────────────
    private void cargarFilaEnFormulario() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) return;

        txtPuesto.setText((String) modeloTabla.getValueAt(fila, 1));
        txtPuesto.setForeground(VERDE_OSCURO);
        txtCompania.setText((String) modeloTabla.getValueAt(fila, 0));
        txtCompania.setForeground(VERDE_OSCURO);
        txtFechaInicio.setText((String) modeloTabla.getValueAt(fila, 2));
        txtFechaInicio.setForeground(VERDE_OSCURO);

        boolean enCurso = Boolean.TRUE.equals(modeloTabla.getValueAt(fila, 4));
        chkEnCurso.setSelected(enCurso);

        if (enCurso) {
            txtFechaFin.setText("En curso");
            txtFechaFin.setForeground(new Color(180, 180, 180));
        } else {
            txtFechaFin.setText((String) modeloTabla.getValueAt(fila, 3));
            txtFechaFin.setForeground(VERDE_OSCURO);
        }

        if (modeloTabla.getColumnCount() > 5) {
            String desc = (String) modeloTabla.getValueAt(fila, 5);
            boolean vacio = desc == null || desc.isEmpty();
            txAreaDescripcion.setText(vacio ? "Descripción..." : desc);
            txAreaDescripcion.setForeground(
                vacio ? new Color(180, 180, 180) : VERDE_OSCURO);
        }
    }

    // ── Limpiar formulario ────────────────────────────────────────
    private void limpiarFormulario() {
        Color ph = new Color(180, 180, 180);
        txtPuesto.setText("Puesto");          txtPuesto.setForeground(ph);
        txtCompania.setText("Compañía");      txtCompania.setForeground(ph);
        txtFechaInicio.setText("dd/mm/aaaa"); txtFechaInicio.setForeground(ph);
        txtFechaFin.setText("dd/mm/aaaa");    txtFechaFin.setForeground(ph);
        chkEnCurso.setSelected(false);
        txAreaDescripcion.setText("Descripción...");
        txAreaDescripcion.setForeground(ph);
    }

    // ── Helper: TextField solo lectura ───────────────────────────
    private JTextField crearTextField(String placeholder) {
        JTextField f = new JTextField(16);
        f.setText(placeholder);
        f.setBackground(BLANCO);
        f.setForeground(new Color(180, 180, 180));
        f.setFont(new Font("Arial", Font.PLAIN, 13));
        f.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
            BorderFactory.createEmptyBorder(7, 10, 7, 10)
        ));
        f.setEditable(false);
        f.setFocusable(false);
        return f;
    }

    // ── Helper: label encima del campo ───────────────────────────
    private JPanel crearFila(String labelTexto, JTextField campo) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(false);

        JLabel lbl = new JLabel(labelTexto);
        lbl.setFont(new Font("Arial", Font.PLAIN, 11));
        lbl.setForeground(VERDE_OSCURO);
        lbl.setAlignmentX(Component.LEFT_ALIGNMENT);
        campo.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.add(lbl);
        panel.add(Box.createVerticalStrut(3));
        panel.add(campo);
        return panel;
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

    // ── Main para pruebas ─────────────────────────────────────────
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Experiencias - Test");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new FrmExperiencias());
            frame.setSize(980, 560);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}