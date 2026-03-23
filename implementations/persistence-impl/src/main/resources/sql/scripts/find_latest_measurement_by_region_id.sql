select * from measurements t
where (t.region_id = ?)
and (t.measured_at <= ?)
order by t.measured_at desc
limit 1;