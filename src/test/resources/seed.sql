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

INSERT INTO products (name, category_id, price, description) VALUES
('T-Shirt', 1, 19.99, 'Comfortable cotton T-shirt.'),
('Jeans', 1, 49.99, 'Classic blue jeans.'),
('Running Shoes', 2, 89.95, 'Lightweight running shoes for fitness enthusiasts.'),
('Yoga Mat', 2, 25.50, 'Non-slip yoga mat.'),
('Protein Powder', 3, 39.99, 'High-quality whey protein powder.'),
('Energy Bar', 3, 2.99, 'Delicious and nutritious energy bar.'),
('Garden Shovel', 4, 15.75, 'Durable metal garden shovel.'),
('Watering Can', 4, 12.49, 'Plastic watering can with long spout.'),
('Knife Set', 5, 79.99, 'Premium stainless steel kitchen knives.'),
('Blender', 5, 59.95, 'High-speed blender for smoothies.'),
('Guitar', 6, 299.99, 'Acoustic guitar with mahogany body.'),
('Drum Sticks', 6, 14.99, 'Professional drum sticks.'),
('Tent', 7, 129.50, '4-person camping tent.'),
('Sleeping Bag', 7, 89.25, 'Warm and lightweight sleeping bag.'),
('Dog Food', 8, 34.99, 'Premium dry dog food.'),
('Cat Toy', 8, 7.99, 'Interactive cat toy with feathers.'),
('Sweater', 1, 29.99, 'Wool blend sweater for winter.'),
('Sports Bra', 2, 24.99, 'Supportive sports bra for workouts.'),
('Granola', 3, 5.99, 'Organic granola with almonds and honey.'),
('Lawn Mower', 4, 249.99, 'Gas-powered lawn mower.'),
('Cutting Board', 5, 19.95, 'Bamboo cutting board.'),
('Keyboard', 6, 499.99, '88-key digital piano keyboard.'),
('Camping Stove', 7, 45.99, 'Portable camping stove with fuel.'),
('Bird Seed', 8, 12.50, 'Mixed seed for wild birds.'),
('Jacket', 1, 89.99, 'Waterproof outdoor jacket.'),
('Fitness Tracker', 2, 149.95, 'Smart fitness tracker with heart rate monitor.'),
('Trail Mix', 3, 6.75, 'Nut and dried fruit trail mix.'),
('Garden Gloves', 4, 9.99, 'Protective garden gloves.'),
('Measuring Cups', 5, 15.99, 'Stainless steel measuring cups.'),
('Violin', 6, 350.00, 'Full-size violin with bow and case.'),
('Backpack', 7, 69.99, 'Durable hiking backpack.'),
('Dog Leash', 8, 14.50, 'Nylon dog leash with padded handle.'),
('Polo Shirt', 1, 24.99, 'Cotton polo shirt.'),
('Dumbbells', 2, 59.99, 'Adjustable dumbbell set.'),
('Honey', 3, 9.49, 'Raw organic honey.'),
('Hedge Trimmer', 4, 179.00, 'Electric hedge trimmer.'),
('Mixing Bowls', 5, 22.75, 'Set of stainless steel mixing bowls.'),
('Microphone', 6, 129.99, 'Studio-quality condenser microphone.'),
('Lantern', 7, 35.50, 'Rechargeable camping lantern.'),
('Fish Tank', 8, 99.95, 'Glass aquarium for tropical fish.'),
('Scarf', 1, 17.99, 'Warm wool scarf.'),
('Resistance Bands', 2, 29.95, 'Set of resistance bands for workouts.'),
('Cereal', 3, 4.50, 'Whole grain breakfast cereal.'),
('Plant Pots', 4, 27.99, 'Set of ceramic plant pots.'),
('Coffee Maker', 5, 89.95, 'Automatic drip coffee maker.'),
('Sheet Music', 6, 11.25, 'Classical piano sheet music.'),
('Hiking Boots', 7, 139.99, 'Waterproof hiking boots.'),
('Pet Bed', 8, 44.95, 'Comfortable pet bed for dogs or cats.');

