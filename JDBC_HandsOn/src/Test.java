import java.util.ArrayList;
public class Test {

    public static void main(String[] args) {

        UserDAO dao = new UserDAO();

        int choice = Integer.parseInt(args[0]);

        switch (choice) {

            case 1:
                System.out.println("User Type : " + dao.getUserType("AB1001"));
                break;

            case 2:
                System.out.println(dao.getIncorrectAttempts("AB1001"));
                break;
            case 3:
                System.out.println(dao.changeUserType("TA1002"));
                break;
            case 4:
                System.out.println(dao.getLockStatus("AB1001"));
                break;
            case 5:
                System.out.println(dao.changeName("RS1003", "Ramesh"));
                break;
            case 6:
                System.out.println(dao.changePassword("RS1003", "RS2026"));
                break;
            case 7:

                UserBean bean1 = new UserBean();

                bean1.setUserID("VK1004");
                bean1.setPassword("VK1004");
                bean1.setName("Vikas");
                bean1.setIncorrectAttempts(0);
                bean1.setLockStatus(0);
                bean1.setUserType("Employee");

                System.out.println(dao.addUser_1(bean1));

                break;
            case 8:

                UserBean bean2 = new UserBean();

                bean2.setUserID("AR1005");
                bean2.setPassword("AR1005");
                bean2.setName("Arun");
                bean2.setIncorrectAttempts(0);
                bean2.setLockStatus(0);
                bean2.setUserType("Employee");

                System.out.println(dao.addUser_2(bean2));

                break;
            case 9:

                ArrayList<UserBean> users = dao.getUsers();
                for(UserBean bean : users){

                    System.out.println(
                    bean.getUserID()+"  "+
                    bean.getPassword()+"  "+
                    bean.getName()+"  "+
                    bean.getIncorrectAttempts()+"  "+
                    bean.getLockStatus()+"  "+
                    bean.getUserType());

                }

                break;
            case 10:

                System.out.println(dao.storeAllRecords());

                break;
            case 11:

                ArrayList<String> names = dao.getNames();

                for(String name : names){

                    System.out.println(name);

                }

                break;            

            default:
                System.out.println("Invalid Choice");
        }
    }
}