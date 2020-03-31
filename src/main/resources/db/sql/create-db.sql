DROP TABLE users IF EXISTS;
DROP TABLE registrations IF EXISTS;
DROP TABLE students IF EXISTS;
DROP TABLE courses IF EXISTS;
DROP TABLE registrationsbooklist IF EXISTS;
DROP TABLE bookusers IF EXISTS;
DROP TABLE publishedbooklist IF EXISTS;
DROP TABLE books IF EXISTS;
DROP TABLE publishers IF EXISTS;

CREATE TABLE users (
  id         INTEGER PRIMARY KEY,
  name VARCHAR(30),
  email  VARCHAR(50)
);

CREATE TABLE students (
  email VARCHAR(50) PRIMARY KEY,
  name VARCHAR(50),
  password VARCHAR(20)
);

CREATE TABLE courses (
  code VARCHAR(50) PRIMARY KEY,
  name VARCHAR(200)
);

CREATE TABLE registrations(
  email VARCHAR(50),
  code VARCHAR(50),
  foreign key (email) references students(email),
  foreign key (code) references courses(code)
);

CREATE TABLE bookusers (
  email VARCHAR (50) PRIMARY KEY,
  name VARCHAR (30),
  fullname VARCHAR (50),
  dob VARCHAR (30),
  password VARCHAR (50)
);

CREATE TABLE books (
  code VARCHAR (50) PRIMARY KEY,
  title  VARCHAR (50),
  author  VARCHAR (50),
  publishedyear VARCHAR (30)
);

CREATE TABLE registrationsbooklist(
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

CREATE TABLE publishedbooklist(
  email VARCHAR(50),
  code VARCHAR(50),
  foreign key (email) references publishers(email),
  foreign key (code) references books(code)
);