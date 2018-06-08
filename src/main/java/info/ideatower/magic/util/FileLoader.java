package info.ideatower.magic.util;

import com.google.common.collect.Lists;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.List;

public class FileLoader {

    @SneakyThrows
    public static List<String> loadResource(String filename) {
        File resource = new File(FileLoader.class.getClassLoader().getResource(filename).toURI());
        return load(resource);
    }

    public static List<String> loadExternalResource(String absoluteFilename) {
        File resource = new File(absoluteFilename);
        return load(resource);
    }

    @SneakyThrows
    private static List<String> load(File file) {
        if (!file.exists() || !file.canRead()) {
            throw new IllegalArgumentException("cannot find resource: " + file.getName());
        }

        List<String> dictList = Lists.newArrayList();
        for (String line : FileUtils.readLines(file)) {
            dictList.add(line);
        }
        return dictList;
    }
}
