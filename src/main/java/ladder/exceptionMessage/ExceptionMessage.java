package ladder.exceptionMessage;

public enum ExceptionMessage {
    /*InputView*/
    EXCEPTION_DUPLICATED_NAME("이름은 중복될 수 없습니다."),
    EXCEPTION_INVALID_BIG_HEIGHT("사다리 높이가 너무 높습니다. 사다리 높이는 100 이하여야 합니다."),
    EXCEPTION_NOT_INTEGER("정수가 아닙니다."),

    /*Player*/
    EXCEPTION_INVALID_NAME_LENGTH("플레이어 이름은 1자 이상 5자 이하여야 합니다."),

    /*Players*/
    EXCEPTION_INVALID_PLAYER_COUNT("게임을 진행하기 위해서는 두 명 이상의 플레이어가 필요합니다."),

    /*Height*/
    EXCEPTION_INVALID_HEIGHT("사다리 높이는 2 이상 100 이하여야 합니다.");

    public final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}