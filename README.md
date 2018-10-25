# education_slackbot
Simple slack bot app for education

---

### 명령어 list
1. list - 친구목록 추가
2. add - 친구 추가
3. remove - 친구 삭제
4. find - 친구정보 출력


#### 친구정보
 - String name
 - int age
 - Gender gender - ENUM type으로 구현해야함

### 제약사항
1. 친구는 최대 10명까지만 추가 가능
2. 친구가 없는데 삭제시 예외처리(적절한 메세지 출력)
3. find결과가 없으면 예외처리(적절한 메세지 출력)
4. key = name, Friend name이 중복이면 안된다.
5. Friend add시, 이름, 나이, 성별이 입력되지 않으면 올바른 값을 입력하라고 출력

### Todo
- [x] 각 동작에 대한 SLACK BOT 명령어 구현
- [x] Friend Class 생성해야함
- [x] 친구목록은 Vector로 구현?
