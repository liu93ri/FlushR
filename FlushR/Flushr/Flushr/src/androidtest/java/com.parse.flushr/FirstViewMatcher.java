package com.parse.flushr;

import org.hamcrest.Matcher;
import android.view.View;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;




/**
 * Created by nickge on 3/6/16.
 */
public class FirstViewMatcher extends BaseMatcher<View> {


    public static boolean matchedBefore = false;

    public FirstViewMatcher() {
        matchedBefore = false;
    }

    @Override
    public boolean matches(Object o) {
        if (matchedBefore) {
            return false;
            } else {
            matchedBefore = true;
            return true;
            }
        }

    @Override
    public void describeTo(Description description) {
        description.appendText(" is the first view that comes along ");
    }

    @Factory
    public static <T> Matcher<View> firstView() {
        return new FirstViewMatcher();
    }
}
