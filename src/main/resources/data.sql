-- SEED PRIVILEGES
insert into privilege (name, created_at, updated_at)
values ('USER', NOW(), NOW()),
       ('ADMIN', NOW(), NOW());

-- SEED USERS
insert into platform_user(username, mobile_number, email, password, privilege_id, created_at)
values ('k4tg', '536645300', 'khaled@live.com', '$2a$10$xaUND5sKFoPNlxM.EfBv5eBHamp7hTNhBSDcbrKpw1RDOF984lAl2',
        (select id from privilege where name = 'USER'), NOW()),
       ('admin', '536645301', 'admin@live.com', '$2a$10$xaUND5sKFoPNlxM.EfBv5eBHamp7hTNhBSDcbrKpw1RDOF984lAl2',
        (select id from privilege where name = 'ADMIN'), NOW());