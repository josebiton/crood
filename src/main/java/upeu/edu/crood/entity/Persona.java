/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.crood.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author 51950
 */
@Data
@Entity
@Table(name = "persona")
public class Persona implements Serializable {

    @Id
    @Column(name = "pers_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long persId;

    @Column(name = "pers_ap_paterno")
    private String persApPaterno;

    @Column(name = "pers_ap_materno")
    private String persApMaterno;

    @Column(name = "pers_nombres")
    private String persNombres;

    @Column(name = "pers_dni")
    private String persDni;

    @Column(name = "pers_telefono")
    private String persTelefono;

    @Column(name = "pers_estado")
    private String persEstado;
    
   
   // @JoinColumn(name="")
    //private Taller taller;
    /* @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_taller",columnDefinition = "INT")
    private Taller taller;*/
    
    // private List<Taller> talleres;
  /*  @ManyToOne @Column(name="tall_pers_id")
    @JoinColumn(name = "tido_id")
    private TipoDocumento tipoDocumento;*/
}
