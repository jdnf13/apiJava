package productos.apiJava.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import productos.apiJava.models.ArticuloModel;
import productos.apiJava.repositories.ArticuloRepository;

@Service
public class ArticuloService {
    @Autowired
    ArticuloRepository articuloRepository;

    public ArrayList<ArticuloModel> traerProductos() {
        return (ArrayList<ArticuloModel>) articuloRepository.findAll();
    }

    public ArticuloModel guardarProducto(ArticuloModel producto) {
        return articuloRepository.save(producto);
    }

    public Optional<ArticuloModel> traerProductoPorId(Long _id){
        return articuloRepository.findById(_id);
    }

    //public abstract ArrayList<ArticuloModel> findByLinea(String linea);
    public ArrayList<ArticuloModel> traerPorLinea(String linea){
        return articuloRepository.findByLinea(linea);
    }

    //public abstract ArrayList<ArticuloModel> findByPromocion(Boolean promocion);
    public ArrayList<ArticuloModel> traerPorPromocion(Boolean promocion){
        return articuloRepository.findByPromocion(promocion);
    }

    //public abstract ArrayList<ArticuloModel> findByDescuento(Long descuento);
    public ArrayList<ArticuloModel> traerPorDescuento(Long descuento){
        return articuloRepository.findByDescuento(descuento);
    }

    public boolean eliminarArticulo(Long _id){
        try {
            articuloRepository.deleteById(_id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }
}
