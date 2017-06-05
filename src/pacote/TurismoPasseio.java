package pacote;

public class TurismoPasseio {

		
		private int id;
		private String descPasseio;
		private String local;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getDescPasseio() {
			return descPasseio;
		}
		public void setDescPasseio(String descPasseio) {
			this.descPasseio = descPasseio;
		}
		public String getLocal() {
			return local;
		}
		public void setLocal(String local) {
			this.local = local;
		}
		
		@Override
		public String toString() {
			return "Passeio [id=" + id + ", descPasseio=" + descPasseio + ", local=" + local + "]";
		}
		
		

}
