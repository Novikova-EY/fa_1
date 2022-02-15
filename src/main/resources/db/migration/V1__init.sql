CREATE TABLE orders
(
    id    bigserial PRIMARY KEY,
    title varchar(255)
);

INSERT INTO orders (title)
VALUES ('Order 1'), ('Order 2');

CREATE TABLE products
(
    id       bigserial PRIMARY KEY,
    title    varchar(255),
    price    int,
    order_id bigint references orders (id)
);

INSERT INTO products (title, price, order_id)
VALUES ('Bread', 50, 1),
       ('Milk', 100, 2),
       ('Water', 10, 1);