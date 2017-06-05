package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import pacote.TurismoPacote;
import pacote.TurismoPasseio;

public class dsff {
	public static void main(String[] args) throws SQLException, ParseException {
		
		/*TurismoPasseio nome = new TurismoPasseio();
		nome.setDescPasseio("teste");
		nome.setLocal("xx");
		
		PasseioDAO x = new PasseioDAO();
		x.adicionar(nome);
		
		DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
		Date date = (Date)formatter.parse("01/29/02");
		
		System.out.print(date);
		
		TurismoPacote y = new TurismoPacote();
		
		y.setDesc("xx");
		y.setDataEmbarque(date);
		y.setDataRetorno(date);
		y.setCusto(12);
		
		PacoteDAO h = new PacoteDAO();
		h.inserirPacotePasseio(1, 1);
		h.adicionar(y);
		 h = new PacoteDAO();

		h.removerPacotePasseio(2);
		h.removerPacote(2);
		
		
		
		ArrayList<TurismoPacote> nome =h.listarPacote();
		
		for(TurismoPacote x:nome){
		
			System.out.println("Pacote:"+x.getId()+"\n data embarque: "+x.getDataEmbarque()+"\n data retorno: "+x.getDataRetorno()+"\n data valor: "+x.getCusto()+"\n");
			
			
			for(TurismoPasseio f:x.getListaPasseios()){
				System.out.println(f.getId()+"-"+f.getDescPasseio()+"-"+f.getLocal()+"\n");
			
			}
		}
		
		*/
		
		DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
		Date date = (Date)formatter.parse("01/29/02");
		
		TurismoPacote y = new TurismoPacote();
		
		y.setDesc("xx");
		y.setDataEmbarque(date);
		y.setDataRetorno(date);
		y.setCusto(12);
		
		PacoteDAO x = new PacoteDAO();
		
		TurismoPacote novo = x.adicionarPacote(y);
		
		System.out.println(novo.getId());
		
		
		
	}
}
