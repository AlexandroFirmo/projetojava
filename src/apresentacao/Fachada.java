package apresentacao;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import dao.PacoteDAO;
import execoes.AtributosInvalidosException;
import execoes.ListaVaziaException;
import execoes.PacoteInvalidoException;
import pacote.TurismoPacote;
import pacote.TurismoPasseio;

public class Fachada {
	
	public void pacote(String desc,Date dataEmbarque,Date dataRetorno,ArrayList<Integer> list,double custo) throws ParseException, SQLException, AtributosInvalidosException{
		
		if(desc!=null && dataEmbarque!=null && dataRetorno!=null &&  list!=null && custo>=0){
			TurismoPacote pacote = new TurismoPacote();
			pacote.setDesc(desc);
			pacote.setDataEmbarque(dataEmbarque);
			pacote.setDataRetorno(dataRetorno);
			pacote.setCusto(custo);
			
			PacoteDAO dao = new PacoteDAO();
			
			TurismoPacote novo = dao.adicionarPacote(pacote);
			
			for(Integer t :list){
				dao.adicionarPacotePasseio(novo.getId(), t);
			}
		}else{
			throw new  AtributosInvalidosException();
		}
	
		
	}
	
	public void listar() throws SQLException, ListaVaziaException{
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		PacoteDAO dao = new PacoteDAO();
		String lista ="";
		
		ArrayList<TurismoPacote> nome= dao.listarPacote();
		
		for(TurismoPacote x:nome){
		
		 lista+="Pacote:"+x.getId()+"\n descrição pacote: "+x.getDesc()+"\n data embarque: "+format.format(x.getDataEmbarque())+"\n data retorno: "+format.format(x.getDataRetorno())+"\n data valor: "+x.getCusto()+"\nPasseio:\n";
			

			for(TurismoPasseio f:x.getListaPasseios()){
				lista+=f.getId()+"-"+f.getDescPasseio()+"-"+f.getLocal()+"\n";
			
			}
			lista+="\n_________________\n";
		}
		
		if(lista!=""){
			JOptionPane.showConfirmDialog(null, lista);
		}else{
			throw new  ListaVaziaException();
		}
		
	}
	
	public void remover(int id) throws PacoteInvalidoException, SQLException{
		PacoteDAO dao = new PacoteDAO();
		if(dao.buscarPacote(id).getDesc()!=null){
		
			dao.removerPacotePasseio(id);
			dao.removerPacote(id);
		}else{
			throw new  PacoteInvalidoException();
		}
	}
	
	public TurismoPacote buscarPacote(int id) throws SQLException{
		PacoteDAO dao = new PacoteDAO();
		TurismoPacote busca =dao.buscarPacote(id);
		return busca;
	}
	public void atualizarPacote(int id,String desc,Date dataEmbarque,Date dataRetorno,ArrayList<Integer> list,double custo) throws ParseException, SQLException, AtributosInvalidosException{
		
		if(desc!=null && dataEmbarque!=null && dataRetorno!=null &&  list!=null && custo>=0){
			TurismoPacote pacote = new TurismoPacote();
			pacote.setId(id);
			pacote.setDesc(desc);
			pacote.setDataEmbarque(dataEmbarque);
			pacote.setDataRetorno(dataRetorno);
			pacote.setCusto(custo);
			
			PacoteDAO dao = new PacoteDAO();
			
			dao.atualizarPacote(pacote);;
			
			for(Integer t :list){
				
				if(!dao.buscarPacotePasseio(pacote.getId(),t)){
					dao.adicionarPacotePasseio(pacote.getId(), t);
				}else{
					dao.removerPasseio(pacote.getId(), t);
				}
			}
		}else{
			throw new  AtributosInvalidosException();
		}
		
	}

}
