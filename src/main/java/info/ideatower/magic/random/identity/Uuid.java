package info.ideatower.magic.random.identity;

import info.ideatower.magic.random.AbstractRandomValue;

import java.util.UUID;

public class Uuid extends AbstractRandomValue<String> {

    @Override
    public String next() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
