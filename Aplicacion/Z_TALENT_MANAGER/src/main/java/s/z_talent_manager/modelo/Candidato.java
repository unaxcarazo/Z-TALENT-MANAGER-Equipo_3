/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s.z_talent_manager.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author DAW1
 */
@Entity
@Table(name = "Candidato")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "curriculum")
public class Candidato extends Usuario{
   
    private String municipio;
    
    private String provincia;
    
    private String telefono;
    
    private LocalDate fechaNacimiento;
    
    private String genero;
    
    @OneToOne(mappedBy = "candidato")
    private Curriculum curriculum;
}
