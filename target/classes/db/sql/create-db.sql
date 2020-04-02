DROP TABLE user_booklists IF EXISTS;
DROP TABLE bookusers IF EXISTS;
DROP TABLE published_booklists IF EXISTS;
DROP TABLE books IF EXISTS;
DROP TABLE publishers IF EXISTS;

CREATE TABLE bookusers (
  email VARCHAR (50) PRIMARY KEY,
  username VARCHAR (30),
  fullname VARCHAR (50),
  dob VARCHAR (30),
  password VARCHAR (50)
);

CREATE TABLE books (
  code VARCHAR (50) PRIMARY KEY,
  booktitle  VARCHAR (50),
  author  VARCHAR (50),
  publishedyear VARCHAR (30)
);

CREATE TABLE user_booklists(
  email VARCHAR(50),
  code VARCHAR(50),
  foreign key (email) references bookusers(email),
  foreign key (code) references books(code)
);

CREATE TABLE publishers (
  email VARCHAR (50) PRIMARY KEY,
  name VARCHAR (30),
  password VARCHAR (50)
);

CREATE TABLE published_booklists(
  email VARCHAR(50),
  code VARCHAR(50),
  foreign key (email) references publishers(email),
  foreign key (code) references books(code)
);