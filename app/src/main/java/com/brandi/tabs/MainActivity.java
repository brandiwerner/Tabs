package com.brandi.tabs;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**import android.widget.Button;**/

public class MainActivity extends AppCompatActivity {

    private Intent intent;
   // Event[] eventArray = new Event[3];  //Array of Events
    DatabaseHelper myDb;

    EditText editEventName;
    EditText editEventDesc;
    //Button btnAddData;

    int CS;
    int CE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this, null, null, 1);

        editEventName = (EditText) findViewById(R.id.E_Name_pt);
        editEventDesc = (EditText) findViewById(R.id.E_Desc_pt);
        //btnAddData = (Button)findViewById(R.id.button_add_data);

       // AddData();
    }

    /**
     *Description: Class for the check boxes that determines which boxes have been checked
     *             and sets a variable for them if they have been checked.
     */
   public void onCheckboxClicked(View view){
        //Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        //Check which checkbox was clicked
        switch(view.getId()){
            case R.id.CS_check:
                if (checked) // Set a variable to true that way I can find out which class needs to be displayed in the next view
                    CS = 1; // Set equal to true
                else
                    CS = 0; // Set equal to false
                break;
            case R.id.CE_check:
                if(checked) //Set a variable to true that way I can find out which class needs to be displayed in the next view
                    CE = 1; // Set equal to true
                else // Not much to do
                    CE = 0; // Set equal to false
                break;
        }
    }

    /**
     *Description: This function is for when the button on the homescreen is clicked.
     *      When the button is clicked it will take the user to the tabSearch view.
     */
    public void sendMessage(View view){
        intent = new Intent(MainActivity.this, tabView.class);
        // Button but = (Button) findViewById(R.id.button);

        startActivity(intent);
    }

    // Add a Row to the database
    public void addDataButtonClicked(View view){
        //Will need to error check to see if they entered in a NULL or just the word name.
        boolean isInserted = myDb.addData(editEventName.getText().toString(), editEventDesc.getText().toString(), CS, CE);
        if(isInserted == true)
            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
        editEventName.setText("");
        editEventDesc.setText("");
    }

 /**  public void AddData(){
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) { */
                        /** Call insert Data Method which returns true or false telling if the insert succeeded or failed **/
     /**                   boolean isInserted =  myDb.insertData(editEventName.getText().toString(), editEventDesc.getText().toString(), CS, CE);
                        if(isInserted == true)
                            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                        editEventName.setText("");
                        //editEventDesc.setOnClickListener(" ");
                    }
                }
        );
    } */
}