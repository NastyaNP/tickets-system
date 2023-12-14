package study.tms;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import study.tms.tickets.Ticket;
import study.tms.tickets.TicketsService;
import study.tms.users.User;
import study.tms.users.UsersRepository;
import study.tms.users.UsersService;

@Component
@RequiredArgsConstructor
public class DatabaseLoader implements CommandLineRunner {

    private final TicketsService ticketService;
    private final UsersService usersService;
    private final UsersRepository usersRepository;

    @Override
    public void run(String... args) throws Exception {
        var ticket1 = createMockTicket("Test Title", "Some description", "High", "Open");
        var ticket2 = createMockTicket("Test Title 2", "Some description 2", "Low", "In Progress");
        var ticket3 = createMockTicket("Test Title 3", "Some description 3", "Medium", "Closed");
        var user1 = createMockUser("John", "Doe");
        var user2 = createMockUser("Jane", "Doe");
        var user3 = createMockUser("John", "Smith");
//        usersService.addTicketToUser(user1.getId(), ticket1.getId());
//        usersService.addTicketToUser(user1.getId(), ticket2.getId());
//        usersService.addTicketToUser(user2.getId(), ticket3.getId());
    }

    private Ticket createMockTicket(String title, String description, String priority, String status) {
        Ticket ticket = new Ticket();
        ticket.setTitle(title);
        ticket.setDescription(description);
        ticket.setPriority(priority);
        ticket.setStatus(status);
        return ticketService.createTicket(ticket);
    }

    private User createMockUser(String firstName, String lastName) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return usersRepository.save(user);
    }


}
