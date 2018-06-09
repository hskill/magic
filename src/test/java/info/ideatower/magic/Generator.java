package info.ideatower.magic;

import info.ideatower.magic.random.identity.Id;
import info.ideatower.magic.random.identity.Increment;
import info.ideatower.magic.random.person.Name;

public class Generator {

    public static final Magic user = Magic.schema("user",
            new Increment("i"),
            new Id("id"),
            new Name("name"));

    public static void main(String[] args) {
        user.asJson().toPrint();
    }
}
