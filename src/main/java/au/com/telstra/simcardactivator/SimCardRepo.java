package au.com.telstra.simcardactivator;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimCardRepo extends CrudRepository<SimCard,Long> {
    SimCard findById(String id);

}
