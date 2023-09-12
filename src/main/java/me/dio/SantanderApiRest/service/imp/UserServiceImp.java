package me.dio.SantanderApiRest.service.imp;

import me.dio.SantanderApiRest.domain.model.User;
import me.dio.SantanderApiRest.domain.repository.UserRepository;
import me.dio.SantanderApiRest.service.UserService;
import me.dio.SantanderApiRest.service.exception.BusinessException;
import me.dio.SantanderApiRest.service.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new BusinessException("This Account number already exists.");
        }
        if (userToCreate.getId() != null && userRepository.existsById(userToCreate.getId())) {
            throw new BusinessException("A user with this ID already exists.");
        }

        return userRepository.save(userToCreate);
    }

    @Override
    public User update(Long id, User userToUpdate) {
        User existingUser = userRepository.findById(id).orElseThrow(NotFoundException::new);

        if(!id.equals(userToUpdate.getId()))
            throw new BusinessException("Cannot update user ID. IDs do not match.");

        existingUser.setName(userToUpdate.getName());
        existingUser.setEmail(userToUpdate.getEmail());
        existingUser.setPhoneNumber(userToUpdate.getPhoneNumber());
        existingUser.setDateOfBirth(userToUpdate.getDateOfBirth());

        return userRepository.save(existingUser);
    }

    @Override
    public void delete(Long id) {
        User userToDelete = userRepository.findById(id).orElseThrow(NotFoundException::new);

        userRepository.delete(userToDelete);

    }
}
