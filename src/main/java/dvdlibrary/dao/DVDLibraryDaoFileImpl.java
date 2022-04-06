/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dvdlibrary.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DVDLibrary.dto.DVD;

//Dejan Savic
public class DVDLibraryDaoFileImpl implements DVDLibraryDao{
	//hashmap
	private Map<String, DVD> dvds = new HashMap<>();
	@Override
	public DVD addDVD(String title, DVD dvd) {
		// TODO Auto-generated method stub
		DVD prevDVD = dvds.put(title, dvd);
		return prevDVD;
	}

	@Override
	public List<DVD> getAllDVDs() {
		// TODO Auto-generated method stub
		return new ArrayList<DVD>(dvds.values());
	}

	@Override
	public DVD getDVD(String title) {
		// TODO Auto-generated method stub
		return dvds.get(title);
	}

	@Override
	public DVD removeDVD(String title) {
		// TODO Auto-generated method stub
		DVD removedDVD = dvds.remove(title);
		return removedDVD;
	}



}
