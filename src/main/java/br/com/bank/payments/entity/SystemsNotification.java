package br.com.bank.payments.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="tb_systems_notification")
public class SystemsNotification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idSistemsNotification;
    private UUID payment;
    private UUID system;
    private LocalDateTime dateTime;
    private Boolean notified;

    public UUID getIdSistemsNotification() {
        return idSistemsNotification;
    }

    public UUID getPayment() {
        return payment;
    }

    public void setPayment(UUID payment) {
        this.payment = payment;
    }

    public UUID getSystem() {
        return system;
    }

    public void setSystem(UUID system) {
        this.system = system;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Boolean isNotified() {
        return notified;
    }

    public void setNotified(Boolean notified) {
        this.notified = notified;
    }
}
