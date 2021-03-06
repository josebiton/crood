/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.crood.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import upeu.edu.crood.entity.Persona;
import upeu.edu.crood.service.PersonaService;

/**
 *
 * @author 51950
 */
@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/all")
    public List<Persona> findAll() {
        return personaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> findById(@PathVariable Long id) {
        Persona persona = personaService.findById(id);
        return ResponseEntity.ok(persona);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        personaService.deleteById(id);
    }

    @PostMapping("/save")
    public Persona save(@RequestBody Persona persona) {
        return personaService.save(persona);
    }

    @PutMapping("/update")
    public Persona update(@RequestBody Persona persona) {
        //Persona aut = new Persona(persona.getId(),persona.getNombres(),persona.getApellidos(), persona.getEstado());        
        return personaService.save(persona);
    }
}
