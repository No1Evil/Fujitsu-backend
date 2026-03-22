select * from air_temperature_fees
where (vehicle_type_id = ? or vehicle_type_id is null)
    and ? between min_temperature and max_temperature
order by vehicle_type_id desc nulls last
limit 1