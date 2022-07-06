/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.crood.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author LENOVO
 */
@Data
@Entity
@Table(name="taller")
public class Taller implements Serializable{
    @Id
    @Column(name="tall_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tallId;
    
    @Column(name="tall_tema")
    private String tallTema;
    
    @Column(name="tall_fecha", columnDefinition = "DATE")
    private String tallFecha;
    
    @Column(name="tall_time",columnDefinition = "TIME")
    private String tallTime;
    
    @Column(name="tall_lugar")
    private String tallLugar;
    
    @Column(name="tall_direccion")
    private String tallDireccion;
    
   // @OneToMany
    //@JoinColumn(name = "tall_pers_id") no pongas join
   // private List<Persona> personas;   
}
