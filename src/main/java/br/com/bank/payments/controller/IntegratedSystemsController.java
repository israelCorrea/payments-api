package br.com.bank.payments.controller;

import br.com.bank.payments.dto.IntegratedSystemsDto;
import br.com.bank.payments.entity.IntegratedSystems;
import br.com.bank.payments.exception.NegocioException;
import br.com.bank.payments.repository.IntegratedSystemsRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Integrated Systems")
public class IntegratedSystemsController {

    @Autowired
    IntegratedSystemsRepository integratedSystemsRepository;

    @PostMapping(value = "/integrated_systems")
    @Operation(summary = "Cria um novo Sistema Integrado.", method = "POST")
    public ResponseEntity<IntegratedSystems> create(@RequestBody @Valid IntegratedSystemsDto integratedSystemsDto) {
        var integratedSystems = new IntegratedSystems();
        BeanUtils.copyProperties(integratedSystemsDto, integratedSystems);
        try{
            integratedSystems = integratedSystemsRepository.save(integratedSystems);
        }
        catch (DataIntegrityViolationException dataIntegrityViolationException){
            throw new NegocioException("A sigla " + integratedSystemsDto.sigla() + " já está cadastrada.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(integratedSystems);
    }
}
