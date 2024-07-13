package lk.ijse.finalProject.bo;

import lk.ijse.finalProject.bo.custom.impl.BookBOImpl;
import lk.ijse.finalProject.bo.custom.impl.MemberBOImpl;
import lk.ijse.finalProject.bo.custom.impl.ReturnBOImpl;
import lk.ijse.finalProject.bo.custom.impl.UserBOImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){
    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes{
        USER,BOOK,MEMBER,RETURN
    }

    //Object creation logic for BO objects
    public SuperBO getBO(BOTypes types){
        switch (types){
            case USER:
                return new UserBOImpl();
            case BOOK:
                return new BookBOImpl();
            case MEMBER:
                return new MemberBOImpl();
            case RETURN:
                return new ReturnBOImpl();
            default:
                return null;
        }
    }

}

