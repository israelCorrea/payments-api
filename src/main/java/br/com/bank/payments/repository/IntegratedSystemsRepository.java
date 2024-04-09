package br.com.bank.payments.repository;

import br.com.bank.payments.entity.IntegratedSystems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IntegratedSystemsRepository extends JpaRepository<IntegratedSystems, UUID> {
    List<IntegratedSystems> findAllByIntegrated(boolean integrated);
}
