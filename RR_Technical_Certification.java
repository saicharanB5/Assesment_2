package dxc;

interface Certification {
	  double REGULAR_COURSE_FEE = 2000;
	  double CRASH_COURSE_FEE = 5000;

	  double calculateFee();
	}

	class RRTechnicalCertification implements Certification {
	  String studentName;
	  String courseName;
	  int registrationId;
	  int admissionTestMarks;
	  static int counter;
	  
	  static
	  {
		  counter=1001;
	  }

	  RRTechnicalCertification(String studentName, String courseName, int admissionTestMarks) {
	    this.studentName = studentName;
	    this.courseName = courseName;
	    this.admissionTestMarks = admissionTestMarks;

	    generateRegistrationId();
	  }

	  void generateRegistrationId() {
	    registrationId = counter;
	    counter += 1;
	  }

	  public double calculateFee() {
	    return 0;
	  }
	}

	class RegularCourseCertification extends RRTechnicalCertification {
	  int courseDuration;

	  RegularCourseCertification(String studentName, String courseName, int admissionTestMarks, int courseDuration) {
	    super(studentName, courseName, admissionTestMarks);
	    this.courseDuration = courseDuration;
	  }

	public  double calculateFee() {
	    double fee = courseDuration * REGULAR_COURSE_FEE;
	    if (admissionTestMarks >= 90) {
	      fee = (int) (fee * 0.9);
	    } else if (admissionTestMarks >= 75) {
	      fee = (int) (fee * 0.95);
	    }
	    return fee;
	  }
	}

	class CrashCourseCertification extends RRTechnicalCertification {
		
		int courseDuration;
	  CrashCourseCertification(String studentName, String courseName, int admissionTestMarks, int courseDuration) {
	    super(studentName, courseName, admissionTestMarks);
	    this.courseDuration = courseDuration;
	  }

	 public double calculateFee() {
		  double serviceTax = 12.36;

	    double fee = CRASH_COURSE_FEE;
	    if (admissionTestMarks >= 90) {
	      fee = (int) (fee * 0.9);
	    } else if (admissionTestMarks >= 75) {
	      fee = (int) (fee * 0.95);
	    }
	    fee = (int) (fee * (1 + serviceTax / 100));
	    return fee;
	  }
	}

public class RR_Technical_Certification {
	  public static void main(String[] args) {
	    RegularCourseCertification regularCourse = new RegularCourseCertification("Rakesh", "J2EE", 85, 5);
	    System.out.println("Regular Course details");
	    System.out.println("*********");
	    System.out.println("Student Name: " + regularCourse.studentName);
	    System.out.println("Course Name: " + regularCourse.courseName);
	    System.out.println("Registration Id: " + regularCourse.registrationId);
	    System.out.println("Course Duration: " + regularCourse.courseDuration + " months");
	    System.out.println("Total Fee: " + regularCourse.calculateFee()+"\n");
   }
}