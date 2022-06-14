package com.llamitatec.backend.user.domain.persistence;

import com.llamitatec.backend.user.domain.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByTypeuser(String typeuser);

}

