package productos.apiJava.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import productos.apiJava.models.UsuarioModel;
import productos.apiJava.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    /**
     * @return
     */
    public ArrayList<UsuarioModel> traerUsuarios() {
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public UsuarioModel guardarUsuario(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> traerPorId(Long id){
        return usuarioRepository.findById(id);
    }   
    
    public ArrayList<UsuarioModel> traerPorCorreo(String correo){
        return usuarioRepository.findByCorreo(correo);
    }

    public boolean eliminarUsuario(Long id){
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }
}
