package au.com.telstra.simcardactivator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SimCardService {
    @Autowired
    SimCardRepo simCardRepo;

    public Optional<SimCard> getSimCard(Long id){
        return simCardRepo.findById(id);
    }
    public Optional<SimCard> createSimCard(SimCard sm){
        return Optional.of(simCardRepo.save(sm));
    }
}
