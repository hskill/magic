package info.ideatower.magic.result;

import com.google.common.collect.Lists;
import info.ideatower.magic.Schema;
import info.ideatower.magic.schema.OnlySchema;
import info.ideatower.magic.schema.SerialSchema;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.lang3.ClassUtils;

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

    /**
     * 返回列表数据
     * @param target
     * @param <T>
     * @return
     */
    public <T> List<T> toList(Class<T> target) {
        List<T> result = Lists.newArrayList();
        if (schema instanceof SerialSchema) {
            ((SerialSchema) schema).next().forEach((item) -> {
                T bean = handleData(item, target);
                result.add(bean);
            });
        }
        else if (schema instanceof OnlySchema) {
            T bean = handleData(((OnlySchema) schema).next(), target);
            result.add(bean);
        }

        return result;
    }

    /**
     * 返回单个数据
     * @param target
     * @param <T>
     * @return
     */
    public <T> T to(Class<T> target) {
        T bean = null;
        if (schema instanceof SerialSchema) {
            List<Map<String, Object>> dataList = ((SerialSchema) schema).next();

            bean = handleData(dataList.get(0), target);
        }
        else if (schema instanceof OnlySchema) {
            bean = handleData(((OnlySchema) schema).next(), target);
        }

        return bean;
    }

    @SneakyThrows
    private <T> T handleData(Map<String, Object> item, Class<T> target) {
        T bean = (T) target.newInstance();

        for (Map.Entry<String, Object> entry : item.entrySet()) {
            if (null != target.getDeclaredField(entry.getKey())) {
                if (entry.getValue() instanceof Map) {
                    Class propertyClass = target.getDeclaredField(entry.getKey()).getType();
                    Object propertyValue = handleData((Map<String, Object>) entry.getValue(), propertyClass);
                    BeanUtils.setProperty(bean, entry.getKey(), propertyValue);
                }
                else {
                    BeanUtils.setProperty(bean, entry.getKey(), entry.getValue());
                }
            }
        }
        return bean;
    }

}
