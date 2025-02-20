package io.mountblue.meetup_clone.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Group> groups = new HashSet<>();

    @ManyToMany(mappedBy = "categories")
    private Set<Event> events = new HashSet<>();

    @ManyToMany(mappedBy = "categories")
    private Set<Discussion> discussions = new HashSet<>();
}
