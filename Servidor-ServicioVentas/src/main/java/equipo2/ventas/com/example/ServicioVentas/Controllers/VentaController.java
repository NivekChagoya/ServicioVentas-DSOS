/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equipo2.ventas.com.example.ServicioVentas.Controllers;

import equipo2.ventas.com.example.ServicioVentas.Models.VentaModel;
import equipo2.ventas.com.example.ServicioVentas.Service.VentaService;
import equipo2.ventas.com.example.ServicioVentas.Utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author KEVIN CHAGOYA
 */
@RestController
@RequestMapping("/api/v1/venta")
@CrossOrigin(origins="http://127.0.0.1:5500/")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @PostMapping("/")
    public CustomResponse createVenta(@RequestBody VentaModel ventaModel) {
        CustomResponse customResponse = new CustomResponse();
        ventaService.createVenta(ventaModel);
        return customResponse;
    }

    @GetMapping("/")
    public CustomResponse getVentas() {
        CustomResponse customResponse = new CustomResponse();
        customResponse.setData(ventaService.getVentas());
        return customResponse;
    }

    @GetMapping("/{FolioVenta}")
    public CustomResponse getVenta(@PathVariable String FolioVenta) {
        CustomResponse customResponse = new CustomResponse();
        customResponse.setData(ventaService.getVenta(FolioVenta));
        return customResponse;
    }

    @PutMapping("/{idVenta}")
    public CustomResponse updateVenta(@RequestBody VentaModel venta, @PathVariable Integer idVenta) {
        CustomResponse customResponse = new CustomResponse();
        ventaService.updateVenta(venta, idVenta);
        return customResponse;
    }

    @DeleteMapping("/{idVenta}")
    public CustomResponse deleteVenta(@PathVariable Integer idVenta) {
        CustomResponse customResponse = new CustomResponse();
        ventaService.deleteVenta(idVenta);
        return customResponse;
    }

}
