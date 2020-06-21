package com.spring.userservice.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    @NotBlank
    @Column(unique = true)
    private String email;

    @Setter(AccessLevel.NONE)
    @CreationTimestamp
    private Instant creationDate;

    public User(@NotEmpty String email) {
        this.email = email;
    }

    //    @ElementCollection
//    @CollectionTable(
//            name = "DELIVER_ADDRESS",
//            joinColumns = @JoinColumn(name = "")
//    )
//    private List<DeliverAddress> deliverAddresses = new ArrayList<>();
//
//    @ElementCollection
//    @CollectionTable(
//            name = "BILLING_ADDRESS",
//            joinColumns = @JoinColumn(name = "")
//    )
//    private List<BillingAddress> billingAddresses = new ArrayList<>();
}
