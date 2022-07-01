/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.crood.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import upeu.edu.crood.entity.Taller;

/**
 *
 * @author LENOVO
 */
@Repository
public interface TallerRepository extends CrudRepository<Taller, Integer>{
    
}
