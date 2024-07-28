package br.com.acmepay.adapters.input.controller;

import br.com.acmepay.adapters.input.api.request.INotificationResourceAPI;
import br.com.acmepay.adapters.input.api.request.NotificationRequest;
import br.com.acmepay.adapters.input.api.response.NotificationResponse;
import br.com.acmepay.application.domain.NotificationDomain;
import br.com.acmepay.application.domain.enums.StatusDocument;
import br.com.acmepay.application.ports.in.ICreateNotificationUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@RestController
public class NotificationController implements INotificationResourceAPI {

    private ICreateNotificationUseCase createNotification;

    @Override
    public NotificationResponse create(NotificationRequest request) {

        var notificationDomain = NotificationDomain.builder()
                .document(request.getDocument())
                .status_document(StatusDocument.SUSPENDED)
                .created_at(LocalDateTime.now())
                .updated_at(null)
                .build();

        createNotification.execute(notificationDomain);

        return NotificationResponse.builder().message("Document Created").build();

    }

    @Override
    public List<NotificationResponse> getNotifications() {
        return List.of();
    }

}

