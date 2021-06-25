package semestr2;

import java.util.function.Function;

public class LambdaRunner {
    public static <T,R> R runner1(Function<T,R> func, T t){
        return func.apply(t);
    }
    public static <T> boolean runner2(HumanLambda<T> lambda, T human, T human1){
        return lambda.method(human, human1);
    }

    public static <A,B,C,D> boolean runner3(HumanCheckAge<A,B,C,D> lambda, A human, B human1, C human2, D maxAge){
        return  lambda.checkAge(human, human1, human2, maxAge);
    }
}
