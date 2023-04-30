INSERT INTO DRONE (id, serial_number, model, weight_limit, battery_capacity, state)
VALUES (10, 'XozATAfi3jdNTuDy', 'Middleweight', 6, 90, 'LOADING'),
       (11, 'ZGS2PS8pqFFBoHMV', 'Cruiserweight', 50, 90, 'DELIVERING'),
       (12, 's5sefsedfw34srdf', 'Middleweight', 50, 90, 'IDLE'),
       (13, 'm76N6GJPKvKdvTni', 'Heavyweight', 100, 10, 'IDLE');


INSERT INTO MEDICATION (id, name, weight, code, image, drone_id)
VALUES (10, 'Panadol extre', 6, 'MEDICINE001', 'http://image1', 10),
       (11, 'Panadol cold and flu', 6, 'MEDICINE002', 'http://image2', 11),
       (12, 'Panadol night', 6, 'MEDICINE003', 'http://image3', 11);
