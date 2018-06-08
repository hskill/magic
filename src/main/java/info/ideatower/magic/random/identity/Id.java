package info.ideatower.magic.random.identity;

import com.sohu.idcenter.IdWorker;
import info.ideatower.magic.random.AbstractRandomValue;

/**
 * 生成唯一id
 */
public class Id extends AbstractRandomValue<Long> {


    private IdWorker idWorker;

    public Id(String mark) {
        super(mark);
        this.idWorker = new IdWorker();
    }

    @Override
    public Long next() {
        return idWorker.getId();
    }
}
