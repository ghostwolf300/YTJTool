ALTER TABLE tbl_company_details ADD COLUMN company_form varchar(40);
UPDATE tbl_company_details SET company_form=companyForm;
ALTER TABLE tbl_company_details DROP COLUMN companyForm;

ALTER TABLE tbl_company_details ADD COLUMN details_uri varchar(40);
UPDATE tbl_company_details SET details_uri=detailsUri;
ALTER TABLE tbl_company_details DROP COLUMN detailsUri;

ALTER TABLE tbl_address ADD COLUMN care_of varchar(128);
UPDATE tbl_address SET care_of=careOf;
ALTER TABLE tbl_address DROP COLUMN careOf;

ALTER TABLE tbl_address ADD COLUMN postcode varchar(10);
UPDATE tbl_address SET postcode=post_code;
ALTER TABLE tbl_address DROP COLUMN post_code;

alter table tbl_liquidation drop primary key;
alter table tbl_liquidation add primary key (business_id,type_code,registration_date,language);
alter table tbl_liquidation alter column language not null;

alter table tbl_company_name drop primary key;
alter table tbl_company_name  alter column source not null;
alter table tbl_company_name add primary key (business_id,name_order,version,source);

alter table tbl_auxiliary_name drop primary key;
alter table tbl_auxiliary_name  alter column source not null;
alter table tbl_auxiliary_name add primary key (business_id,name_order,version,source);