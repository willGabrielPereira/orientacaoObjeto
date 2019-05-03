package bo;

import java.util.List;

import dto.Marca;
import dao.MarcaDAO;

public class MarcaBo {
	public boolean inserir(Marca marca) {
		if(existe(marca) != true) {
			MarcaDAO marcasDAO = new MarcaDAO();
			return marcasDAO.inserir(marca);
		}
		return false;
	}
	public boolean alterar(Marca marca) {
		MarcaDAO marcasDAO = new MarcaDAO();
		return marcasDAO.alterar(marca);
	}
	public boolean excluir(Marca marca) {
		MarcaDAO marcasDAO = new MarcaDAO();
		return marcasDAO.excluir(marca);
	}
	public Marca procurarPorCodigo(Marca marca) {
		MarcaDAO marcasDAO = new MarcaDAO();
		return marcasDAO.procurarPorCodigo(marca);
	}
	public Marca procurarPorDescricao(Marca marca) {
		MarcaDAO marcasDAO = new MarcaDAO();
		return marcasDAO.procurarPorDescricao(marca);
	}
	public boolean existe(Marca marca) {
		MarcaDAO marcasDAO = new MarcaDAO();
		return marcasDAO.existe(marca);
	}
	public List<Marca> PesquisarTodos(){
		MarcaDAO marcasDAO = new MarcaDAO();
		return marcasDAO.pesquisarTodos();
	}
}
