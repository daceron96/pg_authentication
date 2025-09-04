package co.com.bancolombia.api;

import co.com.bancolombia.api.dto.request.UserRequestDTO;
import co.com.bancolombia.api.mapper.UserRequestMapper;
import co.com.bancolombia.api.validator.ValidatorFactory;
import co.com.bancolombia.model.user.User;
import co.com.bancolombia.usecase.createuser.CreateUserUseCase;
import co.com.bancolombia.usecase.createuser.ListUsersUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {

    private final ListUsersUseCase listUsersUseCase;
    private final ValidatorFactory validatorFactory;
    private final CreateUserUseCase createUserUseCase;
    private final UserRequestMapper userRequestMapper;

    public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {

        return serverRequest
                .bodyToMono(UserRequestDTO.class)
                .doOnNext(validatorFactory::validateRequest)
                .map(userRequestMapper::toModel)
                .flatMap(createUserUseCase::execute)
                .flatMap(userCreated -> ServerResponse
                        .status(HttpStatus.CREATED)
                        .bodyValue(userCreated));
    }

    public Mono<ServerResponse> listUsers(ServerRequest serverRequest) {
            return ServerResponse.ok()
                    .body(listUsersUseCase.execute(), User.class);
    }

//    public Mono<ServerResponse> listenGETUseCase(ServerRequest serverRequest) {
//        // useCase.logic();
//
////        return serverRequest.bodyToMono(User.class)
////                .flatMap(validaciones :: validate)
////                .flatMap(useCase:: ejecutar)
////                .flatMap(response -> ServerResponse.ok().bodyValue(response));
//        return ServerResponse.ok().bodyValue("");
//    }


}
