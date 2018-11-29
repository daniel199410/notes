package com.notes.core.repository;



import com.notes.core.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<UserEntity, Serializable> {
    UserEntity findByUserName(String user);
}
