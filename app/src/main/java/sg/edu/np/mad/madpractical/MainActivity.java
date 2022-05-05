package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    User u = new User("John", "Lorem ipsum dolor sit amet, consectetur adipiscing " +
            "elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua", 1, false);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = getIntent();
        int randomInt = i.getIntExtra("randomInt", 1739039545);
        TextView name = findViewById(R.id.username);
        String displayName = u.name + " " + randomInt;
        name.setText(displayName);

        TextView des = findViewById(R.id.description);
        des.setText(u.description);

        followStatus();
        Button follow = findViewById(R.id.followButton);
        follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                followStatus();
                if(u.followed){
                    Toast.makeText(MainActivity.this, "Followed", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Unfollowed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button message = findViewById(R.id.messageButton);
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(i2);
            }
        });
    }

    public void followStatus(){
        Button follow = findViewById(R.id.followButton);
        if(u.followed){
            follow.setText("Unfollow");
            u.followed = false;
        } else {
            follow.setText("Follow");
            u.followed = true;
        }
    }
}