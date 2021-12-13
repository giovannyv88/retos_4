/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2_c4.Servicios;

import Reto2_c4.Modelos.TablaPedidos;
import Reto2_c4.Repositorios.RepositorioPedido;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Giovanny Vanegas
 */
@Service
public class ServicioPedido {
    
    @Autowired
    private RepositorioPedido repoPedido;
    
    public List<TablaPedidos> getPedidos(){
        return repoPedido.getPedidos();
    }
    
    public Optional <TablaPedidos> getPedido(int id){
        return repoPedido.getPedido(id);
    }
    
    public TablaPedidos crearPedido(TablaPedidos pedido) {
        if (pedido.getId()== null) {
            return pedido;
        } else {
            return repoPedido.crearPedido(pedido);
        }
    }
    
    public TablaPedidos updatePedido(TablaPedidos pedido){
        
        if (pedido.getId() !=null){
            Optional<TablaPedidos> pedidoColl = repoPedido.getPedido(pedido.getId());
            if (!pedidoColl.isEmpty()){
                if(pedido.getStatus() !=null){
                    pedidoColl.get().setStatus(pedido.getStatus());
                }
                repoPedido.actualizarPedido(pedidoColl.get());
                return pedidoColl.get();
            }
            else{
                return pedido;
            }
           
            
        }
        else{
            return pedido;
        }
    }
    
   public boolean borrarPedidos(int id){
       Optional <TablaPedidos> pedido = repoPedido.getPedido(id);
       
       if (pedido.isEmpty()){
           return false;
       }
       else{
           repoPedido.borrarPedido(pedido.get());
           return true;
       }
   }
   
   
   public List<TablaPedidos> hallarZona(String zona){
       return repoPedido.hallarZona(zona);
   }
   
   public List<TablaPedidos> pedidoVendedorId(Integer id){
       return repoPedido.pedidoVendedorId(id);
   }
   
   public List<TablaPedidos> pedidoEstatus(String estado , Integer id){
       return repoPedido.pedidoEstatus(estado, id);
   }
   
   public List<TablaPedidos> fechaPedido (String fecha, Integer id){
       return repoPedido.fechaPedido(fecha, id);
   }
   
      
}

