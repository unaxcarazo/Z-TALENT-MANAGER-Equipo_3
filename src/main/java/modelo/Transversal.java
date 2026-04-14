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
@Table(name = "transversales")
public class Transversal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idTransversal")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

}
