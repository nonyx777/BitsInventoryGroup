DROP DATABASE IF EXISTS inventory;

CREATE DATABASE inventory;

\connect inventory

CREATE TABLE public.sale (
    product varchar NOT NULL,
    "date" varchar NOT NULL,
    quantity varchar NOT NULL,
    price varchar NOT NULL,
    total_price varchar NOT NULL,
    id int4 NOT NULL GENERATED ALWAYS AS IDENTITY,
    CONSTRAINT sale_pk PRIMARY KEY (id)
);