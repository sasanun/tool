package tool;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.TreeMap;

public class CheckPoint {

    /*処理内での任意の位置でポインターを表示したり任意の処理の間での時間を計測する*/
    private TreeMap<String, Instant> checkPoints;

    /*コンストラクタ*/
    public CheckPoint() {
        super();
        this.checkPoints = new TreeMap<>();
    }

    /*チェックポイントを作成する*/
    public void check(String tag) {
        if (checkPoints.containsKey(tag)) {
            throw new IllegalArgumentException("重複するtagがすでに存在します");
        } else {
            checkPoints.put(tag, Instant.now());
            System.out.printf("---------<<< %s >>>---------\n", tag);
        }
    }

    /*チェックポイント間の時間を計測する*/
    public long between(String startTag, String endTag, TemporalUnit unit) {
        return checkPoints.get(startTag).until(checkPoints.get(endTag), unit);
    }

    /*チェックポイント間の時間を文字列で返す*/
    public java.lang.String toStringBetween(String startTag, String endTag, TemporalUnit unit) {
        return java.lang.String.format(
                "between %-9s to %-9s: %,18dns\n",
                startTag,
                endTag,
                between(startTag, endTag, unit));
    }

    public java.lang.String toString() {
        StringBuilder sb = new StringBuilder();
        List<String> tagList = List.copyOf(checkPoints.keySet());
        for (int i = 1; i < tagList.size(); i++) {
            sb.append(
                    this.toStringBetween(tagList.get(i -1),
                            tagList.get(i),
                            ChronoUnit.NANOS)
            );
        }

        return sb.toString();
    }
}