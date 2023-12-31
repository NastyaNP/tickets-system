package study.tms.tickets.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class TicketNotFoundException extends ResponseStatusException {

    public TicketNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND, "Ticket with id " + id + " not found!");
    }

}
