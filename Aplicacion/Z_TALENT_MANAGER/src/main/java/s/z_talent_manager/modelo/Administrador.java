/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s.z_talent_manager.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author DAW1
 */
@Entity
@Table(name = "Administrador")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Administrador extends Usuario{
   
    private String cargo;
    
}
