package ladder.model;

public class PlayerName {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private final String playerName;

    public PlayerName(String playerName) {
        playerName = removeWhiteSpace(playerName);
        validatePlayerNameLength(playerName);
        this.playerName = playerName;
    }

    private String removeWhiteSpace(String playerName) {
        return playerName.replaceAll(" ", "");
    }

    private void validatePlayerNameLength(String playerName) {
        if (!isNameLengthIncludedInRange(playerName)) {
            throw new IllegalArgumentException(ErrorMessage.EXCEPTION_INVALID_LENGTH_NAME.getMessage());
        }
    }

    private boolean isNameLengthIncludedInRange(String playerName) {
        return MIN_LENGTH < playerName.length() && playerName.length() < MAX_LENGTH;
    }

    public String getPlayerName() {
        return playerName;
    }

    private enum ErrorMessage {
        EXCEPTION_INVALID_LENGTH_NAME("플레이어 이름은 1자 이상 5자 이하여야 합니다.");
        private final String message;

        ErrorMessage(String message) {
            this.message = message;
        }

        private String getMessage() {
            return message;
        }
    }

}
