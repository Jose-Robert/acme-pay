package br.com.acmepay.application.ports.out;

import br.com.acmepay.application.domain.NotificationDomain;

import java.util.List;

public interface IFindNotification {

    List<NotificationDomain> execute();
}
