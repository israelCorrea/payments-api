package br.com.bank.payments.controller;

import br.com.bank.payments.entity.SystemsNotification;
import br.com.bank.payments.repository.SystemsNotificationRepository;
import br.com.bank.payments.service.SystemNotificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Tag(name = "Systems Notification")
public class SystemsNotificationController {

    @Autowired
    SystemsNotificationRepository systemsNotificationRepository;

    @Autowired
    SystemNotificationService systemNotificationService;

    @GetMapping(value = "/systems_notification/{system}")
    @Operation(summary = "Fornece informações de INCLUSAO, ALTERACAO ou EXCLUSAO de pagamentos por Sistema Integrado.", method = "GET")
    public ResponseEntity<List<SystemsNotification>> getAllSystemsNotification(@PathVariable(value="system") UUID system){
        var systemsNotificationList = systemsNotificationRepository.findBySystemAndNotified(system, false);
        systemNotificationService.checkNotification(systemsNotificationList);
        return ResponseEntity.status(HttpStatus.OK).body(systemsNotificationList);
    }
}
