/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package equipo2.ventas.com.example.ServicioVentas.Service;

import equipo2.ventas.com.example.ServicioVentas.Models.VentaModel;
import java.util.List;

/**
 *
 * @author KEVIN CHAGOYA
 */
public interface VentaService {

    public void createVenta(VentaModel venta);

    public List getVentas();

    public VentaModel getVenta(String FolioVenta);

    public void updateVenta(VentaModel ventaModel, Integer idVenta);

    public void deleteVenta(Integer idVenta);
}
