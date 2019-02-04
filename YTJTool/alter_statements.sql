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
