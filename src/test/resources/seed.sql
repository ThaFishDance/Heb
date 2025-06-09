INSERT INTO categories (name)
VALUES ('Clothing'),
       ('Fitness'),
       ('Food'),
       ('Garden'),
       ('Kitchen'),
       ('Music'),
       ('Outdoor'),
       ('Pets')
;

INSERT INTO products (name, category_id, price, description)
VALUES ('Pet Hair Vacuum Cleaner Attachment', (SELECT id FROM categories WHERE name = 'Pets'), 14.99,
        'Specialized attachment for removing pet hair from surfaces.');

INSERT INTO products (name, category_id, price, description)
VALUES ('Multi-Function Meat Tenderizer', (SELECT id FROM categories WHERE name = 'Kitchen'), 19.99,
        'Kitchen tool for tenderizing meat to enhance flavors.');

INSERT INTO products (name, category_id, price, description)
VALUES ('Snap-On Tupperware Set', (SELECT id FROM categories WHERE name = 'Kitchen'), 34.99,
        'Durable and versatile food storage containers.');

INSERT INTO products (name, category_id, price, description)
VALUES ('Sparkling Blood Orange Soda', (SELECT id FROM categories WHERE name = 'Food'), 1.99,
        'A refreshing sparkling beverage with a bold blood orange flavor.');

INSERT INTO products (name, category_id, price, description)
VALUES ('Outdoor String Lights', (SELECT id FROM categories WHERE name = 'Outdoor'), 24.99,
        'Fairy lights perfect for decorating patios and backyards.');

INSERT INTO products (name, category_id, price, description)
VALUES ('Bodyweight Resistance Bands', (SELECT id FROM categories WHERE name = 'Fitness'), 22.99,
        'Set of resistance bands for strength training at home.');

