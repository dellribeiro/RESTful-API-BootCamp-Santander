package me.dio.SantanderApiRest.domain.repository;

import me.dio.SantanderApiRest.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
