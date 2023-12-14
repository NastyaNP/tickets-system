package study.tms.tickets;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketsRepository extends CrudRepository<Ticket, Long> {

    @Query("SELECT ticket FROM Ticket ticket WHERE lower(ticket.title) LIKE lower(concat('%', ?1, '%'))")
    List<Ticket> searchByTitle(String title);

}
