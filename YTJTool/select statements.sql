select * from tbl_company_details
select * from tbl_company_name
select * from tbl_auxiliary_name
select * from tbl_address
select * from tbl_auxiliary_name
select * from tbl_liquidation
select * from tbl_id_change

select business_id,Max(change_date) as latest_change,change,old_business_id,new_business_id,language,description,source from tbl_id_change where business_id=? group by business_id,change,old_business_id,new_business_id,language,description,source