package io.mountblue.meetup_clone.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Data
@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 1000)
    private String description;

    private String locationName;
    private Double latitude;
    private Double longitude;

    private Date createdAt;

    private boolean isPublic = true;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;

    @ManyToMany(mappedBy = "joinedGroups")
    private Set<User> members = new HashSet<>();

    @OneToMany(mappedBy = "group")
    private List<Event> events = new ArrayList<>();

    @OneToMany(mappedBy = "group")
    private List<Discussion> discussions = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "group_id")
    private List<Image> images = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "group_categories",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();

}
