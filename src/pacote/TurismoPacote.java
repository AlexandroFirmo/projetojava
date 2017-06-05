package pacote;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TurismoPacote {
	
	private int id;
	private String desc;
	private Date dataEmbarque;
	private Date dataRetorno;
	private double custo;
	private ArrayList <TurismoPasseio> listaPasseios;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getDataEmbarque() {
		return dataEmbarque;
	}
	public void setDataEmbarque(Date dataEmbarque) {
		this.dataEmbarque = dataEmbarque;
	}
	public Date getDataRetorno() {
		return dataRetorno;
	}
	public void setDataRetorno(Date dataRetorno) {
		this.dataRetorno = dataRetorno;
	}
	public double getCusto() {
		return custo;
	}
	public void setCusto(double custo) {
		this.custo = custo;
	}
	
	public List<TurismoPasseio> getListaPasseios() {
		return listaPasseios;
	}
	public void setListaPasseios(ArrayList<TurismoPasseio> listaPasseios) {
		this.listaPasseios = listaPasseios;
	}
	
	public void inserirPasseio(TurismoPasseio idPasseio){
		listaPasseios.add(idPasseio);
	}

	public void removerPasseio(TurismoPasseio idPasseio){
		
		listaPasseios.remove(idPasseio);
		
	}
	
	@Override
	public String toString() {
		return "Pacote [id=" + id + ", desc=" + desc + ", dataEmbarque=" + dataEmbarque + ", dataRetorno=" + dataRetorno
				+ ", custo=" + custo + ", listaPasseios=" + listaPasseios + "]";
	}
	
	
		
}
