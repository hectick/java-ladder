package ladder.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class InputViewTest {
    private final InputView inputView = InputView.getInstance();

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    @DisplayName("입력받은 문자열을 ,를 기준으로 잘 분리하는지 테스트")
    void splitNameTest() {
        String input = "이오,이리내,깃짱,성하\n";
        InputStream in = generateUserInput(input);
        System.setIn(in);

        assertThat(inputView.readNames().size()).isEqualTo(4);
    }

    @ParameterizedTest
    @DisplayName("사다리 높이가 정수가 아니면 예외처리 테스트")
    @ValueSource(strings = {"이것은 높이가 아니다\n", "0.1234\n"})
    void notIntegerHeightTest(String input) {
        InputStream in = generateUserInput(input);
        System.setIn(in);

        Assertions.assertThatThrownBy(inputView::readHeight)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("사다리 높이가 너무 너무 큰 정수면 예외처리 테스트")
    @ValueSource(strings = {"10000000000000\n", "3245343212314231241231231\n"})
    void largeIntegerHeightTest(String input) {
        InputStream in = generateUserInput(input);
        System.setIn(in);

        Assertions.assertThatThrownBy(inputView::readHeight)
                .isInstanceOf(IllegalArgumentException.class);
    }

}
