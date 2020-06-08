package tool;

import java.time.Instant;
import java.time.temporal.TemporalUnit;

public class Interval {
    private Instant startInstant;
    private Instant endInstant;

    private Interval()  {
        super();
    }

    public static Interval getInstance() {
        return new Interval();
    }

    public Interval start() throws IllegalStateException {
        if (this.startInstant != null) {
            throw new IllegalStateException("startInstantは上書きできません");

        } else {
            this.startInstant = Instant.now();
            return this;
        }
    }

    public Interval end() throws IllegalStateException {
        if (startInstant == null) {
            throw new IllegalStateException("startInstantがnullです");

        } else if (endInstant != null) {
            throw new IllegalStateException("endInstantは上書きできません");

        } else {
            this.endInstant = Instant.now();
            return this;

        }
    }

    public long getInterval(TemporalUnit unit) throws IllegalStateException {

        if (startInstant == null || endInstant == null) {
            throw new IllegalStateException("フィールドに値がありません");
        } else {
            return startInstant.until(endInstant, unit);
        }
    }
}



