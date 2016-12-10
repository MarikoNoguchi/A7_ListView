package edu.mnstate.cw3967me.a7_listview;

/*
store data(name and image resource) of the presitdent
Mariko Noguchi
10/21/2016
 */

/**
 * Created by marikonoguchi on 10/19/16.
 */


public class PresData {

    private String presName;
    private int presPic;
    private int presId;


    public void setPresName(String name) {
        presName = name;
    }

    public String getPresName() {
        return presName;
    }

    public void setPresPic(int pic) {
        presPic = pic;
    }

    public int getPresPic() {
        return presPic;
    }

    public void setPresId(int id){ presId = id;}

    public int getPresId(){ return presId;}
}
