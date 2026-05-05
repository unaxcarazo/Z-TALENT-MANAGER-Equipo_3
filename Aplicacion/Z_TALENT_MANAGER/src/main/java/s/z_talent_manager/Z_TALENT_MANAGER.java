/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package s.z_talent_manager;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import s.z_talent_manager.vista.FrmLogin;
import s.z_talent_manager.vista.FrmPanelAdmin;
import s.z_talent_manager.vista.FrmVentanaPrincipal;

/**
 *
 * @author DAW1
 */
public class Z_TALENT_MANAGER {

    public static void main(String[] args) {
        
        FlatLaf.setup(new FlatMacLightLaf());
        new FrmPanelAdmin().setVisible(true);
        
    }
}
