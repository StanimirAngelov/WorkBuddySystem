drop table users;

CREATE TABLE Users (
    user_id INT,
    name varchar(100),
    username varchar(15),
	age INT,
	password varchar(50)
	primary key (user_id)
	);

	select * from users; 

	delete from users where user_id = 2; 