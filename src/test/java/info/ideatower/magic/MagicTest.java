package info.ideatower.magic;

import info.ideatower.magic.random.identity.Id;
import info.ideatower.magic.random.person.Age;
import info.ideatower.magic.random.person.Name;
import lombok.Data;
import org.junit.Test;

import java.io.OutputStreamWriter;
import java.util.List;

public class MagicTest {

    @Test
    public void schema() {

        Magic.schame("xxx",
            new Id("id"),
            new Name("name"),
            new Age("age")
        )
        .as()
        .size(10)
        .str("${id?c} - ${name} - ${age}\n", new OutputStreamWriter(System.out));


//        List<Person> personList = Magic.schame(
//            new Id("id"),
//            Magic.getSchema("xxx").getProduced("name", "name")
//        )
//        .as()
//        .size(10)
//        .obj(Person.class);
//
//        for (Person p : personList) {
//            System.out.println(p);
//        }
    }

    @Data
    public static class Person {
        private Long id;
        private String name;
    }
}