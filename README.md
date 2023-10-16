# abc-shopping-system

![image](https://github.com/JaekwanJeon/abc-shopping-system/assets/3446997/9253a8f0-bf39-4e26-b7a8-16bd7e0b7780)

헥사고널 아키텍처
![image](https://github.com/JaekwanJeon/abc-shopping-system/assets/3446997/5783a59a-6e2f-49e6-b46a-1fb67870ebd0) ![image](https://github.com/JaekwanJeon/abc-shopping-system/assets/3446997/cde940b7-6e34-4c63-83ff-1cffbe4f38b4)

## 1. Database 설정

### user service
```
create schema "user"
create table "user".users
(
    id         uuid not null primary key,
    user_name   varchar not null,
    phone_number varchar not null,
    address  varchar
);


select * from "user".users;

insert into "user".users (id, user_name, phone_number, address)
values
        (gen_random_uuid(), '홍길동', '01012345678', '서울시 강남구'),
        (gen_random_uuid(), '김철수', '01045345678', '서울시 강동구'),
        (gen_random_uuid(), '김삼성', '01056645678', '서울시 강서구');
```
### product service
```
create schema product;
create table product.product
(
    id         uuid not null primary key,
    name   varchar not null,
    company   varchar not null,
    description varchar,
    quantity  bigint
);


insert into product.product (id, name, company, description, quantity)
values
        (gen_random_uuid(), '맛동산', '해태', '땅콩으로 버무린 튀김과자', 100),
        (gen_random_uuid(), '초코파이', '오리온', '초코와 마시멜로의 조화', 100),
        (gen_random_uuid(), '갤럭시 S23', '삼성', '삼성의 23년도 플래그쉽 폰', 100);
```

## 2. 서버 테스트
### user service
```
GET http://localhost:8089/user/999fa683-765b-4fd2-8ef9-9a95c231e549
{
  "user": {
    "id": {
      "value": "999fa683-765b-4fd2-8ef9-9a95c231e549"
    },
    "userName": "홍길동",
    "phoneNumber": "01012345678",
    "address": "서울시 강남구"
  },
  "failureMessages": null
}
```
### product service
```
GET http://localhost:8088/product/8cecc491-f942-41fb-a144-d3b020a12689
{
  "product": {
    "id": {
      "value": "8cecc491-f942-41fb-a144-d3b020a12689"
    },
    "name": "맛동산",
    "company": "해태",
    "description": "땅콩으로 버무린 튀김과자",
    "quantity": 100
  },
  "failureMessages": null
}
```





