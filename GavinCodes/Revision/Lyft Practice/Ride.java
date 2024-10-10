import java.util.ArrayList;

class Ride {
    Long rideId;
    Long riderId;
    Long driverId;
    Long timestamp;

    public Ride(Long rideId, Long riderId, Long driverId, Long timestamp) {
        this.rideId = rideId;
        this.riderId = riderId;
        this.driverId = driverId;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Ride {" +
                "rideId = " + rideId +
                ", riderId = " + riderId +
                ", driverId = " + driverId +
                ", timestamp = " + timestamp +
                '}';
    }
}


