create table warehouse
(
    id   integer,
    name varchar(255)
);
create table item
(
    id   integer,
    name varchar(255),
    category_name varchar(255),
    price numeric(10,3)
);
create table warehouse_item(
                               warehouse_id integer,
                               item_id integer,
                               amount integer
);

-- Найти Склад , самым большим колличеством товаров item;
-- Найти Склад на котором есть самый дорогой item
-- Найти Склад на котором есть второй по стоимости item


insert into warehouse values (1, 'Склад 1'), (2, 'Склад 2');
insert into item values (1, 'Item 1', 'Category 1', 210.3);
insert into item values (2, 'Item 2', 'Category 2', 310.1);
insert into item values (3, 'Item 3', 'Category 1', 110.5);
insert into item values (4, 'Item 4', 'Category 2', 210.2);
insert into item values (5, 'Item 11', 'Category 2', 111.3);
insert into item values (6, 'Item 12', 'Category 1', 210.1);
insert into item values (7, 'Item 13', 'Category 2', 310.1);
insert into item values (8, 'Item 14', 'Category 1', 410.2);

insert into warehouse_item values (1, 1, 5);
insert into warehouse_item values (1, 2, 2);
insert into warehouse_item values (1, 3, 8);
insert into warehouse_item values (1, 4, 13);
insert into warehouse_item values (2, 5, 20);
insert into warehouse_item values (2, 6, 12);
insert into warehouse_item values (2, 7, 10);
insert into warehouse_item values (2, 8, 4);


SELECT item.name, item.price
FROM warehouse
         JOIN warehouse_item ON warehouse.id = warehouse_item.warehouse_id
         JOIN item ON item.id = warehouse_item.item_id
WHERE warehouse.id = 2
ORDER BY item.price DESC
LIMIT 1 OFFSET 1;