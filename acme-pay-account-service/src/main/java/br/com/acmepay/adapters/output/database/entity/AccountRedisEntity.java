package br.com.acmepay.adapters.output.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@RedisHash(value = "Account", timeToLive = 120L)
public class AccountRedisEntity implements Serializable {

    @Id
    private String document;
    private Integer number;
    private Integer agency;
    private BigDecimal balance;
    private Boolean close;

}

