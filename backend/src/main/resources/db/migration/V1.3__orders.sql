CREATE TABLE IF NOT EXISTS orders
(
  order_id SERIAL PRIMARY KEY,
  items INTEGER REFERENCES order_item(order_item_id),
  status INT NOT NULL
);