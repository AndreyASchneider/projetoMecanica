package persistencia;

import apoio.db.DataBaseException;

public class DAOFactory {

    public static ClienteDAO newClienteDAO() throws DataBaseException {
        return new ClienteDAOPostgreSQL();
    }

    public static CarroDAO newCarroDAO() throws DataBaseException {
        return new CarroDAOPostgreSQL();
    }

    public static UsuarioDAO newUsuarioDAO() throws DataBaseException {
        return new UsuarioDAOPostgreSQL();
    }

    public static FuncionarioDAO newFuncionarioDAO() throws DataBaseException {
        return new FuncionarioDAOPostgreSQL();
    }

    public static PeçasDAO newPeçasDAO() throws DataBaseException {
        return new PeçasDAOPostgreSQL();
    }

    public static OrdensDAO newOrdensDAO() throws DataBaseException {
        return new OrdensDAOPostgreSQL();
    }

}
