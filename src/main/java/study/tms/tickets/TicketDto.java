package study.tms.tickets;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import study.tms.comments.Comment;
import study.tms.users.User;

import java.time.LocalDateTime;
import java.util.Set;

@RequiredArgsConstructor
@Getter
@Setter
@Data
public class TicketDto {
    private Long id;
    private String title;
    private String description;
    private String priority;
    private User assignee;
    private Set<Comment> comments;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
