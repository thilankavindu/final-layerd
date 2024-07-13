package lk.ijse.finalProject.dao;

import lk.ijse.finalProject.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){
    }
    public static DAOFactory getBoFactory(){
        return (daoFactory==null)? daoFactory=new DAOFactory() : daoFactory;
    }

    public enum BOTypes{
BOOK,CART,MEMBER,RETURN,USER  }

    //Object creation logic for BO objects
    public SuperDAO getBO(BOTypes types){
        switch (types){
            case BOOK:
                return new BookDAOImpl();
            case CART:
                //return new CartDAOImpl();
            case RETURN:
                return new ReturnDAOImpl();
            case MEMBER:
                return new MemberDAOImpl();
            case USER:
                return new UserDAOImpl();
            default:
                return null;
        }
    }

}

