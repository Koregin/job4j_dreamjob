CREATE TABLE if not exists post (
   id SERIAL PRIMARY KEY,
   name TEXT,
   description TEXT,
   created timestamp,
   visible boolean,
   city_id integer
);

INSERT INTO post (name, description, created, visible, city_id)
        VALUES ('Junior Java Job', 'Job for junior', '2022-04-12', false, 1);
INSERT INTO post (name, description, created, visible, city_id)
        VALUES ('Middle Java Job', 'Job for middle', '2022-04-12', false, 1);
INSERT INTO post (name, description, created, visible, city_id)
        VALUES ('Senior Java Job', 'Job for senior', '2022-04-12', false, 1);