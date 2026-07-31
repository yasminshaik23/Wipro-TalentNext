public class JDBCCalls {

    public static void main(String[] args) {

        DAOClass dao = new DAOClass();

        int choice = Integer.parseInt(args[0]);

        switch (choice) {

    case 1:
        dao.insert(
                Integer.parseInt(args[1]),
                args[2],
                args[3],
                args[4],
                Double.parseDouble(args[5]));
        break;

    case 2:
        dao.delete(Integer.parseInt(args[1]));
        break;

    case 3:
        dao.modify(
                Integer.parseInt(args[1]),
                Double.parseDouble(args[2]));
        break;

    case 4:
        if (args.length == 2)
            dao.display(Integer.parseInt(args[1]));
        else
            dao.display();
        break;

    default:
        System.out.println("Invalid Choice");
}
}
}