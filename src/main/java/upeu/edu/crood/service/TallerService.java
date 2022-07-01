/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.crood.service;

import java.util.List;
import upeu.edu.crood.entity.Taller;

/**
 *
 * @author LENOVO
 */
public interface TallerService {
    public List<Taller> findAll();
    
    public Taller findById(Integer id);

    public Taller save(Taller taller);

    public void delete(Taller taller);

    public void deleteById(Integer id);
}
