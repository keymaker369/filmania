
create table filmania.ROLE (
	ID int NOT NULL AUTO_INCREMENT,
	NAME VARCHAR(20),
	PRIMARY KEY (ID)	
);

create table filmania.GENRE (
	ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20)
);

create table filmania.USER (
	ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	USERNAME VARCHAR(20),
	PASSWORD VARCHAR(20),
	EMAIL VARCHAR(20),
	ACCOUNTNONEXPIRED BOOL,
	ACCOUNTNONLOCKED BOOL,
	CREDINTIALSNONEXPIRED BOOL,
	ENABLED BOOL
);

create table filmania.USER_ROLE(
	USER_ID int NOT NULL,
	ROLE_ID int NOT NULL,
	PRIMARY KEY (USER_ID, ROLE_ID),
	INDEX USER_ROLE_fk1 (`USER_ID` ASC) ,
	INDEX USER_ROLE_fk2 (`ROLE_ID` ASC) ,
	CONSTRAINT USER_ROLE_fk1
		FOREIGN KEY (USER_ID)
	    	REFERENCES USER (ID)
	    	ON DELETE NO ACTION
    		ON UPDATE NO ACTION,
	CONSTRAINT USER_ROLE_fk2
		FOREIGN KEY (ROLE_ID)
	    	REFERENCES ROLE (ID)
	    	ON DELETE NO ACTION
    		ON UPDATE NO ACTION
);

create table filmania.MOVIE (
	ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20),
	INPUTDATE DATETIME,
	RANK DOUBLE,
	USER_ID int NOT NULL,
	INDEX MOVIE_fk1 (`USER_ID` ASC) ,
	CONSTRAINT MOVIE_fk1
		FOREIGN KEY (USER_ID)
	    	REFERENCES USER (ID)
	    	ON DELETE NO ACTION
    		ON UPDATE NO ACTION
);

create table filmania.MOVIE_GENRE (
	GENRE_ID int NOT NULL,
	MOVIE_ID int NOT NULL,
	PRIMARY KEY (GENRE_ID, MOVIE_ID),
	INDEX MOVIE_GENRE_fk1 (GENRE_ID ASC) ,
	INDEX MOVIE_GENRE_fk2 (MOVIE_ID ASC) ,
	CONSTRAINT MOVIE_GENRE_fk1
		FOREIGN KEY (GENRE_ID)
	    	REFERENCES GENRE (ID)
	    	ON DELETE NO ACTION
    		ON UPDATE NO ACTION,
	CONSTRAINT MOVIE_GENRE_fk2
		FOREIGN KEY (MOVIE_ID)
	    	REFERENCES MOVIE (ID)
	    	ON DELETE NO ACTION
    		ON UPDATE NO ACTION
);

create table filmania.COMMENT (
	ID int NOT NULL AUTO_INCREMENT,
	CONTENT LONGTEXT,
	INPUTDATE DATETIME,
	USER_ID int NOT NULL,
	MOVIE_ID int NOT NULL,
	PRIMARY KEY (ID, USER_ID, MOVIE_ID),
	INDEX COMMENT_fk1 (USER_ID ASC) ,
	INDEX COMMENT_fk2 (MOVIE_ID ASC) ,
	CONSTRAINT COMMENT_fk1
		FOREIGN KEY (USER_ID)
	    	REFERENCES USER (ID)
	    	ON DELETE NO ACTION
    		ON UPDATE NO ACTION,
	CONSTRAINT COMMENT_fk2
		FOREIGN KEY (MOVIE_ID)
	    	REFERENCES MOVIE (ID)
	    	ON DELETE NO ACTION
    		ON UPDATE NO ACTION
);

create table filmania.RATING (
	ID int NOT NULL AUTO_INCREMENT,
	MARK int NOT NULL,
	INPUTDATE DATETIME,
	USER_ID int NOT NULL,
	MOVIE_ID int NOT NULL,
	PRIMARY KEY (ID, USER_ID, MOVIE_ID),
	INDEX RATING_fk1 (USER_ID ASC) ,
	INDEX RATING_fk2 (MOVIE_ID ASC) ,
	CONSTRAINT RATING_fk1
		FOREIGN KEY (USER_ID)
	    	REFERENCES USER (ID)
	    	ON DELETE NO ACTION
    		ON UPDATE NO ACTION,
	CONSTRAINT RATING_fk2
		FOREIGN KEY (MOVIE_ID)
	    	REFERENCES MOVIE (ID)
	    	ON DELETE NO ACTION
    		ON UPDATE NO ACTION
);