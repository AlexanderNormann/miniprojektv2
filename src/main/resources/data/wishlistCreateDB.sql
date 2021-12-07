CREATE SCHEMA 'WISHLIST';


DROP TABLE IF EXISTS `list`;

CREATE TABLE `list`
(
    `listID`          int NOT NULL AUTO_INCREMENT,
    `listname`        varchar(45) DEFAULT NULL,
    `listdescription` varchar(45) DEFAULT NULL,
    `userID_FK`       int NOT NULL,
    PRIMARY KEY (`listID`),
    KEY               `userID_FK_idx` (`userID_FK`),
    CONSTRAINT `userID_FK` FOREIGN KEY (`userID_FK`) REFERENCES `users` (`userID`) ON DELETE CASCADE
        DROP TABLE IF EXISTS `product`;

CREATE TABLE `product`
(
    `productID`         int NOT NULL AUTO_INCREMENT,
    `productname`       varchar(45)  DEFAULT NULL,
    `productsize`       varchar(45)  DEFAULT NULL,
    `productdesciption` varchar(200) DEFAULT NULL,
    `color`             varchar(45)  DEFAULT NULL,
    `url`               varchar(200) DEFAULT NULL,
    `price`             varchar(45)  DEFAULT NULL,
    `userID_FK`         int NOT NULL,
    PRIMARY KEY (`productID`),
    KEY                 `userID_FK_idx` (`userID_FK`),
    CONSTRAINT `userID` FOREIGN KEY (`userID_FK`) REFERENCES `users` (`userID`) ON DELETE CASCADE
        DROP TABLE IF EXISTS `users`;

CREATE TABLE `users`
(
    `userID`    int NOT NULL AUTO_INCREMENT,
    `firstname` varchar(45)  DEFAULT NULL,
    `lastname`  varchar(45)  DEFAULT NULL,
    `email`     varchar(100) DEFAULT NULL,
    `password`  varchar(45)  DEFAULT NULL,
    PRIMARY KEY (`userID`),
    UNIQUE KEY `emil_UNIQUE` (`email`)