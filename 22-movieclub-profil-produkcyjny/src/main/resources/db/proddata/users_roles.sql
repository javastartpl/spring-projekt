insert into
    user_role (name, description)
values
    ('ADMIN', 'pełne uprawnienia'),   -- 1
    ('USER', 'podstawowe uprawnienia, możliwość oddawania głosów'),   -- 2
    ('EDITOR', 'podstawowe uprawnienia + możliwość zarządzania treściami');   -- 3

insert into users(email, password)
# admin / adminPass
# joe_editor@example.com / editorPass
# adam@example.com / userPass
values
    ('admin@example.com', '{bcrypt}$2a$12$3vzGS0hU7bDuErAlfd2AL.Kfo4ruBzAZLHB85kTE4SWN1hhpSdJW.'),
    ('joe_editor@example.com', '{bcrypt}$2a$12$WIe4Nymx9d2sPABB.Bb7oeCf9feo58YHxxesYi4yreEsiRys.uUfW'),
    ('adam@example.com', '{bcrypt}$2a$12$yJeU795NEjv6TaITeLw6ee9Varr84m.Qyv9AW2BDcekD4WfHMMpny');

insert into
    user_roles (user_id, role_id)
values
    (1, 1),
    (2, 2),
    (3, 3);
