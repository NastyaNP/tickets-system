package study.tms.tickets.mappers;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import study.tms.tickets.Ticket;
import study.tms.tickets.TicketDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-16T06:37:59+0300",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class TicketMapperImpl implements TicketMapper {

    @Override
    public void updateTicketFromDto(TicketDto dto, Ticket post) {
        if ( dto == null ) {
            return;
        }
    }
}
