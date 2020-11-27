package my.id.fanfan.ewalletsimpleapi.service;

import my.id.fanfan.ewalletsimpleapi.entity.User;

import java.util.List;
import java.util.NoSuchElementException;

public interface UserService {
    List<User> getUsers();
    User getUser(Long id) throws NoSuchElementException;

}
