package br.com.acmepay.adapters.output.database;

import br.com.acmepay.adapters.output.database.entity.NotificationEntity;
import br.com.acmepay.adapters.output.database.repository.INotificationRepository;
import br.com.acmepay.application.domain.NotificationDomain;
import br.com.acmepay.application.ports.out.ICreateNotification;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CreateNotificationService implements ICreateNotification {

    private INotificationRepository repository;

    @Override
    public void execute(NotificationDomain domain) {

        var notificationEntity = NotificationEntity.builder()
                                    .document(domain.getDocument())
                                    .status_document(domain.getStatus_document())
                                    .created_at(domain.getCreated_at())
                                    .updated_at(null)
                                    .build();

        repository.save(notificationEntity);
    }
}
