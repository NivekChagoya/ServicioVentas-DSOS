/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edumx.tecnm.oaxaca.servicioweb.controller;

import edumx.tecnm.oaxaca.servicioweb.model.ArticuloModel;
import edumx.tecnm.oaxaca.servicioweb.model.ClienteModel;
import edumx.tecnm.oaxaca.servicioweb.service.ClienteService;
import edumx.tecnm.oaxaca.servicioweb.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/v1/cliente")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteservice;
    
    @PostMapping("/")
    public CustomResponse createCliente(@RequestBody ClienteModel clienteModel) {
        CustomResponse customResponse = new CustomResponse();
        clienteservice.createCliente(clienteModel);
        return customResponse;
    }
    
    @GetMapping("/")
    public CustomResponse getClientes(){
        CustomResponse customResponse = new CustomResponse();
        customResponse.setData(clienteservice.getClientes());
        return customResponse;
    }
}
