
package apoio.db;

import apoio.db.DuplicateKeyException;
import java.util.ArrayList;
import java.util.logging.Filter;

public interface IDAO<T> 
{
    public void criar( T a ) throws DataBaseException, DuplicateKeyException;
    public void editar( T a ) throws DataBaseException;
    public void apagar( T a ) throws DataBaseException;
    public T ler( int id ) throws DataBaseException;
    public ArrayList<T> lerTudo() throws DataBaseException;
    public ArrayList<T> lerComFiltro(Filter filter) throws DataBaseException;
}

