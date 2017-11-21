package m.todomanager;


/**
 * Created by Sara on 11/6/17.
 */

public class Task {

    String title,priority,status,theTime,theDate;



    public Task(String t , String s, String p, String tm, String dt){
        this.title=t;
        this.status=s;
        this.priority=p;
        this.theTime=tm;
        this.theDate=dt;

    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTheTime() {
        return theTime;
    }

    public void setTheTime(String theTime) {
        this.theTime = theTime;
    }

    public String getTheDate() {
        return theDate;
    }

    public void setTheDate(String theDate) {
        this.theDate = theDate;
    }


}
