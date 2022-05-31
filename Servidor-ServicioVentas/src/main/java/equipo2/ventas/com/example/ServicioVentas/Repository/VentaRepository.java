/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package equipo2.ventas.com.example.ServicioVentas.Repository;

import equipo2.ventas.com.example.ServicioVentas.Models.VentaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author KEVIN CHAGOYA
 */
@Repository
public interface VentaRepository extends JpaRepository<VentaModel,Integer>{
    public VentaModel findByFolioVenta(String FolioVenta);
}
