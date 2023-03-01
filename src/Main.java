import database.DbConnection;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().callBuilInFunction("Try to transform this sentence" ));
    }

    private String callBuilInFunction(String chaine) {
        String resultat = chaine;
        final String SQL = "{ ? = call initcap( ? ) }";

        try {
            Connection connection = new DbConnection().connect();
            CallableStatement statement = connection.prepareCall(SQL);
            statement.registerOutParameter(1, Types.VARCHAR);
            statement.setString(2, chaine);
            statement.execute();

            resultat = statement.getString(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return resultat;
    }
}