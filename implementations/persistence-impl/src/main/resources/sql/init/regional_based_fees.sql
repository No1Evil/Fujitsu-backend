-- Tallinn
merge into regional_based_fees (id, region_id, vehicle_type_id, fee)
VALUES ( 1, 1, 1, 4 );

merge into regional_based_fees (id, region_id, vehicle_type_id, fee)
VALUES ( 2, 1, 2, 3.5 );

merge into regional_based_fees (id, region_id, vehicle_type_id, fee)
VALUES (3, 1, 3, 3 );

-- Tartu
merge into regional_based_fees (id, region_id, vehicle_type_id, fee)
VALUES ( 4,2, 1, 3.5 );

merge into regional_based_fees (id, region_id, vehicle_type_id, fee)
VALUES ( 5,2, 2, 3 );

merge into regional_based_fees (id, region_id, vehicle_type_id, fee)
VALUES ( 6,2, 3, 2.5 );

-- Pärnu
merge into regional_based_fees (id, region_id, vehicle_type_id, fee)
VALUES ( 7,3, 1, 3 );

merge into regional_based_fees (id, region_id, vehicle_type_id, fee)
VALUES ( 8,3, 2, 2.5 );

merge into regional_based_fees (id, region_id, vehicle_type_id, fee)
VALUES ( 9,3, 3, 2 );