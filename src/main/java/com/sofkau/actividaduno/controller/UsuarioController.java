package com.sofkau.actividaduno.controller;


import com.sofkau.actividaduno.model.Usuario;
import com.sofkau.actividaduno.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioRepository;

    public ResponseEntity<List<Usuario>> getAllUsuarios(){
        return usuarioRepository.getAllUsuarios();
    }


}
