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
@Table(name = "curriculumTransversal", uniqueConstraints = @UniqueConstraint(columnNames = {"idCurriculum", "idTransversal"}))
public class CurriculumTransversal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCurriculumTransversal")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idCurriculum", nullable = false)
    private Curriculum curriculum;

    @ManyToOne
    @JoinColumn(name = "idTransversal", nullable = false)
    private Transversal transversal;

    @Column(name = "nivelTr")
    private String nivelTr;

    public CurriculumTransversal() {
    }

    public CurriculumTransversal(Curriculum curriculum, Transversal transversal, String nivelTr) {
        this.curriculum = curriculum;
        this.transversal = transversal;
        this.nivelTr = nivelTr;
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

    public Transversal getTransversal() {
        return transversal;
    }

    public void setTransversal(Transversal transversal) {
        this.transversal = transversal;
    }

    public String getNivelTr() {
        return nivelTr;
    }

    public void setNivelTr(String nivelTr) {
        this.nivelTr = nivelTr;
    }

    @Override
    public String toString() {
        return "CurriculumTransversal{" + "id=" + id + ", curriculum=" + curriculum + ", transversal=" + transversal + ", nivelTr=" + nivelTr + '}';
    }

}
