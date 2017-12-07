CREATE TABLE IF NOT EXISTS order_item
(
  id  SERIAL PRIMARY KEY,
  menu_item INTEGER REFERENCES menu(id),
  order_id INTEGER REFERENCES orders(id),
  quantity INTEGER CHECK(quantity >= 0)
);
