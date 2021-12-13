
package Reto2_c4.Controladores;

import Reto2_c4.Modelos.TablaPedidos;
import Reto2_c4.Servicios.ServicioPedido;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Giovanny Vanegas
 */
@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
public class ControladorPedido {
    
    @Autowired
    private ServicioPedido servPedido;
    
    @GetMapping("/all")
    public List<TablaPedidos> getPedidos(){
        return servPedido.getPedidos();
    }
    
    @GetMapping("/{id}")
    public Optional <TablaPedidos> getPedido(@PathVariable("id") int id ){
        return servPedido.getPedido(id);
    }
    
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public TablaPedidos crearPedido(@RequestBody TablaPedidos pedido){
        return servPedido.crearPedido(pedido);
        
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public TablaPedidos updatePedido(@RequestBody TablaPedidos pedido){
        return servPedido.updatePedido(pedido);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean borrarPedido(@PathVariable("id") int id){
        return servPedido.borrarPedidos(id);
    }
    
    @GetMapping("/zona/{zone}")
    public List <TablaPedidos> hallarZona(@PathVariable("zone")String zona){
        return servPedido.hallarZona(zona);
    }
    
    @GetMapping("/salesman/{id}")
    public List <TablaPedidos> pedidoVendedorId(@PathVariable("id") Integer id){
        return servPedido.pedidoVendedorId(id);
    }
    
    @GetMapping("/state/{state}/{id}")
    public List <TablaPedidos> pedidoEstatus(@PathVariable("state") String estado, @PathVariable ("id") Integer id){
        return servPedido.pedidoEstatus(estado, id);
    }
    
    @GetMapping ("/date/{date}/{id}")
    public List<TablaPedidos> fechaPedido(@PathVariable("date") String fechas, @PathVariable("id") Integer id){
        return servPedido.fechaPedido(fechas, id);
    }
    
    
    
       
}
