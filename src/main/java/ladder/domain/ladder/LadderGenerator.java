package ladder.domain.ladder;

import ladder.domain.rule.LadderRule;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {
    public static Ladder generate(final int ladderWidth, final int ladderHeight, final LadderRule rule) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            lines.add(LineGenerator.generate(ladderWidth, rule));
        }
        return new Ladder(lines);
    }
}