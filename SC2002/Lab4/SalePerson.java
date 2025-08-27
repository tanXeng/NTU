package Lab4;

public class SalePerson implements Comparable {
    private String firstName;
    private String lastName;
    private int totalSales;

    public SalePerson(String f, String l, int t) {
        firstName = f;
        lastName = l;
        totalSales = t;
    }

    public String toString() {
        return lastName +  "  , " + firstName + "   :  " + totalSales;
    }

    public boolean equals(Object o) {
  	SalePerson other = (SalePerson) o;

    return ((other.firstName == firstName) && (other.lastName == lastName));
    }

    public int compareTo(Object o) {
  	SalePerson other = (SalePerson) o;

    if (totalSales < other.totalSales) return -1; // this object is smaller than the other one
    if (totalSales > other.totalSales) return 1;  // this object is larger than the other one
    return -(lastName.compareTo(other.lastName));  // alphabetical order if the total sales are the same 
    /*
     * minus sign is to ensure ascending alphabetical order because task 4 changed the order of insertion swap
     */
  }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getTotalSales() {
        return totalSales;
    }
}
