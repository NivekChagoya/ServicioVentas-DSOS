/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edumx.tecnm.oaxaca.servicioweb.repository;

import edumx.tecnm.oaxaca.servicioweb.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author KEVIN CHAGOYA
 */
@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel,Integer>{
    
}
