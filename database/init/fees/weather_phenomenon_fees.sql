-- Vehicle type = Scooter, Weather phenomenon is related to snow or sleet, then WPEF = 1 €
insert into weather_phenomenon_fees (vehicle_type_id, weather_phenomenon, fee)
VALUES ( 2, 'snow', 1 );

insert into weather_phenomenon_fees (vehicle_type_id, weather_phenomenon, fee)
VALUES ( 2, 'sleet', 1 );

-- Vehicle type = Bike, Weather phenomenon is related to snow or sleet, then WPEF = 1 €
insert into weather_phenomenon_fees (vehicle_type_id, weather_phenomenon, fee)
VALUES ( 3, 'snow', 1 );

insert into weather_phenomenon_fees (vehicle_type_id, weather_phenomenon, fee)
VALUES ( 3, 'sleet', 1 );

-- Vehicle type = Scooter, Weather phenomenon is related to rain, then WPEF = 0,5 €
insert into weather_phenomenon_fees (vehicle_type_id, weather_phenomenon, fee)
VALUES ( 2, 'rain', 0.5 );

-- Vehicle type = Bike, Weather phenomenon is related to rain, then WPEF = 0,5 €
insert into weather_phenomenon_fees (vehicle_type_id, weather_phenomenon, fee)
VALUES ( 3, 'rain', 0.5 );

-- In case the weather phenomenon is glaze, hail, or thunder, then the error message “Usage of
-- selected vehicle type is forbidden” has to be given
insert into weather_phenomenon_fees (vehicle_type_id, weather_phenomenon, fee, is_allowed)
VALUES ( 2, 'glaze', 0, false );

insert into weather_phenomenon_fees (vehicle_type_id, weather_phenomenon, fee, is_allowed)
VALUES ( 2, 'hail', 0, false );

insert into weather_phenomenon_fees (vehicle_type_id, weather_phenomenon, fee, is_allowed)
VALUES ( 2, 'thunder', 0, false );

insert into weather_phenomenon_fees (vehicle_type_id, weather_phenomenon, fee, is_allowed)
VALUES ( 3, 'glaze', 0, false );

insert into weather_phenomenon_fees (vehicle_type_id, weather_phenomenon, fee, is_allowed)
VALUES ( 3, 'hail', 0, false );

insert into weather_phenomenon_fees (vehicle_type_id, weather_phenomenon, fee, is_allowed)
VALUES ( 3, 'thunder', 0, false );

insert into weather_phenomenon_fees (vehicle_type_id, weather_phenomenon, fee)
VALUES ( null, null, 0);