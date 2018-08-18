package ecom.mycompany.hotel.exception;

/**
 * Custom Exception class for File Read issues
 *
 * @author Vinod
 */
public class FileReadException extends Exception {
    public FileReadException(String s)
    {
       super(s);
    }
}
