/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s.z_talent_manager.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;
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
@ToString(exclude = {"experiencias", "curriculumTitulaciones",
                     "curriculumTransversales", "curriculumTecnicas",
                     "curriculumIdiomas"})

public class Candidato extends Usuario{
   
    private String nombre;
    
    private String primerApellido;
    
    private String segundoApellido;
    
    private String municipio;
    
    private String provincia;
    
    private String telefono;
    
    private LocalDate fechaNacimiento;
    
    private String genero;
    
    private String sobreMi;
    
     @OneToMany(mappedBy ="candidato")
    private List<Experiencia> experiencias;
    
    @OneToMany(mappedBy = "candidato")
    private List<CandidatoTitulacion> curriculumTitulaciones;
    
    @OneToMany(mappedBy = "candidato")
    private List<CandidatoTransversal> curriculumTransversales;
    
    @OneToMany(mappedBy = "candidato")
    private List<CandidatoTecnica> curriculumTecnicas;
    
    @OneToMany(mappedBy = "candidato")
    private List<CandidatoIdioma> curriculumIdiomas;
    
    @Column(columnDefinition = "DATE NOT NULL")
    private LocalDate fechaCreacion;
   
}
