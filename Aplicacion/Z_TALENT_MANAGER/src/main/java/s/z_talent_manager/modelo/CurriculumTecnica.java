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
@Table (name = "CurriculumTecnica")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = {"curriculum", "competenciaTecnica"})
public class CurriculumTecnica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idCurriculumTecnica;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCurriculum")
    private Curriculum curriculum;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCompetenciaTecnica")
    private CompetenciaTecnica competenciaTecnica;

    private String nivelTe;
    
}

