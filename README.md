# Product API

상품에 관한 CRUD를 제공하는 API 입니다

## 요구사항 분석

### ER 다이어그램

ERDCloud를 활용하여 erd를 작성해 보았습니다

<img width="504" alt="image" src="https://github.com/dduneon/whatap-labs-task-product/assets/84072084/66b56d2b-e53d-4c70-934b-fc2ddf490710">

<br>

### Product API 명세

요구 사항을 바탕으로 API 명세를 작성해 보았습니다

<img width="751" alt="image" src="https://github.com/dduneon/whatap-labs-task-product/assets/84072084/6a8d74f8-c3bc-45a9-9bed-ab5713921568">

### 테스팅

```http
### 특정 상품 하나에 대한 정보 가져오는 요청
GET http://localhost:7010/products/1

### 특정 상품 하나에 대한 정보 가져오는 요청 (상품 존재하지 않을 경우)
GET http://localhost:7010/products/111

### 해당하는 페이지 내의 상품 리스트를 가져오는 요청
GET http://localhost:7010/products?page=0&size=5

### 페이지와 사이즈를 지정해 주지 않은 경우 (default 값인 page=0, size=5)
GET http://localhost:7010/products


### 상품 생성하는 요청
POST http://localhost:7010/products
Content-Type: application/json

{
  "name": "상품명",
  "description": "상품설명"
}

### 상품 생성하는 요청 (정확한 요청이 아닌 경우)
POST http://localhost:7010/products
Content-Type: application/json

{
  "description": "상품설명"
}

### 상품에 대한 정보를 수정하는 요청
PUT http://localhost:7010/products
Content-Type: application/json

{
  "id": 1,
  "name": "새로운이름",
  "description": "새로운상품"
}

### 상품에 대한 정보를 수정하는 요청 (상품이 존재하지 않는 경우)
PUT http://localhost:7010/products
Content-Type: application/json

{
  "id": 111,
  "name": "새로운이름",
  "description": "새로운상품"
}

### 상품에 대한 정보를 수정하는 요청 (요청이 정확하지 않은 경우)
PUT http://localhost:7010/products
Content-Type: application/json

{
  "name": "새로운이름",
  "description": "새로운상품"
}

### 상품을 삭제하는 요청
DELETE http://localhost:7010/products/1

### 상품을 삭제하는 요청 (상품이 존재하지 않는 경우)
DELETE http://localhost:7010/products/111
```
