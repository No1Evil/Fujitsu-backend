-- Vehicle type = Scooter, Weather phenomenon is related to snow or sleet, then WPEF = 1 €
merge into weather_phenomenon_fees (id, vehicle_type_id, weather_phenomenon, fee)
VALUES ( 1,2, 'snow', 1 );

merge into weather_phenomenon_fees (id, vehicle_type_id, weather_phenomenon, fee)
VALUES ( 2,2, 'sleet', 1 );

-- Vehicle type = Bike, Weather phenomenon is related to snow or sleet, then WPEF = 1 €
merge into weather_phenomenon_fees (id, vehicle_type_id, weather_phenomenon, fee)
VALUES ( 3,3, 'snow', 1 );

merge into weather_phenomenon_fees (id, vehicle_type_id, weather_phenomenon, fee)
VALUES ( 4,3, 'sleet', 1 );

-- Vehicle type = Scooter, Weather phenomenon is related to rain, then WPEF = 0,5 €
merge into weather_phenomenon_fees (id, vehicle_type_id, weather_phenomenon, fee)
VALUES ( 5,2, 'rain', 0.5 );

-- Vehicle type = Bike, Weather phenomenon is related to rain, then WPEF = 0,5 €
merge into weather_phenomenon_fees (id, vehicle_type_id, weather_phenomenon, fee)
VALUES ( 6,3, 'rain', 0.5 );

-- In case the weather phenomenon is glaze, hail, or thunder, then the error message “Usage of
-- selected vehicle type is forbidden” has to be given
merge into weather_phenomenon_fees (id, vehicle_type_id, weather_phenomenon, fee, is_allowed)
VALUES ( 7,2, 'glaze', 0, false );

merge into weather_phenomenon_fees (id, vehicle_type_id, weather_phenomenon, fee, is_allowed)
VALUES ( 8,2, 'hail', 0, false );

merge into weather_phenomenon_fees (id, vehicle_type_id, weather_phenomenon, fee, is_allowed)
VALUES ( 9,2, 'thunder', 0, false );

merge into weather_phenomenon_fees (id, vehicle_type_id, weather_phenomenon, fee, is_allowed)
VALUES ( 10,3, 'glaze', 0, false );

merge into weather_phenomenon_fees (id, vehicle_type_id, weather_phenomenon, fee, is_allowed)
VALUES ( 11,3, 'hail', 0, false );

merge into weather_phenomenon_fees (id, vehicle_type_id, weather_phenomenon, fee, is_allowed)
VALUES ( 12,3, 'thunder', 0, false );

merge into weather_phenomenon_fees (id, vehicle_type_id, weather_phenomenon, fee)
VALUES ( 13, null, null, 0);