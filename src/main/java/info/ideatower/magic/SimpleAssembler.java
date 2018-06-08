package info.ideatower.magic;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import info.ideatower.magic.util.TemplateRenderer;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.Writer;
import java.util.List;
import java.util.Map;

/**
 * 数据处理器
 */
public class SimpleAssembler {

    private Schema schema;

    private TemplateRenderer renderer;
    private int size = 100;

    public SimpleAssembler size(int size) {
        this.size = size;
        return this;
    }

    public SimpleAssembler(Schema schema) {
        this.schema = schema;
        this.renderer = new TemplateRenderer();
    }


    /**
     * 按模板生成安答串
     * @param itemTemplate 模板
     * @return
     */
    public List<String> str(String itemTemplate) {
        List<String> strList = Lists.newArrayList();
        for (Map<String, Object> data : data()) {
            String rendered = renderer.render(itemTemplate, data);
            strList.add(rendered);
        }
        return strList;
    }

    /**
     * 写文件
     * @param itemTemplate 内容模板
     * @param filename 文件名
     */
    @SneakyThrows
    public void str(String itemTemplate, String filename) {
        List<String> all = str(itemTemplate);
        StringBuilder str = new StringBuilder();
        for (String line : all) {
            str.append(line);
        }
        FileUtils.writeStringToFile(new File(filename), str.toString());
    }

    /**
     * 通过io写
     * @param itemTemplate 内容模板
     * @param writer
     */
    @SneakyThrows
    public void str(String itemTemplate, Writer writer) {
        List<String> all = str(itemTemplate);
        for (String line : all) {
            writer.write(line);
        }
        writer.flush();
    }

    /**
     * 生成json字符串
     * @return
     */
    public String json() {
        List<Map<String, Object>> datas = data();
        return JSON.toJSONString(datas);
    }

    /**
     * 生成json文件
     * @param filename
     */
    @SneakyThrows
    public void json(String filename) {
        String content = json();
        FileUtils.writeStringToFile(new File(filename), content);
    }

    /**
     * 生成json文件
     * @param clazz
     * @param filename
     */
    @SneakyThrows
    public void json(Class<?> clazz, String filename) {
        String content = json(clazz);
        FileUtils.writeStringToFile(new File(filename), content);
    }

    /**
     * 生成json文件
     * @param clazz
     * @return
     */
    public String json(Class<?> clazz) {
        String content = JSON.toJSONString(obj(clazz));
        return content;
    }

    /**
     * 获取对象数据
     * @param clazz 对象类
     * @param <T> 对象类型
     * @return 对象列表
     */
    @SneakyThrows
    public <T> List<T> obj(Class<T> clazz) {
        List<T> result = Lists.newArrayList();

        for (Map<String, Object> item : data()) {
            T bean = clazz.newInstance();
            BeanUtils.populate(bean, item);

            result.add(bean);
        }

        return result;
    }

    /**
     * 获取数据
     * @return 数据列表
     */
    public List<Map<String, Object>> data() {
        List<Map<String, Object>> result = Lists.newArrayList();
        for (int i = 0; i < this.size; i++) {
            Map<String, Object> item = Maps.newHashMap();
            for (Randomable able : this.schema.getRandomable()) {
                item.put(able.getMark(), able.next());
            }
            result.add(item);
        }
        return result;
    }

}
