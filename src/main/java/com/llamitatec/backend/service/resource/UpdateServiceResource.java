package com.llamitatec.backend.service.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdateServiceResource {
    @NotNull
    @NotBlank
    @Size(max=100)
    private String name;

    @NotNull
    @NotBlank
    private String urlToImage;

    @NotNull
    @NotBlank
    @Size(max = 1000)
    private String description;
}
