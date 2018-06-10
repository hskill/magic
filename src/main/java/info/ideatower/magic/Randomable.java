package info.ideatower.magic;

/**
 * 可随机的数据
 */
public interface Randomable<T> {

    /**
     * 获取数据名称标识
     * @return 名称标识
     */
    String getMark();

    /**
     * 产生数据
     * @return
     */
    T next();

}
