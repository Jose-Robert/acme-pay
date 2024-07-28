package br.com.acmepay.application.ports.in;

import br.com.acmepay.application.domain.NotificationDomain;

public interface ICreateNotificationUseCase {

    void execute(NotificationDomain domain);

}
