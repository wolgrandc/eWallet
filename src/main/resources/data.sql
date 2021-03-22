INSERT INTO USER(name, birthday, phone, personal_id_code, email, login, password) VALUES('Wolgrand Cardoso', '1990-05-05', '+55999999999', '9999999999', 'wolgrand@email.com', 'wolgrand.cardoso', '123456');
INSERT INTO USER(name, birthday, phone, personal_id_code, email, login, password) VALUES('Ayrton Macaubas', '2000-06-06', '+55999999999', '8888888888', 'ayrton@email.com', 'ayrton.macaubas', '123456');
INSERT INTO USER(name, birthday, phone, personal_id_code, email, login, password) VALUES('Ana Cristina', '1960-05-05', '+55999999999', '1111111111', 'ana@email.com', 'ana.cristina', '123456');
INSERT INTO USER(name, birthday, phone, personal_id_code, email, login, password) VALUES('Bruno Martins', '1995-10-06', '+55999999999', '2121212121', 'bruno@email.com', 'bruno.martin', '123456');
INSERT INTO USER(name, birthday, phone, personal_id_code, email, login, password) VALUES('Antonio Fagundes', '1955-11-05', '+55999999999', '1415141514', 'antonio@email.com', 'antonio.fagundes', '123456');
INSERT INTO USER(name, birthday, phone, personal_id_code, email, login, password) VALUES('Lucia Costa', '2002-01-06', '+55999999999', '1234567890', 'lucia@email.com', 'lucia.costa', '123456');
INSERT INTO USER(name, birthday, phone, personal_id_code, email, login, password) VALUES('Pedro Dantas', '1987-07-05', '+55999999999', '4587858785', 'pedro@email.com', 'pedro.dantas', '123456');
INSERT INTO USER(name, birthday, phone, personal_id_code, email, login, password) VALUES('Diego Braga', '1985-06-06', '+55999999999', '4455998877', 'diego@email.com', 'diego.braga', '123456');

INSERT INTO WALLET(user_id, value) VALUES(1, 1000);
INSERT INTO WALLET(user_id, value) VALUES(2, 500);
INSERT INTO WALLET(user_id, value) VALUES(3, 1000);
INSERT INTO WALLET(user_id, value) VALUES(4, 500);
INSERT INTO WALLET(user_id, value) VALUES(5, 1000);
INSERT INTO WALLET(user_id, value) VALUES(6, 500);
INSERT INTO WALLET(user_id, value) VALUES(7, 1000);
INSERT INTO WALLET(user_id, value) VALUES(8, 500);

INSERT INTO WITHDRAW(code, date, value, source_id) VALUES('81245124787845', '2021-03-20 12:13:07.35', 100, 1);
INSERT INTO WITHDRAW(code, date, value, source_id) VALUES('81245587787845', '2021-03-19 14:17:02.33', 150, 2);
INSERT INTO WITHDRAW(code, date, value, source_id) VALUES('81245745787845', '2021-03-19 13:45:12.12', 120, 3);
INSERT INTO WITHDRAW(code, date, value, source_id) VALUES('81244477787845', '2021-03-17 12:50:32.55', 200, 4);
INSERT INTO WITHDRAW(code, date, value, source_id) VALUES('81245698787845', '2021-03-16 17:00:55.50', 50, 5);
INSERT INTO WITHDRAW(code, date, value, source_id) VALUES('14560124787845', '2021-03-15 10:44:11.44', 100, 6);
INSERT INTO WITHDRAW(code, date, value, source_id) VALUES('80011124787845', '2021-03-15 11:33:21.21', 130, 7);

INSERT INTO PAYMENT(code, date, value, source_id) VALUES('12547884554544', '2021-03-20 12:13:07.35', 100, 7);
INSERT INTO PAYMENT(code, date, value, source_id) VALUES('12123457845465', '2021-03-19 14:17:02.33', 150, 6);
INSERT INTO PAYMENT(code, date, value, source_id) VALUES('56745656745644', '2021-03-19 13:45:12.12', 120, 5);
INSERT INTO PAYMENT(code, date, value, source_id) VALUES('78914561564578', '2021-03-18 12:45:32.55', 200, 4);
INSERT INTO PAYMENT(code, date, value, source_id) VALUES('45645645645645', '2021-03-16 17:00:55.50', 50, 3);
INSERT INTO PAYMENT(code, date, value, source_id) VALUES('79846780415621', '2021-03-15 10:44:11.44', 100, 2);
INSERT INTO PAYMENT(code, date, value, source_id) VALUES('56778984565215', '2021-03-15 11:33:21.21', 130, 1);

INSERT INTO DEPOSIT(code, date, value, target_id) VALUES('12547884554544', '2021-03-20 12:13:07.35', 100, 3);
INSERT INTO DEPOSIT(code, date, value, target_id) VALUES('12123457845465', '2021-03-19 14:17:02.33', 150, 2);
INSERT INTO DEPOSIT(code, date, value, target_id) VALUES('56745656745644', '2021-03-19 13:45:12.12', 120, 1);
INSERT INTO DEPOSIT(code, date, value, target_id) VALUES('78914561564578', '2021-03-18 12:45:32.55', 200, 5);
INSERT INTO DEPOSIT(code, date, value, target_id) VALUES('45645645645645', '2021-03-16 17:00:55.50', 50, 4);
INSERT INTO DEPOSIT(code, date, value, target_id) VALUES('79846780415621', '2021-03-15 10:44:11.44', 100, 7);
INSERT INTO DEPOSIT(code, date, value, target_id) VALUES('56778984565215', '2021-03-15 11:33:21.21', 130, 6);

INSERT INTO TRANSFER(code, date, value, source_id, target_id) VALUES('12547884554544', '2021-03-20 12:13:07.35', 100, 3, 2);
INSERT INTO TRANSFER(code, date, value, source_id, target_id) VALUES('12123457845465', '2021-03-19 14:17:02.33', 150, 2, 1);
INSERT INTO TRANSFER(code, date, value, source_id, target_id) VALUES('56745656745644', '2021-03-19 13:45:12.12', 120, 1, 7);
INSERT INTO TRANSFER(code, date, value, source_id, target_id) VALUES('78914561564578', '2021-03-18 12:45:32.55', 200, 5, 4);
INSERT INTO TRANSFER(code, date, value, source_id, target_id) VALUES('45645645645645', '2021-03-16 17:00:55.50', 50, 4, 3);
INSERT INTO TRANSFER(code, date, value, source_id, target_id) VALUES('79846780415621', '2021-03-15 10:44:11.44', 100, 7, 6);
INSERT INTO TRANSFER(code, date, value, source_id, target_id) VALUES('56778984565215', '2021-03-15 11:33:21.21', 130, 6, 5);
