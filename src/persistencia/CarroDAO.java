package persistencia;

import apoio.db.IDAO;
import java.util.Collection;
import negocio.Carro;

public interface CarroDAO extends IDAO<Carro> {

    public Collection<?> lerComFiltro(String ano);

}
