CREATE TABLE IF NOT EXISTS menu
(
  id SERIAL PRIMARY KEY,
  item_name VARCHAR,
  price REAL NOT NULL
);

CREATE sequence IF NOT EXISTS hibernate_sequence;