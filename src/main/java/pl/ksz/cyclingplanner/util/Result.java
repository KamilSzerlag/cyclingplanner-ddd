package pl.ksz.cyclingplanner.util;

import java.util.NoSuchElementException;
import java.util.function.Function;

public interface Result<L, R> {

    L getFailure();

    R getSuccess();

    static <L, R> Failure<L, R> failure(L value) {
        return new Failure<>(value);
    }

    static <L, R> Success<L, R> success(R value) {
        return new Success<>(value);
    }

    default <S> Result<L, S> bind(Function<R, S> bindedFunction) {
        if (isSuccess()) {
            return success(bindedFunction.apply(getSuccess()));
        }
        return failure(getFailure());
    }

    default boolean isFailure() {
        return this instanceof Result.Failure;
    }

    default boolean isSuccess() {
        return this instanceof Result.Success;
    }

    record Failure<L, R>(L value) implements Result<L, R> {

        @Override
        public L getFailure() {
            return value;
        }

        @Override
        public R getSuccess() {
            throw new NoSuchElementException();
        }
    }

    record Success<L, R>(R value) implements Result<L, R> {

        @Override
        public L getFailure() {
            throw new NoSuchElementException();
        }

        @Override
        public R getSuccess() {
            return value;
        }
    }


}
