-- Light rain in the morning
merge into measurements (id, region_id, air_temperature, wind_speed, weather_phenomenon, measured_at)
values (1, 1,5.2, 4.1, 'rain', '2026-03-22 08:00:00');

-- Snowy conditions
merge into measurements (id, region_id, air_temperature, wind_speed, weather_phenomenon, measured_at)
values (2,2, -2.5, 7.8, 'snow', '2026-03-22 10:30:00');

-- Sleet during a temperature transition
merge into measurements (id, region_id, air_temperature, wind_speed, weather_phenomenon, measured_at)
values (3, 3, 1.0, 5.5, 'sleet', '2026-03-22 12:15:00');

merge into measurements (id, region_id, air_temperature, wind_speed, weather_phenomenon, measured_at)
values (4,3, 1.2, 6.5, 'sleet', '2026-03-22 12:17:18');