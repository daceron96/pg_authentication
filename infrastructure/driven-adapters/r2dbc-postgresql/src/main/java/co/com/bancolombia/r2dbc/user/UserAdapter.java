package co.com.bancolombia.r2dbc.user;

import co.com.bancolombia.model.user.User;

import co.com.bancolombia.model.user.gateways.UserRepositoryGetaway;
import co.com.bancolombia.r2dbc.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UserAdapter implements UserRepositoryGetaway {

    private final UserRepository repository;

    @Override
    public Mono<User> save(User user){
        return repository.save(UserMapper.MAPPER.toEntity(user))
                .map(UserMapper.MAPPER::toModel);

    }

}
