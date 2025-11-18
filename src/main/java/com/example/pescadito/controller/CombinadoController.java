package com.example.pescadito.controller;
import com.example.pescadito.model.Combinado;
import com.example.pescadito.service.CombinadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/combinado")
public class CombinadoController {
    private final CombinadoService combinadoService;

    public CombinadoController (CombinadoService combinadoService){
        this.combinadoService = combinadoService;
    }

    @GetMapping
    public List<Combinado> obtenerCombinado(){
        return combinadoService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Combinado> obtenerCombinadoPorId(@PathVariable Integer id){
        return combinadoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?>
    crearMascota(@RequestBody Combinado combinado) {
        if (combinado.getNombre() == null || combinado.getNombre().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El campo Nombres es obligatorio");
        }
        if (combinado.getDescripcion() == null || combinado.getDescripcion().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El campo Descripcion es obligatorio");
        }
        if (combinado.getPrecio() == null) {
            return ResponseEntity.badRequest().body("El campo Precio es obligatorio");
        }
        if (combinado.getDisponible() == null) {
            return ResponseEntity.badRequest().body("El campo Disponibilidad es obligatorio");
        }
        if (combinado.getCategoria()==null || combinado.getCategoria().trim().isEmpty()){
            return ResponseEntity.badRequest().body("El campo Categoria es obligatorio");
        }
        return ResponseEntity.ok(combinadoService.crearCombinado(combinado));
    }
}
