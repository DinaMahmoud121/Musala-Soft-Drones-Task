INSERT INTO DRONE (id, serial_number, model, weight_limit, battery_capacity, state)
VALUES (1, 'XozATAfi3jdNTuDy', 'Middleweight', 6, 90, 'LOADING'),
       (2, 'ZGS2PS8pqFFBoHMV', 'Cruiserweight', 50, 90, 'DELIVERING'),
       (3, 'm76N6GJPKvKdvTni', 'Heavyweight', 100, 30, 'IDLE');


INSERT INTO MEDICATION (id, name, weight, code, image, drone_id)
VALUES (1, 'Panadol extre', 6, 'MEDICINE001', 'http://image1', 1),
       (2, 'Panadol cold and flu', 6, 'MEDICINE002', 'http://image2', 2),
       (3, 'Panadol night', 6, 'MEDICINE003', 'http://image3', 2);
