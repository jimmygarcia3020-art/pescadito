package com.example.pescadito.service;
import com.example.pescadito.model.Combinado;
import com.example.pescadito.repository.CombinadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import java.util.*;
@Service
public class CombinadoService {

        private final CombinadoRepository combinadoRepository;

        public CombinadoService(CombinadoRepository combinadoRepository){
            this.combinadoRepository = combinadoRepository;
        }

        public List<Combinado> listarTodas(){
            return combinadoRepository.findAll();
        }

        public Optional<Combinado> buscarPorId(Integer id){
            return combinadoRepository.findById(id);
        }

        public Combinado crearCombinado(Combinado combinado){
            return combinadoRepository.save(combinado);
        }

        public Combinado actualizarCombinado(Integer id, Combinado combinado){
            combinado.setId(id);
            return combinadoRepository.save(combinado);
        }

        public void eliminarCombinado(Integer id){
            combinadoRepository.deleteById(id);
        }

    }


