package info.ideatower.magic;

/**
 * 可随机的数据
 */
public interface Randomable<T> {

    String getMark();

    T next();
}
