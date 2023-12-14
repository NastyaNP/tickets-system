package study.tms.tickets;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.tms.comments.Comment;
import study.tms.tickets.exceptions.TicketNotFoundException;
import study.tms.tickets.mappers.TicketMapper;
import study.tms.users.User;
import study.tms.users.UsersRepository;
import study.tms.users.exceptions.UserNotFoundException;

@RequiredArgsConstructor
@Service
public class TicketsServiceImpl implements TicketsService {
    private final TicketsRepository ticketRepository;
    private final TicketMapper ticketMapper;
    private final UsersRepository usersRepository;

    @Override
    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    @Transactional
    public Ticket updateTicket(Long id, TicketDto ticket) throws TicketNotFoundException {
        Ticket ticketToUpdate = ticketRepository.findById(id).orElseThrow(() -> new TicketNotFoundException(id));
        ticketMapper.updateTicketFromDto(ticket, ticketToUpdate);
        return ticketRepository.save(ticketToUpdate);
    }

    @Override
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Ticket addAssignee(Long ticketId, Long userId) {
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow(() -> new TicketNotFoundException(ticketId));
        User user = usersRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        ticket.setAssignee(user);
        return ticketRepository.save(ticket);
    }

    @Override
    @Transactional
    public Ticket addComment(Long ticketId, Long userId, Comment comment) {
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow(() -> new TicketNotFoundException(ticketId));
        comment.setAuthor(usersRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId)));
        comment.setTicket(ticket);
        ticket.getComments().add(comment);
        return ticketRepository.save(ticket);
    }
}
