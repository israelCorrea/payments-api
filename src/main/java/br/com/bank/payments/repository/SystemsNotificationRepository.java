package br.com.bank.payments.repository;

import br.com.bank.payments.entity.SystemsNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SystemsNotificationRepository extends JpaRepository<SystemsNotification, UUID> {
    List<SystemsNotification> findBySystemAndNotified(UUID system, boolean notified);
}
