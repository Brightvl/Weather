#CREATE

-- CREATE TABLE `weatherdb`.`users` (
--   `id` INT NOT NULL AUTO_INCREMENT,
--   `name` VARCHAR(45) NOT NULL,
--   `age` INT(3) NULL,
--   `email` VARCHAR(64) NULL,
--   PRIMARY KEY (`id`))
-- ENGINE = InnoDB
-- DEFAULT CHARACTER SET = utf8;

insert into users (name,age,email) values('Steve', 55, 'asdf@mail.com');

#REQUEST
# select * from users;
# select * from users where id = 2;
# select * from users where name = 'Steve';


#UPDATE
# update users set name = 'Steve', age=55 where id = 2;

#DELETE
# delete from users;
# delete from users where id = 4;

