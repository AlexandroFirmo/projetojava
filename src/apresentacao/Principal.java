package apresentacao;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Principal {
	public static void main(String[] args) {
		int opcao = 0;
		
		while(opcao != 5){
			try{
				
				opcao = Integer.parseInt(JOptionPane.showInputDialog("1 -Cadastra Pacote.\n 2 -Lista Pacotes.\n 3 -remover Pacote.\n 4-Alterar Pacote.\n"
						+ "5 - Finalizar Sistema. "));
				
				switch(opcao){
				
				case 1:{
					
				
					boolean v = false;
					ArrayList<Integer>passeios = new ArrayList<Integer>();
					
					JOptionPane.showConfirmDialog(null,"Para Cadastrar um Pacote informe:\n"
							+ " Descricao , Data embarque Data chegada e Custo");
					String desc = JOptionPane.showInputDialog("Digite a desciração do pacote.");
					String dataEmbarque = JOptionPane.showInputDialog("Digite a data Embarque.");
					String dataRetorno = JOptionPane.showInputDialog("Digite a data Retorno.");
					
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
					
					Fachada fachada = new Fachada();
					fachada.pacote(desc,dataEmbarque,dataRetorno, passeios, custo);
					
					
					
					break;
				}
				
				case 2:
				{
					Fachada fachada = new Fachada();
					fachada.listar();
					break;
				}
				case 3:
				{
					int id = Integer.parseInt(JOptionPane.showInputDialog("Para remover digite\n o numero do id do pacote."));
					Fachada fachada = new Fachada();
					fachada.remover(id);
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
