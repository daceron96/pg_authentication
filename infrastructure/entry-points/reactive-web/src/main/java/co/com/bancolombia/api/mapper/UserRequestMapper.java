package co.com.bancolombia.api.mapper;

import co.com.bancolombia.api.dto.request.UserRequestDTO;
import co.com.bancolombia.model.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserRequestMapper {

    UserRequestMapper MAPPER =  Mappers.getMapper(UserRequestMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "birthDate", target = "birthDate")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "phoneNumber", target = "phoneNumber")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "salary", target = "salary")
    User toModel(UserRequestDTO dto);
}
