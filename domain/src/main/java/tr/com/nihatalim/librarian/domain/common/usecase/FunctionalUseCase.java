package tr.com.nihatalim.librarian.domain.common.usecase;

import java.util.function.Function;

public interface FunctionalUseCase<T, R> extends Function<T,R> {
}
