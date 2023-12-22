-- liquibase formatted sql

-- changeset: User1
CREATE TABLE ad (
    id BIGINT PRIMARY KEY,
    title VARCHAR,
    price INT,
    decription VARCHAR,
    image_url VARCHAR,
    author_id INT
);

CREATE TABLE comments (
    id BIGINT PRIMARY KEY,
    text VARCHAR,
    created_at INT,
    author_id INT,
    ad_id INT
);

CREATE TABLE users (
    id BIGINT PRIMARY KEY,
    email VARCHAR,
    password VARCHAR,
    first_name VARCHAR,
    last_name VARCHAR,
    phone_number VARCHAR,
    image VARCHAR,
    role VARCHAR, --enum Role
);
