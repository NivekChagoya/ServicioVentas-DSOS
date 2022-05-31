/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equipo2.ventas.com.example.ServicioVentas.ImplementService;

import equipo2.ventas.com.example.ServicioVentas.Models.VentaModel;
import equipo2.ventas.com.example.ServicioVentas.Repository.VentaRepository;
import equipo2.ventas.com.example.ServicioVentas.Service.VentaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author KEVIN CHAGOYA
 */
@Service
public class VentaServiceImplement implements VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public void createVenta(VentaModel venta) {
        ventaRepository.save(venta);
    }

    @Override
    public List getVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public VentaModel getVenta(String FolioVenta) {
        return ventaRepository.findByFolioVenta(FolioVenta);
    }

    @Override
    public void updateVenta(VentaModel ventaModel, Integer idVenta) {
        ventaModel.setIdVenta(idVenta);
        ventaRepository.save(ventaModel);
    }

    @Override
    public void deleteVenta(Integer idVenta) {
        ventaRepository.deleteById(idVenta);
    }

}
