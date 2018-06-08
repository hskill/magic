package info.ideatower.magic.random.area;

import com.google.common.collect.Lists;
import info.ideatower.magic.util.FileLoader;
import info.ideatower.magic.random.value.Picker;

/**
 * 地址生成
 *
 * 按地址文件随机生成地址数据
 *
 * TODO 地址文件需要补充
 */
public class Address extends Picker {

    public Address(String mark) {
        super(mark, Lists.newArrayList(FileLoader.loadResource("area/address.txt")));
    }
}
