package info.ideatower.magic.util;

import freemarker.cache.StringTemplateLoader;
import freemarker.core.Environment;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public class TemplateRenderer {

    /**
     * 渲染内容
     * @param content 模板内容字符串
     * @param data 数据
     * @param writer 输出
     */
    public void render(String content, Object data, Writer writer) {
        try {
            Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
            configuration.setTemplateExceptionHandler(new TemplateExceptionHandler() {
                @Override
                public void handleTemplateException(TemplateException te, Environment env, Writer out) throws TemplateException {
                    throw te;
                }
            });
            StringTemplateLoader stringLoader = new StringTemplateLoader();
            stringLoader.putTemplate("template", content);
            configuration.setTemplateLoader(stringLoader);
            freemarker.template.Template t = configuration.getTemplate("template", "UTF-8");

            configuration.setDefaultEncoding("UTF-8");   //这个一定要设置，不然在生成的页面中 会乱码
            t.process(data, writer);
        }
        catch (IOException e) {
            throw new RuntimeException("模板生成出错", e);
        }
        catch (TemplateException e) {
            throw new RuntimeException("模板编写有误，请注意模板中的：" + e.getBlamedExpressionString(), e);
        }
    }

    /**
     * 渲染内容
     * @param content 模板内容字符串
     * @param data 数据
     */
    public String render(String content, Object data) {
        StringWriter writer = new StringWriter();
        render(content, data, writer);
        return writer.toString();
    }
}
