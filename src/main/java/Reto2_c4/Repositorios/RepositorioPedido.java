
package Reto2_c4.Repositorios;

import Reto2_c4.Interfaces.pedidoInterfaz;
import Reto2_c4.Modelos.TablaPedidos;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Giovanny Vanegas
 */
@Repository
public class RepositorioPedido {
    
    @Autowired
    private pedidoInterfaz crudPedido;
    
    @Autowired
    private MongoTemplate mongoTemplate;
    
    public List<TablaPedidos> getPedidos(){
        return (List<TablaPedidos>) crudPedido.findAll();
    }
    
    public Optional <TablaPedidos> getPedido(int id){
        return crudPedido.findById(id);
    }
    
    public TablaPedidos crearPedido(TablaPedidos pedido){
        return crudPedido.save(pedido);
    }
    
    public void actualizarPedido(TablaPedidos pedido){
        crudPedido.save(pedido);
    }
    
    public void borrarPedido(TablaPedidos pedido){
        crudPedido.delete(pedido);
    }
    
    public Optional<TablaPedidos> ultimoUserPedido(){
        return crudPedido.findTopByOrderByIdDesc();    
    }
    
    public List<TablaPedidos> hallarZona (String zona ){
        return crudPedido.findBySalesManZone(zona);
        
    }
    
    public List<TablaPedidos> pedidoVendedorId(Integer id){
        Query query = new Query();
        
        Criteria criterio = Criteria.where("salesMan.id").is(id);
        query.addCriteria(criterio);
        
        List<TablaPedidos> pedidos = mongoTemplate.find(query, TablaPedidos.class);
        
        return pedidos;
    }
    
    public List<TablaPedidos> pedidoEstatus (String estado, Integer id){
        Query query = new Query();
        Criteria criterio = Criteria.where("salesMan.id").is(id).and ("status").is(estado);
        
        query.addCriteria(criterio);
        
        List<TablaPedidos> pedidos = mongoTemplate.find(query, TablaPedidos.class);
        
        return pedidos;
        
    }
    
    public List<TablaPedidos> fechaPedido (String fechas, Integer id){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Query query = new Query();
        
        Criteria fechaCriterio = Criteria.where("registerDay")
                .gte(LocalDate.parse(fechas, formato).minusDays(1).atStartOfDay())
                .lt(LocalDate.parse(fechas, formato).plusDays(1).atStartOfDay()).and("salesMan.id").is(id);
        
        query.addCriteria(fechaCriterio);
        
        List<TablaPedidos> pedidos = mongoTemplate.find(query, TablaPedidos.class);
        return pedidos;
    }
  
     
}
