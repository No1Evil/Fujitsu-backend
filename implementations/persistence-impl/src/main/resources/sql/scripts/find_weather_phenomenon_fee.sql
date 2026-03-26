select * from weather_phenomenon_fees t
where (t.vehicle_type_id = ? or t.vehicle_type_id is null)
and (t.weather_phenomenon = ? or t.weather_phenomenon is null)
order by
    t.vehicle_type_id desc nulls last,
    t.weather_phenomenon desc nulls last
limit 1