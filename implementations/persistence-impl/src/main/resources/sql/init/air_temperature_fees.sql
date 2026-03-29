merge into air_temperature_fees (id, vehicle_type_id, min_temperature, max_temperature, fee)
    values (1, 2, -999.9, -10, 1);

-- Vehicle type = Bike, Air temperature is less than -10 C, then ATEF = 1 €
merge into air_temperature_fees (id, vehicle_type_id, min_temperature, max_temperature, fee)
    values (2, 3, -999.9, -10, 1);

-- Vehicle type = Scooter, Air temperature is between -10̊ C and 0̊ C, then ATEF = 0,5 €
merge into air_temperature_fees (id, vehicle_type_id, min_temperature, max_temperature, fee)
values ( 3, 2, -10, 0, 0.5 );

-- Vehicle type = Bike, Air temperature is between -10̊ C and 0̊ C, then ATEF = 0,5 €
merge into air_temperature_fees (id, vehicle_type_id, min_temperature, max_temperature, fee)
values ( 4, 3, -10, 0, 0.5 );

-- remove fee from everything else
merge into air_temperature_fees (id, vehicle_type_id, min_temperature, max_temperature, fee)
values (5, null, -999.9, 999.9, 0 )