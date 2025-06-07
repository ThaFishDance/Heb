package com.tcb.heb.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "user")
    @Builder.Default
    @ToString.Exclude // Have to have this if you want to use the builder design pattern
    private List<Address> addresses = new ArrayList<>();

    public void addAddress(Address address) {
        addresses.add(address);
        address.setUser(this);
    }

    public void removeAddress(Address address) {
        addresses.remove(address);
        address.setUser(null);
    }

    @ManyToMany
    @JoinTable(
        name="user_tags",
        // Set the FK referencing the users table
        joinColumns = @JoinColumn(name="user_id"),
        // Set the other FK
        inverseJoinColumns = @JoinColumn(name="tag_id")
    )
    @Builder.Default
    @ToString.Exclude
    private Set<Tag> tags = new HashSet<>();

    public void addTag(String tagName) {
        Tag tag = new Tag(tagName);
        tags.add(tag);
        tag.getUsers().add(this);
    }

    // TODO: add remove tag

    @OneToOne(mappedBy = "user")
    private Profile profile;
}
