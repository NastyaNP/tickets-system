package study.tms.tickets;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;
import study.tms.comments.Comment;
import study.tms.users.User;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Table(name = "tickets", schema = "public")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Setter
    private String title;

    @Setter
    private String description;

    @Setter
    private String priority;

    @Setter
    private String status;

    @Setter
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "ticket")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Comment> comments;

    @Setter
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "assignee_id")
    @JsonIgnoreProperties({"tickets", "comments"})
    private User assignee;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(updatable = false)
    private LocalDateTime updatedAt;

}
