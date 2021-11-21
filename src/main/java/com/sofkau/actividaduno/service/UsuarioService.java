package com.sofkau.actividaduno.service;

import com.sofkau.actividaduno.model.Usuario;
import com.sofkau.actividaduno.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        try {
            List<Usuario> lista = new ArrayList<>();
            usuarioRepository.findAll().forEach(e -> lista.add((Usuario) e));
            if (lista.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<List<Usuario>>(lista, HttpStatus.OK);
            }

        } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }


    }

}
