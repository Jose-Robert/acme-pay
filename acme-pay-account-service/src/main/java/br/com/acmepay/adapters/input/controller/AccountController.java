package br.com.acmepay.adapters.input.controller;

import br.com.acmepay.adapters.input.api.IAccountResourceAPI;
import br.com.acmepay.adapters.input.api.request.AccountRequest;
import br.com.acmepay.adapters.input.api.request.TransactionRequest;
import br.com.acmepay.adapters.input.api.response.AccountResponse;
import br.com.acmepay.adapters.input.api.response.CardResponse;
import br.com.acmepay.application.domain.AccountDomain;
import br.com.acmepay.application.domain.exception.BalanceToWithdrawException;
import br.com.acmepay.application.domain.exception.ValidDocumentException;
import br.com.acmepay.application.ports.in.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

import static br.com.acmepay.adapters.output.mapper.ResponseMapper.toResponse;

@AllArgsConstructor
@RestController
public class AccountController implements IAccountResourceAPI {

    private final ICreateAccountUseCase createAccountUseCase;
    private final IDeleteAccountUseCase deleteAccountUseCase;
    private final IListAccountUseCase listAccountUseCase;
    private final IDepositUseCase depositUseCase;
    private final IWithdrawUseCase withdrawUseCase;
    private final ITransferUseCase transferUseCase;
    private final ICreateCardUseCase createCardUseCase;

    @Override
    public AccountResponse create(AccountRequest request)  {

        try {
            var domain = AccountDomain.builder()
                    .created_at(LocalDateTime.now())
                    .updated_at(null)
                    .close(false)
                    .agency(request.getAgency())
                    .number(request.getNumber())
                    .document(request.getDocument())
                    .balance(request.getBalance())
                    .build();

            createAccountUseCase.execute(domain);

            return AccountResponse.builder()
                    .message("account created!")
                    .build();

        }catch (ValidDocumentException e){

            return AccountResponse.builder()
                    .message(e.getMessage())
                    .build();
        }


    }

    @Override
    public AccountResponse delete(Integer numberAccount) {

        var domain = AccountDomain.builder()
                .created_at(null)
                .updated_at(LocalDateTime.now())
                .close(true)
                .agency(null)
                .number(numberAccount)
                .document(null)
                .balance(null)
                .build();

        deleteAccountUseCase.execute(domain);

        return AccountResponse.builder()
                .message("account created!")
                .build();
    }

    @Override
    public List<AccountResponse> getAccounts() {

        return listAccountUseCase.execute()
                .stream()
                .map(e -> AccountResponse.builder()
                        .message(e.toString())
                        .build())
                .toList();
    }

    @Override
    public AccountResponse deposit(TransactionRequest transactionRequest) {

        var amount = transactionRequest.getTransferValue();

        var domain = AccountDomain.builder()
                .created_at(null)
                .updated_at(null)
                .close(false)
                .agency(transactionRequest.getAgency())
                .number(transactionRequest.getNumber())
                .document(transactionRequest.getDocument())
                .balance(null)
                .build();

        depositUseCase.execute(amount, domain);

        return AccountResponse.builder()
                .message("deposit made!")
                .build();
    }

    @Override
    public AccountResponse withdraw(TransactionRequest transactionRequest) throws BalanceToWithdrawException {

        try {

            var amount = transactionRequest.getTransferValue();

            var domain = AccountDomain.builder()
                    .created_at(null)
                    .updated_at(null)
                    .close(false)
                    .agency(transactionRequest.getAgency())
                    .number(transactionRequest.getNumber())
                    .document(transactionRequest.getDocument())
                    .balance(null)
                    .build();

            withdrawUseCase.execute(amount, domain);

            return AccountResponse.builder()
                    .message("withdraw made!")
                    .build();

        }catch (BalanceToWithdrawException e){

            return AccountResponse.builder()
                    .message(e.getMessage())
                    .build();
        }


    }

    @Override
    public AccountResponse transfer(TransactionRequest transactionRequest) throws BalanceToWithdrawException {

        try {

            var amount = transactionRequest.getTransferValue();

            var domain = AccountDomain.builder()
                    .created_at(null)
                    .updated_at(null)
                    .close(false)
                    .agency(transactionRequest.getAgency())
                    .number(transactionRequest.getNumber())
                    .document(transactionRequest.getDocument())
                    .balance(null)
                    .build();

            var transactionRequestDestiny = transactionRequest.getAccountDestiny();

            var domainDestiny = AccountDomain.builder()
                    .created_at(null)
                    .updated_at(null)
                    .close(false)
                    .agency(transactionRequestDestiny.getAgency())
                    .number(transactionRequestDestiny.getNumber())
                    .document(transactionRequestDestiny.getDocument())
                    .balance(null)
                    .build();

            transferUseCase.execute(domain, domainDestiny, amount);

            return AccountResponse.builder()
                    .message("transfer made!")
                    .build();

        }catch (BalanceToWithdrawException e){

            return AccountResponse.builder()
                    .message(e.getMessage())
                    .build();
        }
    }

    @Override
    public ResponseEntity<CardResponse> createCard(String document) {
        var domain = AccountDomain.builder()
                .document(document)
                .build();
        var card = createCardUseCase.execute(domain);
        return ResponseEntity.ok(toResponse(card));
    }


}
