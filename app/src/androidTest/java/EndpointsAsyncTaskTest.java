import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.InstrumentationTestCase;
import android.util.Log;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.MainActivity;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest extends InstrumentationTestCase {

    private static final String TAG = "EndpointTaskTest";

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkProvidingJokeByAsyncTask() throws Throwable {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Context context = InstrumentationRegistry.getContext();
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(context) {
            @Override
            protected void onPostExecute(String result) {
                assertNotNull(result);
                Log.d("TAG", result);
                assertTrue(result.length() > 0);
                Assert.assertThat(result, CoreMatchers.containsString("Q: "));
                countDownLatch.countDown();
            }
        };
        endpointsAsyncTask.execute();
        countDownLatch.await();
    }

}
