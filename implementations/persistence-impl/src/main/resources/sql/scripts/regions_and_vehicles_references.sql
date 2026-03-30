merge into regions (id, name, WMO_CODE) values (1, 'Tallinn', '21211');
merge into vehicle_types (id, type) values ( 1, 'Car');
merge into vehicle_types (id, type) values (4, 'Test');
ALTER TABLE regions ALTER COLUMN id RESTART WITH 4;