package example.task;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table (name = "tasktodo")
public class Task {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column (length = 100, nullable = false)
    private String title;

    @Column (nullable = false, columnDefinition = "boolean")
    private boolean state;

    @Column (nullable = false)
    private LocalDate createAt;

    @Column (nullable = false)
    private LocalDateTime updateat;
}
