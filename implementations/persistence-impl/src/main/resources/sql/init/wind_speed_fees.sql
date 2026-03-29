merge into wind_speed_fees (id, vehicle_type_id, min_wind_speed, max_wind_speed, fee)
values ( 1,null, 10, 20, 0.5);

merge into wind_speed_fees (id, vehicle_type_id, min_wind_speed, max_wind_speed, fee, is_allowed)
values ( 2,null, 20, 100, 0, false);