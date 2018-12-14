package model;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WrittenExam {

    private String examID;
    private Date date;
    private String location;
    private int time;
    private int maxPoints;
    private List<Student> students;



    //one constructor for setting datapoint directly
    public WrittenExam (String examID, Date date, String location, int time, int maxPoints) {
        this.date = date;
        this.examID = examID;
        this.location = location;
        this.time = time;
        this.maxPoints = maxPoints;

        //Initilizing the arraylist
        students = new ArrayList<Student>();

    }


    //one constructor for not setting the datapoints directyl
    public WrittenExam(){
        students = new ArrayList<Student>();

    }

    public String getExamID() {
        return examID;
    }

    public void setExamID(String examID) {
        this.examID = examID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}


