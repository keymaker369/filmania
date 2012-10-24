select * from USER;
select * from GENRE;
select * from MOVIE;
select * from MOVIE_GENRE;
select * from RATING;
select * from COMMENT;
select * from GENRE where name = '123456789';
select * from GENRE where id = 4000000;
select * from MOVIE_GENRE where movie_id = 5000001;
select m.* from MOVIE m where id >= 5000000;
select c.* from COMMENT c where id >= 5000000;
select mg.* from MOVIE_GENRE mg where GENRE_ID >= 5000000;
select mg.* from MOVIE_GENRE mg where not (GENRE_ID = MOVIE_ID);
select mg.* from MOVIE_GENRE mg where MOVIE_ID >= 5000000;
select mg.* from GENRE_MOVY mg where MOVy >= 5000000;
select m.* from GENRE m where id > 5000000;
select m.* from USER m where id >= 5000000;
select r.* from RATING r where id >= 5000000;
select count(g.name) from GENRE g;
select count(m.name) from MOVIE m;
select count(u.username) from USER u;
select count(c.content) from COMMENT c;
select count(r.mark) from RATING r;
select count(mg.movie_id) from MOVIE_GENRE mg;
select count(mg.MOVY) from GENRE_MOVY mg;
DELETE FROM GENRE where NAME = 'AkcijaJmeter';
DELETE FROM GENRE;
DELETE FROM COMMENT;
DELETE FROM RATING;
call randomiseUsers(4999997);
call randomiseGenres(5000000);
call randomiseMovies(5000000,1);
call randomiseMoveGenres(1,5000000);
call randomiseRatings(1,5000000);
call randomiseComments(1,5000000);




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

CREATE DEFINER=`root`@`localhost` PROCEDURE `randomiseMovies`(IN numberOfRecords INT(20), IN userID INT(20))
BEGIN
declare i int Default 0 ;
      declare random char(20) ;
      myloop: loop
      set random=conv(floor(rand() * 99999999999999), 20, 36) ;
      insert into MOVIE (`name`, INPUTDATE, RANK, USER_ID) VALUES (random, '2012-08-12 22:18:30', 10, userID);
      set i=i+1;
      if i=numberOfRecords then
        leave myloop;
	end if;
    end loop myloop;
END