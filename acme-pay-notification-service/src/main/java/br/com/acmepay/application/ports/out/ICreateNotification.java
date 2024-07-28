package br.com.acmepay.application.ports.out;

import br.com.acmepay.application.domain.NotificationDomain;

public interface ICreateNotification {
    void execute(NotificationDomain domain);
}
