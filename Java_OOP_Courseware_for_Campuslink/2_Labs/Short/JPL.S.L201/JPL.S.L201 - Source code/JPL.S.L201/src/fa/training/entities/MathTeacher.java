package fa.training.entities;

/**
 * 
 * @author DieuNT1
 *
 */
public class MathTeacher extends Teacher {
    protected String mainSubject;

    public MathTeacher() {
    }

    public MathTeacher(String designation, String collegename, String mainSubject) {
        super(designation, collegename);

        this.mainSubject = mainSubject;
    }

    public String getMainSubject() {
        return mainSubject;
    }

    public void setMainSubject(String mainSubject) {
        this.mainSubject = mainSubject;
    }

    /**
     * The method return sum of all two numbers.
     * 
     * @param number1
     * @param number2
     * @return an integer value.
     */
    public int sum(int number1, int number2) {
        return (number1 + number2);
    }

    @Override
    public void teach() {
        System.out.print("Teaching math subject:");
    }

    @Override
    public String toString() {
        return "MathTeacher [mainSubject=" + mainSubject + ", designation=" + designation + ", collegeName="
                + collegeName + "]";
    }

   

}
