INSERT INTO card_holder (id, username, password, user_type)
VALUES
(1, 'mac', 'password123', 'STANDARD'),
(2, 'jane', 'password123', 'PREMIUM'),
(3, 'admin', 'adminpass', 'PLATINUM');

INSERT INTO card (id, card_number, balance, user_id)
VALUES
(1, '1234567890123456', 1000.00, 1),
(2, '9876543210987654', 2500.00, 1),
(3, '5555666677778888', 3000.00, 2),
(4, '4444555566667777', 1500.00, 3);

INSERT INTO merchant (id, name, category)
VALUES
(1, 'Starbucks', 'FOOD_DRINKS'),
(2, 'Amazon', 'SHOPPING'),
(3, 'Gym', 'RECREATION'),
(4, 'University', 'EDUCATION');

INSERT INTO `transaction` (id, timestamp, amount, card_id, merchant_id, success)
VALUES
(1, '2024-05-18 10:00:00', 20.00, 1, 1, TRUE),
(2, '2024-05-18 11:00:00', 150.00, 2, 2, TRUE),
(3, '2024-05-18 12:00:00', 50.00, 3, 3, FALSE),
(4, '2024-05-18 13:00:00', 200.00, 4, 4, TRUE),
(5, '2024-05-18 14:00:00', 75.00, 1, 2, TRUE);