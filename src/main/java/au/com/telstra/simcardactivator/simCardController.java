package au.com.telstra.simcardactivator;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/simcard")
public class simCardController {

    @PostMapping
    public ResponseEntity<String> activeSim(@RequestBody Map<String,String> payload){
        RestTemplate restTemplate = new RestTemplate();
        Map<String,String> iccid = Map.of("iccid",payload.get("iccid"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String,String>> httpEntity = new HttpEntity<>(iccid,headers);
        ResponseEntity<String> result = restTemplate.postForEntity("http://localhost:8444/actuate",httpEntity,String.class);
        return result;
    }


}
