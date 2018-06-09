package info.ideatower.magic.random.web;

import com.google.common.collect.Lists;
import info.ideatower.magic.random.value.Picker;

/**
 * 协议名称
 */
public class Protocol extends Picker<String> {
    
    public Protocol(String mark) {
        super(mark);
        this.values(Lists.newArrayList("http", "ftp", "gopher", "mailto", "mid", "cid", "news", "nntp", "prospero", "telnet", "rlogin", "tn3270", "wais"));
    }
}
