package br.com.acmepay.adapters.input.api.request;

import br.com.acmepay.adapters.input.api.response.NotificationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/notifications")
public interface INotificationResourceAPI {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    NotificationResponse create(@RequestBody NotificationRequest request);

//    @ResponseStatus(HttpStatus.OK)
//    @DeleteMapping("/{numberAccount}")
//    NotificationResponse delete(@PathVariable("numberAccount") Integer numberAccount) ;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<NotificationResponse> getNotifications() ;
}
