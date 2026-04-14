/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import jakarta.persistence.*;

/**
 *
 * @author Diego
 */
@Entity
//Esto evita la duplicidad de datos
@Table(name = "curriculumTecnica", uniqueConstraints = @UniqueConstraint(columnNames = {"idCurriculum", "idCompetenciaTecnica"}))
public class CurriculumTecnica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCurriculumTecnica")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idCurriculum", nullable = false)
    private Curriculum curriculum;

    @ManyToOne
    @JoinColumn(name = "idCompetenciaTecnica", nullable = false)
    private CompetenciaTecnica CompetenciaTecnica;

    @Column(name = "nivelTe")
    private String nivelTe;

    public CurriculumTecnica() {
    }

    public CurriculumTecnica(Curriculum curriculum, CompetenciaTecnica CompetenciaTecnica, String nivelTe) {
        this.curriculum = curriculum;
        this.CompetenciaTecnica = CompetenciaTecnica;
        this.nivelTe = nivelTe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

    public CompetenciaTecnica getCompetenciaTecnica() {
        return CompetenciaTecnica;
    }

    public void setCompetenciaTecnica(CompetenciaTecnica CompetenciaTecnica) {
        this.CompetenciaTecnica = CompetenciaTecnica;
    }

    public String getNivelTe() {
        return nivelTe;
    }

    public void setNivelTe(String nivelTe) {
        this.nivelTe = nivelTe;
    }

}
