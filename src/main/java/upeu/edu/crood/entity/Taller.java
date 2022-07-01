/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.crood.entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    private Integer tallId;
    
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
    
    @ManyToOne
    @JoinColumn(name = "programa_prog_id")
    private Programa programa;   
}
