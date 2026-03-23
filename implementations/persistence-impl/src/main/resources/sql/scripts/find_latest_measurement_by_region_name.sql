select t.* from measurements t
left join public.regions r on t.region_id = r.id
where r.name = ?
and (t.measured_at <= ?)
order by t.measured_at desc
limit 1;