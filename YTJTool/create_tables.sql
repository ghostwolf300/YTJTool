create table tbl_company_details(
	business_id varchar(9) not null,
	name varchar(128) not null,
	company_form varchar(40),
	registration_date date,
	details_uri varchar(40),
	primary key(business_id)
);

create table tbl_company_name(
	business_id varchar(9) not null constraint fk_company_name_business_id references tbl_company_details on delete cascade on update restrict,
	name_order int not null,
	version int,
	name varchar(128) not null,
	registration_date date,
	end_date date,
	source int,
	primary key(business_id,name_order,version)
);

create table tbl_auxiliary_name(
	business_id varchar(9) not null constraint fk_auxiliary_name_business_id references tbl_company_details on delete cascade on update restrict,
	name_order int not null,
	version int not null,
	name varchar(128) not null,
	registration_date date,
	end_date date,
	source int,
	primary key(business_id,name_order,version)
);

create table tbl_address(
	business_id varchar(9) not null constraint fk_address_business_id references tbl_company_details on delete cascade on update restrict,
	address_type int not null,
	version int not null,
	care_of varchar(128),
	street varchar(60),
	post_code varchar(10),
	city varchar(40),
	country varchar(2),
	language varchar(2),
	primary key(business_id,address_type,version)
);

create table tbl_company_form(
	business_id varchar(9) not null constraint fk_company_form_business_id references tbl_company_details on delete cascade on update restrict,
	version int not null,
	form_type varchar(40),
	registrationDate date,
	endDate date,
	language varchar(2),
	source int,
	primary key(business_id,version,language)
);

create table tbl_business_line(
	business_id varchar(9) not null constraint fk_business_line_business_id references tbl_company_details on delete cascade on update restrict,
	order_num int not null,
	version int not null,
	code varchar(10),
	name varchar(128),
	registrationDate date,
	endDate date,
	language varchar(2),
	source int,
	primary key(business_id,order_num,version,language)
);

create table tbl_company_language(
	business_id varchar(9) not null constraint fk_company_language_business_id references tbl_company_details on delete cascade on update restrict,
	version int not null,
	name varchar(20),
	registrationDate date,
	endDate date,
	language varchar(2),
	source int,
	primary key(business_id,version,language)
);

create table tbl_registed_office(
	business_id varchar(9) not null constraint fk_registed_office_business_id references tbl_company_details on delete cascade on update restrict,
	order_num int not null,
	version int not null,
	name varchar(40),
	registrationDate date,
	endDate date,
	language varchar(2),
	source int,
	primary key(business_id,order_num,version,language)
);

create table tbl_contact_detail(
	business_id varchar(9) not null constraint fk_contact_detail_business_id references tbl_company_details on delete cascade on update restrict,
	version int not null,
	contact_type varchar(20),
	contact_value varchar(60),
	registrationDate date,
	endDate date,
	language varchar(2),
	source int,
	primary key(business_id,version,language)
);

create table tbl_registered_entry(
	business_id varchar(9) not null constraint fk_registered_entry_business_id references tbl_company_details on delete cascade on update restrict,
	authority int,
	register int,
	status int,
	registrationDate date,
	endDate date,
	statusDate date,
	language varchar(2),
	description varchar(40),
	primary key(business_id,register,language)
);

create table tbl_id_change(
	business_id varchar(9) not null constraint fk_id_change_business_id references tbl_company_details on delete cascade on update restrict,
	change_date date,
	change varchar(5),
	old_business_id varchar(9),
	new_business_id varchar(9),
	language varchar(2),
	description varchar(40),
	source int,
	primary key(business_id,change_date,change)
);
