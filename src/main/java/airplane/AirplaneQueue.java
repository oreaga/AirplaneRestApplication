package airplane;

import java.util.List;

public interface AirplaneQueue {

        String queueAircraft(Aircraft aircraft);

        Aircraft dequeueAircraft() throws Exception;

        List<Aircraft> listAircraft();
}
