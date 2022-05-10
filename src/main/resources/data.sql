SET AUTOCOMMIT TRUE;

CREATE TABLE IF NOT EXISTS user
(
    id          int auto_increment primary key,
    name        varchar(250),
    description varchar(250),
    role        int,
    email       varchar(120),
    pass        varchar(120),
    confirmed   boolean
);

CREATE TABLE IF NOT EXISTS role
(
    id          int auto_increment primary key,
    name        varchar(250),
    description varchar(250),
    work        int
);

CREATE TABLE IF NOT EXISTS work
(
    id          long auto_increment primary key,
    name        varchar(250),
    description varchar(250),
    role        int,
    start       timestamp,
    end         timestamp
);