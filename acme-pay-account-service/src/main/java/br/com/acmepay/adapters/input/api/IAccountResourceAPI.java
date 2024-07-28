package br.com.acmepay.adapters.input.api;

import br.com.acmepay.adapters.input.api.request.AccountRequest;
import br.com.acmepay.adapters.input.api.request.TransactionRequest;
import br.com.acmepay.adapters.input.api.response.AccountResponse;
import br.com.acmepay.adapters.input.api.response.CardResponse;
import br.com.acmepay.application.domain.exception.BalanceToWithdrawException;
import br.com.acmepay.application.domain.exception.ValidDocumentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/accounts")
public interface IAccountResourceAPI {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    AccountResponse create(@RequestBody AccountRequest request) throws ValidDocumentException;

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{numberAccount}")
    AccountResponse delete(@PathVariable("numberAccount") Integer numberAccount) ;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<AccountResponse> getAccounts() ;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/deposit")
    AccountResponse deposit(@RequestBody TransactionRequest transactionRequest);

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/withdraw")
    AccountResponse withdraw(@RequestBody TransactionRequest transactionRequest) throws BalanceToWithdrawException;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/transfer")
    AccountResponse transfer(@RequestBody TransactionRequest transactionRequest) throws BalanceToWithdrawException;

    @GetMapping(value = "/find-salary-customer/{document}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CardResponse> createCard(@PathVariable(name = "document") String document);

}
