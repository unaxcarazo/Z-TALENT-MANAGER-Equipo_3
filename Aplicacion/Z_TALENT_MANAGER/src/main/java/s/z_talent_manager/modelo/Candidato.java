/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s.z_talent_manager.modelo;

import jakarta.persistence.CascadeType;
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
@ToString(exclude = {"experiencias", "candidatoTitulaciones",
                     "candidatoTransversales", "candidatoTecnicas",
                     "candidatoIdiomas"})

public class Candidato extends Usuario{
   
   /* private String nombre;
    
    private String primerApellido;
    
    private String segundoApellido; */
    
    private String municipio;
    
    private String provincia;
    
    private String telefono;
    
    private LocalDate fechaNacimiento;
    
    private String genero;
    
    private String sobreMi;
    
    @OneToMany(mappedBy ="candidato", 
               cascade = CascadeType.ALL, 
               orphanRemoval = true)
    private List<Experiencia> experiencias;
    
    @OneToMany(mappedBy = "candidato", 
               cascade = CascadeType.ALL, 
               orphanRemoval = true)
    private List<CandidatoTitulacion> candidatoTitulaciones;
    
    @OneToMany(mappedBy = "candidato", 
               cascade = CascadeType.ALL, 
               orphanRemoval = true)
    private List<CandidatoTransversal> candidatoTransversales;
    
    @OneToMany(mappedBy = "candidato", 
               cascade = CascadeType.ALL, 
               orphanRemoval = true)
    private List<CandidatoTecnica> candidatoTecnicas;
    
    @OneToMany(mappedBy = "candidato", 
               cascade = CascadeType.ALL, 
               orphanRemoval = true)
    private List<CandidatoIdioma> candidatoIdiomas;
    
    @Column(columnDefinition = "DATE NOT NULL")
    private LocalDate fechaCreacion;
   
    
    /* Obtener nombre y apellidos de Usuario para que se muestre en los FRM*/
       // --- MÉTODOS PARA EL NOMBRE ---
    @Override
    public String getNombre() {
        return super.getNombre();
    }
    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    // --- MÉTODOS PARA LOS APELLIDOS ---
    public String getPrimerApellido() {
        String ape = super.getApellidos();
        if (ape == null) return "";
        return ape.contains(" ") ? ape.split(" ")[0] : ape;
    }

    public String getSegundoApellido() {
        String ape = super.getApellidos();
        if (ape == null || !ape.contains(" ")) return "";
        return ape.substring(ape.indexOf(" ") + 1);
    }

    
    public void setPrimerApellido(String p) {
        super.setApellidos((p + " " + getSegundoApellido()).trim());
    }

    public void setSegundoApellido(String s) {
        super.setApellidos((getPrimerApellido() + " " + s).trim());
    }
}
