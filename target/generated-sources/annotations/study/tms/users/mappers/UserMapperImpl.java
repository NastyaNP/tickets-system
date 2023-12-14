package study.tms.users.mappers;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import study.tms.users.User;
import study.tms.users.UserDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-14T05:51:13+0300",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public void updateUserFromDto(UserDto dto, User user) {
        if ( dto == null ) {
            return;
        }
    }

    @Override
    public UserDto convertToDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        return userDto;
    }
}
