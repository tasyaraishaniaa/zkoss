INSERT INTO role (id, name) VALUES (1, 'ROLE_USER');
INSERT INTO role (id, name) VALUES (2, 'ROLE_ADMIN');

INSERT INTO userLogin (id, username, password) VALUES (1, 'admin', '$2a$10$LnbH/MkKrpDyTPpOeEp7cOp4x3DB1S5PnnQqRQIp0UpxGLQmBj5Km');
INSERT INTO userLogin (id, username, password) VALUES (2, 'user', '$2a$10$cgRnh6Tbq86fkJh7MOt93.5Ol.PdAdYNlVYuArkp8dUSeywMkqeYi');

INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (1, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 1);
