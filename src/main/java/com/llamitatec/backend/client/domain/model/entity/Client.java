package com.llamitatec.backend.client.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.llamitatec.backend.user.domain.model.entity.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int age;

    @NotNull
    @NotBlank
    @Size(max = 40)
    private String email;

    @NotNull
    @NotBlank
    @Size(max = 9)
    private String phone;

    @NotNull
    @NotBlank
    @Size(max = 5)
    private String altphone;

    @NotNull
    @NotBlank
    private String urlToImage;

    @NotNull
    @NotBlank
    @Size(max = 500)
    private String address;

    @NotNull
    @NotBlank
    @Size(max = 1000)
    private String description;


    //Relationship
    @OneToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name= "user_id", nullable = false)
    @JoinColumn(name= "user_name", nullable = false)
    @JsonIgnore
    private User user;
}
