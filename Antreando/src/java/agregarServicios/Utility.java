//GEN-BEGIN:Client
/**
 * This file is generated. Please do not change
 */
package agregarServicios;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;

/**
 *  This class is used as an external protocol utility. It is so we don't
 *  generate as much code.
 */
public class Utility {

    /** Marker for null. Null is a type and a value together. */
    private final static short NULL_TYPE = -1;
    /** Marker for void return types. */
    public final static Object VOID_VALUE = new Object();

    /**
     * Sends return values to the client output stream.
     *
     * @param output The output stream into which all the data should be written
     * @param  returnValue The value which we should write into the stream
     * @throws IOException If an error occured while writing the results
     */
    public static void writeResults(DataOutput output, Object returnValue, int[] paramIDs) throws IOException {
        for (int i = 0; i < paramIDs.length; i++) {
            writeObject(output, returnValue, paramIDs[i]);
        }
    }

    /**
     * 
     * @param output 
     * @param o 
     * @throws java.io.IOException 
     */
    public static void writeObject(DataOutput output, Object o, int id) throws IOException {
        if (o == null) {
            // write null type to the stream
            output.writeShort(NULL_TYPE);
            return;
        }
        switch (id) {
            case 2:
                // int
                output.writeShort(2);
                output.writeInt(((Integer) o).intValue());
                break;
            default:
                // default if a data type is not supported
                throw new IllegalArgumentException("Unsupported parameter type: " + o.getClass());
        }
    }

    /**
     * 
     * @param in 
     * @return 
     * @throws java.io.IOException 
     */
    protected static Object readObject(DataInput in) throws IOException {
        short type = in.readShort();
        Object result;
        switch (type) {
            case 5:
                // String
                result = in.readUTF();
                return result;
            case NULL_TYPE: /* null */
                return null;
            default:
                throw new IllegalArgumentException(
                        "Unsupported return type (" + type + ")");
        }
    }
}
//GEN-END:Client