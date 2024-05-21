INSERT INTO customer_company (id, name)
VALUES
(1, 'Company A'),
(2, 'Company B');

INSERT INTO card_holder (id, username, password, user_type, customer_company_id)
VALUES
(1, 'mac', '$2a$12$GdSOggI/DgVJJFBfDpDTm.gWFXuXAorSqDwX0dezuz1M7r3firHQa', 'STANDARD', 1), -- https://bcrypt-generator.com/
(2, 'jane', 'password123', 'PREMIUM', 1),
(3, 'thirduser', 'adminpass', 'PLATINUM', 1),
(4, 'mac123', '$2a$12$GdSOggI/DgVJJFBfDpDTm.gWFXuXAorSqDwX0dezuz1M7r3firHQa', 'STANDARD', 2),
(5, 'jane324', 'password123', 'PREMIUM', 2),
(6, 'sixuser', 'adminpass', 'PLATINUM', 2);

INSERT INTO card (id, card_number, balance, card_holder_id)
VALUES
(1, '12', 1000.00, 1),
(2, '13', 2500.00, 2),
(3, '14', 3000.00, 3),
(4, '15', 1500.00, 4),
(5, '16', 1500.00, 5),
(6, '17', 1500.00, 6);

INSERT INTO category (id, name)
VALUES
(1, 'FOOD_DRINKS'),
(2, 'SHOPPING'),
(3, 'RECREATION'),
(4, 'EDUCATION');

INSERT INTO merchant (id, name, category_id)
VALUES
(1, 'Starbucks', 1),
(2, 'Amazon', 2),
(3, 'Gym', 3),
(4, 'University', 4);

INSERT INTO customer_merchant (customer_id, merchant_id, discount_amount)
VALUES
(1, 1, 0.2),
(1, 2, 0.1),
(2, 3, 0.3);

INSERT INTO customer_category_benefit (customer_id, merchant_id)
VALUES
(1, 1),
(1, 2),
(2, 2),
(2, 3),
(2, 4);

INSERT INTO `transaction` (id, timestamp, amount, card_id, merchant_id, success)
VALUES
(1, '2024-05-18 10:00:00', 20.00, 1, 1, 'SUCCESS'),
(2, '2024-05-18 11:00:00', 150.00, 2, 2, 'SUCCESS'),
(3, '2024-05-18 12:00:00', 50.00, 3, 3, 'FAIL'),
(4, '2024-05-18 13:00:00', 200.00, 4, 4, 'SUCCESS'),
(5, '2024-05-18 14:00:00', 75.00, 1, 2, 'SUCCESS');
