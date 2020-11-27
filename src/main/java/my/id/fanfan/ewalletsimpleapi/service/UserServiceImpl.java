package my.id.fanfan.ewalletsimpleapi.service;

import my.id.fanfan.ewalletsimpleapi.entity.User;
import my.id.fanfan.ewalletsimpleapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public User getUser(Long id) throws NoSuchElementException {
        User user = userRepository.findById(id).get();
        return user;
    }

    @Override
    public User createUser(User user) {
        User userCreated = userRepository.save(user);
        return user;
    }


    @Override
    public List<User> searchUserByUsername(String username) {
        return null;
    }

    @Override
    public User addBalance(Long id,Long balance) {
        User user = userRepository.findById(id).get();
        user.setBalance(user.getBalance()+balance);
        user = userRepository.save(user);
        return user;
    }

    @Override
    public User transferBalance(Long idSender, Long idRecipient, Long value) {
        User sender = userRepository.findById(idSender).get();
        User recipient = userRepository.findById(idRecipient).get();
        sender.setBalance(sender.getBalance()-value);
        recipient.setBalance(recipient.getBalance()+value);
        sender = userRepository.save(sender);
        recipient = userRepository.save(recipient);
        return sender;
    }
}
