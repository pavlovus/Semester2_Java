package ua.com.laboratory02;

import java.io.*;

public class GroupFile extends File {

    /**
     * Constructs a new GroupFile with the specified file name.
     *
     * @param fileName the name of the file to be created or accessed
     */
    public GroupFile(String fileName) {
        super(fileName);
    }

    /**
     * Saves a Store<ItemGroup> object to this file using serialization.
     * The method will overwrite any existing content in the file.
     * If an IOException occurs during the operation, it will be printed to stderr.
     *
     * @param list the Store<ItemGroup> object to be saved to the file
     * @throws IOException if an I/O error occurs while creating the output stream
     */
    public void saveGroups(Store<ItemGroup> list) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this))) {
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves a Store<ItemGroup> object from this file using deserialization.
     *
     * @return the deserialized Store<ItemGroup> object
     * @throws FileNotFoundException if the file does not exist or cannot be opened for reading
     * @throws ClassNotFoundException if the class of a serialized object cannot be found
     */
    public Store<ItemGroup> retrieveGroups() throws FileNotFoundException {
        Store<ItemGroup> loadedObj;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this))) {
            loadedObj = (Store<ItemGroup>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new FileNotFoundException();
        }
        return loadedObj;
    }
}