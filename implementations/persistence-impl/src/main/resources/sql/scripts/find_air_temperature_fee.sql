select * from air_temperature_fees t
where (t.vehicle_type_id = ? or t.vehicle_type_id is null)
    and ? between t.min_temperature and t.max_temperature
order by
    t.vehicle_type_id desc nulls last,
    t.max_temperature - t.min_temperature
limit 1