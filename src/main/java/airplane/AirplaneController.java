package airplane;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirplaneController {

    AirplaneQueue queue;

    @RequestMapping("/initialize")
    public String initializeQueue() {
        queue = new AirplaneQueueImpl();
        return "Queue initialized";
    }

    @RequestMapping("/list")
    public String listAircraft() {
        ObjectMapper objectMapper = new ObjectMapper();
        String retString;
        try {
            retString = objectMapper.writeValueAsString(queue.listAircraft());
        }
        catch (JsonProcessingException exception) {
            retString = "Could not parse list of aircraft";
        }
        return retString;
    }

    @RequestMapping("/queue")
    public String queueAircraft(@RequestParam("type") String type, @RequestParam("size") String size) {
        Aircraft aircraft = new Aircraft(type, size);
        return queue.queueAircraft(aircraft);
    }

    @RequestMapping("/dequeue")
    public String dequeueAircraft() {
        ObjectMapper objectMapper = new ObjectMapper();
        String retString;

        try {
            retString = objectMapper.writeValueAsString(queue.dequeueAircraft());
        }
        catch (Exception exception) {
            retString = exception.toString();
        }
        return retString;
    }
}
