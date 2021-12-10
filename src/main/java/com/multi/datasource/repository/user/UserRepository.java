package com.multi.datasource.repository.user;

import com.multi.datasource.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
