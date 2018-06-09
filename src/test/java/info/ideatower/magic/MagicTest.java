package info.ideatower.magic;

import info.ideatower.magic.random.identity.Id;
import info.ideatower.magic.random.identity.Increment;
import info.ideatower.magic.random.person.Name;
import lombok.Data;
import org.junit.Test;

public class MagicTest {

    @Test
    public void schema() {

        Magic teacher = Magic.schema("teacher",
            new Increment("id"),
            new Name("name")
        );

        Magic student = Magic.schema("student",
                new Id("id"),
                Magic.getSchema("teacher").getProduced("id", "foreignId"));

        teacher.asText().size(10).template("${id?c} - ${name}").toPrint();
        student.asText().size(10).template("${id?c} - ${foreignId?c}").toPrint();

        teacher.asText().size(10).template("${id?c} - ${name}").toPrint();
        student.asText().size(10).template("${id?c} - ${foreignId?c}").toPrint();

    }

    @Data
    public static class Person {
        private Long id;
        private String name;
    }
}