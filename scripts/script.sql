
create table  if not exists customer(
	id serial PRIMARY KEY,
	name VARCHAR not null,
	email VARCHAR not null,
	phone VARCHAR not null,
	document VARCHAR not null UNIQUE,
	created_at TIMESTAMP not null,
	updated_at TIMESTAMP
);

create table  if not exists accounts(
	id serial PRIMARY KEY,
	number INTEGER not null,
	agency INTEGER not null,
	balance DECIMAL(10,2) not null,
	close BOOLEAN,
	customer_id serial not null,
	created_at TIMESTAMP not null,
	updated_at TIMESTAMP,
	foreign key (customer_id) references customers (id)

);

create table  if not exists cards(
	id serial PRIMARY KEY,
	flag VARCHAR (20) not null,
	card_limit DECIMAL(10,2) not null,
	account_id serial not null,
	foreign key (account_id) references accounts (id)
);

create table  if not exists transactions(
	id serial PRIMARY KEY,
	data_transaction TIMESTAMP not null,
	source_account INTEGER not null,
	destination_account INTEGER not null,
	amount DECIMAL(10,2) not null
);

create table  if not exists notifications(
	id serial PRIMARY KEY,
	data_transaction TIMESTAMP not null,
	source_account INTEGER not null,
	destination_account INTEGER not null,
	amount DECIMAL(10,2) not null
);