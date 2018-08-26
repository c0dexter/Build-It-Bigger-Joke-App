import android.os.AsyncTask;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.InstrumentationTestCase;

import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.R;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest extends InstrumentationTestCase {

    private final CountDownLatch downLatch = new CountDownLatch(1);

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void buttonTestShowJoke() {
        try {
            testAsyncTask();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public void testAsyncTask() throws Throwable {
        new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                return onView(withId(R.id.instructions_text_view)).perform(click());
            }

            @Override
            protected void onPostExecute(Object o) {
                assertNotNull(o);
                downLatch.countDown();
                onView(withId(R.id.joke_text_view)).check(matches(Matchers.not(withText(""))));
            }
        };
        downLatch.await(40, TimeUnit.SECONDS);
    }
}
