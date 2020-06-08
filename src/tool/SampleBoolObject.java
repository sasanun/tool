package tool;

import java.util.Random;
import java.util.function.BooleanSupplier;

public class SampleBoolObject implements BooleanSupplier {
    boolean bool;

    private SampleBoolObject(Object... args){}

    public void toBoolRandom() {
        this.bool = new Random().nextBoolean();
    }

    public void toBoolOpposite() {
        this.bool = !this.bool;
    }

    public static SampleBoolObject getInstance() {
        return new SampleBoolObject();
    }

    public void setBool(Boolean bool) {
        this.bool = bool;
    }

    @Override
    public boolean getAsBoolean() {
        return this.bool;
    }

    public static boolean getBoolRandom(){
        return new Random().nextBoolean();
    }
}
