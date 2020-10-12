create sequence hibernate_sequence;

create table if not exists nobb_overgruppe
(
	beskrivelse varchar(255),
	overgruppe_nr varchar(255) not null
		constraint nobb_overgruppe_pkey
			primary key
);

create table if not exists nobb_hovedgruppe
(
	beskrivelse varchar(255),
	hovedgruppe_nr varchar(255) not null
		constraint nobb_hovedgruppe_pkey
			primary key,
	nobb_overgruppe_nr varchar(255)
		constraint fkg1678dngc1lyfs96fjtr2x8v4
			references nobb_overgruppe
);

create table if not exists nobb_varegruppe
(
	beskrivelse varchar(255),
	varegruppe_nr varchar(255) not null
		constraint nobb_varegruppe_pkey
			primary key,
	nobb_hovedgruppe_nr varchar(255)
		constraint fkmu0yvng2g60qxfo5mw1n80rmp
			references nobb_hovedgruppe
);

create table if not exists nobb_product
(
	nobb_nr integer not null
		constraint nobb_product_pkey
			primary key,
	lang_varetekst varchar(1000),
	pris_enhet varchar(255),
	varetekst varchar(255),
	nobb_varegruppe_nr varchar(255)
		constraint fkssv4cfqd71ca589q668w6s6x1
			references nobb_varegruppe,
	created timestamp,
	updated timestamp,
	vare_type varchar(255)
);
