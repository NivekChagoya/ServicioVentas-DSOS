/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edumx.tecnm.oaxaca.servicioweb.service;

import edumx.tecnm.oaxaca.servicioweb.model.ClienteModel;
import java.util.List;

/**
 *
 * @author KEVIN CHAGOYA
 */
public interface ClienteService {
    
    public void createCliente(ClienteModel cliente);    
    public List getClientes(); 
    
}
