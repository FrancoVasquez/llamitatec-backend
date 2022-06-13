package com.llamitatec.backend.user.domain.service;

import com.llamitatec.backend.user.domain.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    //get
    List<User> getAll();
    Page<User> getAll(Pageable pageable);
    User getById(Long userId);

    //post, put, delete
    User create(User user);
    User update(Long userId, User request);
    ResponseEntity<?> delete(Long userId);
}
