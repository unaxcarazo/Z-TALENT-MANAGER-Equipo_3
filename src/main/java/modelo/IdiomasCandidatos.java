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
@Table(name = "idiomasCandidatos")
public class IdiomasCandidatos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idIdiomasCandidatos") //duda
    private Long id;

    //@
    //@
    @Column(name = "speaking")
    private String speaking;

    @Column(name = "writing")
    private String writing;

    @Column(name = "listening")
    private String listening;

    @Column(name = "reading")
    private String reading;
}
