package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class DirectionTest {

    @Test
    void init_invalid() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Direction(true, true);
        });
    }

    @Test
    void move_left() {
        Direction direction = new Direction(true, false);
        assertThat(direction.move()).isEqualTo(-1);
    }

    @Test
    void move_right() {
        Direction direction = new Direction(false, true);
        assertThat(direction.move()).isEqualTo(1);
    }

    @Test
    void move_none() {
        Direction direction = new Direction(false, false);
        assertThat(direction.move()).isEqualTo(0);
    }

    @Test
    void move_next() {
        Direction direction = new Direction(false, false);
        assertThat(direction.next(true)).isEqualTo(new Direction(false, true));
    }

    @Test
    void first() {
        Direction direction = Direction.first(new AlwaysTrue());
        assertThat(direction).isEqualTo(new Direction(false, true));
    }

    @Test
    void last() {
        Direction direction = Direction.first(new AlwaysTrue()).last();
        assertThat(direction).isEqualTo(new Direction(true, false));
    }
}
