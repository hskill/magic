package info.ideatower.magic.random.area;

import info.ideatower.magic.random.value.Picker;
import info.ideatower.magic.util.FileLoader;

/**
 * 地址生成
 *
 * 按地址文件随机生成地址数据
 *
 * 数据来源于 莆田医院地址 https://github.com/putianxi/putianxi.github.io
 */
public class Address extends Picker<String> {

    public Address(String mark) {
        super(mark);
        this.values(FileLoader.loadResource("area/address.txt"));
    }
}
