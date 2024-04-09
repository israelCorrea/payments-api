package br.com.bank.payments.service;

import br.com.bank.payments.entity.SystemsNotification;
import br.com.bank.payments.repository.SystemsNotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemNotificationService {

    @Autowired
    SystemsNotificationRepository systemsNotificationRepository;

    public List<SystemsNotification> checkNotification(List<SystemsNotification> systemsNotificationList){
        for(var systemNotification : systemsNotificationList){
            systemNotification.setNotified(true);
            systemsNotificationRepository.save(systemNotification);
        }
        return systemsNotificationList;
    }
}
