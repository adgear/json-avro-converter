package tech.allegro.schema.json2avro.converter;

import java.io.Serializable;
import java.util.function.Function;

public class CustomFieldMapping implements Serializable {
    final String targetName;
    final Function<?, ?> typeMapper;

    private CustomFieldMapping(final String targetName) {
        this(targetName, null);
    }

    private CustomFieldMapping(final Function<?, ?> typeMapper) {
        this(null, typeMapper);
    }

    public CustomFieldMapping(final String targetName, final Function<?, ?> typeMapper) {
        this.targetName = targetName;
        this.typeMapper = typeMapper;
    }

    public static CustomFieldMapping of(final String targetName) {
        return new CustomFieldMapping(targetName);
    }

    public static CustomFieldMapping of(final Function<?, ?> typeMapper) {
        return new CustomFieldMapping(null, typeMapper);
    }

    public static CustomFieldMapping of(final String targetName, final Function<?, ?> typeMapper) {
        return new CustomFieldMapping(targetName, typeMapper);
    }
}
