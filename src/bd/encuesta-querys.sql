select * from category
select * from fn_addquestion('El curso le resultó agradable?', 3, 5)
select * from question



CREATE or replace FUNCTION fn_addsurvey(p_name varchar(25), 
							 p_description varchar(200), 
							 p_timelimit smallint, 
							 p_startdate timestamp without time zone, 
							 p_enddate timestamp without time zone, 
							 p_createdby integer) RETURNS integer AS $$
BEGIN
	insert into survey values (default, p_name, p_description, p_timelimit, p_startdate, p_enddate, p_createdby) RETURNING id;
END; $$
LANGUAGE PLPGSQL;

declare xd integer
select * from fn_addsurvey('ejemplo','ejemplo2',30,'2019-04-21 08:00:00','2019-04-21 08:00:00',2) into xd
select fn_addsurvey('xd', 'xd', 20, '2019-04-21 08:00:00', '2019-04-21 08:00:00', 2)
drop function fn_addsurvey
INSERT INTO table(id,field)
VALUES($id,$value)
RETURNING id into var;
select * from survey
insert into survey values(default,'ejemplo','ejemplo2',30,'2019-04-21 08:00:00','2019-04-21 08:00:00',2)


CREATE SEQUENCE test_id_seq MINVALUE 1


ALTER TABLE survey ALTER id SET DEFAULT nextval('test_id_seq')


ALTER SEQUENCE test_id_seq OWNED BY survey.id




ALTER TABLE survey ADD COLUMN create_time_holder TIMESTAMP without time zone NULL;

-- Copy casted value over to the temporary column
UPDATE survey SET create_time_holder = enddate::TIMESTAMP;

-- Modify original column using the temporary column
ALTER TABLE survey ALTER COLUMN enddate TYPE TIMESTAMP without time zone USING create_time_holder;

-- Drop the temporary column (after examining altered column values)
ALTER TABLE survey DROP COLUMN create_time_holder;



