/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s.z_talent_manager.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Table (name = "CurriculumIdioma")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = {"curriculum", "idioma"})
public class CurriculumIdioma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idCurriculumIdioma;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCurriculum")
    private Curriculum curriculum;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idIdioma")
    private Idioma idioma;

    private String speakingLevel;
    
    private String writingLevel;
    
    private String listeningLevel;
    
    private String readingLevel;
    
}
