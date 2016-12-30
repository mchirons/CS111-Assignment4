public class Roster {
    Student [ ] students;
    int numStudents;
    int stopPoint;
    Course course;
	
    /**
     * The constructor for this class.
     * Initialize this roster to empty, i.e., holds no students,
     *   with given stop point and course
     */
    public Roster(int stopPoint, Course course){

    	this.course = course;
    	this.stopPoint = stopPoint;
    	students = new Student[stopPoint];
    	numStudents = 0;

    }
    
    /**
     * toString is a method every class has.  It returns a string 
     * that represents the object for printing
     */
    public String toString( ){
	String res = "";
	for(int j = 0; j < numStudents; j++){
	    res = res + "\n" + students[j].toString();
	}
	return course + " " + numStudents + "/" + stopPoint+res;
    }

    /**
     * isFull returns true if and only if the number of students in it is 
     *   at the stopPoint
     */
    public boolean isFull( ){
    	if (numStudents == stopPoint){
    		return true;
    	}
    	else{
    		return false;
    	}
	
    }
	
    /**
     * add given student to this roster
     * if student already on roster or numStudents already == stopPoint, 
     *   do not change roster and return false
     * @return true if successful, else false
     */
    public boolean addStudent(Student student){
    	
    	if (this.isFull()){ 
    		return false;
    	}
    	for (int i = 0; i < students.length; i++){
    		if (students[i] == null || i == numStudents){
    			students[i] = student;
    			numStudents++; //adds one more student to the total roster count
    			break;  
    		}
    		else if (this.findStudent(student)){ //student is already on roster
    			return false;
    		}
    		else{
    			//continues to next student object in students[]
    		}
    	}
    	return true; 
    }


    /**
     * returns true if and only if the student is on this roster.
     */
    public boolean findStudent(Student student){

    	for (int i = 0; i < numStudents; i++){ //true if student is on current roster, not whole array
    		if (this.isEmpty()){
    			break;
    		}
    		if (students[i].toString().equals(student.toString())){
    			return true;
    		}
    		else{
    			// moves on the the next element in students[]
    		}
    	}
    	return false; // did not find the student in students[]
    }

    /**
     * Remove given student from this roster. 
     * If student is not on this roster do not change roster and return false
     * @return true if successful, else false
     */
    public boolean dropStudent(Student student){

    	if (this.isEmpty()){
    		return false;
    	}
    	else {
    		for (int i = 0; i < students.length; i++){
    			if (students[i].toString().equals(student.toString())){
    				students[i] = students[numStudents - 1];
    				numStudents--;
    				return true;
    			}
    			else{
    				// moves on the the next element in students[]
    			}
    		}
    	}
    	return false; //roster is not empty and the student object is not in students[]
    }
    
    private boolean isEmpty(){
    	for (int i = 0; i < students.length; i++){
    		if (students[i] == null){
    			return true;
    		}
    	}
    	return false;
    }

}