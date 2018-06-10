package info.ideatower.magic.result;

import com.alibaba.fastjson.JSON;
import info.ideatower.magic.Schema;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * 生成结果转为json
 */
public class Json {

    private Schema schema;
    private Class<?> target;
    private String file;
    private Obj obj;

    public Json(Schema schema) {
        this.schema = schema;
        this.obj = new Obj(schema);
    }

    public Json file(String file) {
        this.file = file;
        return this;
    }

    public Json target(Class<?> target) {
        this.target = target;
        return this;
    }

    /**
     * 转为json字符串
     * @return
     */
    public String toStr() {
        if (target != null) {
            return JSON.toJSONString(this.obj.toList(target));
        }
        else {
            return JSON.toJSONString(this.schema.next());
        }
    }

    /**
     * 通过writer写json
     * @param writer
     */
    @SneakyThrows
    public void toWriter(Writer writer) {
        String all = toStr();
        writer.write(all);
        writer.flush();
    }

    /**
     * 打印在屏幕上
     */
    public void toPrint() {
        toWriter(new OutputStreamWriter(System.out));
    }

    /**
     * 通过文件存储json
     */
    @SneakyThrows
    public void toFile() {
        FileWriter writer = new FileWriter(new File(this.file));
        toWriter(writer);
        writer.close();
    }
}
