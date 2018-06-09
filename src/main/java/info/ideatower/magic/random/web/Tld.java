package info.ideatower.magic.random.web;

import com.google.common.collect.Lists;
import info.ideatower.magic.random.value.Picker;
import info.ideatower.magic.util.FileLoader;

public class Tld extends Picker<String> {

    public Tld(String mark) {
        super(mark);
        this.values(Lists.newArrayList(FileLoader.loadResource("web/tld.txt")));
    }

}
