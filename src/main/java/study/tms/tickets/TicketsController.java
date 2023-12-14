package study.tms.tickets;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import study.tms.comments.Comment;
import study.tms.tickets.exceptions.TicketNotFoundException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/tickets")
public class TicketsController {

    private final TicketsRepository ticketRepository;
    private final TicketsService ticketService;

    @GetMapping
    public Iterable<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable("id") Long id) throws TicketNotFoundException {
        return ticketRepository.findById(id).orElseThrow(() -> new TicketNotFoundException(id));
    }

    @GetMapping("/search")
    public Iterable<Ticket> searchTickets(@RequestParam("search") String searchValue) {
        return ticketRepository.searchByTitle(searchValue);
    }

    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketService.createTicket(ticket);
    }

    @PostMapping("/{id}/comment")
    public Ticket addComment(@PathVariable("id") Long ticketId, @RequestParam("userId") Long userId, @RequestBody Comment comment) {
        return ticketService.addComment(ticketId, userId, comment);
    }

    @PatchMapping("/{id}")
    public Ticket updateTicket(@PathVariable("id") Long id, @RequestBody TicketDto ticket) throws TicketNotFoundException {
        return ticketService.updateTicket(id, ticket);
    }

    @PatchMapping("/{id}/assignee")
    public Ticket addAssignee(@PathVariable("id") Long ticketId, @RequestParam("userId") Long userId) {
        return ticketService.addAssignee(ticketId, userId);
    }

}
