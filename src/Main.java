import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
    }

    public static void task1() {
        Scanner scanner = new Scanner(System.in);
        Integer z = scanner.nextInt();
        Predicate<Integer> integerPredicate = new Predicate<Integer>() {
            @Override
            public boolean positiveNumber(Integer number) {
                return number >= 0;
            }
        };
        System.out.println("Число: " + z + (integerPredicate.positiveNumber(z) ? " положительное." : " отрицательное."));
        Predicate<Integer> integerPredicate1 = y -> y >= 0;
        Integer y = scanner.nextInt();
        System.out.println("Число: " + y + (integerPredicate.positiveNumber(y) ? " положительное." : " отрицательное."));
    }

    public static void task2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String name) {
                System.out.println("Привет " + name);
            }
        };
        consumer.accept(name);

        Consumer<String> consumer1 = name1 -> System.out.println("Привет " + name1);
        String name1 = scanner.nextLine();

        consumer1.accept(name1);
    }
    public static void task3() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите вещественное число :");
        Double aDouble = scanner.nextDouble();
        Function<Double, Long> longFunction = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return aDouble.longValue();
            }
        };
        System.out.println(longFunction.apply(aDouble));

        Double aDouble1 = scanner.nextDouble();
        Function<Double, Long> longFunction1 = Double::longValue;
        System.out.println(longFunction1.apply(aDouble1));
    }
    public static void task4() {
        int max = 100;
        int min = 0;
        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                int x = (int) ((Math.random()*((max-min)+1))+min);
                return x;
            }
        };
        System.out.println(supplier.get());

        Supplier<Integer> supplier1 = () -> (int) ((Math.random()*((max-min)+1))+min);

    }
    public static void task5() {
        Integer y = 25;

        Predicate<Integer> condition = x -> x > 22;
        System.out.println(condition.positiveNumber(y));
        Function<Integer, Integer> ifTrue = x -> x * x;
        System.out.println(ifTrue.apply(y));
        Function<Integer, Integer> ifFalse = x -> x + x;
        System.out.println(ifFalse.apply(y));
        ternaryOperator(condition, ifTrue, ifFalse);
        System.out.println(ternaryOperator(condition, ifTrue, ifFalse).apply(y));
    }
        public static <T, U> Function<T, U> ternaryOperator(
                Predicate<? super T> condition,
                Function<? super T, ? extends U> ifTrue,
                Function<? super T, ? extends U> ifFalse) {
            return x -> condition.positiveNumber(x) ? ifTrue.apply(x) : ifFalse.apply(x);

    }

}