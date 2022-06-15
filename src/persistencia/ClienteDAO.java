
package persistencia;

import apoio.db.IDAO;
import java.util.ArrayList;
import negocio.Cliente;

public interface ClienteDAO extends IDAO<Cliente>{

    public ArrayList<Cliente> lerComFiltro(String nome);
    
}
