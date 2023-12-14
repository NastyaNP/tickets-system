package study.tms.users;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.tms.tickets.Ticket;
import study.tms.tickets.TicketsRepository;
import study.tms.tickets.exceptions.TicketNotFoundException;
import study.tms.users.exceptions.UserNotFoundException;
import study.tms.users.mappers.UserMapper;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;
    private final TicketsRepository ticketsRepository;
    private final UserMapper usersMapper;

    public User updateUser(Long id, UserDto users) throws UserNotFoundException {
        User usersToUpdate = usersRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        usersMapper.updateUserFromDto(users, usersToUpdate);
        return usersRepository.save(usersToUpdate);
    }

    @Override
    public Iterable<UserDto> findAll() {
        return StreamSupport.stream(usersRepository.findAll().spliterator(), true)
                .map(usersMapper::convertToDto)
                .collect(Collectors.toList());
    }
}
