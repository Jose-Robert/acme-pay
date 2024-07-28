package br.com.acmepay.adapters.output.database.repository;

import br.com.acmepay.adapters.output.database.entity.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface INotificationRepository extends JpaRepository<NotificationEntity, Long> {

    Optional<NotificationEntity> findByDocument(String document);

}
