package com.sofkau.actividaduno.controller;


import com.sofkau.actividaduno.model.Usuario;
import com.sofkau.actividaduno.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioRepository;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        return usuarioRepository.getAllUsuarios();
    }

    @PostMapping
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.guardarUsuario(usuario);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Usuario>> buscarById(@PathVariable("id") int id) {
        return usuarioRepository.getById(id);
    }

    //query?prprioridad=valor, como busca por parametros
    @GetMapping("/query")
    public ResponseEntity<Optional<Usuario>> getByPriority(@RequestParam("prioridad") String priority) {
        return usuarioRepository.getByPriority(priority);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarUsuario(@PathVariable("id") int id) {
        boolean respuesta = usuarioRepository.borrarById(id);
        if (respuesta) {
            return "Se elemino con exito el id: " + id;
        }
        return "No se pudo eliminar id: " + id;
    }

}
