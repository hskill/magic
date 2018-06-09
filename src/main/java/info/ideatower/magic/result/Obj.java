package info.ideatower.magic.result;

import java.util.List;

/**
 * 生成结果转为对象
 */
public class Obj {

    private final Result result;

    private int size = 100;
    private Class<?> target;

    public Obj(Result result) {
        this.result = result;
    }

    public Obj size(int size) {
        this.result.size(size);
        return this;
    }

    public Obj target(Class<?> target) {
        this.target = target;
        return this;
    }

    public <T> List<T> toList() {
        if (this.target != null) {
            return (List<T>) this.result.getObjects(this.target);
        }
        return (List<T>) this.result.getDatas();
    }
}
