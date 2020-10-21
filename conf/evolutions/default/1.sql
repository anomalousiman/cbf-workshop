# --- !Ups

create table "products" (
    "id" int not null primary key,
    "name" varchar,
    "description" varchar,
    "images" varchar
);

create table "likes" (
    "product_id" int not null primary key
);

insert into "products"("id", "name", "description", "images") values (0, 'Bag', 'A vintage gucci bag', 'https://d2h1pu99sxkfvn.cloudfront.net/b0/2413185/841928653_be56fadbb343466ab29b26879fff4cd6/P0.jpg');
insert into "products"("id", "name", "description", "images") values (1, 'Red Cardigan', 'A red Lacoste cardigan', 'https://d2h1pu99sxkfvn.cloudfront.net/b0/1965357/844498709_60e619352df74746af9ea80736845fee/P0.jpg');
insert into "products"("id", "name", "description", "images") values (2, 'Hoodie', 'Purple Nike hoodie', 'https://d2h1pu99sxkfvn.cloudfront.net/b0/1965357/840207113_1c42622307574d9d95056ee8d29b14e3/P0.jpg|https://d2h1pu99sxkfvn.cloudfront.net/b0/1965357/840207095_31afb3d7c00248f491005148f6a19836/P0.jpg');
insert into "products"("id", "name", "description", "images") values (3, 'A hat', 'Very practical', 'https://d2h1pu99sxkfvn.cloudfront.net/b0/1988192/832283911_ddf5a308d9ea40a297ed5b95241e21a2/P0.jpg');
insert into "products"("id", "name", "description", "images") values (4, 'Crochet bag', 'Granny chic', 'https://d2h1pu99sxkfvn.cloudfront.net/b0/5938437/839200690_e8a333bac22c4921912f9e3fc0cb6cb3/P0.jpg|https://d2h1pu99sxkfvn.cloudfront.net/b0/5938437/839201059_ffc09ae4c6ae4bcba66e597c5c6a7bc3/P0.jpg');

# --- !Downs

drop table "products" if exists;
drop table "likes" if exists;
