/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dvdlibrary.controller;

/**
 *
 * @author harle
 */
import dvdlibrary.dao.DVDLibraryDao;
import dvdlibrary.dao.DVDLibraryDaoException;
import dvdlibrary.dto.DVD;
import dvdlibrary.ui.UserIOConsoleImpl;
import dvdlibrary.ui.DVDLibraryView;
import java.util.List;

public class DVDLibraryController {
    
    private DVDLibraryDao dao;
    private DVDLibraryView view;
    private final UserIOConsoleImpl io = new UserIOConsoleImpl();
    
    public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view){
        this.dao = dao;
        this.view = view;
    }
    
    public void run(){
        boolean keepGoing = true;
        int menuSelection = 0;
        try{
            while(keepGoing){
                menuSelection = getMenuSelection();
                
                switch(menuSelection){
                    case 1:
                        listDVDs();
                        break;
                    case 2:
                        addDVD();
                        break;
                    case 3:
                        viewDVD();
                        break;
                    case 4:
                        removeDVD();
                        break;
                    case 5:
                        //editDVD();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                } 
            }
            exitMessage();
        } catch(DVDLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }
    
    private int getMenuSelection() throws DVDLibraryDaoException{
        return view.printMenuAndGetSelection();
    }
    
    private void addDVD()throws DVDLibraryDaoException{
        view.displayCreateDVDBanner();
        DVD newDvd = view.getNewDVDInfo();
        dao.addDVD(newDvd.getTitle(), newDvd);
        view.displayCreateSuccessBanner();
    }
    
    private void listDVDs()throws DVDLibraryDaoException{
        view.displayDisplayAllBanner();
        List<DVD> dvdList = dao.getAllDVDs();
        view.displayDVDList(dvdList);
    }
    
   private void viewDVD()throws DVDLibraryDaoException{
       view.displayDisplayDVDBanner();
       String dvdTitle = view.getDVDIdChoice();
       DVD dvd = dao.getDVD(dvdTitle);
       view.displayDVD(dvd);
   }
   
   private void removeDVD()throws DVDLibraryDaoException{
       view.displayRemoveDVDBanner();
       String dvdTitle = view.getDVDIdChoice();
       DVD removedDvd = dao.getDVD(dvdTitle);
       view.displayRemoveResult(removedDvd);
   }
   
    private void unknownCommand(){
        view.displayUnknownCommandBanner();
    }
    
    private void exitMessage(){
        view.displayExitBanner();
    }
    
}
