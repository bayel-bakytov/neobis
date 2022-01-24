SELECT products.name FROM products
JOIN providers on products.id_providers = providers.id
WHERE amount < 20 AND amount > 10 
and providers.name like 'P%';