package info.ideatower.magic.random.web;

import info.ideatower.magic.Magic;
import org.junit.Test;

import java.io.OutputStreamWriter;

public class IpTest {

    @Test
    public void test() {
        Ip ip = new Ip("ip");
        Magic.schame(ip)
                .as()
                .size(10)
                .writer("ip: ${ip}\n", new OutputStreamWriter(System.out));
    }

}