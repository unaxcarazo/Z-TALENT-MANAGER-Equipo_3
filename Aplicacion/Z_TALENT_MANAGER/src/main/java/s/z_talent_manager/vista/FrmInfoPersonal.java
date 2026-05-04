/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s.z_talent_manager.vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Window;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import s.z_talent_manager.modelo.Candidato;

/**
 *
 * @author fabia
 */
public class FrmInfoPersonal extends JPanel {

  // ── Paleta ───────────────────────────────────────────────────
    private static final Color VERDE_OSCURO = new Color(7,   48,  26);
    private static final Color VERDE_BASE   = new Color(51,  153, 102);
    private static final Color VERDE_MEDIO  = new Color(102, 204, 153);
    private static final Color VERDE_CLARO  = new Color(211, 254, 234);
    private static final Color BLANCO       = Color.WHITE;

    // ── Campos ───────────────────────────────────────────────────
    private JTextField txtNombreMain;
    private JTextField txtPrimerApellidoMain;
    private JTextField txtSegundoApellidoMain;
    private JTextField txtGeneroMain;
    private JTextField txtFechaNacimientoMain;
    private JTextField txtTelefonoMain;
    private JTextField txtCorreoMain;
    private JTextField txtProvinciaMain;
    private JTextField txtMunicipioMain;
    private JTextArea  txAreaSobreMiMain;

    // ── Avatar ───────────────────────────────────────────────────
    private BufferedImage imagenPerfil = null;
    private AvatarPanel   avatarPanel;

