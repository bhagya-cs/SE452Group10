--PAYMENT METHOD :
INSERT INTO payment_method (id,stu_id, payment_date, amount, method, trans_id, remarks)
VALUES (12,123456, '2023-04-19', 100.0, 'credit_card', '1234567890', 'Payment for tuition fees1');

INSERT INTO payment_method (id,stu_id, payment_date, amount, method, trans_id, remarks)
VALUES (23,12456, '2022-05-19', 1244.0, 'credit_car', '123455454567890', 'Payment for tuition fees2');

--INSERT INTO payment_method (id,stu_id, payment_date, amount, method, trans_id, remarks)
--VALUES (44,1236, '2022-04-19', 1244.0, 'credit_card', '123455454567890', 'Payment for tuition fees2');





--PAYMENT RECORDS:
INSERT INTO payment_record (course_id,course_fee) VALUES(123,3500);
INSERT INTO payment_record (course_id,course_fee) VALUES(153,4567);
--INSERT INTO payment_record (course_id,course_fee) VALUES(153,3760);