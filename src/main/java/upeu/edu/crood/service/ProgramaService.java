/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.crood.service;


import java.util.List;
import upeu.edu.crood.entity.Programa;

/**
 *
 * @author 51950
 */
public interface ProgramaService {

    public List<Programa> findAll();

    public Programa findById(Long id);

    public Programa save(Programa programa);

    public void delete(Programa programa);

    public void deleteById(Long id);
}

