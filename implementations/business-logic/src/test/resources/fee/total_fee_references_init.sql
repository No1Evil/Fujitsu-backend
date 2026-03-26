insert into regions (id, name, wmo_code)
values (1, 'Tallinn', '121211');
insert into regions (id, name, wmo_code)
values (2, 'Tartu', '121212');
insert into regions (id, name, wmo_code)
values (3, 'Pärnu', '121213');

insert into vehicle_types(id, type)
values (1, 'Car');
insert into vehicle_types(id, type)
values (2, 'Scooter');
insert into vehicle_types(id, type)
values (3, 'Bike');

-- Tallinn
insert into regional_based_fees(region_id, vehicle_type_id, fee, is_allowed)
values (1, 1, 4, true);
insert into regional_based_fees(region_id, vehicle_type_id, fee, is_allowed)
values (1, 2, 3.5, true);
insert into regional_based_fees(region_id, vehicle_type_id, fee, is_allowed)
values (1, 3, 3, true);

-- Tartu
insert into regional_based_fees(region_id, vehicle_type_id, fee, is_allowed)
values (2, 1, 3.5, true);
insert into regional_based_fees(region_id, vehicle_type_id, fee, is_allowed)
values (2, 2, 3, true);
insert into regional_based_fees(region_id, vehicle_type_id, fee, is_allowed)
values (2, 3, 2.5, true);

-- Pärnu
insert into regional_based_fees(region_id, vehicle_type_id, fee, is_allowed)
values (3, 1, 3, true);
insert into regional_based_fees(region_id, vehicle_type_id, fee, is_allowed)
values (3, 2, 2.5, true);
insert into regional_based_fees(region_id, vehicle_type_id, fee, is_allowed)
values (3, 3, 2, true);