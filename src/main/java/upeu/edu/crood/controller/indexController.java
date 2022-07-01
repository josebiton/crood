/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.crood.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author LENOVO
 */
@Controller
public class indexController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("titulo", "Bienvenido a Thymeleaf");
        return "index";
    }
}
