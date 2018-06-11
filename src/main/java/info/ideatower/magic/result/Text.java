package info.ideatower.magic.result;

import com.google.common.collect.Lists;
import info.ideatower.magic.Schema;
import info.ideatower.magic.schema.OnlySchema;
import info.ideatower.magic.schema.SerialSchema;
import info.ideatower.magic.util.TemplateRenderer;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;

/**
 * 结果生成为字符串
 */
public class Text {

    private final TemplateRenderer renderer;

    private Schema schema;
    private String template;
    private String seperator;

    public Text(Schema schema) {
        this.schema = schema;
        this.renderer = new TemplateRenderer();
        this.seperator = System.getProperty("line.separator");
    }

    public Text template(String template) {
        this.template = template;
        return this;
    }

    public Text seperator(String seperator) {
        this.seperator = seperator;
        return this;
    }

    @SneakyThrows
    public void toFile(String filename) {
        List<String> all = toList();
        StringBuilder str = new StringBuilder();
        for (String line : all) {
            str.append(line);
            str.append(this.seperator);
        }
        FileUtils.writeStringToFile(new File(filename), str.toString());
    }

    @SneakyThrows
    public void toWriter(Writer writer) {
        List<String> all = toList();
        for (String line : all) {
            writer.write(line);
            writer.write(this.seperator);
        }
        writer.flush();
    }

    public void toPrint() {
        toWriter(new OutputStreamWriter(System.out));
    }

    /**
     * 返回字符串列表
     * @return
     */
    public List<String> toList() {
        List<String> strList = Lists.newArrayList();
        if (schema instanceof SerialSchema) {
            ((SerialSchema) schema).next().forEach((item) -> {
                String rendered = handleData(item);
                strList.add(rendered);
            });
        }
        else if (schema instanceof OnlySchema) {
            String rendered = handleData(((OnlySchema) schema).next());
            strList.add(rendered);
        }

        return strList;
    }


    /**
     * 返回单个字符串
     * @return
     */
    public String to() {
        String str = "";
        if (schema instanceof SerialSchema) {
            List<Map<String, Object>> dataList = ((SerialSchema) schema).next();
            str = handleData(dataList.get(0));
        }
        else if (schema instanceof OnlySchema) {
            str = handleData(((OnlySchema) schema).next());
        }

        return str;
    }

    private String handleData(Map<String, Object> item) {
        String rendered = renderer.render(this.template, item);
        return rendered;
    }
}
