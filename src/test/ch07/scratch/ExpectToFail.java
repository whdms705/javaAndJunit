package test.ch07.scratch;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})

public @interface ExpectToFail {
}
