/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edumx.tecnm.oaxaca.servicioweb.implementservice;

import edumx.tecnm.oaxaca.servicioweb.model.ClienteModel;
import edumx.tecnm.oaxaca.servicioweb.repository.ClienteRepository;
import edumx.tecnm.oaxaca.servicioweb.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author KEVIN CHAGOYA
 */
@Service
public class ClienteServiceImplement implements ClienteService {

    @Autowired
    private ClienteRepository clienterepository;

    @Override
    public void createCliente(ClienteModel cliente) {
        clienterepository.save(cliente);
    }

    @Override
    public List getClientes() {
        return clienterepository.findAll();
    }

}
