package productos.apiJava.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import productos.apiJava.models.ArticuloModel;

@Repository
public interface ArticuloRepository extends CrudRepository<ArticuloModel, Long> {
    public abstract ArrayList<ArticuloModel> findByLinea(String linea);
    public abstract ArrayList<ArticuloModel> findByPromocion(Boolean promocion);
    public abstract ArrayList<ArticuloModel> findByDescuento(Long descuento);
}
