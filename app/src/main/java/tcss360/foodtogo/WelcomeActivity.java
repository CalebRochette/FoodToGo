package tcss360.foodtogo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        final Users theUsers = Users.getInstance();
        String user = theUsers.getLoggedIn();
        String[] userData = user.split(":");
        final TextView WelcomeMessage = (TextView) findViewById(R.id.tvWelcome);
        WelcomeMessage.setText("Welcome " + userData[2]);
        final Button btLogout = (Button) findViewById(R.id.btLogout);
        btLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theUsers.logOut();
                Intent loginIntent = new Intent(WelcomeActivity.this, LoginActivity.class);
                WelcomeActivity.this.startActivity(loginIntent);
            }
        });


    }
}
