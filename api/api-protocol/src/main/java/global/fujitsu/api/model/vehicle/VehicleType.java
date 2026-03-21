package global.fujitsu.api.model.vehicle;

public enum VehicleType {
    UNSPECIFIED,
    CAR,
    SCOOTER,
    BIKE;

    public void validate(){
        validate("Vehicle Type must be specified");
    }

    public void validate(String errorMessage){
        if (this == UNSPECIFIED){
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
