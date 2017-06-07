package apresentacao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import dao.PacoteDAO;
import execoes.AtributosInvalidosException;
import execoes.ListaVaziaException;
import execoes.PacoteInvalidoException;

public class Principal {
	public static void main(String[] args) {
		int opcao = 0;
		
		while(opcao != 5){
			try{
				
				opcao = Integer.parseInt(JOptionPane.showInputDialog("1 -Cadastra Pacote.\n 2 -Lista Pacotes.\n 3 -remover Pacote.\n 4-Alterar Pacote.\n"
						+ "5 - Finalizar Sistema. "));
				
				switch(opcao){
				
				case 1:{
					Date dataEmbarque= null;
					Date dataRetorno=null;
					int data = 0;
					boolean v = false;
					ArrayList<Integer>passeios = new ArrayList<Integer>();
					
					JOptionPane.showConfirmDialog(null,"Para Cadastrar um Pacote informe:\n"
							+ " Descricao , Data embarque Data chegada e Custo");
					String desc = JOptionPane.showInputDialog("Digite a desciração do pacote.");
					
					while(data!=-1){
						DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
						dataEmbarque = (Date)formatter.parse(JOptionPane.showInputDialog("Digite a data Embarque."));
						dataRetorno = (Date)formatter.parse(JOptionPane.showInputDialog("Digite a data Retorno."));
						
						data = dataEmbarque.compareTo(dataRetorno);
						
						if(data==1 || data==0){;
						 JOptionPane.showConfirmDialog(null, "A data de retorno Tem que ser\n maior que data de embarque");
						}
					}
					while(!v){
						
						switch(Integer.parseInt(JOptionPane.showInputDialog(" Digite um tipo de passeio:\n praia 1.\n shoping 2.\n teste 3."
								+ "\ndigite zero para proceguir. "))){
						case 1:
							passeios.add(1);
							break;
						case 2:
							passeios.add(2);
							break;
						case 3:
							passeios.add(3);
							break;
						default:
							v = true;
							break;
						}
						
						
					}
					double custo = Double.parseDouble(JOptionPane.showInputDialog("Valor Pacote."));
					
					
					try {
						Fachada fachada = new Fachada();
						fachada.pacote(desc,dataEmbarque,dataRetorno, passeios, custo);
						JOptionPane.showMessageDialog(null, "Pacote Cadastrado Com Sucesso!!. ");
						
					}catch(AtributosInvalidosException e){
						JOptionPane.showMessageDialog(null, e.getMessage());
						
					}
					
					
					
					break;
				}
				
				case 2:
				{
					
					try {
						Fachada fachada = new Fachada();
						fachada.listar();
					}catch(ListaVaziaException e){
						JOptionPane.showMessageDialog(null, e.getMessage());
						
					}
					
					break;
				}
				case 3:
				{
					int id = Integer.parseInt(JOptionPane.showInputDialog("Para remover digite\n o numero do id do pacote."));
					
					
					try {
						Fachada fachada = new Fachada();
						fachada.remover(id);
						JOptionPane.showMessageDialog(null, "Pacote Removido Com Sucesso!!. ");
						
					}catch(PacoteInvalidoException e){
						JOptionPane.showMessageDialog(null, e.getMessage());
						
					}
					
					
					break;
				}
				
				case 4:
				{
					int id = Integer.parseInt(JOptionPane.showInputDialog("Para alterar um pacote digte\n o numero do id do pacote."));
					
					Fachada fachada = new Fachada();
						
						if(fachada.buscarPacote(id).getDesc()!=null){
							
						int idPacote = fachada.buscarPacote(id).getId();
						PacoteDAO dao = new PacoteDAO();
						Date dataEmbarque= null;
						Date dataRetorno=null;
						int data = 0;
						boolean v = false;
						ArrayList<Integer>passeios = new ArrayList<Integer>();
						
						JOptionPane.showConfirmDialog(null,"Para Cadastrar um Pacote informe:\n"
								+ " Descricao , Data embarque Data chegada e Custo");
						String desc = JOptionPane.showInputDialog("Digite a desciração do pacote.");
						
						while(data!=-1){
							DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
							dataEmbarque = (Date)formatter.parse(JOptionPane.showInputDialog("Digite a data Embarque."));
							dataRetorno = (Date)formatter.parse(JOptionPane.showInputDialog("Digite a data Retorno."));
							
							data = dataEmbarque.compareTo(dataRetorno);
							
							if(data==1 || data==0){;
							 JOptionPane.showConfirmDialog(null, "A data de retorno Tem que ser\n maior que data de embarque");
							}
						}
						while(!v){
							
							switch(Integer.parseInt(JOptionPane.showInputDialog(" Digite um tipo de passeio:\n joão pessoa 1.\n recife 2.\n são paulo 3."
									+ "\ndigite zero para proceguir. "))){
							case 1:
								passeios.add(1);
								break;
							case 2:
								passeios.add(2);
								break;
							case 3:
								passeios.add(3);
								break;
							default:
								v = true;
								break;
							}
							
							
						}
						double custo = Double.parseDouble(JOptionPane.showInputDialog("Valor Pacote."));
						
						
						try {
	
							fachada.atualizarPacote(idPacote,desc,dataEmbarque,dataRetorno, passeios, custo);
							JOptionPane.showMessageDialog(null, "Pacote Atualiado Com Sucesso!!. ");
							
						}catch(AtributosInvalidosException e){
							JOptionPane.showMessageDialog(null, e.getMessage());
							
						}
					
					}else{
						JOptionPane.showConfirmDialog(null, "Pacote não encontrado");
					}
					
					break;
				}
				default:
					break;
				
				}
				
				
			} catch (Exception e){
			
				e.printStackTrace();
			}
		}
	}
}
