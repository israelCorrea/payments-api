package br.com.bank.payments.entity;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="tb_integrated_systems")
public class IntegratedSystems extends RepresentationModel<IntegratedSystems> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idIntegratedSistems;
    private String sigla;
    @Column(columnDefinition = "boolean default true")
    private Boolean integrated;

    public IntegratedSystems(){
        this.integrated = true;
    }

    public UUID getIdIntegratedSistems() {
        return idIntegratedSistems;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Boolean isIntegrated() {
        return integrated;
    }

    public void setIntegrated(Boolean integrated) {
        this.integrated = integrated;
    }
}
