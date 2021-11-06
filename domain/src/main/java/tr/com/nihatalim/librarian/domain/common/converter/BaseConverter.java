package tr.com.nihatalim.librarian.domain.common.converter;

import java.util.List;
import java.util.stream.Collectors;

public interface BaseConverter<T, R> {
    R convert(T model);

    default List<R> convert(List<T> entities) {
        return entities.stream().map(this::convert).collect(Collectors.toList());
    }
}
