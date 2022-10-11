package productos.apiJava.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import productos.apiJava.models.ArticuloModel;
import productos.apiJava.services.ArticuloService;

@RestController
@RequestMapping("/producto")
public class ArticuloController {
    @Autowired
    ArticuloService articuloService;

    @GetMapping()
    public ArrayList<ArticuloModel> traerProductos(){
        return articuloService.traerProductos();
    }

    @GetMapping(path = "/{_id}")
    public Optional<ArticuloModel> traerProductoPorId(@PathVariable("_id") Long _id) {
        return this.articuloService.traerProductoPorId(_id);        
    }

    @GetMapping(path = "/promo")
    public ArrayList<ArticuloModel> traerProductosPromocion(@RequestParam("promocion") Boolean promocion) {
        return articuloService.traerPorPromocion(promocion);
    }

    @GetMapping(path = "/desc")
    public ArrayList<ArticuloModel> traerProductosDescuento(@RequestParam("descuento") Long descuento) {
        return articuloService.traerPorDescuento(descuento);
    }

    @GetMapping(path = "/lin")
    public ArrayList<ArticuloModel> traerProductosLinea(@RequestParam("linea") String linea) {
        return articuloService.traerPorLinea(linea);
    }

    @PostMapping()
    public ArticuloModel guardarProducto(@RequestBody ArticuloModel producto){
        return this.articuloService.guardarProducto(producto);
    }

    @DeleteMapping(path = "/{_id}")
    public String eliminarProducto(@PathVariable("_id") Long _id){
        boolean ok = this.articuloService.eliminarArticulo(_id);
        if(ok){
           return "Registro eliminado con Èxito"; 
        }else{
            return "El registro no se elimino correctamente";
        }
    }

}
