package br.com.acmepay.application.usecase;

import br.com.acmepay.application.domain.NotificationDomain;
import br.com.acmepay.application.ports.in.IFindStatusByDocUseCase;
import br.com.acmepay.application.ports.out.IFindStatusNotificationByDoc;
import br.com.acmepay.application.utils.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class FindStatusByDocUseCase implements IFindStatusByDocUseCase {

    private IFindStatusNotificationByDoc notificationByDoc;

    @Override
    public void execute(String document) {
        var notificationDomain = NotificationDomain.builder().build();

        notificationDomain.statusDocument(document, notificationByDoc);
    }
}
