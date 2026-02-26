public class People {

    /**
     * Represents a person with a full name.
     */
    protected String fullName;

    /**
     * Constructs a People object.
     *
     * @param fullName the full name of the person
     */
    public People(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Gets the full name of the person.
     *
     * @return the full name of the person
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the full name of the person.
     *
     * @param fullName the full name to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
