package com.spring.userservice.model.entity;

import library.common.model.Permissions;
import library.common.model.Roles;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(name = "account")
public class Account {

    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @Column(unique = true)
    @NaturalId
    private String username;

    @NaturalId
    private String password;

    private Permissions permissions;

    private Roles roles;

    private boolean active;

    private boolean accountExpired;

    private boolean locked;

    private boolean credentialsExpired;

//    public List<String> getRoles() {
//        return Arrays.asList(this.roles.split(","));
//    }
//
//    public List<String> getPermissions() {
//        return Arrays.asList(this.permissions.split(","));
//    }
}
