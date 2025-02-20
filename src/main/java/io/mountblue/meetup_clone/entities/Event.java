package io.mountblue.meetup_clone.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.*;

@Data
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 1000)
    private String description;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    private String locationName;
    private Double latitude;
    private Double longitude;

    private Integer capacity;

    private String coverPhotoUrl;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private User organizer;

    @ManyToMany(mappedBy = "attendedEvents")
    private Set<User> attendees = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "event_id")
    private List<Image> images = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "event_categories",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();

}