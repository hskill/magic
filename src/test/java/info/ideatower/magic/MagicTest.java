package info.ideatower.magic;

import info.ideatower.magic.random.area.Address;
import info.ideatower.magic.random.identity.Id;
import info.ideatower.magic.random.identity.Increment;
import info.ideatower.magic.random.person.Name;
import lombok.Data;
import org.junit.Test;

import java.util.List;

public class MagicTest {

    @Test
    public void test() {

        Schema teacher = Schema.of("teacher",
            new Increment("id"),
            new Name("name"),
            Schema.of("addresses",
                new Id("id"),
                new Address("address"))
            .count(10)
        );

        teacher.asText().template("${name},${id?c}").toList().forEach((p) -> {
            System.out.println(p);
        });

//        Magic student = Magic.schema("student",
//                new Id("id"),
//                Magic.getSchema("teacher").getProduced("id", "foreignId"));
//
//        teacher.asText().size(10).template("${id?c} - ${name}").toPrint();
//        student.asText().size(10).template("${id?c} - ${foreignId?c}").toPrint();
//
//        teacher.asText().size(10).template("${id?c} - ${name}").toPrint();
//        student.asText().size(10).template("${id?c} - ${foreignId?c}").toPrint();

    }

    @Data
    public static class Person {
        private Long id;
        private String name;

        public List<AddressInfo> addresses;
    }

    public static class AddressInfo {
        private Long id;
        private String address;
    }
}