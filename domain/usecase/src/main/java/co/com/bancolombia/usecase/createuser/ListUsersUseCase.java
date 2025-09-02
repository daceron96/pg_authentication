package co.com.bancolombia.usecase.createuser;

import co.com.bancolombia.model.user.User;
import co.com.bancolombia.model.user.gateways.UserRepositoryGetaway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListUsersUseCase {

    private final UserRepositoryGetaway userRepositoryGetaway;

    public Flux<User> execute(){
        return userRepositoryGetaway.findAll();
    }

}
