package kz.sirius.myapplication.activity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import kz.sirius.myapplication.R;
import kz.sirius.myapplication.database.DataBaseProvider;
import kz.sirius.myapplication.database.User;

public class DataBaseUsersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        DataBaseProvider dataBaseProvider = DataBaseProvider.getInstance(this);

        ///dataBaseProvider.insertUser("+3333333", "Nice Guy");

        int numberOfUsers = dataBaseProvider.getNumberOfUsers();
        Log.d("DataBase", String.valueOf(numberOfUsers));

        /*List<User>users = dataBaseProvider.getUsers();
        for (int i = 0; i < users.size(); i++) {
            Log.d("DataBase", users.get(i).getName() + " " + users.get(i).getPhone());
        }*/
    }
}
