package airplane;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;


public class AirplaneQueueImpl implements AirplaneQueue {

    List<ArrayList<Aircraft>> emergencyAirplaneQueue;
    List<ArrayList<Aircraft>> vipAirplaneQueue;
    List<ArrayList<Aircraft>> passengerAirplaneQueue;
    List<ArrayList<Aircraft>> cargoAirplaneQueue;
    List<List> queueList;

    public AirplaneQueueImpl() {
        emergencyAirplaneQueue = new ArrayList<>();
        emergencyAirplaneQueue.add(new ArrayList<>());
        emergencyAirplaneQueue.add(new ArrayList<>());
        vipAirplaneQueue = new ArrayList<>(new ArrayList<>());
        vipAirplaneQueue.add(new ArrayList<>());
        vipAirplaneQueue.add(new ArrayList<>());
        passengerAirplaneQueue = new ArrayList<>(new ArrayList<>());
        passengerAirplaneQueue.add(new ArrayList<>());
        passengerAirplaneQueue.add(new ArrayList<>());
        cargoAirplaneQueue = new ArrayList<>(new ArrayList<>());
        cargoAirplaneQueue.add(new ArrayList<>());
        cargoAirplaneQueue.add(new ArrayList<>());
        queueList = new ArrayList<>();
        queueList.add(emergencyAirplaneQueue);
        queueList.add(vipAirplaneQueue);
        queueList.add(passengerAirplaneQueue);
        queueList.add(cargoAirplaneQueue);
    }

    public String queueAircraft(Aircraft aircraft) {
        switch (aircraft.getType()) {
            case "emergency":
                if (aircraft.getSize().equals("large")) {
                    emergencyAirplaneQueue.get(0).add(aircraft);
                }
                else {
                    emergencyAirplaneQueue.get(1).add(aircraft);
                }

                break;
            case "vip":
                if (aircraft.getSize().equals("large")) {
                    vipAirplaneQueue.get(0).add(aircraft);
                }
                else {
                    vipAirplaneQueue.get(1).add(aircraft);
                }

                break;
            case "passenger":
                if (aircraft.getSize().equals("large")) {
                    passengerAirplaneQueue.get(0).add(aircraft);
                }
                else {
                    passengerAirplaneQueue.get(1).add(aircraft);
                }

                break;
            case "cargo":
                if (aircraft.getSize().equals("large")) {
                    cargoAirplaneQueue.get(0).add(aircraft);
                }
                else {
                    cargoAirplaneQueue.get(1).add(aircraft);
                }

                break;
        }

        return "Aircraft Queued";
    }

    public Aircraft dequeueAircraft() throws Exception {
        Aircraft retAircraft = null;

        for (List<ArrayList<Aircraft>> queue: queueList) {
            for (ArrayList<Aircraft> sizeQueue: queue) {
                if (!sizeQueue.isEmpty()) {
                    return sizeQueue.remove(0);

                }
            }
        }

        return retAircraft;
    }

    public ArrayList<Aircraft> listAircraft() {
        ArrayList<Aircraft> retArray = new ArrayList<>();
        for (List<ArrayList<Aircraft>> queue: queueList) {
            for (ArrayList<Aircraft> sizeQueue: queue) {
                retArray.addAll(sizeQueue);
            }
        }
        return retArray;
    }
}
