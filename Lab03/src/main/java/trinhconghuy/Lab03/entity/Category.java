package trinhconghuy.Lab03.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Book> books;
}