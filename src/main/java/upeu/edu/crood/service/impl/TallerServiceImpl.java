/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.crood.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import upeu.edu.crood.entity.Taller;
import upeu.edu.crood.repository.TallerRepository;
import upeu.edu.crood.service.TallerService;

/**
 *
 * @author LENOVO
 */
@Service
public class TallerServiceImpl implements TallerService{
    @Autowired
    private TallerRepository tallerRepository;
    @Transactional(readOnly = true)

    @Override
    public List<Taller> findAll() {
    return (List<Taller>)tallerRepository.findAll();
    }

    @Override
    public Taller findById(Integer id) {
    return tallerRepository.findById(id).orElse(null);
    }

    @Override
    public Taller save(Taller taller) {
    return tallerRepository.save(taller);
    
    }

    @Override
    public void delete(Taller taller) {
      tallerRepository.delete(taller);
    }

    @Override
    public void deleteById(Integer id) {
    tallerRepository.deleteById(id);
    }
    
}
