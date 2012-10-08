select * from USER;
select * from GENRE;
select count(g.name) from GENRE g;
DELETE FROM GENRE where NAME = 'AkcijaJmeter';
call randomise(5);





-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `randomise`(IN numberOfRecords INT(20))
BEGIN
declare i int Default 0 ;
      declare random char(20) ;
      myloop: loop
      set random=conv(floor(rand() * 99999999999999), 20, 36) ;
      insert into GENRE (`name`) VALUES (random);
      set i=i+1;
      if i=numberOfRecords then
        leave myloop;
	end if;
    end loop myloop;
END
