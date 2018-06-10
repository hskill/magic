package info.ideatower.magic.result;

import com.google.common.collect.Lists;
import info.ideatower.magic.Schema;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.util.List;
import java.util.Map;

/**
 * 生成结果转为对象
 */
public class Obj {

    private final Schema schema;

    public Obj(Schema schema) {
        this.schema = schema;
    }

    @SneakyThrows
    public <T> List<T> toList(Class<T> target) {
        List<T> result = Lists.newArrayList();
        for (Map<String, Object> item : this.schema.next()) {
            T bean = (T) target.newInstance();
            BeanUtils.populate(bean, item);
            result.add(bean);
        }
        return result;
    }

}
