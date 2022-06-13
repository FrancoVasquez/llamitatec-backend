package com.llamitatec.backend.request.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestResource {
    private Long id;
    private String title;
    private String description;
    private String urlToImage;
    private Boolean paid;
}
