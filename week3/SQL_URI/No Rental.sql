SELECT customers.id, customers.name FROM customers LEFT outer JOIN locations ON  
locations.id_customers = customers.id where
locations.id_customers is null;