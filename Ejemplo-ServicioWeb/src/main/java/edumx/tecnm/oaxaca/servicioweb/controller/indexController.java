/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edumx.tecnm.oaxaca.servicioweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author KEVIN CHAGOYA
 */
@RestController
public class indexController {
    
    @GetMapping("/")
    public String index(){
        return "prueba de server";
    }
        
    @GetMapping("/ejemplo")
    public String ejemplo(){
        return "Accediendo a la ruta ejemplo";
    }
    
    @GetMapping("/ejemplo/retorno/numero")
    public Integer ejemploNumero(){
        return (int)((Math.random()+1) * 100);
    }
    
    @PostMapping("/saludar")
    public String saludar(String name){
        String saludo= "Hola soy tu servidor mucho gusto";
        return saludo.concat(name == null? "Estaba en null":name);
    }
}
