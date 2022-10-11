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

import productos.apiJava.models.UsuarioModel;
import productos.apiJava.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> traerUsuarios(){
        return usuarioService.traerUsuarios();
    }

    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }

    /**
     * @return
     */
    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> traerPorId(@PathVariable("id") Long id){
        return this.usuarioService.traerPorId(id);
    }

    @GetMapping(path = "/query")
    public ArrayList<UsuarioModel> traerPorCorreo(@RequestParam("correo") String correo){
        return this.usuarioService.traerPorCorreo(correo);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarUsuario(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if(ok){
           return "Registro eliminado con Èxito"; 
        }else{
            return "El registro no se elimino correctamente";
        }
    }
}
