package info.ideatower.magic.result;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import info.ideatower.magic.Randomable;
import info.ideatower.magic.Schema;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.util.List;
import java.util.Map;

/**
 * 数据生成
 */
public class Result {

    private int size = 100;
    private Schema schema;

    public Result(Schema schema) {
        this.schema = schema;
    }

    public Result size(int size) {
        if (size <= 0) {
            return this;
        }
        this.size = size;
        return this;
    }

    @SneakyThrows
    public <T> List<T> getObjects(Class<T> target) {
        List<T> result = Lists.newArrayList();
        for (Map<String, Object> item : getDatas()) {
            T bean = (T) target.newInstance();
            BeanUtils.populate(bean, item);
            result.add(bean);
        }
        return result;
    }

    public List<Map<String, Object>> getDatas() {
        List<Map<String, Object>> result = Lists.newArrayList();
        if (!this.schema.getRandomable().isEmpty()) {
            for (int i = 0; i < this.size; i++) {
                Map<String, Object> item = Maps.newHashMap();
                for (Randomable able : this.schema.getRandomable()) {
                    item.put(able.getMark(), able.next());
                }
                result.add(item);
            }
        }
        return result;
    }
}
