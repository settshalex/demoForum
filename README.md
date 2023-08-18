# demoForum

<pre>
create table users
(
    id       bigserial
        constraint users_pk
            primary key,
    email    varchar(300) not null,
    password varchar(200)
);

alter table users
    owner to postgres;

create table posts
(
    id         bigserial
        constraint posts_pk
            primary key,
    text       text      not null,
    created_at timestamp not null,
    user_id    bigint    not null
        constraint posts_users_id_fk
            references users
);

alter table posts
    owner to postgres;

create table threads
(
    id         bigserial
        constraint threads_pk
            primary key,
    title      varchar(1000) not null,
    created_by bigint        not null
        constraint threads_users_id_fk
            references users,
    created_at time          not null
);

alter table threads
    owner to postgres;

create table threads_posts
(
    thread_id bigserial
        constraint threads_posts_threads_id_fk
            references threads,
    post_id   bigint not null
        constraint threads_posts_posts_id_fk
            references posts
);

alter table threads_posts
    owner to postgres;

create unique index users_id_uindex
    on users (id);

create unique index users_email_uindex
    on users (email);

INSERT INTO public.users (id, email, password) VALUES (DEFAULT, 'arctgalex@gmail.com'::varchar(300), '$2a$10$w2JqK0lto3IiAFe0tNgMX.EOEfLBGl6H8jEaYOmnBWERYanvdi7qG'::varchar(200))
</pre>

