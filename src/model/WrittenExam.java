package model;




import java.util.ArrayList;
//import copy.Course;
//import copy.WrittenExam;
import java.util.Collections;



public class WrittenExam {

    private String examID;
    private String location;
    private final int MAX_VALUE = 100;
    private ArrayList<Result> results = new ArrayList<Result>();
    private Course course;


    /**
     * Create exam for a location connected to course.
     *
     * @param String location
     * @param Course course
     * @return WrittenExam
     */
    public WrittenExam (String location, Course course) {
        this.examID = this.generateExamId(course);
        this.location = location;
        this.setCourse(course);
        course.addWrittenExam(this);
    }

    /**
     * Calculates average of results for given exam.
     *
     * @return double average
     */
    public double getAverage() {
    	double average = 0;
    	if(results.size() > 0) {
	    	for (Result res : results) {
	    		average += res.getPoints();
	    	}
	    	average = average/getResults().size();
    	}
        return average;
    }

    /**
     * Calculates median of results for given exam.
     *
     * @return double median
     */
    public double getMedian() {
    	double med = 0;
    	ArrayList<Double> sortedResults = new ArrayList<Double>();
    	for(Result x : results) sortedResults.add((double) x.getPoints());
    	Collections.sort(sortedResults);
    	if(sortedResults.size() > 0) {
    		if(sortedResults.size() % 2 == 0) {
    			double med1 = sortedResults.get((int)(results.size()/2));
    			double med2 = sortedResults.get((int)(results.size()/2)-1);
    			median = (med1+med2) / 2;
    		} else {
    			median = sortedResults.get((int)((results.size()/2)+0.5));
    		}
    	}
		return median;
    }

    /**
     * The number of students who passed a given exam.
     *
     * @return int count
     */
    public int passed() {
    	int count = 0;
    	if(results.size() > 0) {
    		for(Result x : results) {
    			if(x.getPoints() >= 50) {
    				count += 1;
    			}
    		}
    	}
    	return count;
    }

    /**
     * The percentage of the students who passed the exam.
     *
     * @return double percentage
     */
    public double passPercentage() {
    	if (results.size() > 0) {
    		return 100 *( ((double)passed()) / results.size()) ;
    	} else {
    		return 0;
    	}
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





}
