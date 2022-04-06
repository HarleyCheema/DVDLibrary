/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dvdlibrary.dao;

import java.util.List;
import DVDLibrary.dto.DVD;
/**
 *
 * @author harle
 */
//Dejan Savic
public interface DVDLibraryDao {
    /**
     * Adds the given DVD to the library and associates it with the given
     * title. If there is already a dvd associated with the given
     * DVD title it will return that DVD object, otherwise it will
     * return null.
     *
     * @param DVD title with which DVD is to be associated
     * @param DVD dvd to be added to the Library
     * @return the DVD object previously associated with the given  
     * DVD title if it exists, null otherwise
     */
    DVD addDVD(String title, DVD dvd);

    /**
     * Returns a List of all DVDs in the library.
     *
     * @return List containing all dvds in the library.
     */
    List<DVD> getAllDVDs();

    /**
     * Returns the DVD object associated with the given DVD title.
     * Returns null if no such DVD exists
     *
     * @param DVD title of the DVD to retrieve
     * @return the DVD object associated with the given DVD title,  
     * null if no such DVD exists
     */
    DVD getDVD(String title);

    /**
     * Removes from the library the DVD associated with the given title.
     * Returns the DVD object that is being removed or null if
     * there is no DVD associated with the given title
     *
     * @param dvdTitle tile of DVD to be removed
     * @return DVD object that was removed or null if DVD
     * was associated with the given student title
     */
    DVD removeDVD(String title);
}

