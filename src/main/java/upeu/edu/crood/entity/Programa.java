/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.crood.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author LENOVO
 */
@Data
@Entity
@Table(name="programa")
public class Programa implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prog_id")
    private Long id;
    
    @Column(name="prog_descripcion")
    private String prog_descripcion;
    
    @Column(name="prog_nombre")
    private String prog_nombre;
    
 
    
   /* @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "programa")
    private List<Taller> talleres;*/
}
