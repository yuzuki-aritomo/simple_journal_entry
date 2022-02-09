use simple_journal_entry_db;

create table snacks
(
    id     bigint      not null primary key auto_increment,
    name   varchar(50) not null,
    price  int         not null
)
