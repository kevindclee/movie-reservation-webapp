# :sun_with_face:movie-reservation-webapp
:bulb:영화예매 웹사이트를 구현한 JPA, Spring Framework 리뷰용 미니 프로젝트

## :movie_camera:프로젝트 주제 소개
- :one: 영화 예매를 도와주는 사이트
- :two: 현장에서 직접 결제를 하는 번거로움을 해소하고 자리 존재 유무 확인을 도와주는 예매 사이트
- :three: 날짜와 시간별로 예매할 수 있는 사이트

## :sunglasses:팀원 명단
- :man:이동찬 : 예매 / 예매 취소 기능 백엔드 구현
- :man:김현수
- :man:송효섭
- :man:김성훈 : 회원가입 / 로그인 기능 백엔드 구현

## :fire:도메인 용어 정의
- :tv:Movie : 기본적인 영화정보
	- :black_circle:id : 영화 id값
  - :black_circle:name : 영화명
  - :black_circle:price : 영화가격

- :cinema:Auditorium : 상영관 (영화관 1관, 2관, ...) 상영관 및 영화에 관한 정보 가지고 있음
	- :black_circle:id : 상영관 id값
  - :black_circle:Movie : 해당 상영관에서 상영하는 영화
  - :black_circle:maxSeatCount : 최대 좌석수

- :seat:Seat : 좌석 (좌석 A1, A2, B1, ...) 좌석, 상영관, 영화에 대한 정보를 가지고 있음
	- :black_circle:id : 좌석 id값
  - :black_circle:name : 좌석명
  - :black_circle:auditorium : 해당 좌석이 위치한 상영관

- :smile:User : 기본적인 유저정보
	- :black_circle:id : 유저 아이디
  - :black_circle:password : 유저 비밀번호

- :ticket:Ticket : 예매티켓, 좌석, 상영관, 영화, 유저 정보 다 가지고 있음
	- :black_circle:id : 티켓 id 값 (한 좌석당 한 티켓이 존재하므로 좌석 id값과 동일)
  - :black_circle:timeStamp : 티켓 발행 시간 및 날짜
  - :black_circle:Seat : 해당 티켓의 좌석 정보
  - :black_circle:User : 해당 티켓의 유저 정보

## :heavy_check_mark:요구사항


## :pencil:ERD
![ER Diagram for movie reservation project](/images/movie-erd1.png "ER Diagram")

## :book:API Document(선택) - RestAPI 사용했을 경우

## :interrobang:트러블슈팅(에러 내역, 어떻게 해결했는지)
:bangbang:문제 :  User 객체 String Id Column Primary key 설정시 테이블 생성 불가 문제<br>
:o:해결 : Id Column을 String으로 선언시 최대 길이 255로 설정되는데 최대길이가 길면 Primary key 설정 불가, 초기 길이를 100으로 설정해주면서 문제해결


## :rainbow:느낀점
- :man:이동찬 : 머리가 터질꺼 같았따ㅋㅋㅋㅋㅋ
- :man:김현수
- :man:송효섭 : ㅎㄴㄷㅁㄺㄷ
- :man:김성훈 : 하하
