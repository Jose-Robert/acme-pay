package br.com.acmepay.application.usecase;

import br.com.acmepay.application.domain.NotificationDomain;
import br.com.acmepay.application.ports.in.ICreateNotificationUseCase;
import br.com.acmepay.application.ports.out.ICreateNotification;
import br.com.acmepay.application.utils.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class CreateNotificationUseCase implements ICreateNotificationUseCase {

    private ICreateNotification createNotification;

    @Override
    public void execute(NotificationDomain domain) {
        domain.create(createNotification);
    }
}
