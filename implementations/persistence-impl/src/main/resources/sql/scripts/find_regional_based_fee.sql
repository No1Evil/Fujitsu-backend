select * from regional_based_fees t
where (t.region_id = ? or t.region_id is null)
and (t.vehicle_type_id = ? or t.vehicle_type_id is null)
order by t.region_id