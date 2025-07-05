package net.engineeringdigest.journalApp.Service;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;

    @Transactional
    public void saveEntry(JournalEntry journalEntry,String userName ){
        try {
            User user = userService.findByUserName(userName);
            JournalEntry saveAll = journalEntryRepository.save(journalEntry);
            user.getCombinedData().add(saveAll);
            userService.saveEntry(user);
        } catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }

    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
    }



    public List<JournalEntry> getall(){
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findbyId(ObjectId Id){
        return journalEntryRepository.findById(Id);
    }

    public void deleteById(ObjectId Id, String userName){
        User user = userService.findByUserName(userName);
        user.getCombinedData().removeIf(x-> x.getId().equals(Id));
        userService.saveEntry(user);
        journalEntryRepository.deleteById(Id);
    }
}
