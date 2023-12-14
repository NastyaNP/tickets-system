package study.tms.tickets;

import study.tms.comments.Comment;

public interface TicketsService {
    Ticket createTicket(Ticket ticket);
    Ticket updateTicket(Long id, TicketDto ticket);
    void deleteTicket(Long id);
    Ticket addAssignee(Long ticketId, Long userId);
    Ticket addComment(Long ticketId, Long userId, Comment comment);
}
