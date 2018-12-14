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
    
    //constructor with default maxValue 100.
    public WrittenExam (String examID, Date date, String location, int time) {
        this.date = date;
        this.examID = examID;
        this.location = location;
        this.time = time;
        this.maxPoints = 100;

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

    //kontrollerar om första char == 'E' eller om examID inte har längden 6.
    public void setExamID(String examID) {
		if(examID.length()==6 && examID.charAt(0)==('E')) {
			String examIDnumber = examID.substring(1,5);
			int code = 0;
			try {
				code = Integer.parseInt(examIDnumber);
			} catch(Exception notnumbers) {
				System.out.println("The E must be followed by 5 numbers");
				}
			//
			if(code>=10000 && code<=99999) { 
				this.examID = examID; 
				} 
		} else {
			System.out.println("ExamID must be E followed by 5 numbers");
		}
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


