CREATE DATABASE IF NOT EXISTS `Users`;

CREATE TABLE IF NOT EXISTS `users`
(
	`userID` int(10) NOT NULL AUTO_INCREMENT,
	`firstName` varchar(50) NOT NULL,
	`lastName` varchar(50) NOT NULL,
	`email` varchar(20) NOT NULL,
	PRIMARY KEY (`userID`)
);

INSERT INTO `users` (firstName, lastName, email) VALUES ("FirstName1", "LastName1", "@mail1");
INSERT INTO `users` (firstName, lastName, email) VALUES ("FirstName2", "LastName2", "@mail2");
INSERT INTO `users` (firstName, lastName, email) VALUES ("FirstName3", "LastName3", "@mail3");