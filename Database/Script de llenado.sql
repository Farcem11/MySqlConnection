insert into users (Name, LastName, Email, Password)
values 
("Fabian", "Arce", "Farcem90@hotmail.com", md5("hola123")),
("Jasson", "Moya", "jasc996@gmail.com", md5("hola123")),
("Kevin", "Hernandez", "kevinah95@gmail.com", md5("hola123"));

DROP PROCEDURE IF EXISTS signIn;
DELIMITER //
CREATE PROCEDURE signIn(pEmail varchar(40), pPassword varbinary(100))
BEGIN
	SELECT Name, LastName, Email FROM Users
	WHERE 
		Email = "Farcem90@hotmail.com"
	AND 
		Password = md5("hola123");
END //
DELIMITER ;


DROP PROCEDURE IF EXISTS register;
DELIMITER //
CREATE PROCEDURE register(pName varchar(20), pLastName varchar(20), pEmail varchar(40), pPassword varbinary(100))
BEGIN
	DECLARE _IdUser int;

	SELECT idUser INTO _IdUser 
	FROM Users 
	WHERE Email = pEmail;
	
	IF _IdUser IS NOT NULL THEN
		SELECT _IdUser;
	ELSE
		insert into users (Name, LastName, Email, Password)
		values (pName, pLastName, pEmail, md5(pPassword));
		SELECT LAST_INSERT_ID();
	END IF;
END //
DELIMITER ;

call register("","","Farcem90@hotmail.com","");

DROP PROCEDURE IF EXISTS test;
DELIMITER //
CREATE PROCEDURE test()
BEGIN

	SELECT * FROM Users;

END //
DELIMITER ;

