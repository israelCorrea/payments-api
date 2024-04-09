package br.com.bank.payments.controller;

import br.com.bank.payments.dto.IntegratedSystemsDto;
import br.com.bank.payments.entity.IntegratedSystems;
import br.com.bank.payments.repository.IntegratedSystemsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IntegratedSystemsController {

    @Autowired
    IntegratedSystemsRepository integratedSystemsRepository;

    @PostMapping("/integrated_systems")
    public ResponseEntity<IntegratedSystems> create(@RequestBody @Valid IntegratedSystemsDto integratedSystemsDto) {
        var integratedSystems = new IntegratedSystems();
        BeanUtils.copyProperties(integratedSystemsDto, integratedSystems);
        return ResponseEntity.status(HttpStatus.CREATED).body(integratedSystemsRepository.save(integratedSystems));
    }
}
