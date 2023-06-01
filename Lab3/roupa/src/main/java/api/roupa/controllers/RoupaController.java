package api.roupa.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import api.roupa.dtos.RoupaDto;
import api.roupa.models.Roupa;
import api.roupa.services.RoupaService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/roupas")
public class RoupaController {

    final RoupaService roupaService;

    public RoupaController(RoupaService roupaService) {
        this.roupaService = roupaService;
    }

    @PostMapping
    public ResponseEntity<Object> saveRoupa(@RequestBody @Valid RoupaDto roupaDto) {
        var roupa = new Roupa();
        BeanUtils.copyProperties(roupaDto, roupa);
        return ResponseEntity.status(HttpStatus.CREATED).body(roupaService.save(roupa));
    }

    @GetMapping
    public ResponseEntity<List<Roupa>> getAllRoupa(){
        return ResponseEntity.status(HttpStatus.OK).body(roupaService.findAll());
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Object> getOneRoupa(@PathVariable(value = "id") UUID id){
        Optional<Roupa> roupaModelOptional = roupaService.findById(id);
        if(!roupaModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Roupa não encontrada!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(roupaModelOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePlanejamento(@PathVariable(value = "id") UUID id,
                                                     @RequestBody @Valid RoupaDto roupaDto){
        Optional<Roupa> roupaModelOptional = roupaService.findById(id);
        if(!roupaModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Roupa não encontrada!");
        }
        var roupa = new Roupa();
        BeanUtils.copyProperties(roupaDto, roupa);
        roupa.setId(roupaModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(roupaService.save(roupa));
    }



}
