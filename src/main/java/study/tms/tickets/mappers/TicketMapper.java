package study.tms.tickets.mappers;

import org.mapstruct.*;
import study.tms.tickets.Ticket;
import study.tms.tickets.TicketDto;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface TicketMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateTicketFromDto(TicketDto dto, @MappingTarget Ticket post);
}
