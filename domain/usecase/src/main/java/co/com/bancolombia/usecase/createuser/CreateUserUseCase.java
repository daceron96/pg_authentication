package co.com.bancolombia.usecase.createuser;

import co.com.bancolombia.model.user.User;
import co.com.bancolombia.model.user.gateways.UserRepositoryGetaway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateUserUseCase {

    private final UserRepositoryGetaway userRepositoryGetaway;

    public Mono<User> execute(User user){
        return userRepositoryGetaway.save(user);
    }

}
