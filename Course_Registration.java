package dxc;

class CourseRegistration
{
	int courseId,registrationId;
	float qualifyingMarks;
	double courseFee;
	String studentName;
	boolean hostelRequired;
	
	public int getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}

	public float getQualifyingMarks() {
		return qualifyingMarks;
	}

	public void setQualifyingMarks(float qualifyingMarks) {
		this.qualifyingMarks = qualifyingMarks;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public boolean isHostelRequired() {
		return hostelRequired;
	}

	public void setHostelRequired(boolean hostelRequired) {
		this.hostelRequired = hostelRequired;
	}

	public double getCourseFee() {
		return courseFee;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getCourseId() {
		return courseId;
	}
	
	public boolean ishostelRequired()
	{
		return hostelRequired;
	}
	
	public boolean validateMarks()
	{
		if(qualifyingMarks>=65 && qualifyingMarks<=100)
		{
			return true;
		}
		else
			return false;
	}
	
	public boolean validateCourseId()
	{
		if(courseId>=1001 && courseId<=1005)
		{
			return true;
		}
		else
			return false;
	}
	
	public void calculateCourseFee()
	{
		double baseFee=0,discount=0;
		if(!validateMarks())
		{
			courseFee=0;
		}
		switch(courseId)
		{
		case 1001: baseFee=55000;
		break;
		case 1002: baseFee=35675;
		break;
		case 1003: baseFee=28300;
		break;
		case 1004: baseFee=22350;
		break;
		case 1005: baseFee=115000;
		break;
		}
		
		if(qualifyingMarks>=65 && qualifyingMarks<=69)
		{
			discount=0.05*baseFee;
		}
		else if(qualifyingMarks>=70 && qualifyingMarks<=84)
		{
			discount=0.1*baseFee;
		}
		else if(qualifyingMarks>=85)
		{
			discount=0.15*baseFee;
		}
		courseFee=baseFee-discount;
		
	}
	
	
}

public class Course_Registration {

	public static void main(String[] args) 
	{
		CourseRegistration c1=new CourseRegistration();
		c1.setStudentName("peter");
		c1.setRegistrationId(5001);
		c1.setQualifyingMarks(78);
		c1.setCourseId(1005);
		c1.setHostelRequired(false);
		c1.calculateCourseFee();
		if(!c1.validateMarks())
		{
			System.out.println("Marks are less than 65 . You are not eligible");
		}
		else if(!c1.validateCourseId())
		{
			System.out.println("Invalid Course ID. Please try again");
		}
		else
			{
		System.out.println("Course Allocation Details \n");
		System.out.println("Student name : "+c1.getStudentName());
		System.out.println("Course Id : "+c1.getCourseId());
		System.out.println("Qualifying Exam Marks : "+c1.getQualifyingMarks());
		System.out.println("Student's Registration Id : "+c1.getRegistrationId());
		System.out.println("Total course Fee : "+c1.getCourseFee());
		System.out.println("Hostel Required : "+c1.ishostelRequired());
			}
	}

}