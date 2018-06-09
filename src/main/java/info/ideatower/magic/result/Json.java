package info.ideatower.magic.result;

import com.alibaba.fastjson.JSON;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * 生成结果转为json
 */
public class Json {

    private Result result;
    private Class<?> target;
    private String file;

    public Json(Result result) {
        this.result = result;
    }

    public Json size(int size) {
        this.result.size(size);
        return this;
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
            return JSON.toJSONString(result.getObjects(this.target));
        }
        else {
            return JSON.toJSONString(result.getDatas());
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
