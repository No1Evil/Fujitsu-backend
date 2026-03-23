select * from wind_speed_fees t
where (t.vehicle_type_id = ? or t.vehicle_type_id is null)
and ? between t.min_wind_speed and t.max_wind_speed
order by t.vehicle_type_id = 1
limit 1