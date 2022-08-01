CREATE SEQUENCE customer_id_seq;

CREATE TABLE "customer" (
	"id"	INTEGER NOT NULL DEFAULT nextval('customer_id_seq'),
	"name"	TEXT NOT NULL,
	"surname"	TEXT NOT NULL,
	"email"	TEXT NOT NULL UNIQUE,
	"country_id"	INTEGER NOT NULL,
	PRIMARY KEY("id")
);

CREATE SEQUENCE manufacturer_id_seq;

CREATE TABLE "manufacturer" (
	"id"	INTEGER NOT NULL DEFAULT nextval('manufacturer_id_seq'),
	"name"	TEXT NOT NULL,
	"country_id"	INTEGER NOT NULL,
	PRIMARY KEY("id")
);

CREATE SEQUENCE product_id_seq;

CREATE TABLE "product" (
	"id"	INTEGER NOT NULL DEFAULT nextval('product_id_seq'),
	"name"	TEXT NOT NULL,
	"type_id"	INTEGER NOT NULL,
	"price"	REAL NOT NULL,
	"last_updated"	TIMESTAMP NOT NULL,
	"manufacturer_id"	INTEGER NOT NULL,
	PRIMARY KEY("id")
);

CREATE SEQUENCE order_id_seq;

CREATE TABLE "order" (
	"id"	INTEGER NOT NULL DEFAULT nextval('order_id_seq'),
	"created_at"	TIMESTAMP NOT NULL,
	"total_price"	REAL NOT NULL,
	"status_id"	INTEGER NOT NULL,
	"customer_id"	INTEGER NOT NULL,
	PRIMARY KEY("id")
);

CREATE SEQUENCE order_item_id_seq;

CREATE TABLE "order_item" (
	"id"	INTEGER NOT NULL DEFAULT nextval('order_item_id_seq'),
	"quantity"	INTEGER NOT NULL,
	"total_price"	REAL NOT NULL,
	"product_id"	INTEGER NOT NULL,
	"order_id"  INTEGER NOT NULL,
	PRIMARY KEY("id")
);

--drop table customer ;
--drop table manufacturer ;
--drop table product ;

