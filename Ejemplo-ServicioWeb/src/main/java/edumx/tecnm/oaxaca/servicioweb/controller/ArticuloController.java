/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edumx.tecnm.oaxaca.servicioweb.controller;

import edumx.tecnm.oaxaca.servicioweb.model.ArticuloModel;
import edumx.tecnm.oaxaca.servicioweb.utils.CustomResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author KEVIN CHAGOYA
 */
@RestController
@RequestMapping("/api/v1/articulo")
public class ArticuloController {

    @PostMapping("/")
    public CustomResponse createArticulo(@RequestBody ArticuloModel articulo) {
        CustomResponse customResponse = new CustomResponse();
        customResponse.setData(articulo);
        return customResponse;
    }

    @GetMapping("/")
    public ArticuloModel getArticulo() {
        ArticuloModel articulo = new ArticuloModel();
        articulo.setNombre("chanclas fashion");
        return articulo;
    }
}
