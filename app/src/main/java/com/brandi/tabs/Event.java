package com.brandi.tabs;

import java.security.PublicKey;

/**
 * Created by Brandi Werner on 10/23/2017.
 * Description: This class holds all of the event details. In the main
 * class is an array that holds these classes
 */

public class Event {
    //Variables for event
    private String eventName;
    private String orgName;
    private String eventDetails;
    //Need a picture variable for the address location of a picture
    private int eventDate;
    private boolean isCheckCompSci;
    private boolean isCheckCompEng;

    //Constructor that sets everything to NULL

    public String getEventName(){
        return eventName;
    }
    public void setEventName(String x){
        eventName = x;
    }

    public String getOrgName(){
        return orgName;
    }
    public void setOrgName(String x){
        orgName = x;
    }

    public String getEventDetails(){
        return eventDetails;
    }
    public void setEventDetails(String x){
        eventDetails = x;
    }

    public int getEventDate(){
        return eventDate;
    }
    public void setEventDate(int x){
        eventDate = x;
    }

    public boolean getIsCheckCompSci(){
        return isCheckCompSci;
    }
    public void setIsCheckCompSci(boolean x){
        isCheckCompSci = x;
    }

    public boolean getIsCheckCompEng(){
        return isCheckCompEng;
    }
    public void setIsCheckCompEng(boolean x){
        isCheckCompEng = x;
    }

}