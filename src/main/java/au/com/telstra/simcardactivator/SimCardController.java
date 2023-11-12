package au.com.telstra.simcardactivator;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;

@RestController
@RequestMapping("/api/v1/simcard")
public class SimCardController {

    @Autowired
    SimCardService simCardService;

    @PostMapping("/activate")
    public ResponseEntity<String> activeSim(@RequestBody SimCard sm){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SimCard> httpEntity = new HttpEntity<>(sm,headers);
        ResponseEntity<String> result = restTemplate.postForEntity("http://localhost:8444/actuate",httpEntity,String.class);
        if (result.getBody().contains("\"success\":true")) {
            sm.setActive(true);
        }
        createSimCard(sm);
        System.out.println(sm.getId());
        return result;
    }



    public Optional<SimCard> createSimCard(SimCard sm){
        return simCardService.createSimCard(sm);
    }
    @GetMapping("/query?simCardId={id}")
    public Optional<SimCard> getSimCard(@PathVariable long id ){
       return simCardService.getSimCard(id);
    }
}
