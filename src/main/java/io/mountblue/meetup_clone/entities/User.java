package io.mountblue.meetup_clone.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String firstName;
    private String lastName;
    private String bio;
    private String profilePictureUrl;

    private Date createdAt;

    private Date lastActive;
    private Boolean isActive = true;

    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "creator")
    private List<Group> createdGroups = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "group_members",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private Set<Group> joinedGroups = new HashSet<>();

    @OneToMany(mappedBy = "organizer")
    private List<Event> organizedEvents = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "event_attendees",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private Set<Event> attendedEvents = new HashSet<>();

    @OneToMany(mappedBy = "uploader")
    private List<Image> uploadedImages = new ArrayList<>();

    @OneToMany(mappedBy = "requester")
    private List<Connection> sentConnectionRequests = new ArrayList<>();

    @OneToMany(mappedBy = "receiver")
    private List<Connection> receivedConnectionRequests = new ArrayList<>();

}
