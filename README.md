 
  Для работы нужно создать базу MySQL: itdatatech доступ к которой получить user с паролем password 
   
  CREATE DATABASE `itdatatech`  
   
  Потребуются таблицы 
   
  Таблица пользователей 
   
  create table APP_USER ( 
  id BIGINT NOT NULL AUTO_INCREMENT, 
  ssoid VARCHAR(30) NOT NULL, 
  password VARCHAR(100) NOT NULL, 
  PRIMARY KEY (id), 
  UNIQUE (ssoid) 
  ); 
   
  таблица профилей  
   
  create table USER_PROFILE( 
  id BIGINT NOT NULL AUTO_INCREMENT, 
  type VARCHAR(30) NOT NULL, 
  PRIMARY KEY (id), 
  UNIQUE (type) 
  ); 
    
  Таблица связки пользователя и прав доступа   
   
  CREATE TABLE APP_USER_USER_PROFILE ( 
  user_id BIGINT NOT NULL, 
  user_profile_id BIGINT NOT NULL, 
  PRIMARY KEY (user_id, user_profile_id), 
  CONSTRAINT FK_APP_USER FOREIGN KEY (user_id) REFERENCES APP_USER (id), 
  CONSTRAINT FK_USER_PROFILE FOREIGN KEY (user_profile_id) REFERENCES USER_PROFILE (id) 
  ); 
    
  INSERT INTO USER_PROFILE(type) 
  VALUES ('USER'); 
    
  INSERT INTO USER_PROFILE(type) 
  VALUES ('ADMIN'); 
   
  Пользователь Admin с паролем Admin c правами админа 
   
  INSERT INTO APP_USER(ssoid, password) 
  VALUES ('Admin','$2a$10$xW69/TsFZ/EVsY0QlvSaF.zM1PAs1XlzhtxHbGWd0C2MOwiy5.Z1.'); 
    
   
INSERT INTO APP_USER_USER_PROFILE (user_id, user_profile_id) SELECT user.id, profile.id FROM APP_USER user, USER_PROFILE profile where user.ssoid='Admin' and profile.type='ADMIN'

    
    
  Пользователь User с паролем User и правами юзера 
   
  INSERT INTO APP_USER(ssoid, password) 
  VALUES ('User','$2a$10$PnWVq0ieD1/qyFGLSH2Ga.1Ko7xEvXlbTgb9NqhXB.52rOwPiKEua'); 
    
  INSERT INTO APP_USER_USER_PROFILE (user_id, user_profile_id) SELECT user.id, profile.id FROM APP_USER user, USER_PROFILE profile where user.ssoid='User' and profile.type='USER' 
  
    
  Таблица авторизации 
   
