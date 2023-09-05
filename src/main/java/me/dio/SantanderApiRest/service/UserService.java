package me.dio.SantanderApiRest.service;

import me.dio.SantanderApiRest.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);
}
