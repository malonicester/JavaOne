package org.java.lld;

import org.java.lld.entities.User;
import org.java.lld.repository.IUserRepository;
import org.java.lld.repository.impl.InMemoryUserRepositoryImpl;
import org.java.lld.repository.impl.LongIdGenerator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        IUserRepository userRepository = new InMemoryUserRepositoryImpl(new LongIdGenerator());
        User user = new User();
        user.setName("Ashish");
        userRepository.save(user);

        List<User> all = userRepository.findAll();
        System.out.println(all);
        user.setName("Ram");
        userRepository.update(user);
        System.out.println(all);
    }
}
