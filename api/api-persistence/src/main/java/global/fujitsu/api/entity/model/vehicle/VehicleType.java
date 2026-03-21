package global.fujitsu.api.entity.model.vehicle;

import global.fujitsu.api.entity.model.EntityModel;

public enum VehicleType implements EntityModel {
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
