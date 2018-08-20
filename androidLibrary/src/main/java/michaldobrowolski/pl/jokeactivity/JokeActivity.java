package michaldobrowolski.pl.jokeactivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public final static String INTENT_JOKE_KEY = "intent_joke";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        TextView tv_joke_container = (TextView) findViewById(R.id.joke_text_view);

        if(getIntent().hasExtra(INTENT_JOKE_KEY)){
            tv_joke_container.setText(getIntent().getStringExtra(INTENT_JOKE_KEY));
        }

    }
}
