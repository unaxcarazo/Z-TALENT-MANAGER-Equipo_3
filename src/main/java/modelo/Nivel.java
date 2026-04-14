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
@Table(name = "nivel", uniqueConstraints = @UniqueConstraint(columnNames = {"idCurriculum", "idIdioma"}))
public class Nivel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idNivel")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idCurriculum", nullable = false)
    private Curriculum curriculum;

    @ManyToOne
    @JoinColumn(name = "idIdioma", nullable = false)
    private Idioma idioma;

    @Column(name = "speakingLevel", length = 10)
    private String speakingLevel;

    @Column(name = "writingLevel", length = 10)
    private String writingLevel;

    @Column(name = "listeningLevel", length = 10)
    private String listeningLevel;

    @Column(name = "readingLevel", length = 10)
    private String readingLevel;

    @Transient
    private String nombreIdioma;

}
