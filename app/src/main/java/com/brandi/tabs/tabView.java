package com.brandi.tabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import static com.brandi.tabs.R.id.CheckCompSci;

/**
 * Created by Brandi Werner on 10/22/2017.
 * Description: This class is for the content that will show up on the tabs view. The tabs
 *    view will be be accessed through the home view and will enable users to select tags
 *    they would like to look for.
 */
public class tabView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_view);
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
            case R.id.CheckCompSci:
                if (checked) {
                    // Set a variable to true that way I can find out which class needs to be displayed in the next view
                }else {
                    // Not much to do
                }
                break;
            case R.id.CheckCompEng:
                if(checked) {
                    //Set a variable to true that way I can find out which class needs to be displayed in the next view
                }else {
                    // Not much to do
                }
                break;
        }
    }
}
