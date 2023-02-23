package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.*;

class PlayerTest {

    @ParameterizedTest
    @DisplayName("플레이어 이름이 1자 미만 6자 이상이면 예외처리 테스트")
    @ValueSource(strings = {"이리내이리내", ""})
    void invalidNameLengthTest(String input) {
        assertThatThrownBy(() -> new Player(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("플레이어 이름이 1자 이상 5자 이하면 통과 테스트")
    @ValueSource(strings = {"이리내", "이오", "이", "이리내이오"})
    void validNameLengthTest(String input) {
        assertThatCode(() -> new Player(input)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("이름 공백을 제거 테스트")
    @CsvSource(value = {" 이리내 :이리내", "이리 내:이리내"}, delimiter = ':', ignoreLeadingAndTrailingWhitespace = false)
    void removeWhiteSpaceTest(String input, String expected) {
        System.out.println(input);
        Player name = new Player(input);
        assertThat(name.getPlayerName()).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("플레이어 이름이 금지어(all) 이면 예외처리 테스트")
    @ValueSource(strings = {"all"})
    void invalidNameTest(String input) {
        assertThatThrownBy(() -> new Player(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
