create table resume
(
    uuid      char(36) primary key not null,
    full_name text                 not null
);

create table contact
(
    id         serial,
    resum_uuid char(36) not null references resume (uuid) on delete cascade,
    type       text     not null,
    value      text     not null

);

create unique index contact_uuid_type_index on contact (resum_uuid, type);

create table section
(
    id         serial primary key,
    resum_uuid char(36) not null references resume (uuid) on delete cascade,
    type       text     not null,
    content      text     not null

);
create unique index section_inx on section (resum_uuid, type);