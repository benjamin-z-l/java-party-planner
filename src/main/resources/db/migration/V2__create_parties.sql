CREATE TABLE parties (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  location_id INTEGER REFERENCES locations(id) NOT NULL,
  description TEXT NOT NULL
);