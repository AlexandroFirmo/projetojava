package apresentacao;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import dao.PacoteDAO;
import pacote.TurismoPacote;
import pacote.TurismoPasseio;

public class Fachada {
	
	public void pacote(String desc,String dataEmbarque,String dataRetorno,ArrayList<Integer> list,double custo) throws ParseException, SQLException{
		TurismoPacote pacote = new TurismoPacote();
		pacote.setDesc(desc);
		
		DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
		Date date = (Date)formatter.parse(dataEmbarque);
		Date date2 = (Date)formatter.parse(dataRetorno);
		
		pacote.setDataEmbarque(date);
		pacote.setDataRetorno(date2);
		pacote.setCusto(custo);
		
		PacoteDAO dao = new PacoteDAO();
		
		TurismoPacote novo = dao.adicionarPacote(pacote);
		
		for(Integer t :list){
			dao.adicionarPacotePasseio(novo.getId(), t);
		}
		
		
	}
	
	public void listar() throws SQLException{
		PacoteDAO dao = new PacoteDAO();
		String lista ="";
		
		ArrayList<TurismoPacote> nome= dao.listarPacote();
		
		for(TurismoPacote x:nome){
		
		 lista+="Pacote:"+x.getId()+"\n descrição pacote: "+x.getDesc()+"\n data embarque: "+x.getDataEmbarque()+"\n data retorno: "+x.getDataRetorno()+"\n data valor: "+x.getCusto()+"\nPasseio:\n";
			

			for(TurismoPasseio f:x.getListaPasseios()){
				lista+=f.getId()+"-"+f.getDescPasseio()+"-"+f.getLocal()+"\n";
			
			}
			lista+="\n_________________\n";
		}
		JOptionPane.showConfirmDialog(null, lista);
	}
	
	public void remover(int id) throws SQLException{
		
		PacoteDAO dao = new PacoteDAO();
		dao.removerPacotePasseio(id);
		dao.removerPacote(id);
		
	}

}
