# Product API

상품에 관한 CRUD를 제공하는 API 입니다

## ERD 설계

<img width="504" alt="image" src="https://github.com/dduneon/whatap-labs-task-product/assets/84072084/66b56d2b-e53d-4c70-934b-fc2ddf490710">

<br>

## API 명세

![image](https://github.com/dduneon/whatap-labs-task-product/assets/84072084/4da0d5ef-76fc-4b4c-b7c6-4bcabd31f80d)


## API 사용 예시

### GET /api/products/{productId}
> 특정 상품의 정보를 가져오는 요청

요청
```http
GET http://localhost:7010/api/products/1
```
응답
```http
HTTP/1.1 200 OK
{
  "id": 1,
  "name": "상품명",
  "description": "상품설명"
}
```

<br>

요청
```http
GET http://localhost:7010/api/products/111
```
응답
```http
HTTP/1.1 404 Not Found
{
  "status": 404,
  "message": "Product(id=111) 를 찾을 수 없습니다"
}
```

<br>

### GET /api/products?page=&size=
> 페이지에 속하는 상품 리스트를 가져오는 요청

요청
```http
GET http://localhost:7010/api/products?page=0&size=3
```
응답
```http
HTTP/1.1 200 OK
{
  "data": [
    {
      "id": 1,
      "name": "상품명",
      "description": "상품설명"
    },
    {
      "id": 2,
      "name": "상품명",
      "description": "상품설명"
    },
    {
      "id": 3,
      "name": "상품명",
      "description": "상품설명"
    }
  ],
  "pageInfo": {
    "page": 0,
    "size": 3,
    "totalElements": 5,
    "totalPages": 2
  }
}
```

<br>

요청
```http
GET http://localhost:7010/api/products
```
응답
```http
HTTP/1.1 200 OK
{
  "data": [
    {
      "id": 1,
      "name": "상품명",
      "description": "상품설명"
    },
    {
      "id": 2,
      "name": "상품명",
      "description": "상품설명"
    },
    {
      "id": 3,
      "name": "상품명",
      "description": "상품설명"
    },
    {
      "id": 4,
      "name": "상품명",
      "description": "상품설명"
    },
    {
      "id": 5,
      "name": "상품명",
      "description": "상품설명"
    }
  ],
  "pageInfo": {
    "page": 0,
    "size": 5,
    "totalElements": 5,
    "totalPages": 1
  }
}
```

<br>

### POST /api/products
> 상품 생성 요청

요청
```http
POST http://localhost:7010/api/products
Content-Type: application/json

{
  "name": "상품명",
  "description": "상품설명"
}
```
응답
```http
HTTP/1.1 201 Created
content-length: 0
```

<br>

요청
```http
POST http://localhost:7010/api/products
Content-Type: application/json

{
  "description": "상품설명"
}
```
응답
```http
HTTP/1.1 400 Bad Request
{
  "title": "Constraint Violation",
  "status": 400,
  "violations": [
    {
      "field": "createProduct.productCreateRequestDto.name",
      "message": "name 필드가 비어 있습니다"
    }
  ]
}
```

<br>

### PUT /api/products
> 상품 수정 요청

요청
```http
PUT http://localhost:7010/api/products
Content-Type: application/json

{
  "id": 1,
  "name": "새로운이름",
  "description": "새로운상품"
}
```
응답
```http
HTTP/1.1 204 No Content
```

<br>

요청
```http
PUT http://localhost:7010/api/products
Content-Type: application/json

{
  "id": 111,
  "name": "새로운이름",
  "description": "새로운상품"
}
```
응답
```http
HTTP/1.1 404 Not Found
{
  "status": 404,
  "message": "Product(id=111) 를 찾을 수 없습니다"
}
```

<br>

요청
```http
PUT http://localhost:7010/api/products
Content-Type: application/json

{
  "name": "새로운이름",
  "description": "새로운상품"
}
```
응답
```http
HTTP/1.1 400 Bad Request
{
  "title": "Constraint Violation",
  "status": 400,
  "violations": [
    {
      "field": "updateProduct.productUpdateRequestDto.id",
      "message": "id 필드가 비어 있습니다"
    }
  ]
}
```

<br>

### DELETE /api/products
> 상품 삭제 요청

요청
```http
DELETE http://localhost:7010/api/products/2
```
응답
```http
HTTP/1.1 204 No Content
```

<br>

요청
```http
DELETE http://localhost:7010/api/products/111
```
응답
```http
HTTP/1.1 404 Not Found
{
  "status": 404,
  "message": "Product(id=111) 를 찾을 수 없습니다"
}
```
