CREATE TABLE IF NOT EXISTS order_item
(
  order_item_id  SERIAL PRIMARY KEY,
  menu_item INTEGER REFERENCES menu(id),
  order_id INTEGER,
  amount INTEGER CHECK(amount >= 0)
);
