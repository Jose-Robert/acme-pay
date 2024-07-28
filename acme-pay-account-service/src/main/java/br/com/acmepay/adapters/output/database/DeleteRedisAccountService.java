package br.com.acmepay.adapters.output.database;

import br.com.acmepay.adapters.output.database.repository.IAccountRedisRepository;
import br.com.acmepay.application.ports.out.IDeleteRedisAccount;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteRedisAccountService implements IDeleteRedisAccount {

    private final IAccountRedisRepository redisRepository;

    @Override
    public void execute(String document) {

        var redisEntity = redisRepository.findById(document);

        redisEntity.ifPresent(redisRepository::delete);


    }
}
