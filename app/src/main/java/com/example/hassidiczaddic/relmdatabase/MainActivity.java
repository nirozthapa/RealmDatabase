package com.example.hassidiczaddic.relmdatabase;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.jar.Attributes;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import io.realm.internal.Context;

public class MainActivity extends AppCompatActivity {
    android.content.Context context;
    EditText code,name,population;
    Button submit;
    TextView txtv;
    private Realm realm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        code = (EditText) findViewById(R.id.editTxtcode);
        name = (EditText) findViewById(R.id.editTxtname);
        population = (EditText) findViewById(R.id.editTxtpop);
        txtv = (TextView)findViewById(R.id.textView);

        submit = (Button) findViewById(R.id.btnSubmit);

        realm = Realm.getDefaultInstance();



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveToDatabase(code.getText().toString().trim(),
                        name.getText().toString().trim(),
                        Integer.parseInt(population.getText().toString().trim()));
                referesh_view();
            }


                });
            }

    private void referesh_view() {


        RealmResults<Country> realmResults = realm.where(Country.class).findAll();
        String output="";

        for(Country c: realmResults) {
            output += c.toString();
        }
          txtv.setText(output);

    }

    public void saveToDatabase(final String code, final String name,final  int population) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                 Country country = bgRealm.createObject(Country.class);
                country.setName(name);
                country.setPopulation(population);
                country.setCode(code);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                // Transaction was a success.
                Log.d("Happy", "Success: ");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                // Transaction failed and was automatically canceled.
                Log.d("UnHappy", "Failure: ");
            }
        });

    }


}








/*

*/
/*    Realm myrealm = Realm.getInstance(new RealmConfiguration.Builder(context).name("").build());
        // /RelmDatabase configuration

        myrealm.beginTransaction();;

        //Create the object of Country Class
        Country country= myrealm.createObject(Country.class);

        country.setName("Nepal");
        country.setPopulation(2743810);
        country.setCode("no");

        myrealm.commitTransaction();


    *//*
*/
/*    //if we had to use the constructor of the Country then
        Country country1 = new Country();
        country1.setName("Nepal");
        country1.setPopulation(1464645);
        country1.setCode("no");

        myrealm.beginTransaction();

        Country copyofcountry1= myrealm.copyToRealm(country1);
        myrealm.commitTransaction();*//*
*/
/*

        RealmResults<Country> realmResults = myrealm.where(Country.class).findAll();

        for(Country c: realmResults){
            Log.d("realmResults", c.getName());
        }*//*

    }
*/

