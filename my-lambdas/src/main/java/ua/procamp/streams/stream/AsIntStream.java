package ua.procamp.streams.stream;

import org.apache.commons.lang.ArrayUtils;
import ua.procamp.streams.function.*;

import java.util.*;
import java.util.function.Supplier;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.apache.commons.collections4.CollectionUtils.isEmpty;
import static org.apache.commons.lang.ArrayUtils.toObject;

public class AsIntStream implements IntStream {

    private static final String NO_VALUES_EXCEPTION_MSG = "The operation can be performed only if there are values.";

    //private List<Integer> values;
    private StreamIterator iterator;
    private ArrayDeque<Supplier<List<Integer>>> deque = new ArrayDeque<>();

    private AsIntStream(int... values) {
        throwIfNull(values);
        //this.values = convertType(values);
        iterator = new StreamIterator(convertType(values));
    }

    public static IntStream of(int... values) {
        return new AsIntStream(values);
    }

    @Override
    public Double average() {
        List<Integer> finalList = getFinalListOrThrowIfEmpty();

        return (double) sum(finalList) / finalList.size();
    }

    @Override
    public Integer max() {
        return Collections.max(getFinalListOrThrowIfEmpty());
    }

    @Override
    public Integer min() {
        return Collections.min(getFinalListOrThrowIfEmpty());
    }

    @Override
    public long count() {
        return getFinalList().size();
    }

    @Override
    public Integer sum() {
        List<Integer> finalList = getFinalListOrThrowIfEmpty();
        return sum(finalList);
    }

    private int sum(List<Integer> finalList) {
        int sum = 0;
        for (int value : finalList) {
            sum += value;
        }
        return sum;
    }

    @Override
    public int[] toArray() {
        return ArrayUtils.toPrimitive(getFinalList().toArray(new Integer[]{}));
    }

    @Override
    public IntStream filter(IntPredicate predicate) {
        Supplier<List<Integer>> valuesSupplied = () -> {
            List<Integer> result = new ArrayList<>();
            for (Integer val : iterator.next()) {
                if (predicate.test(val)) {
                    result.add(val);
                }
            }
            return result;
        };
        deque.add(valuesSupplied);
        return this;
    }

    @Override
    public IntStream map(IntUnaryOperator mapper) {
        Supplier<List<Integer>> valuesSupplied = () -> {
            List<Integer> result = new ArrayList<>(iterator.next().size());
            for (Integer val : iterator.next()) {
                result.add(mapper.apply(val));
            }
            return result;
        };
        deque.add(valuesSupplied);
        return this;
    }

    @Override
    public IntStream flatMap(IntToIntStreamFunction func) {
        Supplier<List<Integer>> valuesSupplied = () -> {
            List<Integer> result = new ArrayList<>();
            for (Integer val : iterator.next()) {
                final int[] newVals = func.applyAsIntStream(val).toArray();
                result.addAll(convertType(newVals));
            }
            return result;
        };
        deque.add(valuesSupplied);
        return this;
    }

    @Override
    public int reduce(int identity, IntBinaryOperator op) {
        int result = identity;
        for (Integer value : getFinalList()) {
            result = op.apply(result, value);
        }
        return result;
    }

    @Override
    public void forEach(IntConsumer action) {
        for (Integer value : getFinalList()) {
            action.accept(value);
        }
    }

    private List<Integer> getFinalList() {
        final List<Integer> result = new ArrayList<>();
        if (isEmpty(iterator.values) || isEmpty(deque)) {
            return iterator.values;
        } else {
            do {
                List<Integer> onePhaseResult = emptyList();
                for (Supplier<List<Integer>> aDeque : deque) {
                    onePhaseResult = aDeque.get();
                    iterator.currentValue = onePhaseResult;
                }
                result.addAll(onePhaseResult);

            } while (iterator.increment());
            return result;
        }
    }

    private List<Integer> getFinalListOrThrowIfEmpty() {
        List<Integer> finalList = getFinalList();
        if (isEmpty(finalList)) {
            throw new IllegalArgumentException(NO_VALUES_EXCEPTION_MSG);
        }
        return finalList;
    }

    private void throwIfNull(int[] array) {
        if (null == array) {
            throw new IllegalArgumentException(NO_VALUES_EXCEPTION_MSG);
        }
    }

    private ArrayList<Integer> convertType(int[] values) {
        return new ArrayList<>(asList(toObject(values)));
    }

    private class StreamIterator implements Iterator<List<Integer>> {
        private final List<Integer> values;
        private List<Integer> currentValue;
        private final int size;

        private int currentIndex = 0;

        private StreamIterator(List<Integer> values) {
            this.values = values;
            size = values.size();
            currentValue = size > 0 ? singletonList(values.get(0)) : emptyList();
        }

        @Override
        public boolean hasNext() {
            return currentIndex + 1 < size;
        }

        @Override
        public List<Integer> next() {
            return currentValue;
        }

        private boolean increment() {
            boolean canGetNext = hasNext();
            if (canGetNext) {
                currentIndex++;
                currentValue = singletonList(values.get(currentIndex));
            }
            return canGetNext;
        }
    }
}