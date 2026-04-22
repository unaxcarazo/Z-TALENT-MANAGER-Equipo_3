/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s.z_talent_manager.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author DAW1
 */
@Entity
@Table (name = "Curriculum")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = {"candidato", "experiencias", "curriculumTitulaciones",
                     "curriculumTransversales", "curriculumTecnicas",
                     "curriculumIdiomas"})
public class Curriculum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idCurriculum;
    
    @OneToOne
    @JoinColumn(name = "idUsuario")
    private Candidato candidato;
    
    @OneToMany(mappedBy ="curriculum")
    private List<Experiencia> experiencias;
    
    @OneToMany(mappedBy = "curriculum")
    private List<CurriculumTitulacion> curriculumTitulaciones;
    
    @OneToMany(mappedBy = "curriculum")
    private List<CurriculumTransversal> curriculumTransversales;
    
    @OneToMany(mappedBy = "curriculum")
    private List<CurriculumTecnica> curriculumTecnicas;
    
    @OneToMany(mappedBy = "curriculum")
    private List<CurriculumIdioma> curriculumIdiomas;
    
    @Column(columnDefinition = "DATE NOT NULL")
    private LocalDate fechaCreacion;
    
    private String sobreMi;
    
    private String nombre;
     
}


    