package com.llamitatec.backend.user.api;

import com.llamitatec.backend.user.domain.service.UserService;
import com.llamitatec.backend.user.mapping.UserMapper;
import com.llamitatec.backend.user.resource.CreateUserResource;
import com.llamitatec.backend.user.resource.UpdateUserResource;
import com.llamitatec.backend.user.resource.UserResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/users")
public class UsersController {
    private final UserService userService;
    private final UserMapper mapper;

    public UsersController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.mapper = userMapper;
    }

    @GetMapping
    public Page<UserResource> getAllUsers(Pageable pageable){
        return mapper.modelListPage(userService.getAll(),pageable);
    }

    @GetMapping("{userId}")
    public UserResource getUserById(@PathVariable("userId") Long userId){
        return mapper.toResource(userService.getById(userId));
    }

    @PostMapping
    public UserResource createUser(@RequestBody CreateUserResource resource){
        return mapper.toResource(userService.create(mapper.toModel(resource)));
    }

    @PutMapping("{userId}")
    private UserResource updateUser(@PathVariable("userId") Long userId,@RequestBody UpdateUserResource resource){
        return mapper.toResource(userService.update(userId,mapper.toModel(resource)));
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") Long userId){
        return userService.delete(userId);
    }
}
