package ladder.view;


import java.util.List;

public class OutputView {

    private static final OutputView INSTANCE = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return INSTANCE;
    }

    public void printPlayerNames(List<String> playerNames) {
        playerNames.forEach(name -> System.out.printf("%-6s", name));
    }

    public void printLadderResultMessage() {
        System.out.println();
        System.out.println("사다리 결과");
    }

    public void printRow(List<Boolean> points) {
        System.out.println();
        System.out.print(LadderMark.COLUMN_LINE.getMark());
        for (boolean point : points) {
            System.out.print(LadderMark.getRowMark(point));
            System.out.print(LadderMark.COLUMN_LINE.getMark());
        }
    }

    public void printResults(List<String> results) {
        System.out.println();
        results.forEach(result -> System.out.printf("%-6s", result));
        System.out.println();
    }

    public void printChosePlayerResult(String result) {
        System.out.println("실행 결과");
        System.out.println(result);
    }

    public void printExceptionMessage(String message) {
        System.out.println(message);
    }

    private enum LadderMark {
        ROW_LINE("-----"),
        ROW_EMPTY("     "),
        COLUMN_LINE("|");
        private final String mark;

        LadderMark(String mark) {
            this.mark = mark;
        }

        private String getMark() {
            return mark;
        }

        private static String getRowMark(boolean hasLine) {
            if (hasLine) return ROW_LINE.mark;
            return ROW_EMPTY.mark;
        }
    }
}
