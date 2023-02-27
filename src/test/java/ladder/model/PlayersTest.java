package ladder.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.*;

class PlayersTest {

    @Test
    @DisplayName("플레이어가 2명 미만이면 예외처리 테스트")
    void invalidSmallPlayerCountTest() {
        List<Player> input = new ArrayList<>(List.of(new Player("이오")));
        assertThatThrownBy(() -> new Players(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("플레이어가 26명 초과면 통과하는 테스트")
    void invalidLargePlayerCountTest() {
        List<String> players = new ArrayList<>(List.of("a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,zzz".split(",")));
        List<Player> input = players.stream().map(Player::new).collect(Collectors.toList());
        assertThatThrownBy(() -> new Players(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("플레이어가 2명 이상이면 통과하는 테스트")
    void validMinPlayerCountTest() {
        List<Player> input = new ArrayList<>(List.of(new Player("이오"), new Player("이리내")));
        assertThatCode(() -> new Players(input)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("플레이어가 26명 이하면 통과하는 테스트")
    void validMaxPlayerCountTest() {
        List<String> players = new ArrayList<>(List.of("a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z".split(",")));
        List<Player> input = players.stream().map(Player::new).collect(Collectors.toList());
        assertThatCode(() -> new Players(input)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("존재하는 플레이어를 잘 찾는지 테스트")
    void findExistPlayerTest() {
        List<String> playerNames = new ArrayList<>(List.of("a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z".split(",")));
        List<Player> input = playerNames.stream().map(Player::new).collect(Collectors.toList());
        Players players = new Players(input);
        assertThat(players.findPlayer(new Player("b"))).isEqualTo(input.get(1));
    }

    @Test
    @DisplayName("존재하지 않는 플레이어라면 예외처리 테스트")
    void findNonExistPlayerTest() {
        List<String> playerNames = new ArrayList<>(List.of("a,b,c,d,e".split(",")));
        List<Player> input = playerNames.stream().map(Player::new).collect(Collectors.toList());
        Players players = new Players(input);
        assertThatThrownBy(() -> players.findPlayer(new Player("z")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복된 이름이 존재하는 경우 예외 처리 테스트")
    void duplicateNameTest() {
        List<String> playerNames = new ArrayList<>(List.of("이오,이리내,깃짱,성하,이오".split(",")));
        List<Player> input = playerNames.stream().map(Player::new).collect(Collectors.toList());

        Assertions.assertThatThrownBy(() -> new Players(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