CREATE TABLE `PERSISTENT_LOGINS` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

   
  Таблица данных в моем случае картинок  
   
  CREATE TABLE `CONTENT` ( 
  `id` bigint(20) NOT NULL AUTO_INCREMENT, 
  `Name` varchar(30) NOT NULL, 
  `Description` varchar(100) NOT NULL, 
  `Path` varchar(255) NOT NULL, 
  `Categories` varchar(100) NOT NULL, 
  `Created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP, 
  PRIMARY KEY (`id`)
  ) ENGINE=InnoDB AUTO_INCREMENT=28 ; 
   
  Добавляем контент  
   
  INSERT INTO `itdatatech`.`CONTENT` (`Name`, `Description`, `Path`, `Categories`) VALUES ('pic1', 'pic', 'https://i.redd.it/spo5q1n66gg11.jpg', '|1|'); 
   
  INSERT INTO `itdatatech`.`CONTENT` (`Name`, `Description`, `Path`, `Categories`) VALUES ('pic2', 'pic', 'https://bigpicture.ru/wp-content/uploads/2012/05/BIGPIC2212.jpg', '|1|'); 
  INSERT INTO `itdatatech`.`CONTENT` (`Name`, `Description`, `Path`, `Categories`) VALUES ('pic3', 'pic', 'https://bigpicture.ru/wp-content/uploads/2012/04/160.jpg', '|1|'); 
  INSERT INTO `itdatatech`.`CONTENT` (`Name`, `Description`, `Path`, `Categories`) VALUES ('pic4', 'pic', 'https://bigpicture.ru/wp-content/uploads/2012/04/160.jpg', '|1|'); 
  INSERT INTO `itdatatech`.`CONTENT` (`Name`, `Description`, `Path`, `Categories`) VALUES ('pic5', 'pic', 'https://bigpicture.ru/wp-content/uploads/2012/05/stars18-990x693.jpg', '|1|'); 
  INSERT INTO `itdatatech`.`CONTENT` (`Name`, `Description`, `Path`, `Categories`) VALUES ('pic6', 'pic', 'https://bigpicture.ru/wp-content/uploads/2012/04/324-660x990.jpg', '|2|'); 
  INSERT INTO `itdatatech`.`CONTENT` (`Name`, `Description`, `Path`, `Categories`) VALUES ('pic7', 'pic', 'https://bigpicture.ru/wp-content/uploads/2012/04/414.jpg', '|1|2|'); 
  INSERT INTO `itdatatech`.`CONTENT` (`Name`, `Description`, `Path`, `Categories`) VALUES ('pic8', 'pic', 'https://bigpicture.ru/wp-content/uploads/2012/04/513.jpg', '|1|'); 
  INSERT INTO `itdatatech`.`CONTENT` (`Name`, `Description`, `Path`, `Categories`) VALUES ('pic9', 'pic', 'https://bigpicture.ru/wp-content/uploads/2012/04/613.jpg', '|1|2|'); 
  INSERT INTO `itdatatech`.`CONTENT` (`Name`, `Description`, `Path`, `Categories`) VALUES ('pic10', 'pic', 'https://bigpicture.ru/wp-content/uploads/2012/04/713.jpg', '|3|'); 
  INSERT INTO `itdatatech`.`CONTENT` (`Name`, `Description`, `Path`, `Categories`) VALUES ('pic11', 'pic', 'https://bigpicture.ru/wp-content/uploads/2012/04/812.jpg', '|1|'); 
  INSERT INTO `itdatatech`.`CONTENT` (`Name`, `Description`, `Path`, `Categories`) VALUES ('pic12', 'pic', 'https://bigpicture.ru/wp-content/uploads/2012/04/912.jpg', '|1|3|'); 
  INSERT INTO `itdatatech`.`CONTENT` (`Name`, `Description`, `Path`, `Categories`) VALUES ('pic13', 'pic', 'https://bigpicture.ru/wp-content/uploads/2012/04/1014.jpg', '|2|'); 
  INSERT INTO `itdatatech`.`CONTENT` (`Name`, `Description`, `Path`, `Categories`) VALUES ('pic14', 'pic', 'https://bigpicture.ru/wp-content/uploads/2012/04/1116.jpg', '|2|3|'); 
  INSERT INTO `itdatatech`.`CONTENT` (`Name`, `Description`, `Path`, `Categories`) VALUES ('pic15', 'pic', 'https://bigpicture.ru/wp-content/uploads/2012/04/1214.jpg', '|1|2|'); 
  INSERT INTO `itdatatech`.`CONTENT` (`Name`, `Description`, `Path`, `Categories`) VALUES ('pic16', 'pic', 'https://bigpicture.ru/wp-content/uploads/2012/04/1313.jpg', '|3|'); 
  INSERT INTO `itdatatech`.`CONTENT` (`Name`, `Description`, `Path`, `Categories`) VALUES ('pic17', 'pic', 'https://bigpicture.ru/wp-content/uploads/2012/04/1412.jpg', '|2|'); 
  INSERT INTO `itdatatech`.`CONTENT` (`Name`, `Description`, `Path`, `Categories`) VALUES ('pic18', 'pic', 'https://bigpicture.ru/wp-content/uploads/2012/04/1511.jpg', '|1|3|'); 
