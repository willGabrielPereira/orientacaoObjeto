package factory;

import java.io.File;
import java.util.List;

public interface Factory<e> {
	public List<e> carrega(String idMarca, String idVeiculo, String idModelo);
	public List<e> limpa();
	public boolean salva(List<e> lista, File arquivo);
}
