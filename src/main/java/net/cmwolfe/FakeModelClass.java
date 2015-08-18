package net.cmwolfe;

/**
 * This class represents a Model class as you would find in
 * an MVC-based webapp.
 * <p>
 * Normally, a Model class would do something more complicated,
 * like retrieve data from a database. For the purposes
 * of brevity, this class simply reverses a string.
 * </p>
 */
public class FakeModelClass {
    public FakeModelClass() {
    }

    public String getSomeData(String str) {
        if(str == null) {
            return "... it looks like you didn't give me a string " +
                   "to start with. Pass one along as a URL query " +
                   "parameter named 'field'";
        }

        return new StringBuilder(str).reverse().toString();
    }
}
