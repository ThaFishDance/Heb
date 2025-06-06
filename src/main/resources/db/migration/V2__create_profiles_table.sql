create table profiles
(
    id             bigint not null
        primary key,
    bio            text,
    phone_number   varchar(15),
    date_of_birth  date,
    loyalty_points int unsigned default 0,
    column_name    int,
    constraint profiles_users_id_fk
        foreign key (id) references users (id)
);
