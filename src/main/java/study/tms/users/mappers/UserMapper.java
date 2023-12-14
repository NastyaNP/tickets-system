package study.tms.users.mappers;

import org.mapstruct.*;
import study.tms.comments.Comment;
import study.tms.tickets.Ticket;
import study.tms.users.User;
import study.tms.users.UserDto;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface UserMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Named("updateUserFromDto")
    void updateUserFromDto(UserDto dto, @MappingTarget User user);

    @Named("convertToDto")
    UserDto convertToDto(User user);
}
