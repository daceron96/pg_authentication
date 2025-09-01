package co.com.bancolombia.r2dbc.mapper;
import co.com.bancolombia.model.user.User;
import co.com.bancolombia.r2dbc.user.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public interface UserMapper {

    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    UserEntity toEntity(User user);

    User toModel(UserEntity entity);

}
