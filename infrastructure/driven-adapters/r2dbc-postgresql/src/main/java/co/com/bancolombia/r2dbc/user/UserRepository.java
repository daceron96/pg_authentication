package co.com.bancolombia.r2dbc.user;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ReactiveCrudRepository<UserEntity, Long> {
}
