package net.engineeringdigest.journalApp.Service;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.JournalEntryRepository;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveEntry(User user){
        userRepository.save(user);
    }

    public List<User> getall(){
        return userRepository.findAll();
    }

    public Optional<User> findbyId(ObjectId Id){
        return userRepository.findById(Id);
    }

    public void deleteById(ObjectId Id){
        userRepository.deleteById(Id);
    }

    public User findByUserName(String UserName){
        return userRepository.findByUserName((UserName));
    }
}
