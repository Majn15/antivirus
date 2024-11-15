package ru.mtuci.antivirus.service;

import ru.mtuci.antivirus.models.User;
import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> findAll();
    User findById(long id);
}