    public FrmInfoPersonal() {
        setBackground(VERDE_CLARO);
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder(24, 30, 24, 30));
        construirUI();
    }

    private void construirUI() {
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(6, 10, 6, 10);
        g.fill   = GridBagConstraints.HORIZONTAL;
        g.anchor = GridBagConstraints.NORTHWEST;

        // ════════════════════════════════════════════════
        // COLUMNA 0 — Avatar + contacto
        // ════════════════════════════════════════════════

        avatarPanel = new AvatarPanel();
        avatarPanel.setPreferredSize(new Dimension(130, 160));
        avatarPanel.setOpaque(false);
        avatarPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        avatarPanel.addMouseListener(new MouseAdapter() {
            @Override public void mouseClicked(MouseEvent e) { seleccionarFoto(); }
        });
        g.gridx = 0; g.gridy = 0; g.gridheight = 4;
        g.anchor = GridBagConstraints.NORTH;
        add(avatarPanel, g);
        g.gridheight = 1;
        g.anchor = GridBagConstraints.NORTHWEST;

        txtTelefonoMain = crearTextField("Teléfono");
        g.gridx = 0; g.gridy = 4;
        add(crearFila("TELÉFONO", txtTelefonoMain), g);

        txtFechaNacimientoMain = crearTextField("dd/mm/aaaa");
        g.gridy = 5;
        add(crearFila("FECHA NACIMIENTO", txtFechaNacimientoMain), g);

        txtCorreoMain = crearTextField("Correo electrónico");
        g.gridy = 6;
        add(crearFila("CORREO", txtCorreoMain), g);

        // ════════════════════════════════════════════════
        // COLUMNA 1 — Nombre completo
        // ════════════════════════════════════════════════

        g.gridx = 1; g.gridy = 0; g.weightx = 0.5;
        g.anchor = GridBagConstraints.NORTHWEST;
        add(crearEncabezadoColumna("Nombre completo"), g);

        txtNombreMain = crearTextField("Nombre");
        g.gridy = 1;
        add(crearFila("NOMBRE", txtNombreMain), g);

        txtPrimerApellidoMain = crearTextField("1º Apellido");
        g.gridy = 2;
        add(crearFila("1º APELLIDO", txtPrimerApellidoMain), g);

        txtSegundoApellidoMain = crearTextField("2º Apellido");
        g.gridy = 3;
        add(crearFila("2º APELLIDO", txtSegundoApellidoMain), g);

        txtGeneroMain = crearTextField("Género");
        g.gridy = 4;
        add(crearFila("GÉNERO", txtGeneroMain), g);

        txtProvinciaMain = crearTextField("Provincia");
        g.gridy = 5;
        add(crearFila("PROVINCIA", txtProvinciaMain), g);

        txtMunicipioMain = crearTextField("Municipio");
        g.gridy = 6;
        add(crearFila("MUNICIPIO", txtMunicipioMain), g);

        // ════════════════════════════════════════════════
        // COLUMNA 2 — Sobre mi
        // ════════════════════════════════════════════════

        g.gridx = 2; g.gridy = 0; g.weightx = 1.0;
        g.anchor = GridBagConstraints.NORTHWEST;
        add(crearEncabezadoCentrado("Sobre mí"), g);

        txAreaSobreMiMain = new JTextArea(4, 20);
        txAreaSobreMiMain.setLineWrap(true);
        txAreaSobreMiMain.setWrapStyleWord(true);
        txAreaSobreMiMain.setBackground(BLANCO);
        txAreaSobreMiMain.setForeground(new Color(180, 180, 180));
        txAreaSobreMiMain.setFont(new Font("Arial", Font.PLAIN, 13));
        txAreaSobreMiMain.setBorder(BorderFactory.createEmptyBorder(10, 12, 10, 12));
        txAreaSobreMiMain.setEditable(false);
        txAreaSobreMiMain.setText("Escribe una descripcion...");

        txAreaSobreMiMain.addFocusListener(new FocusAdapter() {
            final String ph = "Escribe una descripcion...";
            @Override public void focusGained(FocusEvent e) {
                if (txAreaSobreMiMain.getText().equals(ph)) {
                    txAreaSobreMiMain.setText("");
                    txAreaSobreMiMain.setForeground(VERDE_OSCURO);
                }
            }
            @Override public void focusLost(FocusEvent e) {
                if (txAreaSobreMiMain.getText().isEmpty()) {
                    txAreaSobreMiMain.setText(ph);
                    txAreaSobreMiMain.setForeground(new Color(180, 180, 180));
                }
            }
        });

        JScrollPane scroll = new JScrollPane(txAreaSobreMiMain);
        scroll.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 1));

        g.gridx = 2; g.gridy = 1;
        g.gridheight = 3;
        g.fill    = GridBagConstraints.HORIZONTAL;
        g.weighty = 0;
        add(scroll, g);
        g.gridheight = 1;
        g.fill       = GridBagConstraints.HORIZONTAL;

        // ════════════════════════════════════════════════
        // BOTON EDITAR — abre ventana de edición
        // ════════════════════════════════════════════════

        JButton btnEditar = new JButton("Editar");
        btnEditar.setBackground(VERDE_BASE);
        btnEditar.setForeground(BLANCO);
        btnEditar.setFont(new Font("Arial", Font.BOLD, 13));
        btnEditar.setFocusPainted(false);
        btnEditar.setBorderPainted(false);
        btnEditar.setOpaque(true);
        btnEditar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnEditar.addActionListener(e -> {
            
            Window ventanaPrincipal = SwingUtilities.getWindowAncestor(this);
            ventanaPrincipal.setVisible(false);

            FrmInformacionPersonalModificacion frameEditar = new FrmInformacionPersonalModificacion();
            frameEditar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frameEditar.setLocationRelativeTo(null);
            frameEditar.setVisible(true);

            frameEditar.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    ventanaPrincipal.setVisible(true);
                }
            });
        });

        g.gridx = 0; g.gridy = 7;
        g.gridwidth = 3;
        g.fill      = GridBagConstraints.NONE;
        g.anchor    = GridBagConstraints.CENTER;
        g.insets    = new Insets(16, 0, 8, 0);
        add(btnEditar, g);
    }
    
    /* ------ CARGAR DATOS DE CANDIDATO BBDD ------ */
        public void cargarDatos(Candidato candidato) {
        if (candidato == null) return;

        txtNombreMain.setText(
            candidato.getNombre() != null ? candidato.getNombre() : "");
        txtNombreMain.setForeground(VERDE_OSCURO);

        txtPrimerApellidoMain.setText(
            candidato.getPrimerApellido() != null ? candidato.getPrimerApellido() : "");
        txtPrimerApellidoMain.setForeground(VERDE_OSCURO);

        txtSegundoApellidoMain.setText(
            candidato.getSegundoApellido() != null ? candidato.getSegundoApellido() : "");
        txtSegundoApellidoMain.setForeground(VERDE_OSCURO);

        txtTelefonoMain.setText(
            candidato.getTelefono() != null ? candidato.getTelefono() : "");
        txtTelefonoMain.setForeground(VERDE_OSCURO);

        // getEmail() viene de Usuario
        txtCorreoMain.setText(
            candidato.getEmail() != null ? candidato.getEmail() : "");
        txtCorreoMain.setForeground(VERDE_OSCURO);

        txtProvinciaMain.setText(
            candidato.getProvincia() != null ? candidato.getProvincia() : "");
        txtProvinciaMain.setForeground(VERDE_OSCURO);

        txtMunicipioMain.setText(
            candidato.getMunicipio() != null ? candidato.getMunicipio() : "");
        txtMunicipioMain.setForeground(VERDE_OSCURO);

        txtGeneroMain.setText(
            candidato.getGenero() != null ? candidato.getGenero() : "");
        txtGeneroMain.setForeground(VERDE_OSCURO);

        txtFechaNacimientoMain.setText(
            candidato.getFechaNacimiento() != null
            ? candidato.getFechaNacimiento().toString() : "");
        txtFechaNacimientoMain.setForeground(VERDE_OSCURO);

        txAreaSobreMiMain.setText(
            candidato.getSobreMi() != null ? candidato.getSobreMi() : "");
        txAreaSobreMiMain.setForeground(VERDE_OSCURO);
    }

    // ── Helper: encabezado izquierda ─────────────────────────────
    private JPanel crearEncabezadoColumna(String titulo) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(false);

        JLabel lbl = new JLabel(titulo);
        lbl.setFont(new Font("Arial", Font.BOLD, 18));
        lbl.setForeground(VERDE_OSCURO);
        lbl.setAlignmentX(Component.LEFT_ALIGNMENT);

        JSeparator sep = new JSeparator(SwingConstants.HORIZONTAL);
        sep.setForeground(VERDE_OSCURO);
        sep.setMaximumSize(new Dimension(Integer.MAX_VALUE, 2));
        sep.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.add(lbl);
        panel.add(Box.createVerticalStrut(4));
        panel.add(sep);
        return panel;
    }

    // ── Helper: encabezado centrado ──────────────────────────────
    private JPanel crearEncabezadoCentrado(String titulo) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(false);

        JLabel lbl = new JLabel(titulo, SwingConstants.CENTER);
        lbl.setFont(new Font("Arial", Font.BOLD, 18));
        lbl.setForeground(VERDE_OSCURO);
        lbl.setAlignmentX(Component.CENTER_ALIGNMENT);

        JSeparator sep = new JSeparator(SwingConstants.HORIZONTAL);
        sep.setForeground(VERDE_OSCURO);
        sep.setMaximumSize(new Dimension(Integer.MAX_VALUE, 2));
        sep.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(lbl);
        panel.add(Box.createVerticalStrut(4));
        panel.add(sep);
        return panel;
    }

    // ── Helper: label pequeño encima del campo ───────────────────
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

    // ── Helper: TextField solo lectura ───────────────────────────
    private JTextField crearTextField(String placeholder) {
        JTextField f = new JTextField(18);
        f.setText(placeholder);
        f.setBackground(BLANCO);
        f.setForeground(new Color(180, 180, 180));
        f.setCaretColor(VERDE_OSCURO);
        f.setFont(new Font("Arial", Font.PLAIN, 13));
        f.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
            BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        f.setEditable(false);
        return f;
    }

    // ── Selector de foto ──────────────────────────────────────────
    private void seleccionarFoto() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter(
            "Imagenes (jpg, png, gif)", "jpg", "jpeg", "png", "gif"));
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                imagenPerfil = ImageIO.read(chooser.getSelectedFile());
                avatarPanel.repaint();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                    "No se pudo cargar la imagen.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // ── Panel avatar circular ─────────────────────────────────────
    private class AvatarPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                RenderingHints.VALUE_ANTIALIAS_ON);

            int size = 110;
            int x    = (getWidth() - size) / 2;
            int y    = 4;

            g2.setColor(VERDE_MEDIO);
            g2.fillOval(x - 3, y - 3, size + 6, size + 6);

            g2.setClip(new Ellipse2D.Float(x, y, size, size));

            if (imagenPerfil != null) {
                g2.drawImage(imagenPerfil, x, y, size, size, null);
            } else {
                g2.setColor(VERDE_BASE);
                g2.fillOval(x, y, size, size);
                g2.setClip(null);
                g2.setColor(BLANCO);
                g2.setFont(new Font("Arial", Font.BOLD, 48));
                FontMetrics fm = g2.getFontMetrics();
                g2.drawString("A",
                    x + (size - fm.stringWidth("A")) / 2,
                    y + (size - fm.getHeight()) / 2 + fm.getAscent());
            }

            g2.setClip(null);

            g2.setColor(VERDE_BASE);
            g2.setFont(new Font("Arial", Font.PLAIN, 10));
            FontMetrics fm2 = g2.getFontMetrics();
            String txt = "Toca para cambiar foto";
            g2.drawString(txt,
                (getWidth() - fm2.stringWidth(txt)) / 2,
                y + size + 18);

            g2.dispose();
        }
    }

    // ── Main para pruebas ─────────────────────────────────────────
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Info Personal - Test");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new FrmInfoPersonal());
            frame.setSize(900, 580);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}