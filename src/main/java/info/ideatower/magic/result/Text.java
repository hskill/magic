package info.ideatower.magic.result;

import com.google.common.collect.Lists;
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

    private Result result;
    private String template;
    private String seperator;

    public Text(Result result) {
        this.result = result;
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

    public Text size(int size) {
        this.result.size(size);
        return this;
    }

    public List<String> toList() {
        List<String> strList = Lists.newArrayList();
        List<Map<String, Object>> datas = result.getDatas();
        if (!datas.isEmpty() && StringUtils.isNotBlank(this.template)) {
            for (Map<String, Object> item : datas) {
                String rendered = renderer.render(this.template, item);
                strList.add(rendered);
            }
        }
        return strList;
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
}
