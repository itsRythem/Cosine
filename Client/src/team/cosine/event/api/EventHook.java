package team.cosine.event.api;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EventHook {

    byte value() default Priority.MEDIUM;
}
