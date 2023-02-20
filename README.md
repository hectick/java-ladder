# java-ladder

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

---

## 1단계 기능 목록

- [x]  참여할 사람의 이름을 입력 받는다
    - [x]  쉼표(,)로 구분한다
    - [x]  최대 5글자 까지 부여할 수 있다
    - [x]  이름에 공백에 포함되면 공백을 삭제한다
    - [x]  참여하는 사람 수가 2명 미만이면 예외처리 한다
    - [x]  중복된 이름이 들어오면 예외처리 한다
- [x]  사다리 높이를 입력 받는다
    - [x]  정수가 아닌 입력이 들어오면 예외처리한다
    - [x]  사다리 높이가 2 미만이면 예외처리한다
- [x]  사다리를 생성한다
    - [x]  세로라인을 사람 수 만큼 생성한다
    - [x]  가로라인을 생성한다
        - [x]  일정한 확률(50%)로 가로라인 생성 여부를 결정한다
        - [x]  결정된 생성 여부에 따라 가로 라인을 생성한다
        - [x]  만약 가로 라인이 겹친다면 그 줄은 넘어간다
- [x]  결과를 출력한다

### 리팩터링 및 고민 거리

- [x] 예외 메세지를 하나의 enum 으로 묶기 (-> exceptionMessage 패키지 내부로 묶음)
- [ ] 재귀를 계속하다가 StackOverFlowException 이 걸리면?
- [ ] 도메인과 모델의 차이
- [x] 사다리 최대 높이 제한 (-> 100 으로 제한)
- [x] 플레이어 최대인원을 콘솔 창에 사다리가 깨지지 않고 이쁘게 나올 수 있을 정도로 제한 (-> 26으로 제한)
- [ ] 한글/영어는 각자 차지하는 칸수가 다른데 어떻게 출력 결과가 이쁘게 보이게 하지

### 2단계 기능 목록

- [x] 실행 결과를 입력받는다
    - [x] 실행 결과는 플레이어 수와 일치해야 한다
- [x] 플레이어들이 사다리 탄 결과를 판단한다
- [x] 사다리 실행 결과를 출력한다
- [ ] 결과를 따로 조회할 수 있다
    - [x] 결과를 보고 싶은 사람을 입력받는다
    - [ ] 개인별 이름을 입력하면 개인별 결과를 출력한다
    - [ ] `all`을 입력하면 전체 참여자의 실행 결과를 출력한다
    - [ ] 반복해서 조회할 수 있다
    - [ ] `exit`를 입력하면 게임을 완전히 종료한다
- [ ] 예외 처리
    - [ ] 플레이어의 이름은 `all` 일 수 없다
    - [ ] 플레이어의 이름은 `exit` 일 수 없다
    - [ ] 결과를 보고 싶은 사람이 존재하지 않으면 예외처리한다

