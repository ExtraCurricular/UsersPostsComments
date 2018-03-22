package com.WebServices.PostService.repositories;

import com.WebServices.PostService.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
}
