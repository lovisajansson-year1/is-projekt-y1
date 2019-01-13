package model;



import java.util.ArrayList;


public class WrittenExam {

    private String examID;
    private String location;
    private final int MAX_VALUE = 100;
    private ArrayList<Result> results = new ArrayList<Result>();
    private Course course;

    //skapa ett exam för en plats och kurs samt dubbelkoppla till kurs.
    public WrittenExam (String location, Course course) {
        this.examID = this.generateExamId(course);
        this.location = location;
        this.setCourse(course);
        course.addWrittenExam(this);
    }

    public WrittenExam() {
		// TODO Auto-generated constructor stub
	}

	public String getExamID() {
        return examID;
    }
 
	public String generateExamId(Course course) {
		ArrayList<Course> allCourses = course.getCourseRegister().getCourses();
		ArrayList<WrittenExam> exams = course.getWrittenExams();
		String newId;
		for(int i=10000+exams.size(); i<100000; i++) {
			newId = "E" + Integer.toString(i);
			for(Course c: allCourses) {
				for(WrittenExam e: c.getWrittenExams()) {
					if(e.getExamID().equals(newId)) {
						newId = null;
						break;
					}
				}				
			}
			if(newId != null) {
				return this.examID = newId;
			}
		}
		return null;
	}
 
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }

	public ArrayList<Result> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result> results) {
		this.results = results;
	}

    public void addResult(Result result) {
    	this.results.add(result);
    }

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
    

}


