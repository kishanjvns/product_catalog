DROP TABLE IF EXISTS USERS;
  
CREATE TABLE USERS(
  id INT AUTO_INCREMENT  PRIMARY KEY,
  title VARCHAR(250) NOT NULL,
  desc VARCHAR(250) NOT NULL,
  imagePath VARCHAR(250) DEFAULT NULL,
  unitPrice Integer NOT NULL
);


INSERT INTO USERS(id, title, desc, imagePath, unitPrice) VALUES
  ('1', 'Ram', 'ddr 3 ram','',2000);