package study.tms.users;

public interface UsersService {
    User updateUser(Long id, UserDto users);
    Iterable<UserDto> findAll();
}
