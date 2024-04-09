package br.com.bank.payments.controller;

import br.com.bank.payments.entity.SystemsNotification;
import br.com.bank.payments.repository.SystemsNotificationRepository;
import br.com.bank.payments.service.SystemNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class SystemsNotificationController {

    @Autowired
    SystemsNotificationRepository systemsNotificationRepository;

    @Autowired
    SystemNotificationService systemNotificationService;

    @GetMapping("/systems_notification/{system}")
    public ResponseEntity<List<SystemsNotification>> getAllSystemsNotification(@PathVariable(value="system") UUID system){
        var systemsNotificationList = systemsNotificationRepository.findBySystem(system);
        systemNotificationService.checkNotification(systemsNotificationList);
        return ResponseEntity.status(HttpStatus.OK).body(systemsNotificationList);
    }
}
