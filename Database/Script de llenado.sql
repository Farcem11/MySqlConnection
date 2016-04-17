insert into users (Name, LastName, Email, Password, UserName)
values 
("Fabian", "Arce", "Farcem90@hotmail.com", md5("hola123"), "Farcem"),
("Esteban", "Fonseca", "Esteban@gmail.com", md5("hola321"), "Efonseca");

DROP PROCEDURE IF EXISTS signIn;
DELIMITER //
CREATE PROCEDURE signIn(pEmail varchar(40), pPassword varbinary(100))
BEGIN
	SELECT Name, LastName, Email, UserName FROM Users
	WHERE 
		Email = pEmail
	AND 
		Password = md5(pPassword);
END //
DELIMITER ;


DROP PROCEDURE IF EXISTS register;
DELIMITER //
CREATE PROCEDURE register(pName varchar(20), pLastName varchar(20), pEmail varchar(40), pPassword varbinary(100), pUserName varchar(30))
BEGIN
	DECLARE _IdUser int;

	SELECT idUser INTO _IdUser 
	FROM Users 
	WHERE Email = pEmail;
	
	IF _IdUser IS NULL THEN
		insert into users (Name, LastName, Email, Password, UserName)
		values (pName, pLastName, pEmail, md5(pPassword), pUserName);
		SELECT TRUE as inserted;
	ELSE
		SELECT FALSE as inserted;
	END IF;
END //
DELIMITER ;

call register("","","Farcem90@hotmail.com","","");
