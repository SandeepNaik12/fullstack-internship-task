package com.sandy.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sandy.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
			User findByEmail(String email);
}
