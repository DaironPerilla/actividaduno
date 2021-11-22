package com.sofkau.actividaduno.service;

import com.sofkau.actividaduno.model.Usuario;
import com.sofkau.actividaduno.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    /**
     * Busca todos los usuarios
     * Retorna un objeto ResponseEntity el cual puede retornar una respuesta del servidor y el objeto
     * @return ResponseEntity<List<Usuario>>
     */
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

    /**
     * Guarda en la BD el usuario
     * Retorna un objeto ResponseEntity el cual puede retornar una respuesta del servidor y el objeto
     * @return ResponseEntity<Usuario>
     */
    public ResponseEntity<Usuario> guardarUsuario(Usuario us) {
        try {
            Usuario usAuxiliar = usuarioRepository.save(us);
            return new ResponseEntity<Usuario>(usAuxiliar, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Busca por id
     * Retorna un objeto ResponseEntity el cual puede retornar una respuesta del servidor y el objeto
     * @return ResponseEntity<Optional<Usuario>>
     */
    public ResponseEntity<Optional<Usuario>> getById(int id) {
        try {
            Optional<Usuario> us = usuarioRepository.findById(id);
            if (!us.isPresent()) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(us, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Busca por el valor de prioridad dado
     * Retorna un objeto ResponseEntity el cual puede retornar una respuesta del servidor y el objeto
     * @return ResponseEntity<Optional<Usuario>>
     */
    public ResponseEntity<Optional<Usuario>> getByPriority(String priority) {
        try {
            Optional<Usuario> us = usuarioRepository.findByPriority(priority);
            if (!us.isPresent()) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(us, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Borra el usuario con la id dada
     * @return boolean
     */
    public boolean borrarById(Integer id) {
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;

        }

    }


}
