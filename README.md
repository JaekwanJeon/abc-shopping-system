# abc-shopping-system

![image](https://github.com/JaekwanJeon/abc-shopping-system/assets/3446997/9253a8f0-bf39-4e26-b7a8-16bd7e0b7780)

헥사고널 아키텍처

![image](https://github.com/JaekwanJeon/abc-shopping-system/assets/3446997/5783a59a-6e2f-49e6-b46a-1fb67870ebd0) ![image](https://github.com/JaekwanJeon/abc-shopping-system/assets/3446997/3415e6b2-355f-4dd2-aeee-9c8a2ebf6ace)


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
    quantity  bigint,
    price bigint
);


insert into product.product (id, name, company, description, quantity, price)
values
        (gen_random_uuid(), '맛동산', '해태', '땅콩으로 버무린 튀김과자', 100, 1000),
        (gen_random_uuid(), '초코파이', '오리온', '초코와 마시멜로의 조화', 100, 500),
        (gen_random_uuid(), '갤럭시 S23', '삼성', '삼성의 23년도 플래그쉽 폰', 100, 1000000);
```
### order service
```
create schema order;
create table orders
(
    id               uuid                 not null
        primary key,
    customer_id      uuid                 not null,
    delivery_id      uuid                 not null,
    tracking_id      uuid                 not null,
    price            numeric(10, 2)       not null,
    order_status     "order".order_status not null,
    failure_messages varchar
);

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
    "quantity": 100,
    "price": 1000
  },
  "failureMessages": null
}
```
### order service
```
POST http://localhost:8081/orders
Content-Type: application/json

{
  "userId": "999fa683-765b-4fd2-8ef9-9a95c231e549",
  "restaurantId": "d215b5f8-0249-4dc5-89a3-51fd148cfb45",
  "address": {
    "street": "street_1",
    "postalCode": "1000AB",
    "city": "Amsterdam"
  },
  "price": 200.00,
  "items": [
    {
      "productId": "d215b5f8-0249-4dc5-89a3-51fd148cfb48",
      "quantity": 1,
      "price": 50.00,
      "subTotal": 50.0
    },
    {
      "productId": "d215b5f8-0249-4dc5-89a3-51fd148cfb48",
      "quantity": 3,
      "price": 50.00,
      "subTotal": 150.0
    }
  ]
}
```




