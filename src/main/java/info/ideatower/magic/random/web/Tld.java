package info.ideatower.magic.random.web;

import com.google.common.collect.Lists;
import info.ideatower.magic.util.FileLoader;
import info.ideatower.magic.random.value.Picker;

public class Tld extends Picker<String> {

    public Tld(String mark) {
        super(mark, Lists.newArrayList(FileLoader.loadResource("web/tld.txt")));
    }

}
