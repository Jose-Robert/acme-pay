package br.com.acmepay.adapters.output.database.repository;

import br.com.acmepay.adapters.output.database.entity.AccountRedisEntity;
import org.springframework.data.repository.CrudRepository;


public interface IAccountRedisRepository extends CrudRepository<AccountRedisEntity, String> {

}
