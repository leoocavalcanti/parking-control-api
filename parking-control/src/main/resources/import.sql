INSERT INTO TB_USER (password, username) VALUES ("$2a$10$VJE6NZVoIh.rmgQ7QNXgueFBO6gpHTvMDCwJCXclxsToWK0WWZ2Zu", "maria");
INSERT INTO TB_USER (password, username) VALUES ("$2a$10$fEck7Pw86qel6uEe0z/.e.LvvAAwF7.L3bzyXl0xasO/l31dNmalC", "joão");
INSERT INTO TB_ROLE (role_name) VALUES ("ROLE_ADMIN");
INSERT INTO TB_ROLE (role_name) VALUES ("ROLE_USER");
INSERT INTO TB_USERS_ROLES (user_id, role_id) VALUES (1, 1);
INSERT INTO TB_USERS_ROLES (user_id, role_id) VALUES (2, 2);