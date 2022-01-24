SELECT products.name, providers.name, products.price
FROM products 
    JOIN providers on providers.id = products.id_providers
    JOIN categories on categories.id = products.id_categories
where categories.name = 'Super Luxury'
and products.price > 1000;