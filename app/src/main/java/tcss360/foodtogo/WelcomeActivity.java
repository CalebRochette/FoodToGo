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

        //objects to hold the components
        final Button btLogout = (Button) findViewById(R.id.btLogout);
        final TextView WelcomeMessage = (TextView) findViewById(R.id.tvWelcome);

        //gets and stores a reference to the Users object
        final Users theUsers = Users.getInstance();

        //gets logged in user and sets the text of Welcome Message to welcome + (name of logged in user)
        Users.User user = theUsers.getLoggedIn();
        WelcomeMessage.setText("Welcome " + user.getName());

        //handles when the user clicks on the logout button
        btLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //logs out the user and returns them to the login activity
                theUsers.logOut();
                Intent loginIntent = new Intent(WelcomeActivity.this, LoginActivity.class);
                WelcomeActivity.this.startActivity(loginIntent);
            }
        });


    }
}
