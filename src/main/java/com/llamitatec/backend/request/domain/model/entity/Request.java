package com.llamitatec.backend.request.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.llamitatec.backend.client.domain.model.entity.Client;
import com.llamitatec.backend.employee.domain.model.entity.Employee;
import com.llamitatec.backend.service.domain.model.entity.Service;
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
@Table(name = "requests")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max=200)
    private String title;

    @NotNull
    @NotBlank
    @Size(max = 1000)
    private String description;

    @NotNull
    @NotBlank
    private String urlToImage;

    @NotNull
    @NotBlank
    private Boolean paid;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name= "employee_id", nullable = false)
    @JsonIgnore
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name= "service_id", nullable = false)
    @JsonIgnore
    private Service service;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name= "client_id", nullable = false)
    @JsonIgnore
    private Client client;
}
